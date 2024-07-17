/* Create database nccs_db */
CREATE DATABASE nccs_db;

USE nccs_db;

/*Table structure for table `tbl_student` */
CREATE TABLE tbl_student (
	student_id INT(11) NOT NULL AUTO_INCREMENT,
	student_name VARCHAR(50),
	gender VARCHAR(50),
	birthdate DATE,
	phone VARCHAR(10),
	email VARCHAR(50),
	address VARCHAR(50),
	program VARCHAR(50),
	created_date TIMESTAMP CURRENT_TIMESTAMP(),
	PRIMARY KEY (`student_id`)
);

/*Data for the table `tbl_student` */

/*Table structure for table `tbl_users` */
CREATE TABLE tbl_users (
	user_id INT(11) NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(50),
	gender VARCHAR(50),
	birthdate DATE,
	phone VARCHAR(10),
	email VARCHAR(50),
	address VARCHAR(50),
	`password` VARCHAR(50),
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`user_id`)
);

/*Data for the table `tbl_users` */
INSERT INTO `tbl_users` (user_name, gender, birthdate, phone, email, address)
	VALUES ('Admin', 'Male', '2002-01-05', '9834567890', 'admin@example.com', 'Kathmandu');
	