USE exam_manager;
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW Staff_Sale AS
    (SELECT 
        a.AccountID, a.FullName, d.DepartmentName
    FROM
        `account` a
	INNER JOIN
			Department d ON a.DepartmentID = d.DepartmentID
            AND DepartmentName = 'SALE');
SELECT * FROM Staff_Sale;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất

CREATE OR REPLACE VIEW MaxAccount_Group AS
    (SELECT 
        a.*, COUNT( g.GroupID) AS 'Tongso group'
    FROM
        `Account` a
	INNER JOIN
        GroupAccount g ON a.AccountID = g.AccountID
    GROUP BY a.AccountID
    HAVING COUNT(g.GroupID)= ( SELECT 
							   COUNT(GroupID) AS 'Số group đã join'
								FROM GroupAccount
								GROUP BY AccountID
								ORDER BY COUNT(GroupID) DESC
								LIMIT 1)
    );
SELECT * FROM MaxAccount_Group;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW MaxContentQuestion
AS
		(SELECT 	*
		FROM		Question
		WHERE		length(Content)>12
		);
SELECT * FROM MaxContentQuestion;


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW Department_MaxStaff AS
    SELECT 
        d.departmentID,
        d.departmentName,
        COUNT(a.AccountID) AS MaxAccount
    FROM
        Department d
	INNER JOIN
        `Account` a ON d.DepartmentID = a.DepartmentID
    GROUP BY a.departmentID
	HAVING COUNT(a.AccountID)=(SELECT COUNT(AccountID)
								FROM `Account`
                                GROUP BY departmentID
                                ORDER BY COUNT(AccountID) DESC
                                LIMIT 1);
SELECT * FROM Department_MaxStaff;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE VIEW Nguyen_Create AS
    (SELECT 
        *
    FROM
        question
    WHERE
        CreatorID IN (SELECT 
							AccountID
						FROM
							`Account`
						WHERE
							FullName LIKE 'Nguyễn%'));
SELECT * FROM Nguyen_Create;