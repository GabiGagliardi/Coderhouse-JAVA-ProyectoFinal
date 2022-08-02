DROP TABLE CLIENTES IF EXISTS;
DROP TABLE PRODUCTOS IF EXISTS;
DROP TABLE COMPROBANTES IF EXISTS;

CREATE TABLE CLIENTES (
	                    clienteid int NOT NULL AUTO_INCREMENT,
                        dni int NOT NULL,
                        nombre VARCHAR(255) NOT NULL,
                        apellido VARCHAR(255) NOT NULL,
                        PRIMARY KEY (clienteid)
                      );

CREATE TABLE PRODUCTOS (
                            productoid int NOT NULL AUTO_INCREMENT,
                            nombre VARCHAR(255) NOT NULL,
                            stock int NOT NULL,
                            precio FLOAT NOT NULL,
                            PRIMARY KEY (productoid)
                       );

CREATE TABLE COMPROBANTES (
                            comprobanteid INT NOT NULL AUTO_INCREMENT,
                            fecha DATE NOT NULL,
                            clienteid INT NOT NULL,
                            productoid INT NOT NULL,
                            producto VARCHAR(255) NOT NULL,
                            precio FLOAT NOT NULL,
                            cantidad  INT NOT NULL,
                            total FLOAT NOT NULL,
                            PRIMARY KEY (comprobanteid)
                         );



