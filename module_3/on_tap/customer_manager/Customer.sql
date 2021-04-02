drop database if exists customer_manager;
create database customer_manager;
use customer_manager;

CREATE TABLE CustomerType (
    customerTypeId INT AUTO_INCREMENT PRIMARY KEY,
    customerTypeName VARCHAR(255)
);
CREATE TABLE Customer (
    customerId INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(255),
    customerBirthday VARCHAR(255),
    customerGender VARCHAR(255),
    customerTypeId INT,
    FOREIGN KEY (customerTypeId)
        REFERENCES CustomerType (customerTypeId)
);
