drop database if exists session_3_quan_ly_thu_vien;
create database session_3_quan_ly_thu_vien;
use session_3_quan_ly_thu_vien;

create table Student (
student_number varchar(15) primary key,
student_name varchar(50) ,
city varchar(255),
country varchar (255),
email varchar(50),
image varchar (8000)
);

create table Category(
catagoryId varchar(255) primary key,
catagory varchar (255)
);

create table BorrowOrder (
borrowOrderId varchar (255) primary key,
borrowOrderName varchar (255),
student_number varchar(15),
foreign key Student(student_number) references Student(student_number)
);

create table Book(
bookId varchar(255) primary key,
bookName varchar(255),
producer varbinary (255),
author varchar(255) ,
publishing varchar(255) ,
numberOfPublications varchar(255) ,
price varchar(255) ,
image varchar(8000) ,
borrowOrderId varchar (255),
foreign key BorrowOrder(borrowOrderId) references BorrowOrder(borrowOrderId),
catagoryId varchar(255),
foreign key Category(catagoryId)references Category(catagoryId)
);





