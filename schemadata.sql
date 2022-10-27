CREATE TABLE stockdata (
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