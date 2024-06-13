REM   Script: Activity6
REM   Activity6

Select * from salesman 
;

Select * from salesman;

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar(32), 
    salesman_city varchar(32), 
    commission int 
);

DESCRIBE salesman


INSERT ALL  
    INTO salesman values(5005, 'Pit Alex', 'London', 11) 
    INTO salesman values(5006, 'McLyon', 'Paris', 14) 
    INTO salesman values(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman values(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 from DUAL;

SELECT * from salesman;

SELECT salesman_id,salesman_city from salesman;

SELECT * from salesman where salesman_city ='Paris';

SELECT salesman_id,commission from salesman where salesman_name='Paul Adam';

ALTER TABLE salesman ADD grade int;

UPDATE salesman SET grade=100;

SELECT * from salesman;

UPDATE salesman SET grade=200 where salesman_city='Rome';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' where salesman_name='McLyon';

UPDATE salesman SET grade=300 where salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' where salesman_name='McLyon';

select * from salesman;

INSERT INTO salesman values(5001,'James Hoog','New York',15,100);

UPDATE salesman SET grade=300 where salesman_name='James Hoog';

 SELECT * from salesman;

SELECT DISTICT salesman_id from salesman;

SELECT DISTINCT salesman_id from salesman;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT * from orders;

SELECT * from orders;

Select DISTINCT SALESMAN_ID from orders;

SELECT ORDER_NO from orders order by ORDER_DATE asc;

SELECT ORDER_NO, ORDER_DATE from orders order by ORDER_DATE;

SELECT * from orders;

SELECT * from orders;

SELECT ORDER_NO,PURCHASE_AMOUNT from orders order by PURCHASE_AMOUNT dsc;

SELECT * from orders;

SELECT ORDER_NO,PURCHASE_AMOUNT from orders order by PURCHASE_AMOUNT desc;

SELECT * from orders;

Select * from orders where PURCHASE_AMOUNT<500;

SELECT * from orders;

Select * from orders where PURCHASE_AMOUNT in between 1000 and 2000;

SELECT * from orders;

Select * from orders where PURCHASE_AMOUNT between 1000 and 2000;

