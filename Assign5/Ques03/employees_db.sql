CREATE DATABASE employees_db;

USE employees_db;

CREATE TABLE employees (
	id INT PRIMARY KEY,
	`name` VARCHAR(50),
	`position` VARCHAR(50),
    salary DOUBLE
);