drop database if exists Session_4_bai_tap_cac_ham_thong_dung;
create database Session_4_bai_tap_cac_ham_thong_dung;
use Session_4_bai_tap_cac_ham_thong_dung;

create table HocVien(
ID int auto_increment primary key,
TEN varchar(255),
TUOI int,
KHOAHOC varchar(255),
SOTIEN double
);

insert into HocVien(TEN,TUOI,KHOAHOC,SOTIEN)
values
('Hoang',21,'CNTT',400000),
('Viet',19,'DTVT',320000),
('Thanh',18,'KTDN',400000),
('Nhan',19,'CK',450000),
('Huong',20,'TCNH',500000),
('Huong',20,'TCNH',200000)
;

select ID,TEN,TUOI,KHOAHOC,SOTIEN
from HocVien
where TEN='Huong';

select ID,TEN,TUOI,KHOAHOC,sum(SOTIEN)as TONGTIEN
from HocVien
where TEN='Huong';

select ID,TEN,TUOI,KHOAHOC,SOTIEN
from HocVien
group by TEN;



