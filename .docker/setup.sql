CREATE DATABASE IF NOT EXISTS stockschema;

CREATE USER 'admin'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';

GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, INDEX, DROP, ALTER, CREATE TEMPORARY TABLES, LOCK TABLES ON stockschema.* TO 'root'@'localhost';

USE stockschema;

CREATE TABLE IF NOT EXISTS stockdata (
quarter INT not null,
stock varchar(255) not null,
date varchar(255) not null,
open DOUBLE,
high INT,
low INT,
close DOUBLE,
volume DOUBLE,
percent_change_price DOUBLE,
percent_change_volume_over_last_wk DOUBLE,
previous_weeks_volume DOUBLE,
next_weeks_open DOUBLE,
next_weeks_close DOUBLE,
percent_change_next_weeks_price DOUBLE,
days_to_next_dividend INT,
percent_return_next_dividend DOUBLE,
PRIMARY KEY (quarter,stock,date)
);