drop database if exists Session_4_luyen_tap_cac_lenh;
create database Session_4_luyen_tap_cac_lenh;
use Session_4_luyen_tap_cac_lenh;
CREATE TABLE CUSTOMERS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    nameCUSTOMERS VARCHAR(255),
    AGE INT,
    ADDRESS VARCHAR(255),
    SALARY DOUBLE
);

insert into CUSTOMERS(nameCUSTOMERS,AGE,ADDRESS,SALARY)
values
('Ha Anh',32,'Da Nang',2000),
('Van Ha',25,'Da lat',4000),
('Vu Bang',23,'ha noi',3333),
('Thu Minh',25,'Da Nang',777),
('Hai An',22,'Da Nang',2000),
('Hai An',24,'Da Nang',222),
('Binh',23,'Da Nan',100);

select age 
from CUSTOMERS
where salary>2000;

select id,nameCUSTOMERS,AGE 
from CUSTOMERS
where age>23;

select id,nameCUSTOMERS,salary  
from CUSTOMERS
where salary>2000;

UPDATE CUSTOMERS
SET ADDRESS = 'Vinh Phuc'
WHERE ID = 6;

select * 
from CUSTOMERS
order by nameCUSTOMERS asc;

select nameCUSTOMERS,SALARY
from CUSTOMERS
order by nameCUSTOMERS,SALARY asc;


select nameCUSTOMERS,SALARY
from CUSTOMERS
order by nameCUSTOMERS desc;

select nameCUSTOMERS,ADDRESS
from CUSTOMERS
order by ADDRESS asc;

select nameCUSTOMERS,sum(SALARY)
from CUSTOMERS
group by nameCUSTOMERS;

select id,nameCUSTOMERS,sum(SALARY)
from CUSTOMERS
group by nameCUSTOMERS;

select id,nameCUSTOMERS,min(SALARY) as a
from CUSTOMERS
group by nameCUSTOMERS;
