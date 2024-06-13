REM   Script: Activity1,2,3,4,5
REM   Activity1-5

select * from salesman;

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar(32), 
    salesman_city varchar(32), 
    commission int, 
);

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(32), 
    salesman_city varchar2(32), 
    commission int, 
);

CREATE TABLE salesmans ( 
    salesman_id int, 
    salesman_name varchar(32), 
    salesman_city varchar(32), 
    commission int, 
);

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

UPDATE salesman SET grade=200 where salesman_city='ROME';

UPDATE salesman SET grade=300 where salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' where salesman_name='McLyon';

UPDATE salesman SET grade=200 where salesman_city='Rome';

UPDATE salesman SET grade=300 where salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' where salesman_name='McLyon';

UPDATE salesman SET grade=200 where salesman_city='Rome';

UPDATE salesman SET grade=300 where salesman_name='James Hoog';

UPDATE salesman SET salesman_name='Pierre' where salesman_name='McLyon';

SELECT * from salesman;

UPDATE salesman SET grade=300 where salesman_name='James Hoog';

SELECT * from salesman;

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

SELECT * from salesman;

UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

SELECT * from salesman;

