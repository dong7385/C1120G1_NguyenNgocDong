drop database if exists session_2_xac_dinh_khoa;
create database session_2_xac_dinh_khoa;
use session_2_xac_dinh_khoa;
create table Customers(
customer_number varchar(255) primary key,
fullname varchar(255) not null,
address varchar(255),
email varchar(20),
phone int
); 
create table accounts(
account_number  varchar(255)  primary key,
account_type  varchar(255) ,
date_acount  date,
balance  int,
customer_number varchar(255),
foreign key(customer_number)references Customers(customer_number)
); 
create table transactions(
tran_number varchar (255)primary key,
ccount_number varchar(255),
date_acount date,
amounts varchar(255),
account_number  varchar(255),
foreign key(account_number)references accounts(account_number)
);

