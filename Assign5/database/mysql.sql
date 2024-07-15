/* Create database 'nccs_db' */
CREATE DATABASE nccs_db;

/* Create table 'tbl_users' with its required column */
CREATE TABLE tbl_users (
	user_id INT AUTO_INCREMENT PRIMARY KEY, 
	user_name VARCHAR(50), 
	gender VARCHAR(50), 
	birthdate DATE, 
	phone VARCHAR(10), 
	email VARCHAR(50), 
	address VARCHAR(50), 
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* Add 'Admin' details into 'tbl_users' table usinf terminal */
INSERT INTO tbl_users (user_name, gender, birthdate, phone, email, address)
VALUES ('Admin', 'Male', '2002-01-05', '9834567890', 'admin@example.com', 'Kathmandu');

/* Create table 'tbl_student' with its required column */
CREATE TABLE tbl_student (
	student_id INT AUTO_INCREMENT PRIMARY KEY, 
	student_name VARCHAR(50), 
	gender VARCHAR(50), 
	birthdate DATE, 
	phone VARCHAR(10), 
	email VARCHAR(50), 
	address VARCHAR(50), 
	program VARCHAR(50),
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
