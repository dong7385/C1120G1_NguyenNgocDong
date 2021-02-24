create database thuc_hanh_1;
use thuc_hanh_1;
drop database c11_student;
create table quan_ly_nhan_vien(
Stt int ,
Tên_Nhân_Viên varchar(255),
Chức_Vụ varchar(255));
insert into quan_ly_nhan_vien(Stt,Tên_Nhân_Viên,Chức_Vụ)
values
(1,'Nguyễn_Văn_A','Trưởng_Phòng'),
(2,'Nguyễn_Văn_B','Nhân_Viên'),
(3,'Nguyễn_Văn_C','Tạp Vụ');
SET SQL_SAFE_UPDATES = 0;
delete from quan_ly_nhan_vien
where Chức_Vụ='Trưởng_Phòng';
SET SQL_SAFE_UPDATES = 1;
insert into quan_ly_nhan_vien(Stt,Tên_Nhân_Viên,Chức_Vụ)
values(1,'Nguyễn_Văn_A','Trưởng Phòng');
alter table quan_ly_nhan_vien
add column Mức_Lương varchar(255);
update quan_ly_nhan_vien
set Mức_Lương=100000000;
