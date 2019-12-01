--
-- Base de datos: `TicTac`
--
DROP DATABASE IF EXISTS tictac;
CREATE DATABASE tictac;
-- --------------------------------------------------------

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Estructura de tabla para la tabla cliente
--

CREATE TABLE IF NOT EXISTS cliente (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Nombre varchar(40) NOT NULL,
  DNI varchar(11) NOT NULL,
  Tarjeta int(11) DEFAULT NULL,
  Activo tinyint(1) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

--
-- Datos para la tabla cliente
--

INSERT INTO cliente (Nombre, DNI, Tarjeta, Activo) VALUES ('Paco Pérez', '123456789G', 1234, 1);
INSERT INTO cliente (Nombre, DNI, Tarjeta, Activo) VALUES ('María Juana', '9878A', 3100, 1);

-- --------------------------------------------------------



--
-- Estructura de tabla para la tabla reloj
--

CREATE TABLE IF NOT EXISTS reloj (
  ID int(11) NOT NULL AUTO_INCREMENT,
  modelo varchar(40) NOT NULL,
  marca varchar(40) NOT NULL,
  precio double NOT NULL,
  activo tinyint(1) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS relojAnalogico (
  ID int(11) NOT NULL,
  esfera varchar(40) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS relojDigital (
  ID int(11) NOT NULL,
	pantalla varchar(40) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

-- Restricciones para reloj 

ALTER TABLE relojAnalogico ADD CONSTRAINT relojanalogico_id FOREIGN KEY (ID) REFERENCES reloj (ID);

ALTER TABLE relojDigital ADD CONSTRAINT relojdigital_id FOREIGN KEY (ID) REFERENCES reloj (ID);

--
-- Datos para la tabla reloj
--

INSERT INTO reloj (modelo, marca, precio, activo) VALUES
('Pineapple Watch', 'Pineapple', 123, 1),
('Basic Clock', 'Casio', 129, 1),
('Pont', 'Switz', 110, 1),
('94ES', 'TAO', 9321, 0),
('Blue Hands', 'MR A', 4, 1);

INSERT INTO relojAnalogico (ID, esfera) VALUES (2,'Plástico'),(3,'Oro'),(4,'Plata');
INSERT INTO relojDigital (ID, pantalla) VALUES (1,'OLED'),(5,'LCD');

--
-- Estructura de tabla para la tabla compra
--

CREATE TABLE IF NOT EXISTS compra (
  ID int(11) NOT NULL AUTO_INCREMENT,
  ClienteID int(11) NOT NULL,
  CosteTotal double NOT NULL,
  Fecha date NOT NULL,
  Activo tinyint(1) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE compra ADD CONSTRAINT compra_cliente FOREIGN KEY (ClienteID) REFERENCES cliente (ID);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla contiene (línea de compra)
--

CREATE TABLE IF NOT EXISTS lineacompra (
  Compra int(11) NOT NULL,
  Reloj int(11) NOT NULL,
  Cantidad int(11) NOT NULL,
  Precio double NOT NULL,
  Activo tinyint(1) NOT NULL,
  PRIMARY KEY (Compra,Reloj)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Restricciones de línea de compra

ALTER TABLE lineacompra ADD CONSTRAINT lineacompra_reloj FOREIGN KEY (Reloj) REFERENCES reloj (ID);
-- --------------------------------------------------------
