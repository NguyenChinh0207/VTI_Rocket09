USE exam_manager;
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các
-- account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS getAccountInDepartment;
DELIMITER $$
CREATE PROCEDURE getAccountInDepartment(IN in_Department_Name NVARCHAR(50))
		BEGIN
			SELECT a.*
			FROM Department d
            JOIN `Account` a ON a.DepartmentID= d.DepartmentID
			WHERE d.DepartmentName= in_Department_Name;
		END$$
DELIMITER ;

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS get_soluong_account;
DELIMITER $$
CREATE PROCEDURE get_soluong_account(IN in_GroupID TINYINT)
BEGIN
	SELECT GroupID, COUNT(accountID) as 'Số lượng Account'
    FROM groupaccount
    WHERE GroupID = in_GroupID
    GROUP BY GroupID;
END$$
DELIMITER ;

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo
-- trong tháng hiện tại
DROP PROCEDURE IF EXISTS statistical_typeQ;
DELIMITER $$
CREATE PROCEDURE statistical_typeQ()
BEGIN
	SELECT typeID, count(questionID) as 'số lượng question được tạo', group_concat(createdate) as CreateDate
    FROM Question
    WHERE YEAR(createDate)= YEAR(NOW())
			AND MONTH(createDate)=MONTH(NOW())
    GROUP BY typeID;
END$$
DELIMITER ;

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS MAX_statistical_typeQ;
DELIMITER $$
CREATE PROCEDURE MAX_statistical_typeQ()
BEGIN
	SELECT typeID, count(questionID) as 'số lượng question', group_concat(questionID) as questions
    FROM Question
    GROUP BY typeID
    HAVING count(questionID)= (SELECT count(questionID)
								FROM Question
                                Group by typeID
								ORDER BY count(questionID) DESC
                                LIMIT 1);
    
END$$
DELIMITER ;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS MAX_statistical_typeName;
DELIMITER $$
CREATE PROCEDURE MAX_statistical_typeName()
BEGIN
	SELECT t.typeID, t.typeName, count(questionID) as 'số lượng question', group_concat(questionID) as questions
    FROM typequestion t
		LEFT JOIN Question q
		ON t.typeID=q.typeID
    GROUP BY q.typeID
    HAVING count(questionID)= (SELECT count(questionID)
								FROM Question
                                Group by typeID
								ORDER BY count(questionID) DESC
                                LIMIT 1);
END$$
DELIMITER ;
CALL MAX_statistical_typeName();
-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS Return_groupName_or_username;
DELIMITER $$
CREATE PROCEDURE Return_groupName_or_username
(IN	in_string VARCHAR(50), IN in_select ENUM('GROUP', 'ACCOUNT'))
BEGIN
	IF in_select = 'GROUP' THEN
		SELECT 	*
        FROM	`Group`
        WHERE	GroupName LIKE concat('%',in_string,'%');
	ELSE
		SELECT 	*
        FROM	`Account`
        WHERE	Username LIKE concat('%',in_string,'%');
	END IF;
END$$
DELIMITER 

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và
-- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_importInf_Of_Account;
DELIMITER $$
CREATE PROCEDURE sp_importInf_Of_Account(IN in_fullName NVARCHAR(50),IN	in_email VARCHAR(50))
BEGIN
	
END$$
DELIMITER ;

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS Max_Content_TypeName;
DELIMITER $$
CREATE PROCEDURE Max_Content_TypeName(IN in_TypeName ENUM('Essay', 'Multiple-Choice'))
BEGIN
	IF (in_TypeName = 'Essay') THEN
			SELECT	Content, MAX(CHAR_LENGTH(Content))
			FROM	Typequestion t
			LEFT JOIN Question q ON q.TypeID= t.TypeID
			WHERE	t.TypeName= 'Essay';
		ELSEIF (in_TypeName = 'Multiple-Choice') THEN
			SELECT	Content, MAX(CHAR_LENGTH(Content))
			FROM	Typequestion t
			LEFT JOIN Question q ON q.TypeID= t.TypeID
			WHERE	t.TypeName= 'Multiple-Choice';
	END IF;
END$$
DELIMITER ;
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS DeleteExamWithID;
DELIMITER $$
CREATE PROCEDURE DeleteExamWithID(IN in_ExamID TINYINT)
BEGIN
	DELETE 	
    FROM 	Exam 
    WHERE	ExamID = in_ExamID;	
    SELECT * FROM Exam;
END$$
DELIMITER ;

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử
-- dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi
-- removing
DROP PROCEDURE IF EXISTS DeleteExamCreate3Year;
DELIMITER $$
CREATE PROCEDURE DeleteExamCreate3Year()
BEGIN
	CREATE OR REPLACE VIEW Exam3Year AS
		SELECT *
		FROM exam
		WHERE (YEAR(NOW()) - YEAR(CreateDate)) > 3;
    
    SELECT count(1) AS 'Count column remove in examquestion'
    FROM examquestion 
    WHERE ExamID = (SELECT * FROM Exam3Year);
    
	DELETE 	
    FROM 	Exam 
    WHERE	ExamID = (SELECT * FROM Exam3Year);
    SELECT * FROM Exam;
END$$
DELIMITER ;

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
-- nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS Delete_Dep;
DELIMITER $$
CREATE PROCEDURE Delete_Dep(IN in_DepName NVARCHAR(50))
BEGIN	
	DELETE 
    FROM	Department
    WHERE	DepartmentName = in_DepName;
    
    UPDATE 	`Account`
    SET		DepartmentName = 'phòng chờ'
    WHERE	DepartmentID = (SELECT 	DepartmentID	
							FROM	Department
							WHERE 	DepartmentName = in_DepName);
END$$
DELIMITER ;

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm
-- nay
DROP PROCEDURE IF EXISTS Month_CreateQ;
DELIMITER $$
CREATE PROCEDURE Month_CreateQ()
BEGIN
	SELECT MONTH(createDate), count(*) AS countQuestion
    FROM Question
    WHERE YEAR(createDate)= YEAR(NOW())		
    GROUP BY MONTH(createDate);
END$$
DELIMITER ;

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6
-- tháng gần đây nhất
-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong
-- tháng")

DROP PROCEDURE IF EXISTS CountQ_In_Month_In_6Month;
DELIMITER $$
CREATE PROCEDURE CountQ_In_Month_In_6Month()
BEGIN
	
END$$
DELIMITER ;
