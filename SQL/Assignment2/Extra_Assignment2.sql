-- Exercise 1: Tiếp tục với Database quản lý Fresher

USE extra_assignment2;
DROP TABLE IF EXISTS Trainee;
CREATE TABLE IF NOT EXISTS Trainee (
		TraineeID 			INT AUTO_INCREMENT PRIMARY KEY,
		Full_Name 			VARCHAR(100) NOT NULL,
		Birth_Date 			DATE NOT NULL,
		Gender 				ENUM('Male','Female','Unknown') NOT NULL,
		ET_IQ 				TINYINT UNSIGNED NOT NULL,
		ET_Gmath 			TINYINT UNSIGNED NOT NULL,
		ET_English 			TINYINT UNSIGNED NOT NULL,
		Training_Class 		VARCHAR(50) NOT NULL,
		Evaluation_Notes 	VARCHAR(500) NOT NULL
);
-- Question 1:
INSERT INTO 
		Trainee
VALUES 	
		(1, 'Đình Tuấn', '1999-07-23', 'Male', 20, 20, 50, 'A007', 'Perfect'),
		(2, 'Bảo Anh', '1999-10-05', 'Male', 10, 10, 25, 'A007', 'Mischief'),
		(3, 'Thùy Dương', '1999-12-03', 'Female', 14, 16, 45, 'A002', 'Docile'),
		(4, 'Quỳnh Anh', '1999-12-10', 'Female', 10, 20, 15, 'A001', 'Docile'),
		(5, 'Đình Tú', '2002-01-22', 'Male', 9, 10, 36, 'A004', 'Mischief'),
		(6, 'Đậu Hiền', '1999-06-14', 'Female', 3, 10, 50, 'A002', 'Docile'),
		(7, 'Đắc Công', '1999-01-01', 'Male', 10, 10, 16, 'A006', 'Mischief'),
		(8, 'Trà My', '1999-03-05', 'Female', 12, 14, 35, 'A001', 'Docile'),
		(9, 'Phan Ngọc', '1977-06-01', 'Female', 20, 20, 40, 'A003', 'Perfect'),
		(10, 'Nguyễn Ngân', '1999-07-23', 'Female', 15, 12, 25, 'A005', 'Docile'),
		(11, 'Nguyễn Thảo', '1999-11-1', 'Female', 1, 2, 25, 'A003', 'Mischief'),
		(12, 'Phương Hoa', '1999-12-04', 'Female', 5, 2, 29, 'A004', 'Docile'),
		(13, 'Đức Vượng', '1999-07-19', 'Male', 15, 12, 45, 'A005', 'Docile');				

-- Question 2:
SELECT 
	*, MONTH (Birth_Date) AS MONTH, Count(MONTH (Birth_Date)) AS CountUser
FROM 
	Trainee
WHERE 
	ET_IQ>10
GROUP BY 
	MONTH(Birth_Date);

-- Question3:
SELECT 
	char_length(Full_Name) AS Length,Full_Name,Birth_Date,Gender,ET_IQ,ET_Gmath,ET_English,Training_Class,Evaluation_Notes
FROM 
	Trainee	
ORDER BY char_length(Full_Name) DESC LIMIT 1;

-- Question4:
SELECT * 
FROM 
	Trainee 
WHERE 
	ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18 AND ET_IQ + ET_Gmath>=20;
    
-- Question5:
DELETE FROM Trainee WHERE TraineeID=3;

-- Question6:
UPDATE trainee SET Trainee_Class='A002' WHERE TraineeID=5;

-- Exercise 2:
DROP TABLE IF EXISTS Department;
CREATE TABLE IF NOT EXISTS Department (
			Department_Number INT AUTO_INCREMENT PRIMARY KEY,
			Department_Name VARCHAR(100) NOT NULL
);
INSERT INTO 
			Department (Department_Name)
VALUES 
			('SAMSUNG'),
            ('SONY'),
            ('LG'),
            ('CANON');

DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE IF NOT EXISTS Employee_Table (
			Employee_Number INT AUTO_INCREMENT PRIMARY KEY,
			Employee_Name VARCHAR(100) NOT NULL,
            Department_Number INT NOT NULL,
            FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)
);
INSERT INTO 
			Employee_Table (Employee_Name, Department_Number)
VALUES 
			('Soobin Hoang Son', 2),
            ('Tran Thanh MC', 3),
            ('Truong Giang MC', 1),
            ('Quan AP', 4),
            ('My Tam', 1),
            ('Dam Vinh Hung', 3),
            ('Binz', 2),
            ('SuBoi', 1),
            ('Big Daddy', 2),
            ('Erik', 3),
            ('Duc Phuc', 4),
            ('Hari Won', 2);

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE IF NOT EXISTS Employee_Skill_Table (
			Employee_Number INT NOT NULL,
			Skill_Code VARCHAR(100) NOT NULL,
            Date_Registered DATE DEFAULT(now()),
            FOREIGN KEY (Employee_Number) REFERENCES Employee_Table(Employee_Number)
);
INSERT INTO 
			Employee_Skill_Table (Employee_Number, Skill_Code)
VALUES
			(1, 'JAVA'),
            (2, 'PYTHON'),
            (3, 'HTML'),
            (4, 'CSS'),
            (5, 'JAVA'),
            (6, 'C#'),
            (7, 'SQL'),
            (8, 'PHOTOSHOP'),
            (9, 'JAVA'),
            (10, 'JAVA'),
            (11, 'HTML'),
            (12, 'C#');

-- Question 3:
SELECT
		EST.Employee_Number, Employee_Name
FROM
		Employee_Table ET, Employee_Skill_Table EST
WHERE
		ET.Employee_Number=EST.Employee_Number
AND
        Skill_Code='JAVA';

-- Question 4:
SELECT 
		et.Department_Number, d.Department_Name, Count(Employee_Number) AS Count_Employees 
FROM
		Employee_Table et, Department d
WHERE
		d.Department_Number=et.Department_Number
GROUP BY
		Department_Number
HAVING
		Count(Employee_Number) > 3;

-- Question 5:
SELECT 
		Department_Number, Employee_Name
FROM 
		Employee_Table
ORDER BY 
		Department_Number;

-- Question 6:
SELECT 
		est.Employee_Number, et.Employee_Name, Count(Skill_Code) AS Count_Skill_Code 
FROM
		Employee_Table et, Employee_Skill_Table est
WHERE
		et.Employee_Number=est.Employee_Number
GROUP BY
		Employee_Number
HAVING
		Count(Skill_Code) > 1;