-- Create DB
DROP DATABASE IF EXISTS Exam_Manager ;
CREATE DATABASE IF NOT EXISTS Exam_Manager;
-- Use Database
USE Exam_Manager;
-- create tables:
CREATE TABLE IF NOT EXISTS Department (
		DepartmentID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		DepartmentName 			NVARCHAR(50) NOT NULL
);
INSERT INTO  Department(DepartmentName)
VALUES ('Sale'), ('Marketing'),(N'Bảo Vệ'),(N'Nhân sự'),(N'Kỹ thuật');

CREATE TABLE IF NOT EXISTS `Position` (
		PositionID 				TINYINT AUTO_INCREMENT PRIMARY KEY,
		PositionName			ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL
);
INSERT INTO  `Position`(PositionName)
VALUES ('Dev'), ('Test'),('Scrum Master'),('PM');

CREATE TABLE IF NOT EXISTS `Account` (
		AccountID 			TINYINT AUTO_INCREMENT PRIMARY KEY,
		Email 				VARCHAR(50),
		Username 			VARCHAR(50) NOT NULL,
		FullName 			NVARCHAR(50),
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
		GroupName 			VARCHAR(50) NOT NULL,
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
		CategoryName 	VARCHAR(50) NOT NULL
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

-- Question 1: lấy ra tất cả các phòng ban
SELECT * 
FROM Department;

-- Question 2: lấy ra id của phòng ban có tên là "Sale"
SELECT 
		DepartmentID 
FROM 
		Department 
WHERE 
		DepartmentName = 'Sale';

-- Question 3: lấy ra thông tin account có full name dài nhất
SELECT 
		* 
FROM 
		`Account`
WHERE 
		length(FullName) = (SELECT MAX(length(FullName)) FROM `Account`);

-- Question 4: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT 
		GroupName 
FROM 
		`Group` 
WHERE 
		CreateDate < 2019-12-20;

-- Question 5: Lấy ra ID của question có >= 4 câu trả lời
SELECT 
		QuestionID 
FROM 
		Answer
GROUP BY 
		QuestionID 
HAVING 
		count(QuestionID) >=4;

-- Question 6: Lấy ra 5 group được tạo gần đây nhất
SELECT * 
FROM 
		`Group` 
ORDER BY 
		CreateDate DESC LIMIT 5;

-- Question 7: không có câu hỏi
-- Question 8: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam WHERE CreateDate < 2019-12-20;

-- Question 9: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account` 
SET FullName= N'Nguyễn Bá Lộc', Email='loc.nguyenba@vti.com.vn'
WHERE AccountID=5;

-- Question 10: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 
		* 
FROM 
		`Account` a, Department d
WHERE 
		a.DepartmentID = d.DepartmentID;

-- Question 11: Viết lệnh để lấy ra tất cả các developer
SELECT 
		*
FROM 
		`Account`
WHERE 
		PositionID=(SELECT PositionID, PositionName 
					FROM `Position` 
                    WHERE PositionName='Dev');

-- Question 12: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 
		Department.*
FROM 
		Department d, `Account` a
WHERE 
		d.DepartmentID=a.DepartmentID
GROUP BY 
		a.DepartmentID
HAVING 
		count(a.DepartmentID)>3;

-- Question 13: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 
		q.*,eq.ExamID, count(eq.QuestionID) AS QuestionUsed
FROM 
		ExamQuestion eq, Question q
WHERE 
		eq.QuestionID= q.QuestionID
GROUP BY 
		eq.ExamID
ORDER BY 
		count(QuestionID) DESC 
LIMIT 1;

-- Question 14: Thông kê mỗi category Question được sử dụng trong bao nhiêu question
SELECT 
		cq.*, count(q.QuestionID) AS SUMQuestion
FROM 
		CategoryQuestion cq, Question q
WHERE 
		cq.CategoryID = q.CategoryID
GROUP BY 
		q.CategoryID;

-- Question 15: Lấy ra Question có nhiều câu trả lời nhất
SELECT 
		a.QuestionID, q.QuestionName, count(a.AnswerID)
FROM 
		Question q, Answer a
WHERE 
		q.QuestionID=a.QuestionID
GROUP BY 
		a.QuestionID
HAVING count(a.AnswerID) >=ALL(
								SELECT  count(a.AnswerID) 
                                FROM Question q, Answer a
                                WHERE q.QuestionID=a.QuestionID
                                GROUP BY a.QuestionID);

-- Question 16: Tìm chức vụ có ít người nhất
SELECT 
		a.PositionID, p.PositionName, count(a.AccountID) AS Users
FROM 
		Position p, `Account` a
WHERE 
		p.PositionID = a.PositionID
GROUP BY 
		a.PositionID
ORDER BY 
		count(a.AccountID)
LIMIT 1;

-- Question 17: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 
			a.DepartmentID, d.DepartmentName,a.PositionID, p.PositionName, count(a.AccountID) AS Tongso
FROM 
			 `Account` a, Department d, `Position` p
WHERE 
			d.DepartmentID = a.DepartmentID
		AND 
			a.PositionID = p.PositionID
GROUP BY 
			a.DepartmentID, a.PositionID;

-- Question 18: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, ...
SELECT 
			q.QuestionID, q.Content, q.CreateDate, t.TypeName, cq.CategoryName, a.FullName AS FullNameCreator, r.Content AS ContentAnswer
FROM 
			Question q, Answer r, CategoryQuestion cq, TypeQuestion t, `Account` a
WHERE 
			q.CreatorID = a.AccountID 
		AND
			q.QuestionID = r.QuestionID 
		AND
			q.CategoryID = cq.CategoryID 
		AND
			q.TypeID = t.TypeID;

-- Question 19: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT 
		q.TypeID, t.TypeName, count(q.QuestionID) AS TOTAL
FROM 
		TypeQuestion t, Question q
WHERE 
		t.TypeID = q.TypeID
GROUP BY 
		q.TypeID;