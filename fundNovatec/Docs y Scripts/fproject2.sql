-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-10-2022 a las 02:49:36
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
-- Base de datos: `fproject2`
--
CREATE DATABASE IF NOT EXISTS `fproject2` DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci;
USE `fproject2`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campana`
--

DROP TABLE IF EXISTS `campana`;
CREATE TABLE `campana` (
  `id_campana` varchar(5) NOT NULL,
  `nombre_campana` varchar(200) NOT NULL,
  `objetivo_campana` text,
  `fundacion_nit` varchar(15) NOT NULL,
  `estado_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `campana`
--

TRUNCATE TABLE `campana`;
--
-- Volcado de datos para la tabla `campana`
--

INSERT INTO `campana` (`id_campana`, `nombre_campana`, `objetivo_campana`, `fundacion_nit`, `estado_id`) VALUES
('@@Qw)', 'Save peru', 'nunca ir a perú', '87432567-2', 2),
('oc={8', 'Save Colombia', 'Sembrar arboles por toda colombia', '87432567-2', 2),
('O~Hp%', 'Siembra por la vida', 'recaudar fondos para el sector agricola', '87432567-2', 1),
('~}I+<', 'Donador', 'ayudar al necesitado', '87432567-2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campana_moneda`
--

DROP TABLE IF EXISTS `campana_moneda`;
CREATE TABLE `campana_moneda` (
  `campana_id` varchar(5) NOT NULL,
  `moneda_iso` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `campana_moneda`
--

TRUNCATE TABLE `campana_moneda`;
--
-- Volcado de datos para la tabla `campana_moneda`
--

INSERT INTO `campana_moneda` (`campana_id`, `moneda_iso`) VALUES
('O~Hp%', 'COP'),
('@@Qw)', 'EUR'),
('O~Hp%', 'EUR'),
('@@Qw)', 'USD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cronograma`
--

DROP TABLE IF EXISTS `cronograma`;
CREATE TABLE `cronograma` (
  `fecha_codificacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_fin` timestamp NOT NULL,
  `fecha_inicio` timestamp NOT NULL,
  `campana_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `cronograma`
--

TRUNCATE TABLE `cronograma`;
--
-- Volcado de datos para la tabla `cronograma`
--

INSERT INTO `cronograma` (`fecha_codificacion`, `fecha_fin`, `fecha_inicio`, `campana_id`) VALUES
('2022-10-16 01:04:48', '2022-10-17 05:00:00', '2022-10-15 05:00:00', '@@Qw)'),
('2022-10-16 01:01:27', '2022-10-16 05:00:00', '2022-10-15 05:00:00', 'oc={8'),
('2022-10-17 00:37:21', '2022-10-16 05:00:00', '2022-10-16 05:00:00', 'O~Hp%'),
('2022-10-16 00:37:31', '2022-10-16 05:00:00', '2022-10-15 05:00:00', '~}I+<');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deposito`
--

DROP TABLE IF EXISTS `deposito`;
CREATE TABLE `deposito` (
  `codigo_deposito` varchar(5) NOT NULL,
  `saldo` double NOT NULL,
  `persona_id` varchar(12) NOT NULL,
  `estado_id` int NOT NULL,
  `moneda_cod` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `deposito`
--

TRUNCATE TABLE `deposito`;
--
-- Volcado de datos para la tabla `deposito`
--

INSERT INTO `deposito` (`codigo_deposito`, `saldo`, `persona_id`, `estado_id`, `moneda_cod`) VALUES
('32270', 10, '21343534', 2, 'USD'),
('32481', 20, '21343534', 2, 'USD'),
('36367', 0, '21343534', 2, 'USD'),
('47543', 0, '21343534', 2, 'COP'),
('56921', 0, '21343534', 2, 'EUR'),
('64787', 0, '21343534', 2, 'COP'),
('77904', 300, '21343534', 2, 'USD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado` (
  `id_estado` int NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `categoria` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `estado`
--

TRUNCATE TABLE `estado`;
--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id_estado`, `descripcion`, `categoria`) VALUES
(1, 'ACTIVO', 'E'),
(2, 'INACTIVO', 'E'),
(3, 'DONACION', 'D'),
(4, 'RETORNO', 'R'),
(5, 'INGRESO', 'I');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fundacion`
--

DROP TABLE IF EXISTS `fundacion`;
CREATE TABLE `fundacion` (
  `nit` varchar(15) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `razon_social` text,
  `moneda_iso` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `fundacion`
--

TRUNCATE TABLE `fundacion`;
--
-- Volcado de datos para la tabla `fundacion`
--

INSERT INTO `fundacion` (`nit`, `nombre`, `razon_social`, `moneda_iso`) VALUES
('87432567-2', 'FUNDACION NOVATEC', 'Un hermano para el mundo', 'COP');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moneda`
--

DROP TABLE IF EXISTS `moneda`;
CREATE TABLE `moneda` (
  `codigo_iso` varchar(5) NOT NULL,
  `tasa_conversion_cop` double NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `moneda`
--

TRUNCATE TABLE `moneda`;
--
-- Volcado de datos para la tabla `moneda`
--

INSERT INTO `moneda` (`codigo_iso`, `tasa_conversion_cop`, `descripcion`) VALUES
('COP', 1, 'PESO COLOMBIANO'),
('EUR', 4568, 'EURO'),
('USD', 4698, 'DOLAR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
CREATE TABLE `movimiento` (
  `id_movimiento` int NOT NULL,
  `estado_id` int NOT NULL,
  `deposito_cod` varchar(5) DEFAULT NULL,
  `campana_id` varchar(5) DEFAULT NULL,
  `valor` double NOT NULL,
  `fecha_mov` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `movimiento`
--

TRUNCATE TABLE `movimiento`;
--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id_movimiento`, `estado_id`, `deposito_cod`, `campana_id`, `valor`, `fecha_mov`) VALUES
(1, 5, NULL, NULL, 350000, '2022-10-15 06:22:16'),
(2, 5, '32481', NULL, 20, '2022-10-15 06:24:37'),
(3, 5, '32270', NULL, 46980, '2022-10-15 06:30:47'),
(4, 3, '36367', '@@Qw)', 939600, '2022-10-16 05:51:17'),
(5, 3, '36367', '@@Qw)', 469800, '2022-10-16 05:56:08'),
(6, 4, '56921', NULL, 913600, '2022-10-16 21:26:49'),
(7, 4, '64787', NULL, 350000, '2022-10-16 21:26:50'),
(8, 4, '56921', NULL, 0, '2022-10-16 23:40:20'),
(9, 4, '64787', NULL, 0, '2022-10-16 23:40:20'),
(10, 5, '47543', NULL, 1000000, '2022-10-16 23:41:44'),
(11, 4, '47543', NULL, 1000000, '2022-10-16 23:49:31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametros_campana`
--

DROP TABLE IF EXISTS `parametros_campana`;
CREATE TABLE `parametros_campana` (
  `cant_donadores` int NOT NULL,
  `cant_donaciones_permit` int NOT NULL,
  `cant_max_donador` double NOT NULL,
  `pocentaje_adm` float NOT NULL,
  `cantMin` double NOT NULL,
  `campana_id` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `parametros_campana`
--

TRUNCATE TABLE `parametros_campana`;
--
-- Volcado de datos para la tabla `parametros_campana`
--

INSERT INTO `parametros_campana` (`cant_donadores`, `cant_donaciones_permit`, `cant_max_donador`, `pocentaje_adm`, `cantMin`, `campana_id`) VALUES
(20, 2, 900000, 0.3, 2000000, '@@Qw)'),
(10, 100, 200000, 0.25, 1000000, 'oc={8'),
(2, 100, 10000000, 0.4, 10000000, 'O~Hp%'),
(2, 10, 20000, 0.2, 15000, '~}I+<');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `identificacion` varchar(12) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `nacimiento` date NOT NULL,
  `sexo_id` int NOT NULL,
  `rol_usuario` int NOT NULL,
  `fn_nit` varchar(15) NOT NULL,
  `id_estado` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `persona`
--

TRUNCATE TABLE `persona`;
--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`identificacion`, `nombre`, `apellidos`, `nacimiento`, `sexo_id`, `rol_usuario`, `fn_nit`, `id_estado`) VALUES
('21343534', 'Ever', 'Bravo', '1990-01-01', 6, 2, '87432567-2', 2),
('425453245', 'rosa', 'vergara', '1990-09-09', 7, 1, '87432567-2', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona_campana`
--

DROP TABLE IF EXISTS `persona_campana`;
CREATE TABLE `persona_campana` (
  `campana_id` varchar(5) NOT NULL,
  `persona_id` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `persona_campana`
--

TRUNCATE TABLE `persona_campana`;
--
-- Volcado de datos para la tabla `persona_campana`
--

INSERT INTO `persona_campana` (`campana_id`, `persona_id`) VALUES
('@@Qw)', '21343534'),
('oc={8', '21343534'),
('~}I+<', '21343534');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol_usuario`
--

DROP TABLE IF EXISTS `rol_usuario`;
CREATE TABLE `rol_usuario` (
  `id_rol` int NOT NULL,
  `descripcion` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `rol_usuario`
--

TRUNCATE TABLE `rol_usuario`;
--
-- Volcado de datos para la tabla `rol_usuario`
--

INSERT INTO `rol_usuario` (`id_rol`, `descripcion`) VALUES
(1, 'ADMINISTRADOR'),
(2, 'DONANTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sexo`
--

DROP TABLE IF EXISTS `sexo`;
CREATE TABLE `sexo` (
  `idsexo` int NOT NULL,
  `descripcion` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `sexo`
--

TRUNCATE TABLE `sexo`;
--
-- Volcado de datos para la tabla `sexo`
--

INSERT INTO `sexo` (`idsexo`, `descripcion`) VALUES
(7, 'FEMENINO'),
(6, 'MASCULINO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `nameuser` varchar(20) NOT NULL,
  `password` varchar(150) NOT NULL,
  `persona_id` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Truncar tablas antes de insertar `usuario`
--

TRUNCATE TABLE `usuario`;
--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nameuser`, `password`, `persona_id`) VALUES
('ever', 'bravo', '21343534'),
('rosa', 'vergara', '425453245');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `campana`
--
ALTER TABLE `campana`
  ADD PRIMARY KEY (`id_campana`),
  ADD UNIQUE KEY `id_campana_UNIQUE` (`id_campana`),
  ADD KEY `fk_campana_fundacion1_idx` (`fundacion_nit`),
  ADD KEY `fk_campana_estado1_idx` (`estado_id`);

--
-- Indices de la tabla `campana_moneda`
--
ALTER TABLE `campana_moneda`
  ADD PRIMARY KEY (`campana_id`,`moneda_iso`),
  ADD KEY `fk_campana_moneda_moneda1_idx` (`moneda_iso`);

--
-- Indices de la tabla `cronograma`
--
ALTER TABLE `cronograma`
  ADD PRIMARY KEY (`campana_id`);

--
-- Indices de la tabla `deposito`
--
ALTER TABLE `deposito`
  ADD PRIMARY KEY (`codigo_deposito`),
  ADD UNIQUE KEY `codigo_deposito_UNIQUE` (`codigo_deposito`),
  ADD KEY `fk_deposito_persona1_idx` (`persona_id`),
  ADD KEY `fk_deposito_estado1_idx` (`estado_id`),
  ADD KEY `fk_deposito_moneda1_idx` (`moneda_cod`);

--
-- Indices de la tabla `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`id_estado`),
  ADD UNIQUE KEY `descripcion_UNIQUE` (`descripcion`),
  ADD UNIQUE KEY `id_estado_UNIQUE` (`id_estado`);

--
-- Indices de la tabla `fundacion`
--
ALTER TABLE `fundacion`
  ADD PRIMARY KEY (`nit`),
  ADD UNIQUE KEY `nit_UNIQUE` (`nit`);

--
-- Indices de la tabla `moneda`
--
ALTER TABLE `moneda`
  ADD PRIMARY KEY (`codigo_iso`),
  ADD UNIQUE KEY `codigo_iso_UNIQUE` (`codigo_iso`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id_movimiento`),
  ADD KEY `fk_movimiento_estado1_idx` (`estado_id`),
  ADD KEY `fk_movimiento_deposito1_idx` (`deposito_cod`),
  ADD KEY `fk_movimiento_campana1_idx` (`campana_id`);

--
-- Indices de la tabla `parametros_campana`
--
ALTER TABLE `parametros_campana`
  ADD PRIMARY KEY (`campana_id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`identificacion`),
  ADD KEY `fk_persona_sexo1_idx` (`sexo_id`),
  ADD KEY `fk_persona_rol_usuario1_idx` (`rol_usuario`),
  ADD KEY `fk_persona_fundacion1_idx` (`fn_nit`),
  ADD KEY `fk_id_estado_estado` (`id_estado`);

--
-- Indices de la tabla `persona_campana`
--
ALTER TABLE `persona_campana`
  ADD PRIMARY KEY (`campana_id`,`persona_id`),
  ADD KEY `fk_persona_campana_campana1_idx` (`campana_id`),
  ADD KEY `fk_persona_campana_persona1_idx` (`persona_id`);

--
-- Indices de la tabla `rol_usuario`
--
ALTER TABLE `rol_usuario`
  ADD PRIMARY KEY (`id_rol`),
  ADD UNIQUE KEY `descripcion_UNIQUE` (`descripcion`);

--
-- Indices de la tabla `sexo`
--
ALTER TABLE `sexo`
  ADD PRIMARY KEY (`idsexo`),
  ADD UNIQUE KEY `descripcion_UNIQUE` (`descripcion`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`persona_id`),
  ADD UNIQUE KEY `nameuser_UNIQUE` (`nameuser`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `estado`
--
ALTER TABLE `estado`
  MODIFY `id_estado` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id_movimiento` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `rol_usuario`
--
ALTER TABLE `rol_usuario`
  MODIFY `id_rol` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sexo`
--
ALTER TABLE `sexo`
  MODIFY `idsexo` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `campana`
--
ALTER TABLE `campana`
  ADD CONSTRAINT `fk_campana_estado1` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id_estado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_campana_fundacion1` FOREIGN KEY (`fundacion_nit`) REFERENCES `fundacion` (`nit`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `campana_moneda`
--
ALTER TABLE `campana_moneda`
  ADD CONSTRAINT `fk_campana_moneda_campana1` FOREIGN KEY (`campana_id`) REFERENCES `campana` (`id_campana`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_campana_moneda_moneda1` FOREIGN KEY (`moneda_iso`) REFERENCES `moneda` (`codigo_iso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cronograma`
--
ALTER TABLE `cronograma`
  ADD CONSTRAINT `fk_cronograma_campana1` FOREIGN KEY (`campana_id`) REFERENCES `campana` (`id_campana`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `deposito`
--
ALTER TABLE `deposito`
  ADD CONSTRAINT `fk_deposito_estado1` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id_estado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_deposito_moneda1` FOREIGN KEY (`moneda_cod`) REFERENCES `moneda` (`codigo_iso`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_deposito_persona1` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`identificacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `fk_movimiento_campana1` FOREIGN KEY (`campana_id`) REFERENCES `campana` (`id_campana`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_movimiento_deposito1` FOREIGN KEY (`deposito_cod`) REFERENCES `deposito` (`codigo_deposito`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_movimiento_estado1` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id_estado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `parametros_campana`
--
ALTER TABLE `parametros_campana`
  ADD CONSTRAINT `fk_parametros_campana_campana1` FOREIGN KEY (`campana_id`) REFERENCES `campana` (`id_campana`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `fk_persona_fundacion1` FOREIGN KEY (`fn_nit`) REFERENCES `fundacion` (`nit`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_persona_sexo1` FOREIGN KEY (`sexo_id`) REFERENCES `sexo` (`idsexo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`rol_usuario`) REFERENCES `rol_usuario` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona_campana`
--
ALTER TABLE `persona_campana`
  ADD CONSTRAINT `fk_persona_campana_campana1` FOREIGN KEY (`campana_id`) REFERENCES `campana` (`id_campana`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_persona_campana_persona1` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`identificacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`identificacion`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
