
-- Create DB
DROP DATABASE IF EXISTS Assignment1;
CREATE DATABASE IF NOT EXISTS Assignment1;
-- Use Database
USE Assignment1;
-- Excercise 1:
-- Create Table Trainee
DROP TABLE IF EXISTS Trainee;
CREATE TABLE IF NOT EXISTS Trainee (
		TraineeID 			INT AUTO_INCREMENT PRIMARY KEY,
		Full_Name 			VARCHAR(50) NOT NULL,
		Birth_Date 			DATE NOT NULL,
		Gender 				ENUM('Male','Female','Unknown') NOT NULL,
		ET_IQ 				TINYINT UNSIGNED NOT NULL,
		ET_Gmath 			TINYINT UNSIGNED NOT NULL,
		ET_English 			TINYINT UNSIGNED NOT NULL,
		Training_Class 		VARCHAR(50) NOT NULL,
		Evaluation_Notes 	VARCHAR(500) NOT NULL
);
ALTER TABLE Trainee ADD VTI_Account VARCHAR(200) UNIQUE NOT NULL;

-- Excercise 2:
CREATE TABLE Ex2 (
		ID 				TINYINT AUTO_INCREMENT PRIMARY KEY,
		`Name` 			VARCHAR(50) NOT NULL,
		`Code` 			CHAR(5) NOT NULL,
		ModifiedDate 	DATETIME NOT NULL
);
-- Excercise 3:
CREATE TABLE Ex3 (
		ID 				TINYINT AUTO_INCREMENT PRIMARY KEY,
		`Name` 			VARCHAR(50) NOT NULL,
		BirthDate 		DATE NOT NULL,
		Gender 			ENUM('0','1'),
        IsDeletedFlag 	BIT NOT NULL
);