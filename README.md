# demo-springbatch-csv2postgres
Spring batch to demo csv file to postgres database using jdbctemplate.

create the table:

create table public.User (id int4 not null, 
				   first_name varchar(50), 
				   last_name varchar(50),
				   gender varchar(10), 
				   birthdate timestamp, 
				   street_name varchar(100),
				   city varchar(25), 
				   state_abbr varchar(3), 
				   zip_code varchar(20), 
				   phone_number varchar(50),
				   email varchar(50),  
				   dept varchar(50), 
				   primary key (id));


Run the initial load:
http://localhost:8089/load-all

to inquire:
http://localhost:8089/user/1001

where:
id = from 1001 to 9000

added webhook

