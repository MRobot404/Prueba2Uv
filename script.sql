--Creacion de tablas
DROP TABLE usuario;
CREATE TABLE USUARIO(
ID_USUARIO INTEGER NOT NULL,
NOMBRE VARCHAR(125),
APELLIDO VARCHAR(125),
NIT NUMBER(13),
FECHA_NACIMIENTO DATE,
CONSTRAINT pk_usuarios primary key(ID_USUARIO)
);

Alter table USUARIO
drop column password;

DROP TABLE EMPLEADO;
CREATE TABLE EMPLEADO(
ID_EMPLEADO INT NOT NULL,
ID_USUARIO INT,
ID_ROL INT,
CODIGO NUMBER(10),
CONSTRAINT PK_EMPLEADOS PRIMARY KEY(ID_EMPLEADO),
CONSTRAINT FK_EMPLEADOS_USUARIOS FOREIGN KEY (ID_USUARIO) REFERENCES  USUARIO(ID_USUARIO)

);

DROP TABLE ROL;
CREATE TABLE ROL(
ID_ROL INT NOT NULL,
AREA VARCHAR(250),
ROL VARCHAR(250),
CONSTRAINT pk_rol primary key(ID_ROL)
);

DROP TABLE TELEFONO;
CREATE TABLE TELEFONO(
ID_TELEFONO INT NOT NULL,
TELEFONO NUMBER (11),
EXTENSION NUMBER(5),
ID_USUARIO INT,
CONSTRAINT PK_TELEFONO PRIMARY KEY(ID_TELEFONO),
CONSTRAINT FK_TELEFONO_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);

DROP TABLE CORREO;
CREATE TABLE CORREO(
ID_CORREO INT NOT NULL,
CORREO VARCHAR(250),
ID_USUARIO INT,
CONSTRAINT PK_CORREO PRIMARY KEY(ID_CORREO),
CONSTRAINT FK_CORREO_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);

-- Restricciones

    
ALTER TABLE EMPLEADO
    ADD CONSTRAINT EUSUARIO_UNIQUE UNIQUE (ID_USUARIO);
    
ALTER TABLE EMPLEADO
    ADD CONSTRAINT EROL_UNIQUE UNIQUE (ID_ROL);
--Visualizaci�n
SELECT * FROM USUARIO;
 SELECT * FROM EMPLEADO;
SELECT * FROM ROL;
SELECT * FROM TELEFONO;
SELECT * FROM CORREO;

--Secuencias
DROP SEQUENCE TEST_SEQ24;
 CREATE SEQUENCE test_seq24
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 DROP SEQUENCE TEST_SEQ25;
  CREATE SEQUENCE test_seq25
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
  DROP SEQUENCE TEST_SEQ26;
  CREATE SEQUENCE test_seq26
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 DROP SEQUENCE TEST_SEQ27;
  CREATE SEQUENCE test_seq27
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
  DROP SEQUENCE TEST_SEQ28;
  CREATE SEQUENCE test_seq28
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

 DROP SEQUENCE TEST_SEQ29;
 CREATE SEQUENCE test_seq29
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
  DROP SEQUENCE TEST_SEQ30;
  CREATE SEQUENCE test_seq30
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
--Creacion de triggers
DROP TRIGGER TGR_USUARIO;
create or replace  TRIGGER TGR_USUARIO
BEFORE INSERT ON USUARIO REFERENCING NEW AS NEW OLD AS OLD FOR EACH ROW
BEGIN
    SELECT TEST_SEQ25.NEXTVAL INTO :New.ID_USUARIO  FROM DUAL;
END;

DROP TRIGGER TGR_EMPLEADO;
create or replace  TRIGGER TGR_EMPLEADO
BEFORE INSERT ON EMPLEADO REFERENCING NEW AS NEW OLD AS OLD FOR EACH ROW
BEGIN
    SELECT TEST_SEQ26.NEXTVAL INTO :New.ID_EMPLEADO  FROM DUAL;   
END;

DROP TRIGGER TGR_ROL;
create or replace  TRIGGER TGR_ROL
BEFORE INSERT ON ROL REFERENCING NEW AS NEW OLD AS OLD FOR EACH ROW
BEGIN
    SELECT TEST_SEQ27.NEXTVAL INTO :New.ID_ROL  FROM DUAL;
END;

DROP TRIGGER TGR_TELEFONO;
create or replace  TRIGGER TGR_TELEFONO
BEFORE INSERT ON  TELEFONO REFERENCING NEW AS NEW OLD AS OLD FOR EACH ROW
BEGIN
    SELECT TEST_SEQ28.NEXTVAL INTO :New.ID_TELEFONO  FROM DUAL;
END;    

DROP TRIGGER TGR_CORREO;
create or replace  TRIGGER TGR_CORREO
BEFORE INSERT ON  CORREO REFERENCING NEW AS NEW OLD AS OLD FOR EACH ROW
BEGIN
    SELECT TEST_SEQ29.NEXTVAL INTO :New.ID_CORREO  FROM DUAL;
END; 
--Insercion de datos
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Lexis', 'Grodden', 5493797873577, '5/2/1989');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Arnoldo', 'Cardiff', 8935467906311, '25/9/1998');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Cori', 'Blondin', 5619924863441, '7/10/1996');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Morley', 'Thayre', 9813879148152, '7/10/1982');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Boony', 'Hurler', 83913388810, '14/2/1980');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Pennie', 'Medcalfe', 1513153373469, '17/7/1991');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Teddi', 'Massot', 9330403425379, '15/5/1985');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Vladimir', 'Maulden', 9955178072891, '1/11/1987');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Stu', 'Larkcum', 6968528473656, '8/5/1985');
insert into USUARIO (NOMBRE, APELLIDO, NIT, FECHA_NACIMIENTO) values ('Phineas', 'Garley', 3483000360287, '5/10/1984');

insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (1, 1, 143919);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (2, 2, 814268);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (3, 3, 596288);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (4, 4, 928353);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (5, 5, 231469);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (6, 6, 101160);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (7, 7, 290686);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (8, 8, 488578);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (9, 9, 179846);
insert into EMPLEADO (ID_USUARIO, ID_ROL, CODIGO) values (10, 10, 646920);

insert into ROL (AREA, ROL) values ('GERENCIA IT', 'GERENTE GENERAL');
insert into ROL (AREA, ROL) values ('GTESORERIATOS MEDICOS', 'GERENTE GENERAL');
insert into ROL (AREA, ROL) values ('RRHH', 'GERENTE GENERAL');
insert into ROL (AREA, ROL) values ('CONTACT CENTER', 'GERENTE GENERAL');
insert into ROL (AREA, ROL) values ('CONTACT CENTER', 'GERENTE DE DEPARTAMENTO');
insert into ROL (AREA, ROL) values ('CONTACT CENTER', 'EJECUTIVO');
insert into ROL (AREA, ROL) values ('TESORERIA', 'GERENTE GENERAL');
insert into ROL (AREA, ROL) values ('GERENCIA IT', 'GERENTE DE PROYECTO');
insert into ROL (AREA, ROL) values ('FINANZAS', 'GERENTE GENERAL');
insert into ROL (AREA, ROL) values ('GERENCIA IT', 'TRAINEE');

insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (48138057, 9984, 1);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (54274512, 495, 2);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (45403654, 9117, 3);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (52178314, 1629, 4);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (52510328, 380, 5);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (56959180, 187, 6);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (53391328, 8176, 7);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (53124848, 1591, 8);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (46788071, 4809, 9);
insert into TELEFONO (TELEFONO, EXTENSION, ID_USUARIO) values (52043903, 9706, 10);

insert into CORREO (CORREO, ID_USUARIO) values ('ckendrick0@imdb.com', 1);
insert into CORREO (CORREO, ID_USUARIO) values ('mwasylkiewicz1@webmd.com', 2);
insert into CORREO (CORREO, ID_USUARIO) values ('hlovejoy2@wikia.com', 3);
insert into CORREO (CORREO, ID_USUARIO) values ('foborne3@soundcloud.com', 4);
insert into CORREO (CORREO, ID_USUARIO) values ('ecullabine4@skyrock.com', 5);
insert into CORREO (CORREO, ID_USUARIO) values ('mculpan5@cornell.edu', 6);
insert into CORREO (CORREO, ID_USUARIO) values ('lelwyn6@scientificamerican.com', 7);
insert into CORREO (CORREO, ID_USUARIO) values ('kdodsley7@kickstarter.com', 8);
insert into CORREO (CORREO, ID_USUARIO) values ('tpinilla8@sun.com', 9);
insert into CORREO (CORREO, ID_USUARIO) values ('kmulcaster9@marketwatch.com', 10);


