

CREATE TABLE salesman (
	salesman_id int(5),
    Name varchar(30),
    City varchar(15),
    Commission decimal(5,2),
    PRIMARY KEY (salesman_id)
); 



CREATE TABLE customer (
	customer_id int(5),
    cust_name varchar(30),
    city varchar(15),
    grade int(5),
    salesman_id int(5),
    PRIMARY KEY (customer_id),
	FOREIGN KEY (salesman_id) REFERENCES salesman(salesman_id)

);

CREATE TABLE orders (
	ORD_NO int(5),
    PURCH_AMT decimal(8,2),
    ORD_date date,
    customer_id int(5),
    salesman_id int(5),
    PRIMARY KEY (ORD_NO),
	FOREIGN KEY (salesman_id) REFERENCES salesman(salesman_id),
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id)

); 