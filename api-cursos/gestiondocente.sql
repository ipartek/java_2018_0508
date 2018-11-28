-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para gestiondocente
DROP DATABASE IF EXISTS `gestiondocente`;
CREATE DATABASE IF NOT EXISTS `gestiondocente` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `gestiondocente`;

-- Volcando estructura para tabla gestiondocente.alumno
DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT COMMENT 'el campo clave de la tabla. Es auto generado.',
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) unsigned zerofill DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `dni` varchar(9) COLLATE utf8_bin NOT NULL,
  `nHermanos` int(2) DEFAULT '0',
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla gestiondocente.alumno: ~4 rows (aproximadamente)
DELETE FROM `alumno`;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`codigo`, `nombre`, `apellidos`, `fNacimiento`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `dni`, `nHermanos`, `activo`) VALUES
	(0, 'alumno', 'sin asignar', NULL, NULL, NULL, 00000, 0, 'aaaaaaa@aaaaa.com', '0000000x', 0, 0),
	(1, 'Don Pimpom', 'aparicio vargas', '1977-12-01', '', '', 00000, 944110293, 'aaaa@aaaa.com', '44974398z', 0, 1),
	(2, 'marilo', 'monasterio', '1986-11-11', '', '', 48007, 944110293, 'mmonasterio@ipartek.com', '16071559x', 0, 1),
	(4, 'enrique javier', 'ruiz jimenez', '2017-02-14', '', '', 00048, 944110239, 'enriqueFErnandexz@gmail.com', '45677362y', 0, 1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondocente.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE utf8_bin NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `telefono` int(9) NOT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) unsigned zerofill DEFAULT NULL,
  `identificador` varchar(15) COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla gestiondocente.cliente: ~4 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`codigo`, `nombre`, `email`, `telefono`, `direccion`, `poblacion`, `codigopostal`, `identificador`, `activo`) VALUES
	(0, 'Sin Definir', 'aaaaaa@aaaaa.com', 9444, NULL, NULL, NULL, '#######', 0),
	(1, 'SERIKAT CONSULTORÍA E INFORMÁTICA, S.A.', 'info@serikat.es', 944250100, 'c/ Ercilla 19', 'Bilbao', 48009, 'A-48476006', 1),
	(2, 'lanbide - servicio vasco de empleo', 'info@lanbide.net', 945160601, 'Jose Atxotegi 1', 'Vitoria-Gazteiz', 01009, 'Q0100571l', 1),
	(3, 'hobetuz', 'bizkaia@hobetuz.eus', 944150808, 'gran vía, 35-6º', NULL, NULL, 'g48850127', 1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondocente.curso
DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8_bin NOT NULL,
  `identificador` varchar(12) COLLATE utf8_bin NOT NULL,
  `fInicio` date DEFAULT NULL,
  `fFin` date DEFAULT NULL,
  `nHoras` int(4) NOT NULL,
  `temario` text COLLATE utf8_bin,
  `activo` tinyint(4) DEFAULT '1',
  `cliente_codigo` int(11) DEFAULT NULL,
  `precio` double(8,2) DEFAULT '0.00',
  `profesor_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_curso_cliente_codigo_idx` (`cliente_codigo`),
  KEY `fk_curso_profesor_codigo_idx` (`profesor_codigo`),
  CONSTRAINT `fk_curso_cliente_codigo` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_profesor_codigo` FOREIGN KEY (`profesor_codigo`) REFERENCES `profesor` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla gestiondocente.curso: ~4 rows (aproximadamente)
DELETE FROM `curso`;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` (`codigo`, `nombre`, `identificador`, `fInicio`, `fFin`, `nHoras`, `temario`, `activo`, `cliente_codigo`, `precio`, `profesor_codigo`) VALUES
	(1, 'Desarrrollo de Aplicaciones con Tecnologias Web', '18482675', '2017-01-09', '2017-06-13', 510, NULL, 1, 2, 300000.00, 1),
	(2, 'Desarrollo de Bases de Datos y Programacion orientada a Objetos', '18488225', '2017-02-20', '2017-09-29', 630, 'IFCD0112_FIC.pdf', 1, 2, 400000.00, 1),
	(3, 'Publicidad en internet', '18482678', '2017-03-27', '2017-03-30', 10, NULL, 1, 3, 1500.00, 2),
	(4, 'Programación en Bases de Datos relaciones con Oracle 12c', 'CI67', '2017-05-02', '2017-05-30', 30, 'CI67.pdf', 1, 3, 3500.00, 2);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondocente.imparticion
DROP TABLE IF EXISTS `imparticion`;
CREATE TABLE IF NOT EXISTS `imparticion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `curso_codigo` int(11) NOT NULL,
  `alumno_codigo` int(11) NOT NULL,
  `fMatriculacion` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_imparticion_alumno_codigo_idx` (`alumno_codigo`),
  KEY `fk_imparticion_curso_codigo_idx` (`curso_codigo`),
  CONSTRAINT `fk_imparticion_alumno_codigo` FOREIGN KEY (`alumno_codigo`) REFERENCES `alumno` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_imparticion_curso_codigo` FOREIGN KEY (`curso_codigo`) REFERENCES `curso` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla gestiondocente.imparticion: ~8 rows (aproximadamente)
DELETE FROM `imparticion`;
/*!40000 ALTER TABLE `imparticion` DISABLE KEYS */;
INSERT INTO `imparticion` (`codigo`, `curso_codigo`, `alumno_codigo`, `fMatriculacion`) VALUES
	(9, 3, 2, NULL),
	(10, 3, 4, NULL),
	(15, 2, 1, NULL),
	(16, 2, 2, NULL),
	(17, 2, 4, NULL),
	(48, 1, 1, NULL),
	(49, 1, 2, NULL),
	(50, 1, 4, NULL);
/*!40000 ALTER TABLE `imparticion` ENABLE KEYS */;

-- Volcando estructura para tabla gestiondocente.profesor
DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `NSS` bigint(12) DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `DNI` varchar(9) COLLATE utf8_bin NOT NULL,
  `direccion` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) unsigned zerofill DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Volcando datos para la tabla gestiondocente.profesor: ~2 rows (aproximadamente)
DELETE FROM `profesor`;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` (`codigo`, `NSS`, `nombre`, `apellidos`, `fNacimiento`, `DNI`, `direccion`, `poblacion`, `codigopostal`, `telefono`, `email`, `activo`) VALUES
	(0, 0, 'profesor', 'sin asignar', NULL, '00000000z', NULL, NULL, NULL, 0, 'aaaaaaaa@aaaaa.aaa', 0),
	(1, 481234567840, 'Urko', 'Sapiems', '1976-11-24', '30693142x', 'Av. Mazustegi 9', 'Bilbao', 48009, 944110293, 'sapimens@ipartek.com', 1),
	(2, 481234567840, 'Ander', 'Uraga', NULL, '1111111H', 'barrio semana', 'bilbao', 48003, 666555444, 'auraga@ipartek.com', 1);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;