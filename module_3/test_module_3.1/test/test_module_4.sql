drop database if exists test_module_4;
create database test_module_4;
use  test_module_4;

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
standard_room varchar(45),
description_other_convenience varchar (45) ,
pool_area double,
number_of_floors int
);

insert into rent_type(rent_type_name, rent_type_cost)
values('Year', 140000), ('Month', 15000), ('Day', 500), ('Hour', 100);
insert into service_type(service_type_name)
values('Villa'), ('House'), ('Room');

insert into service(service_id,service_name, service_area, service_max_people, service_cost, rent_type_id, service_type_id,
standard_room, description_other_convenience, pool_area, number_of_floors)
values  ('DV-1',"Villa 1",100,5,1000,1,1,'Luxury','Balcony', 40, 3),
		('DV-2',"House 1",60,4,600,2,2,'Suite','Bathtub', null, 2),
		('DV-3',"Room 1",40,3,300,3,3, null, null, null, null),
		('DV-4',"Villa 2",80,5,800,4,1,'Luxury','Balcony', 40, 3),
		('DV-5',"Room 2",30,2,200,2,3, null, null, null, null),
        ('DV-6',"House 2",50,4,600,2,2,'Suite','Bathtub', null, 2);
        
        
    insert into thanhToan(hinhThucThanhToanTen)
values('thang'), ('quy'), ('nam');

insert into phongTro(phongTroId,phongTroTen,Sdt,ngayBatDauThue,hinhThucThanhToanId,ghiChu)
values	('PT-001','Nguyen Van A', 0905276588,'19/2/2012',1, 'Co phong Dieu Hoa'),
	('PT-002','Nguyen Van B', 0905276585,'19/2/2012',2, 'KHong co Dieu Hoa'),	
    ('PT-003','Nguyen Van c', 0905276587,'19/2/2012',3, 'Co phong Dieu Hoa');
    SELECT * FROM phongTro;
        