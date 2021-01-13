
-- Create DB
DROP DATABASE IF EXISTS ThucTap ;
CREATE DATABASE ThucTap;
-- Use Database
USE ThucTap;
-- Question1:
-- create tables:
DROP TABLE IF EXISTS Country;
CREATE TABLE Country (
		country_id 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		country_name 			NVARCHAR(100) NOT NULL
);
INSERT INTO  Country(country_name)
VALUES 				('Philipin'), 
					('Singapore'),
					(N'Việt Nam'),
					(N'Hàn Quốc'),
					(N'Trung Quốc');

-- ************************
DROP TABLE IF EXISTS Location;
CREATE TABLE Location (
		location_id 					TINYINT 	UNSIGNED 	AUTO_INCREMENT 	PRIMARY KEY,
		street_address					NVARCHAR(200) 			NOT NULL,
        postal_code 					CHAR(10) 				NOT NULL,
        country_id						TINYINT 	UNSIGNED	NOT NULL,
        FOREIGN KEY (country_id) 		REFERENCES  Country(country_id)  
);
INSERT INTO 	Location(street_address				, postal_code, country_id)
VALUES 					(N'25-Nguyễn Đình Chiểu'	, 'AB123'	, 3),
						(N'307- Hàm Nghi'			, 'FHJD123'	, 2),
						(N'466- Dương Quảng Hàm'	, 'GHHJ263'	, 2),
						(N'104- Cầu Giấy'			, 'DGD5555'	, 3),
						(N'Ngõ 208- Phương Canh'	, 'GHG8555'	, 1);

-- ************************
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
		employee_id 					TINYINT UNSIGNED 	AUTO_INCREMENT 		PRIMARY KEY,
		full_name						NVARCHAR(100) 		NOT NULL,
        email 							VARCHAR(100) 		UNIQUE,
        location_id						TINYINT   UNSIGNED  ,
        FOREIGN KEY (location_id) 		REFERENCES  Location (location_id) 
);

INSERT INTO 	Employee(full_name				, email					, location_id)
VALUES 					(N'Nguyễn Thị Chinh'	, 'nchinh407@gmail.com'	, 1),
						(N'Nguyễn Văn Nam'		, 'nn03@gmail.com'		, 3),
						(N'Hoàng Kiều Linh'		, 'hklinh04@gmail.com'	, 4),
						(N'Hà Thị Anh'			, 'htanh@gmail.com'		, 1),
						(N'Kim Thùy Trang'		, 'kttrang43@gmail.com'	, 5),
                        (N'Vũ Anh Tú'			, 'vatu04@gmail.com'	, 5),
						(N'Đỗ Hùng'				, 'dhung@gmail.com'		, 3),
						(N'Kim Thùy Mai'		, 'ktmai43@gmail.com'	, 2);
                       

-- Question 2:
-- 2.a:Lấy tất cả các nhân viên thuộc Việt nam
SELECT 
    e.*
FROM
    ((employee e
    INNER JOIN location l ON e.location_id = l.location_id)
    INNER JOIN country c ON l.country_id = c.country_id)
WHERE
    c.country_name = 'Việt Nam';

-- 2.b:Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
SELECT 
    c.country_name
FROM
    ((employee e
    INNER JOIN location l ON e.location_id = l.location_id)
    INNER JOIN country c ON l.country_id = c.country_id)
WHERE
    e.email = 'nn03@gmail.com';

-- 2.c: Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.

CREATE OR REPLACE VIEW countrytk AS
    SELECT 
       c.country_id, count(e.employee_id) AS 'Số nhân viên đang làm việc theo tên nước'
    FROM ((country c
    LEFT JOIN location l ON c.country_id = l.country_id)
    LEFT JOIN employee e ON l.location_id = e.location_id)
    GROUP BY c.country_id;

CREATE OR REPLACE VIEW locationtk AS
    SELECT 
       l.location_id, count(e.employee_id) AS 'Số nhân viên đang làm việc theo location'
    FROM location l
    LEFT JOIN employee e ON l.location_id = e.location_id
    GROUP BY l.location_id;
    
SELECT * FROM countrytk 
UNION ALL
SELECT * FROM locationtk ;

select c.country_id, l.location_id, count(employee_id) as 'so nhan vien'
FROM ((country c
    LEFT JOIN location l ON c.country_id = l.country_id)
    LEFT JOIN employee e ON l.location_id = e.location_id)
group by c.country_id, l.location_id;

-- Question 3:Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa
-- 10 employee

DROP TRIGGER IF EXISTS Trigg_InsertMax10e;
DELIMITER $$
CREATE TRIGGER Trigg_InsertMax10e
BEFORE INSERT ON employee 
FOR EACH ROW
BEGIN
	IF (SELECT count(*) AS 'sô lượng employee' FROM ((employee e
    LEFT JOIN location l ON e.location_id = l.location_id)
    INNER JOIN country c ON l.country_id = c.country_id) WHERE l.location_id = NEW.location_id GROUP BY c.country_id) >=10
		THEN SIGNAL SQLSTATE '12345' SET MESSAGE_TEXT = 'Không được thêm quá 10 employee trong mỗi quốc gia';
		END IF;
END$$
DELIMITER ;


INSERT INTO Employee(full_name				, email					, location_id)
VALUE 				(N'Dương Lị Chi'		,'hchi09@gmail.com'    , 5			);

-- 4. Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở
-- location đó sẽ có location_id = null

DROP TRIGGER IF EXISTS trigg_Delete_Location;
DELIMITER $$
CREATE TRIGGER trigg_Delete_Location
AFTER  DELETE ON location 
FOR EACH ROW
BEGIN
	UPDATE 
			Employee
        SET
			location_id = NULL
		WHERE  
			location_id = OLD.location_id;
END$$
DELIMITER ;

DELETE FROM Location
WHERE location_id =4;

SELECT * FROM employee;