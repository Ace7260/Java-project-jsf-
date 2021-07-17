Create database Cashpower;

use Cashpower;

CREATE TABLE CashTable (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(100),
surname VARCHAR(100),
email VARCHAR(50),
date VARCHAR(50),
number VARCHAR(50),
password VARCHAR(20),
typeCompteur VARCHAR(100),
gender VARCHAR(1), 
address VARCHAR(100));