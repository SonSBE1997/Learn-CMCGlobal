drop database if exists atjb;

create database atjb;
use atjb;

-- create table user
create table users
(
	user_id int auto_increment primary key,
    email varchar(50), 
    password varchar(50)
);

-- create table personal
create table personal
(
	personal_id int auto_increment primary key,
    first_name varchar(20),
    last_name varchar(20),
    telephone varchar(11),
    email varchar(50),
    address varchar(255),
    hobbie varchar(255),
    description varchar(200)
);
