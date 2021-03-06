
USE  Testing_System10;
CREATE TABLE IF NOT EXISTS Department (
		DepartmentID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		DepartmentName 			VARCHAR(250) NOT NULL
);
INSERT INTO  Department(DepartmentName)
VALUES ('Sale'), ('Marketing'),(N'Bao Ve'),(N'Nhan su'),(N'Ky thuat');

CREATE TABLE IF NOT EXISTS `Position` (
		PositionID 				TINYINT AUTO_INCREMENT PRIMARY KEY,
		PositionName			VARCHAR(250) NOT NULL
);
INSERT INTO  `Position`(PositionName)
VALUES ('Dev'), ('Test'),('Scrum Master'),('PM');

CREATE TABLE IF NOT EXISTS `Account` (
		AccountID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		Email 				VARCHAR(250),
		Username 			VARCHAR(250) NOT NULL,
		FullName 			NVARCHAR(250),
		DepartmentID 		TINYINT NOT NULL ,
		PositionID 			TINYINT NOT NULL,
		CreateDate 			DATE DEFAULT(NOW()),
		FOREIGN KEY (DepartmentID) 		REFERENCES  Department(DepartmentID) ON DELETE CASCADE,
		FOREIGN KEY (PositionID) 		REFERENCES  `Position`(PositionID) ON DELETE CASCADE
);
INSERT INTO  `Account`(Email,Username,FullName,DepartmentID,PositionID)
VALUES 		('nchinh407@gmail.com','Chinhnt', N'Nguyễn Thị Chinh',1,1), 
			('lan@gmail.com','lannt', N'Nguyễn Thị Lan',4,1),
            ('mai@gmail.com', 'maint', N'Nguyễn Văn Mai',4,1),
            ('hoa@gmail.com', 'hoant',N'Nguyễn Thị Hoa',1,2),
            ('kim@gmail.com', 'kimnt',N'Nguyễn Văn Kim',3,4);
            
CREATE TABLE `Group`  (
		GroupID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		GroupName 			VARCHAR(250) NOT NULL,
		CreatorID 			TINYINT NOT NULL,
		CreateDate 			DATE DEFAULT(NOW()),
		FOREIGN KEY (CreatorID) 		REFERENCES  `Account`(AccountID) ON DELETE CASCADE
);
INSERT INTO  `Group`(GroupName,CreatorID)
VALUES 		('SaleGroup', 1), 
			('MarketingGroup', 2),
            ('ProtectGroup', 4),
            ('StaffGroup', 4),
            ('DepartmentGroup', 2);

CREATE TABLE GroupAccount  (
		GroupID 			TINYINT NOT NULL,
		AccountID 			TINYINT NOT NULL,
		JoinDate 			DATE DEFAULT(NOW()),
		FOREIGN KEY (GroupID) 		REFERENCES  `Group`(GroupID) ON DELETE CASCADE,
		FOREIGN KEY (AccountID) 	REFERENCES  `Account`(AccountID) ON DELETE CASCADE
);
INSERT INTO  GroupAccount(GroupID,AccountID,JoinDate)
VALUES 		(1, 1, '2020-11-25'),
			(2, 2, '2020-11-25'),
			(1, 4, '2020-11-25'),
            (3, 4, '2020-11-25'),
			(2, 2, '2020-11-25');

CREATE TABLE TypeQuestion  (
		TypeID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		TypeName 		ENUM('Essay', 'Multiple-Choice') NOT NULL
);
INSERT INTO  TypeQuestion(TypeName)
VALUES 		('Essay'),('Multiple-Choice');

CREATE TABLE CategoryQuestion   (
		CategoryID 		TINYINT AUTO_INCREMENT PRIMARY KEY,
		CategoryName 	VARCHAR(250) NOT NULL
);
INSERT INTO  CategoryQuestion(CategoryName)
VALUES 		('SQL'),('Java'), ('NodeJS'),('Sales'),('React Native'),('JavaScript');

CREATE TABLE Question   (
		QuestionID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		Content 			NVARCHAR(500) NOT NULL,
		CategoryID 			TINYINT NOT NULL,
		TypeID 				TINYINT NOT NULL,
		CreatorID 			TINYINT NOT NULL,
		CreateDate 			DATE DEFAULT(NOW()),
		FOREIGN KEY (CategoryID) 		REFERENCES  CategoryQuestion(CategoryID) ,
		FOREIGN KEY (TypeID) 			REFERENCES  TypeQuestion(TypeID) ,
		FOREIGN KEY (CreatorID) 		REFERENCES  `Account`(AccountID) 
);
INSERT INTO  Question(Content,CategoryID,TypeID,CreatorID)
VALUES 		(N'SQL là gì', 1, 1,1),
			(N'SQL tên đầy đủ là gì', 1, 2,3),
            (N'Sales là gì', 4, 2,2),
            (N'NodeJS là gì', 3, 1,4),
			(N'React Native là gì', 1, 2,1);
  
CREATE TABLE Answer   (
		AnswerID 		TINYINT AUTO_INCREMENT PRIMARY KEY,
		Content 		NVARCHAR(500) NOT NULL,
		QuestionID 		TINYINT NOT NULL,
		isCorrect 		BOOLEAN NOT NULL,
		FOREIGN KEY (QuestionID) 		REFERENCES  Question(QuestionID) 
);
INSERT INTO  Answer(Content,QuestionID,isCorrect)
VALUES 		(N'Là ngôn ngữ truy vấn có cấu trúc', 1, 1),
			(N'Sales là sales', 3, 0),
            (N'Tất cả đáp án trên đều sai', 5, 1),
            (N'Khác', 4, 0),
            (N'Tôi Không biết', 2, 0);
            
CREATE TABLE Exam   (
		ExamID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		`Code` 			CHAR(10) UNIQUE ,
		Title 			NVARCHAR(200) NOT NULL,
		CategoryID 		TINYINT NOT NULL,
		Duration		INT NOT NULL,
		CreatorID		TINYINT NOT NULL,
		CreateDate		DATE DEFAULT(NOW()),
		FOREIGN KEY (CategoryID) 		REFERENCES  CategoryQuestion(CategoryID) ON DELETE CASCADE,
		FOREIGN KEY (CreatorID) 		REFERENCES  `Account`(AccountID) ON DELETE CASCADE
);

INSERT INTO  Exam(`Code`,Title,CategoryID,Duration,CreatorID)
VALUES 		('ABC01', N'Kiểm tra Java lần 1', 2, 120, 1),
			('ABC02', N'Bài thi SQL lần 1', 1, 60,1),
            ('ABC03', N'Bài thi lần 2', 3, 80,2),
            ('ABC04', N'Bài kiểm tra năng lực', 1, 90,3),
            ('ABC05', N'Kiểm tra sales', 4, 100,2);
            
CREATE TABLE ExamQuestion   (
		ExamID 			TINYINT NOT NULL,
		QuestionID 		TINYINT NOT NULL,
		FOREIGN KEY (ExamID) 		REFERENCES  Exam(ExamID) ON DELETE CASCADE,
		FOREIGN KEY (QuestionID) 	REFERENCES  Question(QuestionID) ON DELETE CASCADE
);
INSERT INTO  ExamQuestion(ExamID,QuestionID)
VALUES 		(2,1),
			(2,2),
            (5,4),
            (4,4),
            (3,5);
            
            
/*store procerduce */
DROP PROCEDURE IF EXISTS sp_delete_department;
DELIMITER $$
CREATE PROCEDURE sp_delete_department(IN id TINYINT)
BEGIN
	DELETE 	
    FROM 	Department 
    WHERE	DepartmentID = id;	
    SELECT * FROM Department;
END$$
DELIMITER ;