CREATE DATABASE ProjectManager;
USE ProjectManager;
CREATE TABLE IF NOT EXISTS Employee
(
		EmployeeID 					INT(11) AUTO_INCREMENT PRIMARY KEY,
		EmployeeLastName 			VARCHAR(50) NOT NULL,
		EmployeeFirstName 			VARCHAR(50) NOT NULL,
		EmployeeHireDate 			DATETIME DEFAULT(Now()),
		EmployeeStatus 				TINYINT(1) NOT NULL,
		SupervisorID 				INT(11) DEFAULT NULL,
		SocialSecurityNumber 		INT(11) NOT NULL,
		FOREIGN KEY (SupervisorID) REFERENCES  Employee(EmployeeID)
);


CREATE TABLE IF NOT EXISTS Projects
(
		ProjectID 				INT(11) AUTO_INCREMENT PRIMARY KEY,
		ManagerID 				INT(11) NOT NULL,
		ProjectName 			VARCHAR(100) NOT NULL,
		ProjectStartDate 		DATETIME DEFAULT(Now()),
		ProjectDescription 		VARCHAR(255) NOT NULL,
		ProjectDetailit 		VARCHAR(255) NOT NULL,
		ProjectCompletedOn 		DATETIME DEFAULT(Now()),
		FOREIGN KEY (ManagerID) REFERENCES  Employee(EmployeeID)
);

CREATE TABLE IF NOT EXISTS Project_Modules
(
		ModuleID 						INT(11) AUTO_INCREMENT PRIMARY KEY,
		ProjectID 						INT(11) NOT NULL,
		ProjectModulesDate 				DATETIME DEFAULT(Now()),
		ProjectModulesCompletedOn 		DATETIME DEFAULT(Now()),
		ProjectModulesDescription 		VARCHAR(255),
		FOREIGN KEY (ProjectID) REFERENCES  Projects(ProjectID)
);

CREATE TABLE IF NOT EXISTS Work_Done
(
		WorkDoneID 			INT(11) AUTO_INCREMENT PRIMARY KEY,
		EmployeeID 			INT(11) NOT NULL,
		ModuleID 			INT(11) NOT NULL,
		WorkDoneDate 		DATETIME DEFAULT(Now()),
		WorkDoneDescription VARCHAR(225) NOT NULL,
		WorkDoneStatus 		TINYINT(1) NOT NULL,
		FOREIGN KEY (EmployeeID) REFERENCES  Employee(EmployeeID),
		FOREIGN KEY (ModuleID) REFERENCES  Project_Modules(ModuleID)
);

INSERT INTO employee 
VALUES 	(1,'Thành','Nguyễn Huy','2019-01-03',1,null,214294),
		(2,'Đông','Công Phương','2019-01-03',1,null,2201),
		(3,'Trang','Đặng Nguyễn Phương','2019-01-03',1,null,1503),
		(4,'Thủy','Thạch Thanh','2019-01-05',1,null,1012),
		(5,'Hiệp','Hoàng Mạnh','2019-01-06',1,null,1106),
		(6,'Hằng','Hồ Thị','2019-02-01',1,null,1907),
		(7,'Anh','Nguyễn Tú','2019-03-05',1,null,1510),
		(8,'Giang','Trần Thị Thu','2019-03-06',1,null,1312),
		(9,'Dũng','Bùi Ngọc','2019-04-03',1,null,1101),
		(10,'Đạt','Giang Tiến','2019-03-08',1,null,1909),
		(11,'Kiên','Lại Trung','2019-03-08',1,null,1544),
		(12,'Anh','Vũ Tuấn','2019-03-08',1,null,3445),
		(13,'Thảo','Ngọc Nguyễn','2019-03-1',1,null,54656),
		(14,'An','Lê Ngọc','2019-03-08',1,null,34344),
		(15,'Việt','Nguyễn Việt','2019-04-09',1,null,5556),
		(16,'Hiếu','Đỗ Duy','2019-04-08',1,null,54554);
        
UPDATE employee SET SupervisorID = '4' WHERE (EmployeeID = '1');
UPDATE employee SET SupervisorID = '1' WHERE (EmployeeID = '2');
UPDATE employee SET SupervisorID = '4' WHERE (EmployeeID = '3');
UPDATE employee SET SupervisorID = '5' WHERE (EmployeeID = '4');
UPDATE employee SET SupervisorID = '8' WHERE (EmployeeID = '7');
UPDATE employee SET SupervisorID = '5' WHERE (EmployeeID = '9');
UPDATE employee SET SupervisorID = '5' WHERE (EmployeeID = '10');


INSERT INTO Projects
VALUES 		(1,1,'Web_MyGo','2020-03-01','WEB for customer','Just a web','2020-07-15'),
			(2,1,'Android_MyGo','2020-03-05','Android App for customer','Just a app','2020-08-29'),
			(3,1,'IOS_MyGo','2020-03-05','IOS App for customer','Just a app',null),
			(4,1,'Backend_MyGo','2020-03-01','BE for MyGo application','Big BE',null),
			(5,4,'Test_MyGo','2020-04-01','Test','Automation','2020-11-01');

INSERT INTO Project_Modules
VALUES 	(1,1,'2020-03-01','2020-05-01','web customer'),
		(2,1,'2020-03-01','2020-05-29','web profile'),
		(3,1,'2020-03-01','2020-08-29','web-report'),
		(4,2,'2020-03-05','2020-09-15','web driver'),
		(5,2,'2020-03-05',null,'app customer'),
		(6,3,'2020-03-05',null,'app driver'),
		(7,3,'2020-03-10',null,'app customer'),
		(8,4,'2020-03-01','2020-09-09','Backend database'),
		(9,4,'2020-04-01','2020-09-01','Manual'),
		(10,5,'2020-04-01','2020-11-14','Automation');

INSERT INTO Work_done
VALUES 	(1,5,1,'2020-05-01','design',1),
		(2,5,1,'2020-05-01','code js',1),
		(3,5,2,'2020-05-29','html',1),
		(4,11,2,'2020-05-29','javascript and vue',1),
		(5,14,3,'2020-08-29','make data',1),
		(6,13,3,'2020-08-29','vue design',1),
		(7,2,4,'2020-09-15','app driver-design',1),
		(8,15,4,'2020-09-25','app api done',1),
		(9,16,5,'2020-10-24','app customer api design',1),
		(10,2,5,'2020-10-14','app cusstomer api done',1),
		(11,9,6,null,'ios design',1),
		(12,10,7,null,'ios design+api',1),
		(13,11,8,null,'backend core',1),
		(14,12,8,null,'backend system',1),
		(15,4,8,null,'backend api',1),
		(16,1,9,'2020-09-09','backend data config',1),
		(17,3,9,'2020-09-09','backend data create',1),
		(18,6,10,'2020-09-01','write test case',1),
		(19,8,10,null,'sumary test case',1),
		(20,7,10,null,'write code done',1);
        
-- b) Viêt thủ tục để Remove toàn bộ thông tin Project đã hoàn thành lâu hơn 3 tháng tính từ thời điểm hiện tại. (Ví dụ bh là tháng 03/12 thì những project nào done trước 03/09 ta sẽ remove đi). Đồng thời thống kê số lượng bản ghi bị xóa ở mỗi bảng liên quan.
DROP PROCEDURE IF EXISTS DEL_Project_sugi_3m;
DELIMITER $$
CREATE PROCEDURE DEL_Project_sugi_3m (OUT out_del INT)
	BEGIN
		SELECT count(*) INTO out_del
        FROM Projects
        WHERE ProjectCompletedOn < date_sub(now(), interval 3 month);
       --  remove
		DELETE FROM Projects
        WHERE ProjectCompletedOn < date_sub(now(), interval 3 month);
    END$$
DELIMITER ;

SET @v=0;
CALL DEL_Project_sugi_3m(@v);
SELECT @v;


-- c)Viết stored procedure (có parameter) để in ra các module đang được thực hiện)
DROP PROCEDURE IF EXISTS Module_dangthuchien;
DELIMITER $$
CREATE PROCEDURE Module_dangthuchien (IN in_projectID INT(11))
	BEGIN
		SELECT *
        FROM Project_Modules
        WHERE ProjectModulesCompletedOn IS NOT NULL
			AND ProjectID = in_projectID;
    END$$
DELIMITER ;

-- d) parameter truyền vào là ProjectID. trả ra danh sách các nhân viên tham gia làm project đó mà ko có ai giao việc cả.
DROP PROCEDURE IF EXISTS STAFF_WORK_ISNOTSupervisor;
DELIMITER $$
CREATE PROCEDURE STAFF_WORK_ISNOTSupervisor (IN in_projectID INT(11))
	BEGIN
		SELECT *
        FROM employee
        WHERE  SupervisorID IS NULL
				AND EmployeeID IN (SELECT EmployeeID
									FROM Work_done
									WHERE moduleID IN (SELECT ModuleID
												FROM project_modules
												WHERE projectID = in_projectID));
    END$$
DELIMITER ;