create table dbo.aplicacion (
idaplicacion varchar(10) not null,
nombreaplicacion varchar(50) not null
primary key(idaplicacion)
);


create table dbo.version (
idVersion varchar(10) not null, 
nombre varchar(50) not null, 
idaplicacion varchar(10) not null,
primary key(idVersion),
CONSTRAINT FK_versionaplicacion FOREIGN KEY (idaplicacion)
REFERENCES aplicacion(idaplicacion));

 create table dbo.prueba(
 idPrueba varchar (10) not null,
 aplicacion  varchar (10) not null,
 version  varchar (10) not null,
 nombreCiclo varchar(50) not null,
 metrica1 int,
 metrica2 int,
 metrica3 int,
 metrica4 int,
 metrica5 int,
 primary key(idPrueba),
CONSTRAINT FK_pruebaplicacion FOREIGN KEY (aplicacion)
REFERENCES aplicacion (idaplicacion),
CONSTRAINT FK_pruebaplicacionversion FOREIGN KEY (version)
REFERENCES dbo.version (idVersion));

