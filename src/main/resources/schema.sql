use springboot_hibernate;

drop database if exists springboot_hibernate;
create database springboot_hibernate;

use springboot_hibernate;

CREATE TABLE PRODUCTO
(
   ID_PRODUCTO BIGINT NOT NULL AUTO_INCREMENT,
   MARCA VARCHAR (40) NOT NULL,
   NOMBRE VARCHAR (40) NOT NULL,
   CATEGORIA VARCHAR (40) NOT NULL,
   PRIMARY KEY (ID_PRODUCTO)
);