
 CREATE TABLE  TAXI_ORDER(
 id_driver int NOT NULL,
 phone_number varchar(11) NOT NULL,
 client_location varchar(50) NOT NULL ,
 distination varchar(50) NOT NULL,
 status int not null ,
 tariff_id int not null ,
 order_id bigint not null primary key
);

CREATE TABLE RATE(
  order_id bigint not null primary key  ,
  review varchar(300)
);

CREATE TABLE TAXI_DRIVER(
  id_driver bigint not null primary key ,
  license_number varchar(12) not null unique ,
  name varchar(50) not null ,
  passport varchar(12)not null unique ,
  car_id bigint not null unique
);

CREATE TABLE CAR(
  car_id bigint not null primary key ,
  manufacturer_id bigint not null,
  model_info varchar(100) not null ,
  tech_condition int check ( tech_condition >0 and tech_condition<10) not null ,
  category int check (category = 0 or category = 1) not null
);

CREATE TABLE CLIENT(
  phone_number varchar(11) primary key ,
  name varchar(50) not null,
  status boolean not null
);

CREATE TABLE TARIFF(
  price int check ( price > 0 ) not null,
  tariff_id int check ( tariff_id > 0 ) primary key ,
  tariff_info varchar(100)
);
