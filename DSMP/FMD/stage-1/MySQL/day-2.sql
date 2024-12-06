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
