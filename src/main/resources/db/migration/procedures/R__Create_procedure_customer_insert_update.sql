-- ${flyway:timestamp}
DELIMITER $$
DROP PROCEDURE IF EXISTS `customer_insert_update`$$
CREATE PROCEDURE `customer_insert_update`
(
	inout id_out int,
	in title varchar(128),
	in comment varchar(2048),
	in amount_sell decimal(20,4),
	in register_user_id int,
	in register_user_fullname varchar(250),
	in register_datetime datetime,
	in active bit
)
-- CALL customer_insert_update(@id_out,'Andrei S.A.C.','Empresa ANdrei',3000,0,'Angie',now(),true);
BEGIN
	SET @id = (Select id From customer where id=id_out);
    
	IF (@id is null) THEN
		INSERT INTO customer
        (
            title,
            comment,
            amount_sell,
            register_user_id,
            register_user_fullname,
            register_datetime,
            active
        )
		VALUES
        (
            title,
            comment,
            amount_sell,
            register_user_id,
            register_user_fullname,
            register_datetime,
            active        
        );
        
        SET id_out = (SELECT LAST_INSERT_ID());
	ELSE 
		UPDATE customer SET
		title=title,
		comment=comment,
		amount_sell=amount_sell,
		register_user_id=register_user_id,
		register_user_fullname=register_user_fullname,
		register_datetime=register_datetime, 
        active=active
        WHERE id=@id;
	END IF;
END