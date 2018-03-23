
SET SQL_SAFE_UPDATES = 0;

##Create database
CREATE DATABASE IF NOT EXISTS food_delivery;
use food_delivery;

##Create table(s)

CREATE TABLE IF NOT EXISTS Admin
(id int unique auto_increment primary key,
username char(20),
parola char(64),
logat boolean
);


CREATE TABLE IF NOT EXISTS Clienti
(id int unique auto_increment primary key,
username char(20),
nume char(20),
adresa char(100),
email char(40),
varsta int,
parola BINARY(32),
logat boolean,
loial boolean
);

drop table if exists produs;
 CREATE TABLE IF NOT EXISTS produs
(id int unique auto_increment primary key,
descriere char(40),
cantitate int,
pret  float);

drop table if exists cos;
 CREATE TABLE IF NOT EXISTS cos
(id int unique auto_increment primary key,
pret_total float,
client_id int,
data_creare datetime,
comanda_finalizata boolean,
card boolean,
cash boolean,
index(client_id),
foreign key (client_id) references clienti(id));

#drop table if exists comanda_articol;
 CREATE TABLE IF NOT EXISTS comanda_articol
(id int unique auto_increment primary key,
cos_id int,
produs_id int,
cantitate int,
pret_bucata float,
index(cos_id),
INDEX (produs_id),

foreign key (cos_id) references cos(id),
FOREIGN KEY (produs_id) REFERENCES produs(id));


#insert into clienti values
#(1,"andreibursuc","Bursuc Andrei Ioan","Neamt,Rediu, str. Polobocului, nr. 23A","andrei_bursuc2002@yaho.com",22,"paswd",false,false);
insert into produs values
(1,"Pizza Capriciosa",3,20);

#insert into produs(descriere,cantitate,pret) values
#("Reducere 5%",1,0);

insert into admin values
(1,"Admin", SHA2('1234',256),false);
delete from admin where id=1;
update produs set cantitate=6 where descriere="Pizza Capriciosa";
update admin set logat=false where id=1;
delete from cos where id=3;
SELECT SHA2('1234',256);

select parola from admin where id=1;

select id,username,nume,adresa,email,varsta,loial from clienti;
update clienti set logat=false where id=2;

select id from produs where descriere="Pizza Tunna";

insert into clienti(username,nume,adresa,email,varsta,parola,loial) VALUES ("andreibursuc2","Bursuc Andrei","Neamt,Rediu, str. Polobocului, nr. 23A","andrei_bursuc2002@yaho.com",22,"paswd",false);