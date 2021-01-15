
DROP DATABASE IF EXISTS FINALEXAM;
CREATE DATABASE FINALEXAM;
USE FINALEXAM;

CREATE TABLE `Project`(
	ProjectID 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	TeamSize 	TINYINT  UNSIGNED	NOT NULL,
    IDManager 	TINYINT UNSIGNED	UNIQUE KEY,
	IDEmployees TINYINT UNSIGNED 	
    -- FOREIGN KEY (IDManager) 		REFERENCES  `User`(ID)
	
);
INSERT INTO `Project`  (TeamSize, IDManager, IDEmployees	) 
VALUES
						( 4		,1			, 3	),
						( 2		,4			, 1	),
						( 3		,3			, 2	),
						( 3		,2			, 2	);
                        
CREATE TABLE `User`(
	ID 	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(250)  	NOT NULL,
    Email 		VARCHAR(250)	UNIQUE KEY,
    `PassWord`	VARCHAR(50) 	NOT NULL,
    `Role`		ENUM("Manager","Employee"),
    ExpInYear 	TINYINT UNSIGNED DEFAULT 0,
    ProjectId	TINYINT UNSIGNED DEFAULT 0,
    ProSkill	VARCHAR(250) 
    -- FOREIGN KEY (ID) 		REFERENCES  `Project`(ProjectID)
);
INSERT INTO `User`(FullName				, Email					,`PassWord`		, `Role`		, ExpInYear, ProjectId, ProSkill) 
VALUES
					( "Nguyen Thi Chinh"	,"nchinh407@vti.com.vn"	, "aDmindf"		,"Manager"  , 9        ,1, null),
                    ( "Hoang Thi Lan"		,"Lan02@vti.com.vn"		, "lAn123"		,"Manager"  , 4        ,4, null),
                    ( "Hoang Van Linh"		,"Linh021@vti.com.vn"	, "linH123456"	,"Manager"  , 8        ,3, null),
                    ( "Nguyen Thi Mai"		,"Mai09554@vti.com.vn"	, "maO123"		,"Manager"  , 7        ,2, null),
                    ( "Ha Thi Tuyet Anh"	,"tuyetanh02@vti.com.vn", "tuytanh00"	,"Manager"  , 4        ,0, null),
                    ( "Nguyen Thi Thuy"		,"thuy854@vti.com.vn"	, "thuy984554"	,"Employee" , 0        , 1		, "dev"),
                    ( "Hoang Mau"			,"mau407@vti.com.vn"	, "mau123456"	,"Employee" , 0        , 1		, "java"),
					( "Ha Kim Linh"			,"linh123@vti.com.vn"	, "123456"		,"Employee" , 0        , 1		, "React"),
					( "Vu Van Hiep"			,"hiep123@vti.com.vn"	, "123456"		,"Employee" , 0        , 2		, "php"),
					( "Nguyen Thi Mai"		,"mai123@vti.com.vn"	, "123456"		,"Employee" , 0        , 3		, "sql"),
					( "Dao Quang Long"		,"long123@vti.com.vn"	, "123456"		,"Employee" , 0        , 3		, "python"),
					( "Hoang ha"			,"ha123@vti.com.vn"		, "123456"		,"Employee" , 0        , 4		, "javascript"),
					( "Hoang My"			,"my123@vti.com.vn"		, "123456"		,"Employee" , 0        , 4		, "C#");


SELECT u.ID, u.FullName
FROM  
Project p  LEFT JOIN `User` u ON  u.ID=p.IDManager
GROUP BY p.ProjectID
ORDER BY u.ID ;

Select * FROM  
`User`  
Where ProjectID=1;



