drop table public.user;

create table public.User (id int4 not null, 
				   first_name varchar(50), 
				   last_name varchar(50),
				   gender varchar(10), 
				   birthdate timestamp, 
				   street_name varchar(100),
				   city varchar(26),
				   state_abbr varchar(3), 
				   zip_code varchar(20), 
				   phone_number varchar(50),
				   email varchar(50),  
				   dept varchar(50), 
				   primary key (id));
