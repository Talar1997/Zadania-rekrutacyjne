DELIMITER $$
CREATE DEFINER=`root`@`localhost` FUNCTION `GenerateData`(`days` INT) RETURNS int(11)
    DETERMINISTIC
BEGIN
   DECLARE i INT;
   DECLARE max_iterations INT;
   DECLARE now TIMESTAMP;
   DECLARE measurement DOUBLE;

   SET i = 0;
   SET max_iterations = 1440 * days;
   SET now = CURRENT_TIMESTAMP;
   SET measurement = 0;

    insert_loop: REPEAT
    IF hour(now) >= 19 OR hour(now) <= 4 THEN
    	SET measurement = null;
    ELSE
    	SET measurement = ROUND(RAND() * 6 + -7, 2);
    END IF;

    INSERT INTO temp (id, time, measurement)
VALUES (null, now, measurement);
    SET now = TIMESTAMPADD(MINUTE,1,now);
    SET i = i + 1;
    UNTIL i >= max_iterations
    END REPEAT insert_loop;

   RETURN max_iterations;

END$$
DELIMITER ;
