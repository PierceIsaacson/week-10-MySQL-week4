create database if not exists items;

use items;

drop table if exists discrete_gpu;

create table discrete_gpu (
	id int(10) not null auto_increment,
	name varchar(50) not null,
	primary key(id)
);