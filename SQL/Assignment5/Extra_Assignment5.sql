use projectmanager;
-- Exercise 1: Tiếp tục với Database ở buổi 4
-- Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp
-- lệ
-- (Project_Modules.ProjectModulesDate < Projects.ProjectStartDate,
-- Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn)

DROP TRIGGER IF EXISTS EX1;
DELIMITER $$
CREATE TRIGGER EX1
BEFORE INSERT ON project_modules 
FOR EACH ROW
BEGIN
	IF NEW.ProjectModulesDate < (SELECT ProjectStartDate 
									FROM projects 
                                    WHERE ProjectID = NEW.ProjectID)
	THEN 
			SET NEW.ProjectModulesDate = (SELECT ProjectStartDate 
											FROM projects 
                                            WHERE projectID= NEW.projectID);
	END IF;
    IF NEW.ProjectModulesCompletedOn > (SELECT ProjectCompletedOn 
											FROM projects 
                                            WHERE ProjectID = NEW.ProjectID)
    THEN
			SET NEW.ProjectModulesCompletedOn =  (SELECT ProjectCompletedON 
													FROM projects 
                                                    WHERE projectID= NEW.projectID);
    END IF;
END$$
DELIMITER ;

-- EX2
USE assignment1;
DROP VIEW IF EXISTS ALLtrainee;
CREATE VIEW ALLtrainee AS (
	SELECT *
    FROM trainee
    WHERE ET_IQ + ET_Gmath>=20 AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18 
);