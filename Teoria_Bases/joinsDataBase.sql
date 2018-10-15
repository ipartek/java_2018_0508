-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.12 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para joins
CREATE DATABASE IF NOT EXISTS `joins` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `joins`;

-- Volcando estructura para tabla joins.departamento
CREATE TABLE IF NOT EXISTS `departamento` (
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla joins.departamento: ~0 rows (aproximadamente)
DELETE FROM `departamento`;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` (`id`, `nombre`) VALUES
	(31, 'ventas'),
	(33, 'ingenieria'),
	(34, 'produccion'),
	(35, 'mercadeo');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;

-- Volcando estructura para tabla joins.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  `id_jefe` int(11) NOT NULL,
  `id_puesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla joins.empleado: ~1 rows (aproximadamente)
DELETE FROM `empleado`;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`id`, `apellido`, `id_departamento`, `id_jefe`, `id_puesto`) VALUES
	(1, 'Andrade', 31, 69, 1),
	(2, 'Jordan', 33, 69, 1),
	(3, 'Steinberg', 33, 69, 2),
	(4, 'Robinson', 34, 69, 1),
	(5, 'Zolano', 34, 69, 2),
	(6, 'Gaspar', 36, 0, 2),
	(69, 'SR.Burns', NULL, 0, 3);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando estructura para tabla joins.puesto
CREATE TABLE IF NOT EXISTS `puesto` (
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `sueldo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla joins.puesto: ~0 rows (aproximadamente)
DELETE FROM `puesto`;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` (`id`, `nombre`, `sueldo`) VALUES
	(1, 'programador', 1000),
	(2, 'becario', 400),
	(3, 'jefe', 5000);
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
