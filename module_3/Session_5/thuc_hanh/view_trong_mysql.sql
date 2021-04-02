use classicmodels;

CREATE VIEW customers_views AS
    SELECT 
        customerNumber, customerName, phone
    FROM
        customers;

SELECT 
    *
FROM
    customers_views;

CREATE OR REPLACE VIEW customers_views AS
    SELECT 
        customerNumber,
        customerName,
        contactFirstName,
        contactLastName,
        phone,
        city
    FROM
        customers
    WHERE
        city = 'Nantes';

DROP VIEW customers_views;