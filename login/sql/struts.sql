set names utf8;
set foreign_key_checks = 0;

drop database if exists logindb_sumi;
create database logindb_sumi;
use logindb_sumi;

create table user(
	id int,
	user_name varchar(255),
	password varchar(255)
);

insert into user values
	(1,"taro","123"),
	(2,"jiro","234"),
	(3,"hanako","345"),
	(4,"saburo","456");
