create table Portfolio(
id INTEGER NOT NULL,
symbol VARCHAR(10) NOT NULL,
quantity INTEGER NOT NULL,
price NUMERIC NOT NULL, PRIMARY KEY (id)
);


insert into Portfolio values (1,'IBM',500,105.50),
 (2,'AMZN',1000,15.25),(3,'AAPL',2000,272.50);
 
 