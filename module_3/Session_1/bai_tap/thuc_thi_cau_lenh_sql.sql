use classicmodels;
select * from customers;
SELECT customerName, phone, city, country FROM customers;
SELECT * FROM customers WHERE customerName = 'Signal Gift Stores';
SELECT * FROM customers WHERE customername like '%&%';
SELECT * FROM customers WHERE city IN ('NYC');


