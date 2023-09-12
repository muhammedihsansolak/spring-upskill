drop table if exists Employees; --if table is created before, delete it and create it again

CREATE TABLE Employees(

  id bigint not null ,
  name varchar(50),
  primary key (id)

);