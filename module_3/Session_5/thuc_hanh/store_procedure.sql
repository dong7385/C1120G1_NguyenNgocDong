use classicmodels;
delimiter $$
create procedure findAllCustomers()
begin
SELECT * FROM customers;
end;$$
delimiter ;

call findAllCustomers();

delimiter $$
drop procedure if exists findAllCustomers;
create procedure findAllCustomers()
SELECT *  FROM customers where customerNumber = 175;
end; $$
delimiter ;