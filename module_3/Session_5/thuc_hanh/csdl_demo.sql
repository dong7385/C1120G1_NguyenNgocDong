drop database if exists session_5_demo;
create database session_5_demo;
use session_5_demo;

create table Products (
Id int auto_increment primary key,
productCode varchar(255),
productName varchar(255),
productPrice int,
productAmount int,
productDescription varchar(255),
productStatus varchar (255)
);

insert into Products(productCode,productName,productPrice,productAmount,productDescription,productStatus)
values
('A1','Đồng hồ Thụy Sĩ',500,5,'tang_dây_đeo','con_hang'),
('A2','Đồng hồ rolex',300,1,'tang_vi_da','con_hang'),
('A','Đồng hồ rotary',400,1,'tang_vi_da','het_hang');

create view Products_view
as
select productCode, productName, productPrice,productStatus
from Products;

select * from Products_view;

create or replace view Products_view
as
select productCode, productName, productPrice,productDescription,productStatus
from Products
where productPrice=500;

drop view Products_view;

delimiter $$
create procedure findAllProducts()
begin
SELECT * FROM Products;
end;$$
delimiter ;

call findAllProducts();
