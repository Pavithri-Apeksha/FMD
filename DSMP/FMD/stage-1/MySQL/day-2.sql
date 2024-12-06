show databases;
cerate database if not exists fmd;
show database;
use fmd;

#Primary Key
create table t1(
    id varchar(10) Primary Key Not null,
    name varchar(45)
);
desc t1;
insert into t1 values ('C001','Kamal');
#insert into t1 values ('C001','Jagath');
insert into t1 values ('C002','Jagath');
select * from t1;

#Not null
create table t2(
    id int Primary Key,
    name varchar(45) NOT NULL
);
desc t2;
insert into t2 values (1001,'Kamal');
insert into t2 values (1002,'Nimal');

#UNIQUE
create table t3(
    id int Primary key,
    name varchar(45) not null,
    nic varchar(45) UNIQUE,
    email varchar(45) UNIQUE
)
insert into t3 values (1001,'Jagath',2001,'jagath@gmail.com');
insert into t3 values (1002,'Saman',2005,'saman@gmail.com');
