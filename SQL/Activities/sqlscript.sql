REM   Script: Activity7,8
REM   Activities

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

SELECT SUM(PURCHASE_AMOUNT) As Total_Amount from orders;

SELECT SUM(PURCHASE_AMOUNT) As Total_Amount from orders;

Select AVG(PURCHASE_AMOUNT) As Average_Amount from orders;

SELECT MAX(PURCHASE_AMOUNT) As maximum_Amount from orders;

SELECT Min(PURCHASE_AMOUNT) As minimum_Amount from orders;

SELECT count(salesman_id) As NumberOf_salesman from orders, 
 
;

SELECT count(salesman_id) As NumberOf_salesman from orders;

SELECT MAX(PURCHASE_AMOUNT) As MaxAmount_orderd,customer_id from orders GROUPBY customer_id;

SELECT MAX(PURCHASE_AMOUNT) As MaxAmount_orderd,customer_id from orders GROUP BY customer_id;

SELECT MAX(PURCHASE_AMOUNT) AS HighestAmount_date,salesman_id,order_date from orders where order_date='2012-08-17' group by salesman_id;

SELECT MAX(PURCHASE_AMOUNT) AS HighestAmount_date,salesman_id,order_date from orders where order_date='2012-08-17' group by salesman_id,order_date;

SELECT MAX(PURCHASE_AMOUNT) AS HighestAmount_date,salesman_id,order_date from orders where order_date='2012-08-17' group by salesman_id,order_date;

SELECT MAX(PURCHASE_AMOUNT) AS HighestAmount_date,salesman_id,order_date from orders where order_date=TO_DATE('2012-08-17','YYYY-MM-DD') group by salesman_id,order_date;

SELECT order_date,order_no,MAX(PURCHASE_AMOUNT) AS HighestAmount_customer from orders group by customer_id,order_date having MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

SELECT order_date,order_no,MAX(PURCHASE_AMOUNT),customer_id AS HighestAmount_customer  
    from orders group by customer_id,order_date having MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

SELECT order_date,customer_id,order_no,MAX(PURCHASE_AMOUNT) AS HighestAmount_customer  
    from orders group by customer_id,order_date having MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

SELECT order_date,customer_id,order_no,MAX(PURCHASE_AMOUNT) AS HighestAmount_customer  
    from orders group by customer_id,order_date having MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

SELECT order_date,customer_id,MAX(PURCHASE_AMOUNT) AS HighestAmount_customer  
    from orders group by customer_id,order_date  
    having MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

