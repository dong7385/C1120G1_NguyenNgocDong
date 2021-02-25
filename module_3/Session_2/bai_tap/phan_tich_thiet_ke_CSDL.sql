drop database if exists session_2_sale_management;
create database session_2_sale_management;
use session_2_sale_management;
create table Customer (
   customerNumber  int primary key not null,
   customerName  varchar(50) not null,
   contactLastName  varchar(50) not null,
   contactFirstName  varchar(50) not null,
   phone varchar(50) not null,
   addressLine1  varchar(50) not null,
   addressLine2  varchar(50) not null,
   city varchar(50) not null,
   state varchar(50) not null,
   postalCode  varchar(15) not null,
   country varchar(50) not null,
   creditLimit  double,
   employeeNumber int not null unique,
   foreign key employee(employeeNumber)references employee(employeeNumber)
);
create table orders (
   orderNumber  int primary key not null,
   orderDate  date not null,
   requiredDate  date not null,
   shippedDate  date,
   statusOrder  varchar(15) not null,
   comments text,
   quantityOrdered  int not null,
   priceEach  double not null,
   customerNumber  int not null ,
   foreign key (customerNumber) references Customers(customerNumber)
   
);
create table payments (
   customerNumber int not null unique,
   checkNumber  varchar(50) not null,
   paymentDate  date not null,
   amount double not null ,
   customerNumber  int not null ,
   foreign key (customerNumber) references Customers(customerNumber)
);
create table products (
   productCode varchar(15) primary key not null,
   productName  varchar(70) not null,
   productScale varchar(10) not null,
   productVendor  varchar(50) not null,
   productDescription  text not null,
   quantityInStock  int not null,
   buyPrice double not null,
   MSRP  double not null,
   productLine varchar(50) not null,
   foreign key(productLine)references productlines(productLine)
   
);
create table productlines (
   productLine  varchar(50) primary key not null,
   textDescription  text not null,
   image  text not null
);
create table employees (
   employeeNumber  int primary key not null,
   lastName  varchar(50) not null,
   firstName varchar(50) not null,
   email varchar(100) not null,
   jobTitle   varchar(50) not null,
 officeCode varchar(10),
 foreign key offices(officeCode)references offices(officeCode)
);
create table offices (
   officeCode varchar(10) primary key not null,
   city  varchar(50) not null,
   phone varchar(50) not null,
   addressLine1  varchar(50) not null,
   addressLine2 varchar(50) not null,
   state varchar(50) not null,
   country varchar(50) not null,
   postalCode  varchar(15) not null
);
create table products_order(
orderNumber  int,
productCode varchar(15),
primary key (orderNumber,productCode)

);



