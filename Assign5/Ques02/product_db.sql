CREATE DATABASE product_db;

USE product_db;

CREATE TABLE products (
	id INT PRIMARY KEY,
	`name` VARCHAR(50),
	price DOUBLE NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO products VALUES ('01', 'Apple', '20', '2000');

INSERT INTO products VALUES ('02', 'Banana', '10', '100'), ('03', 'Dragonfruit', '300', '20'), ('04', 'Eggplant', '40', '10');