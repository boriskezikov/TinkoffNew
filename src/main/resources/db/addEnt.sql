insert into car (
  car_id,
  manufacturer_id,
  model_info,
  tech_condition,
  category
) values (1,6, 'BMW',8,2);

insert into car (
  car_id,
  manufacturer_id,
  model_info,
  tech_condition,
  category
) values (2, 6, 'carol',9, 2);

insert into car (
  car_id,
  manufacturer_id,
  model_info,
  tech_condition,
  category
) values (3, 7, 'lannioster',5,1);

insert into car (
  car_id,
  manufacturer_id,
  model_info,
  tech_condition,
  category
) values (4, 9, 'lada',6,2);

insert into taxi_driver(
   id_driver, license_number, name, passport, car_id, status

)  values (1, '1421421','Robert Caloew', '1234224552', 1 , 0);
insert into taxi_driver(
  id_driver, license_number, name, passport, car_id, status

)  values (2, '14455421','Cal el', '9958224552', 2 , 0);
insert into taxi_driver(
  id_driver, license_number, name, passport, car_id, status

)  values (3, '5678944','Laster lloot', '445441244', 3 , 0);
insert into taxi_driver(
  id_driver, license_number, name, passport, car_id, status

)  values (4, '1244552','kkiie Rwr', '999484455', 4 , 0);

insert into tariff(
  tariff_id, price, tariff_info

)values(1,14,'yellow tariff');
insert into tariff(
  tariff_id, price, tariff_info

)values(2,25,'black tariff');
insert into tariff(
  tariff_id, price, tariff_info

)values(3,40,'gold tariff')
