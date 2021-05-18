drop database if exists test_module_3;
create database test_module_3;
use  test_module_3;

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

insert into customer_type(customer_type_name)
values('Diamond'), ('Platinium'), ('Gold'), ('Silver'), ('Members');

insert into customer(customer_id,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone,customer_email, customer_address)
values	('KH-3',3, 'Lý liên Kiệt','1995/04/05', 1, '345345345', 0908111222, 'lylienkiet@gmail.com','Czech'),
		('KH-33',3, 'Trương Tam Phong', '2000/03/05', 1, '111222333', 0908111333, 'trungtamphong@gmail.com', 'Spain'),
		('KH-32',2, 'Trương Vô Kị', '2001/11/11', 1, '343444555', 0908111444, 'truongvoki@gmail.com', 'France'),
		('KH-31',1, 'Hồng Liên Quang', '2001/04/05', 0, '111111111', 0908111545, 'honglienquang@gmail.com', 'England'),
		('KH-34',2,'Phương Thế Ngọc', '1994/12/12', 0, '020202021', 0908111666,'phuongthengoc@gmail.com','USA'),
        ('KH-35', 4,'Lý Mạc Sầu', '1986/12/12', 1, '027699843', 0976798223,'lymacsau@gmail.com','Germany');
