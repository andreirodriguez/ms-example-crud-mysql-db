-- ${flyway:timestamp}
DELIMITER $$
DROP PROCEDURE IF EXISTS `customer_search`$$
CREATE PROCEDURE `customer_search`
(
	in parameters_json json,
	in order_by varchar(128)
)
-- CALL customer_search('{"id":1}','');
BEGIN

	DECLARE sql_body varchar(5500); DECLARE sql_join varchar(1000); DECLARE sql_where varchar(1500);

	-- FILTERS
	BEGIN
		SET @id =
		(
			SELECT JSON_EXTRACT(parameters_json, '$.id')
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
		SET @sql = CONCAT(sql_body,sql_join,sql_where,order_by);

		-- SELECT @sql

		PREPARE stmt FROM @sql;
		EXECUTE stmt;
		DEALLOCATE PREPARE stmt;
	END;
END;

