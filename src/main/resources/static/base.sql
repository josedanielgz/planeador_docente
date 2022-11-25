CREATE TABLE Docente (
	documento varchar(20) primary key,
	primerNombre varchar(20) not null,
	primerApellido varchar(20) not null,
	codigo varchar(20) not null,
	email varchar(40) not null unique,
	clave varchar(192) not null
);

/*Provisional en caso de que utilicemos el rol de administrador*/
CREATE TABLE Administrador (
	docente varchar(20) primary key
);

ALTER TABLE Administrador ADD CONSTRAINT fk_Docente_Admin FOREIGN KEY (usuario) REFERENCES Usuario(documento);

/*
https://stackoverflow.com/a/56896292
https://stackoverflow.com/a/33956284
*/
create table Materia (
    id varchar(10) primary key default (substring(sha2(rand(), 256),1,10)),
    descripcion varchar(20) not null
);

/*
IDs generados aleatoriamente
Echar un vistazo después
https://www.mysqltutorial.org/mysql-text/
Para lidiar con esto en el lado de JDBC
https://stackoverflow.com/a/24328976
*/

create table Competencia (
	id varchar(10) not null default (substring(sha2(rand(), 256),1,10)),
	descripcion varchar(20) not null
);

create table Microcurriculo (
	id varchar(20) primary key;
	descripcion varchar(20) not null;
	materia varchar (10) not null;
);

create table Resultado (
	id varchar(20) not null
	competencia varchar(10) not null;
	microcurriculo varchar(20) not null;
	descripcion varchar(40) not null;
);

create table UnidadTematica (

	id varchar(20) not null;
	resultado varchar(20) not null;
	descripcion varchar(40) not null;
);

create table Categoria (
	id varchar(10) not null default (substring(sha2(rand(), 256),1,10)),
	descripcion varchar(20) not null
);

create table Categoria_UnidadTematica (
	id varchar(10) not null default (substring(sha2(rand(), 256),1,10)),
	descripcion varchar(20) not null
);


create table Curso (
	id varchar(20) primary key;
	docente varchar(20) not null;
	descripcion varchar(40);
);

/*
Revisar si el asunto de la fecha está funcionando correctamente
https://stackoverflow.com/a/1932112
También el decimal para la calificación
https://www.mysqltutorial.org/mysql-int/
*/

create table Instrumento (
	id varchar(40) primary key;
	curso varchar(10) not null;
	unidad_tematica varchar(10) not null;
	categoria varchar(10);
	porcentaje decimal(1,2);
	corte int not null;
);

create table MecanismoEvaluacion (

	id varchar(10) primary key;
	curso varchar(20) not null;
	fecha_realizacion date default current_timestamp;
	descripcion varchar(40);
);



-- ALTER TABLE Usuario_Categoria add PRIMARY KEY(categoria, usuario);
-- ALTER TABLE Usuario_Categoria add CONSTRAINT fk_UsuarioCategoria_Categoria FOREIGN KEY(categoria) REFERENCES Categoria(id_categoria);
