-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-10-2022 a las 22:52:25
-- Versión del servidor: 8.0.30
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fproject`
--
CREATE DATABASE IF NOT EXISTS `fproject1` DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci;
USE `fproject1`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banco`
--

CREATE TABLE `banco` (
  `nit` varchar(20) NOT NULL,
  `nombre_banco` varchar(150) NOT NULL,
  `nombre_usuario` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `banco`
--

TRUNCATE TABLE `banco`;
--
-- Volcado de datos para la tabla `banco`
--

INSERT INTO `banco` (`nit`, `nombre_banco`, `nombre_usuario`) VALUES
('41243254', 'Bancolombia', 'ever1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cedula` varchar(15) NOT NULL,
  `nombre_cliente` varchar(100) NOT NULL,
  `apellidos_cliente` varchar(150) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(11) NOT NULL,
  `banco` varchar(20) NOT NULL,
  `nombre_usuario` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `cliente`
--

TRUNCATE TABLE `cliente`;
--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cedula`, `nombre_cliente`, `apellidos_cliente`, `fecha_nacimiento`, `sexo`, `banco`, `nombre_usuario`) VALUES
('08778934', 'gustavo', 'rojas', '1990-09-09', 'M', '41243254', 'gus'),
('1003067243', 'Rossa', 'Bravo', '1999-07-05', 'F', '41243254', 'rbravo'),
('1003067244', 'Ever', 'Bravo', '2001-10-15', 'M', '41243254', 'bravo'),
('12342345234', 'ggsgsg', 'jhklas', '1990-07-05', 'M', '41243254', 'fbravo'),
('21223', 'yeison', 'navarro', '2000-03-23', 'M', '41243254', 'yei'),
('23235', 'ev', 'br', '2020-10-22', 'm', '41243254', 'desd'),
('8765654563', 'juan', 'lopez', '1990-10-10', 'M', '41243254', 'jlopez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `numero_cuenta` varchar(10) NOT NULL,
  `saldo_cuenta` double NOT NULL DEFAULT '100',
  `estado_cuenta` char(1) DEFAULT 'A',
  `cedula` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `cuenta`
--

TRUNCATE TABLE `cuenta`;
--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`numero_cuenta`, `saldo_cuenta`, `estado_cuenta`, `cedula`) VALUES
('234114314', 168, 'B', '1003067244'),
('234524252', 150, 'A', '1003067243'),
('2642388348', 200, 'A', '1003067244'),
('2708811421', 200, 'A', '12342345234'),
('2752191344', 150, 'A', '1003067243'),
('2948713418', 100, 'A', '1003067244'),
('3071254531', 105, 'A', '1003067244'),
('3317330092', 100, 'A', '1003067244'),
('3674131699', 100, 'A', '1003067244'),
('4699480134', 150, 'A', '12342345234'),
('5742783035', 150, 'A', '1003067244'),
('5789167775', 15, 'A', '8765654563'),
('6668781530', 100, 'A', '1003067244'),
('6671023485', 100, 'A', '1003067244'),
('7606141696', 100, 'A', '1003067244'),
('8172659849', 5, 'A', '12342345234'),
('8634433544', 100, 'A', '1003067244');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transaccion`
--

CREATE TABLE `transaccion` (
  `id_transaccion` int NOT NULL,
  `fecha_transaccion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `estado_transaccion` char(1) NOT NULL DEFAULT 'A',
  `desc_transaccion` varchar(300) DEFAULT NULL,
  `numero_cuenta` varchar(10) NOT NULL,
  `monto` double NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `transaccion`
--

TRUNCATE TABLE `transaccion`;
--
-- Volcado de datos para la tabla `transaccion`
--

INSERT INTO `transaccion` (`id_transaccion`, `fecha_transaccion`, `estado_transaccion`, `desc_transaccion`, `numero_cuenta`, `monto`) VALUES
(1, '2022-10-11 03:43:32', 'A', 'retiro de dinero', '234114314', 0),
(2, NULL, 'A', 'retiro de dinero', '234114314', 20),
(3, NULL, 'A', 'retiro de dinero', '234114314', 20),
(4, NULL, 'A', 'retiro de dinero', '234114314', 20),
(5, '2022-10-11 03:54:31', 'A', 'retiro de dinero', '234114314', 20),
(6, '2022-10-11 05:15:41', 'A', 'Retiro Exitoso', '234114314', 16),
(7, '2022-10-11 05:16:07', 'A', 'Retiro Exitoso', '234114314', 16),
(8, '2022-10-11 05:22:28', 'A', 'Ingreso de dinero', '234114314', 100),
(10, '2022-10-11 15:12:54', 'A', 'Ingreso de dinero', '8172659849', 2000),
(11, '2022-10-11 15:15:15', 'A', 'Retiro de dinero', '8172659849', 200),
(12, '2022-10-11 15:16:28', 'A', 'Retiro de dinero', '8172659849', 1995),
(13, '2022-10-11 20:35:02', 'A', 'Retiro de dinero', '3071254531', 95),
(14, '2022-10-11 20:35:32', 'A', 'Ingreso de dinero', '3071254531', 100),
(15, '2022-10-12 03:53:14', 'A', 'Ingreso de dinero', '5789167775', 200),
(16, '2022-10-12 03:54:08', 'A', 'Retiro de dinero', '5789167775', 295),
(17, '2022-10-12 03:54:37', 'A', 'Ingreso de dinero', '5789167775', 10),
(18, '2022-10-12 20:32:37', 'A', 'Ingreso de dinero', '2642388348', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombre_usuario` varchar(16) NOT NULL,
  `correo_usuario` varchar(255) DEFAULT NULL,
  `contrasena_usuario` varchar(32) NOT NULL,
  `hora_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `rol_usuario` char(1) DEFAULT 'U'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `usuario`
--

TRUNCATE TABLE `usuario`;
--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombre_usuario`, `correo_usuario`, `contrasena_usuario`, `hora_creacion`, `rol_usuario`) VALUES
('bravo', 'bravo@gmail.com', 'ever124', '2022-10-11 02:55:35', 'U'),
('desd', 'ass@dsd', '3222', '2022-10-12 20:28:10', 'U'),
('ever1', 'ever@gmail.com', 'ever124', '2022-10-11 02:24:35', 'A'),
('fbravo', 'rsavo@gmail.com', 'eversa', '2022-10-11 15:03:28', 'A'),
('gus', 'gus123', 'gus', '2022-10-12 03:58:47', 'U'),
('jlopez', 'jlopez@gmail.com', 'jlopez1', '2022-10-12 03:51:36', 'U'),
('rbravo', 'rbravo@gmail.com', 'r124', '2022-10-11 06:12:47', 'A'),
('yei', 'yeison@gmail.com', 'yeison123', '2022-10-11 21:23:44', 'U');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `banco`
--
ALTER TABLE `banco`
  ADD PRIMARY KEY (`nit`),
  ADD UNIQUE KEY `nit_UNIQUE` (`nit`),
  ADD KEY `fk_banco_usuario1_idx` (`nombre_usuario`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cedula`),
  ADD UNIQUE KEY `cedula_UNIQUE` (`cedula`),
  ADD KEY `fk_cliente_banco_idx` (`banco`),
  ADD KEY `fk_cliente_usuario1_idx` (`nombre_usuario`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`numero_cuenta`),
  ADD UNIQUE KEY `numero_cuenta_UNIQUE` (`numero_cuenta`),
  ADD KEY `fk_cuenta_cliente1_idx` (`cedula`);

--
-- Indices de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD PRIMARY KEY (`id_transaccion`),
  ADD UNIQUE KEY `id_transaccion_UNIQUE` (`id_transaccion`),
  ADD KEY `fk_transaccion_cuenta1_idx` (`numero_cuenta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nombre_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `transaccion`
--
ALTER TABLE `transaccion`
  MODIFY `id_transaccion` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `banco`
--
ALTER TABLE `banco`
  ADD CONSTRAINT `fk_banco_usuario1` FOREIGN KEY (`nombre_usuario`) REFERENCES `usuario` (`nombre_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_banco` FOREIGN KEY (`banco`) REFERENCES `banco` (`nit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cliente_usuario1` FOREIGN KEY (`nombre_usuario`) REFERENCES `usuario` (`nombre_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `fk_cuenta_cliente1` FOREIGN KEY (`cedula`) REFERENCES `cliente` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `transaccion`
--
ALTER TABLE `transaccion`
  ADD CONSTRAINT `fk_transaccion_cuenta1` FOREIGN KEY (`numero_cuenta`) REFERENCES `cuenta` (`numero_cuenta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
