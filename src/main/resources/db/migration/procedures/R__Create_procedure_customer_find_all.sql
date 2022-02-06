-- ${flyway:timestamp}
DELIMITER $$
DROP PROCEDURE IF EXISTS `customer_find_all`$$
CREATE PROCEDURE `customer_find_all`
(
	in parameters_json json,
	in page_active int,
	in show_quantity int,
	in order_by varchar(128),
	inout total_registers int
)
-- CALL customer_find_all('{"comment":"tienda"}',1,10,'',@total_registers);
BEGIN

	DECLARE sql_body varchar(5500); DECLARE sql_join varchar(1000); DECLARE sql_where varchar(1500);

	Declare page_start varchar(10);Declare page_end varchar(10);

	-- INIT VARIABLES
	BEGIN
		Set page_start = (((page_active - 1) * show_quantity));
        
		Set page_end = (page_active * show_quantity);    
    END;

	-- FILTERS
	BEGIN
		SET @id =
		(
			SELECT JSON_EXTRACT(parameters_json, '$.id')
		);
        
		SET @comment =
		(
			SELECT JSON_UNQUOTE(JSON_EXTRACT(parameters_json, '$.comment'))
		);        
	END;

	-- CONSTRUCT SQL
	BEGIN
		-- SQL BODY
		BEGIN
			SET sql_body = "
			SELECT
			CUS.id,
			CUS.title,
			CUS.comment,
			CUS.amount_sell,
			CUS.register_user_id,
			CUS.register_user_fullname,
			CUS.register_datetime,
			CUS.active";

			SET sql_join = "
			FROM customer CUS";
		END;

		-- SQL WHERE
		BEGIN
			SET sql_where = "
			WHERE (1=1)";

			-- id
			IF @id IS NOT NULL THEN
				SET sql_where = CONCAT(sql_where,"
				AND CUS.id = @id");
			END IF;
            
			-- comment
			IF @comment IS NOT NULL THEN
				SET sql_where = CONCAT(sql_where,"
				AND CUS.comment LIKE CONCAT('%',@comment,'%')");
			END IF;            
		END;

		-- ORDER BY
		BEGIN
			IF order_by = "" THEN
				Set order_by = "id ASC";
			END IF;

			SET order_by = CONCAT("
			Order By ",order_by);
		END;
	END;

	-- EXECUTE SQL
	BEGIN
		SET total_registers = 0;
    
		SET @sql = CONCAT(sql_body,sql_join,sql_where,order_by);

		IF page_active > 0 THEN
			SET @sql_count = CONCAT("SELECT Count(1)",sql_join,sql_where," into @total_registers_out");

			PREPARE stmt_count from @sql_count;
			Execute stmt_count;
			Deallocate PREPARE stmt_count;    

			SET total_registers = @total_registers_out;
            SET @sql = Concat(@sql," Limit ",page_start,',',show_quantity);
        END IF;

		-- SELECT @sql

		PREPARE stmt FROM @sql;
		EXECUTE stmt;
		DEALLOCATE PREPARE stmt;
	END;
END;