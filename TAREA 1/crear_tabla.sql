create database akihabara_db;
use akihabara_db;

create table producto(
id int auto_increment primary key,
nombre varchar(255) not null,
categoria varchar (100),
precio decimal (10,2),
stock int
);

CREATE USER userAkihabara IDENTIFIED BY '1234';

grant all
on producto
to userAkihabara;

-- Figuras
INSERT INTO producto (nombre, categoria, precio, stock) VALUES 
('Figura Goku Super Saiyan', 'Figura', 39.99, 15),
('Figura Luffy Gear 5', 'Figura', 45.50, 10),
('Figura Naruto Sage Mode', 'Figura', 42.00, 12);

-- Mangas
INSERT INTO producto (nombre, categoria, precio, stock) VALUES 
('One Piece Vol. 3', 'Manga', 7.99, 25),
('Naruto Vol. 72', 'Manga', 8.50, 18),
('Attack on Titan Vol. 10', 'Manga', 9.00, 20);

-- Pósters
INSERT INTO producto (nombre, categoria, precio, stock) VALUES 
('Póster Demon Slayer', 'Póster', 5.99, 30),
('Póster Evangelion', 'Póster', 6.50, 15),
('Póster Tokyo Revengers', 'Póster', 5.00, 22);

-- Llaveros
INSERT INTO producto (nombre, categoria, precio, stock) VALUES 
('Llavero Pikachu', 'Llavero', 3.50, 40),
('Llavero Totoro', 'Llavero', 4.00, 35),
('Llavero One Piece Jolly Roger', 'Llavero', 3.75, 38);

-- Ropa
INSERT INTO producto (nombre, categoria, precio, stock) VALUES 
('Camiseta Goku - Talla M', 'Ropa', 19.99, 10),
('Sudadera One Piece - Talla L', 'Ropa', 29.99, 8),
('Gorra Inazuma Eleven', 'Ropa', 14.99, 12);
