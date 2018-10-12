CREATE DATABASE pruebaCRUD;
USE pruebaCRUD;
CREATE TABLE usuarios(
idUsuario INT not null primary key auto_increment,
usuario VARCHAR(30) not null,
clave VARCHAR(50) not null);
INSERT INTO usuarios (usuario, clave) VALUES ('sebastian.solar', '12345');