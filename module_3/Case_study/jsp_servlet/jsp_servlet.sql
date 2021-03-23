drop database if exists case_study_jsp_servlet;
create database case_study_jsp_servlet;
use  case_study_jsp_servlet;
create table `position` (
position_id int auto_increment primary key ,
position_name varchar(45) 
); 
create table education_degree(
education_degree_id int auto_increment primary key,
education_degree_name varchar(45) 
);
create table division (
division_id int auto_increment primary key,
division_name varchar(45)
);
create table  `role` (
role_id int auto_increment primary key,
role_name varchar(45)
);
create table `user`(
username varchar (255) primary key,
userpassword varchar(255)
);
create table user_role (
role_id int  ,
foreign key (role_id) references `role`(role_id) on update cascade on delete cascade,
username varchar (255),
foreign key (username) references `user`(username) on update cascade on delete cascade

);

create table attach_service(
attach_service_id int auto_increment primary key,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit int not null,
attach_service_status varchar(45)
);

create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);
create table customer(
customer_id varchar(45)  primary key,
customer_type_id int ,
foreign key (customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade,
customer_name varchar (255) not null,
customer_birthday date not null,
customer_gender bit (1) not null,
customer_id_card varchar (45) not null,
customer_phone varchar(45) not null,
customer_email varchar (45) ,
customer_address varchar (45)
);
create table employee (
employee_id int primary key auto_increment ,
employee_name varchar (45) not null, 
employee_birthday date not null,
employee_id_card varchar (45) not null,
employee_salary double not null,
employee_phone varchar (45) not null,
employee_email varchar(45) ,
employee_address varchar(45),
position_id int not null ,
foreign key (position_id) references`position`(position_id) on update cascade on delete cascade,
education_degree_id int not null,
foreign key (education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
division_id int not null,
foreign key (division_id) references division(division_id) on update cascade on delete cascade,
username varchar(255),
foreign key (username) references `user`(username) on update cascade on delete cascade
); 
create table service_type(
service_type_id int auto_increment primary key,
service_type_name varchar (45) 
);
create table rent_type(
rent_type_id int auto_increment primary key,
rent_type_name varchar(45) ,
rent_type_cost double 
);
create table service(
service_id varchar(45) primary key ,
service_name varchar(45) not null,
service_area int ,
service_cost double not null,
service_max_people int ,
rent_type_id int not null,
foreign key (rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade,
service_type_id int not null,
foreign key (service_type_id) references service_type(service_type_id) on update cascade on delete cascade,
standar_room varchar(45),
description_other_convenience varchar (45) ,
pool_area double,
number_of_floors int
);
create table contract(
contract_id int primary key auto_increment,
contract_start_day datetime not null,
contract_end_day datetime not null,
contract_deposit double not null,
contract_total_money double not null,
employee_id int not null,
foreign key (employee_id) references employee(employee_id) on update cascade on delete cascade,
customer_id varchar(45) not null,
foreign key (customer_id) references customer(customer_id) on update cascade on delete cascade,
service_id varchar(45) not null,
foreign key (service_id) references service(service_id) on update cascade on delete cascade
);
create table contract_detail(
contract_detail_id int auto_increment primary key,
contract_id int ,
 foreign key (contract_id) references contract(contract_id) on update cascade on delete cascade  ,
attach_service_id int ,
foreign key (attach_service_id) references attach_service(attach_service_id)  on update cascade on delete cascade,
quantity int not null
);

insert into `position`(position_name)
values  ('Giam Doc'), ('Quan Ly'), ('Giam Sat'), ('Chuyen Vien'), ('Phuc Vu'), ('Le Tan');
insert into education_degree(education_degree_name)
values('Trung Cap'), ('Cao Dang'), ('Dai Hoc'), ('Sau Dai Hoc');
insert into division(division_name)
values('Sale_Marketing'), ('Hanh Chinh'), ('Phuc Vu'), ('Quan Ly');
insert into customer_type(customer_type_name)
values('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Members');
insert into rent_type(rent_type_name, rent_type_cost)
values('Year', 140000), ('Month', 15000), ('Day', 500), ('Hour', 100);
insert into service_type(service_type_name)
values('Villa'), ('House'), ('Room');
insert into attach_service(attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values 	('Massage', 35, 1, 'Available'),
		('Karaoke', 10, 1, 'Available'),
        ('Food', 25, 1, 'Available'),
        ('Drink', 10, 1, 'Available'),
        ('RentalCar', 40, 1, 'Available');
insert into `role`(role_name)
values 	('Admin'),
		('Giam Doc'),
		('Quan Ly'),
        ('Giam Sat'),
        ('Nhan Vien'),
        ('Nguoi Dung');
insert into `user`(username, userpassword)
values 	('admin', 'admin'),
		('giamdoc', 'giamdoc'),
        ('quanly', 'quanly'),
        ('giamsat', 'giamsat'),
        ('nhanvien', 'nhanvien'),
        ('nguoidung', 'nguoidung');
insert into user_role(role_id, username)
values	(1, 'admin'),
		(2, 'giamdoc'),
        (3, 'quanly'),
        (4, 'giamsat'),
        (5, 'nhanvien'),
        (6, 'nguoidung');
insert into employee(employee_name, position_id, education_degree_id,division_id, username, employee_birthday, 
employee_id_card, employee_salary, employee_phone, employee_email, employee_address)
values 	('Trần Quốc Hoàng', 1, 2, 4, 'giamdoc','1995/12/12', '123123123', '300000', '0909123111', 'hoangtq@gmail.com', 'Quảng Nam'),
		('Ngọc Thuần', 2, 2, 4, 'quanly','2000/10/05', '123123444', 400000, '0909123121', 'thuanng@gmail.com', 'TP HCM'),
		('Lê Quang',  3, 3, 4, 'giamsat','1998/02/11', '123123555', 900000, '0909123345', 'quangle@gmail.com', 'Huế'),
		('Trần Hoàng Sang',  4, 2, 2, 'nhanvien','1995/04/04', '123123777', '300000', '0909123333', 'sangth@gmail.com', 'Quảng Bình'),
		('Bùi Khoa',  2, 3, 2, 'admin','1999/04/25', '123123999', '250000', '0909123222', 'khoa@gmail.com', 'Quảng Trị'),
        ('Lệnh Hồ Xung ', 5, 3, 3, 'nhanvien','1996/12/12', '123123127', '600000', '0909123111', 'xungtq@gmail.com', 'Quảng Nam'),
		('Doãn Chí Bình', 6, 1, 3, 'nguoidung','1992/10/05', '123123446', 100000, '0909123121', 'binh@gmail.com', 'TP HCM');
insert into customer(customer_id,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone,customer_email, customer_address)
values	('KH-3',3, 'Rosicky','1995/04/05', 1, '345345345', 0908111222, 'tomas@gmail.com','Czech'),
		('KH-33',3, 'Arteta', '2000/03/05', 1, '111222333', 0908111333, 'mikel@gmail.com', 'Spain'),
		('KH-32',2, 'Wenger', '2001/11/11', 1, '343444555', 0908111444, 'wenger@gmail.com', 'France'),
		('KH-31',1, 'Gemma Atkinson', '2001/04/05', 0, '111111111', 0908111545, 'gemmath@gmail.com', 'England'),
		('KH-34',2,'Cheryl Cole', '1994/12/12', 0, '020202021', 0908111666,'coleth@gmail.com','USA'),
        ('KH-35', 4,'Joachim Low', '1986/12/12', 1, '027699843', 0976798223,'low@gmail.com','Germany');
insert into service(service_id,service_name, service_area, service_max_people, service_cost, rent_type_id, service_type_id,
standar_room, description_other_convenience, pool_area, number_of_floors)
values  ('DV-1',"Villa 1",100,5,1000,1,1,'Luxury','Balcony', 40, 3),
		('DV-2',"House 1",60,4,600,2,2,'Suite','Bathtub', null, 2),
		('DV-3',"Room 1",40,3,300,3,3, null, null, null, null),
		('DV-4',"Villa 2",80,5,800,4,1,'Luxury','Balcony', 40, 3),
		('DV-5',"Room 2",30,2,200,2,3, null, null, null, null),
        ('DV-6',"House 2",50,4,600,2,2,'Suite','Bathtub', null, 2);
  
insert into contract(employee_id, customer_id, service_id, contract_start_day, contract_end_day, contract_deposit, contract_total_money)
values 	(3,'KH-3','DV-1',"2018-12-12","2019-03-12",100,0),
		(1,'KH-33','DV-5',"2019-01-12","2019-08-12",100,0),
		(2,'KH-32','DV-4',"2020-01-12","2020-10-12",100,0),
		(5,'KH-31','DV-6',"2021-01-12","2020-10-12",100,0),
		(4,'KH-34','DV-3',"2019-05-01","2021-05-01",100,0),
        (6,'KH-35','DV-2',"2016-12-12","2019-03-12",100,0);
       
        
insert into contract_detail(quantity)
values 	(4),
		(3),
		(3),
		(4),
		(5),
		(6)



