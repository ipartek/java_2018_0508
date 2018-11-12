-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.19 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- SENTENCIAS AÑADIDAS
DROP SCHEMA IF EXISTS howarts;
CREATE DATABASE howarts;
USE howarts;

-- Volcando estructura de base de datos para hogwarts

-- Volcando estructura para tabla hogwarts.alumno
DROP TABLE IF EXISTS `alumno`;
CREATE TABLE IF NOT EXISTS `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `numero_mago` varchar(45) NOT NULL,
  `casa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_alumno_casa_idx` (`casa_id`),
  CONSTRAINT `fk_alumno_casa` FOREIGN KEY (`casa_id`) REFERENCES `casa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.alumno: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
REPLACE INTO `alumno` (`id`, `nombre`, `apellidos`, `numero_mago`, `casa_id`) VALUES
	(1, 'Jarri', 'Potas Duras', '666', 1),
	(2, 'Dolores', 'Fuertes de Estomago', '854896', 1),
	(3, 'Hola', 'Noseque Poner', '8888815', 3),
	(4, 'Antonio', 'Jimenez los Santos', '555555', 4),
	(5, 'Antonia', 'Jimenez los Santos', '555554', 4),
	(6, 'Antonito', 'Jimenez los Santos', '555444', 4),
	(7, 'Felisa', 'De Todos Los Santos', '459873', 2);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.alumno_has_asignatura
DROP TABLE IF EXISTS `alumno_has_asignatura`;
CREATE TABLE IF NOT EXISTS `alumno_has_asignatura` (
  `alumno_id` int(11) NOT NULL,
  `asignatura_id` int(11) NOT NULL,
  `anio` int(4) NOT NULL DEFAULT '0',
  `nota` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`alumno_id`,`asignatura_id`,`anio`),
  KEY `fk_alumno_has_asignatura_asignatura1_idx` (`asignatura_id`),
  KEY `fk_alumno_has_asignatura_alumno1_idx` (`alumno_id`),
  KEY `anio` (`anio`),
  CONSTRAINT `fk_alumno_has_asignatura_alumno1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_has_asignatura_asignatura1` FOREIGN KEY (`asignatura_id`) REFERENCES `asignatura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.alumno_has_asignatura: ~72 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno_has_asignatura` DISABLE KEYS */;
REPLACE INTO `alumno_has_asignatura` (`alumno_id`, `asignatura_id`, `anio`, `nota`) VALUES
	(1, 1, 2016, 9),
	(1, 1, 2017, 6),
	(1, 2, 2016, 9),
	(1, 2, 2017, 8),
	(1, 3, 2016, 9),
	(1, 3, 2017, 4),
	(1, 4, 2016, 9),
	(1, 4, 2017, 6),
	(1, 6, 2017, 8),
	(1, 7, 2016, 9),
	(1, 7, 2017, 7),
	(2, 2, 2016, 5),
	(2, 2, 2017, 6),
	(2, 3, 2016, 4),
	(2, 3, 2017, 9),
	(2, 4, 2016, 9),
	(2, 4, 2017, 5),
	(2, 5, 2016, 5),
	(2, 5, 2017, 9),
	(2, 6, 2016, 5),
	(2, 6, 2017, 5),
	(3, 1, 2016, 4),
	(3, 1, 2017, 5),
	(3, 2, 2016, 4),
	(3, 2, 2017, 9),
	(3, 4, 2016, 4),
	(3, 4, 2017, 6),
	(3, 6, 2016, 4),
	(3, 6, 2017, 9),
	(3, 7, 2016, 4),
	(3, 7, 2017, 5),
	(4, 2, 2016, 4),
	(4, 2, 2017, 3),
	(4, 3, 2016, 8),
	(4, 3, 2017, 10),
	(4, 4, 2016, 7),
	(4, 4, 2017, 2),
	(4, 5, 2016, 8),
	(4, 5, 2017, 3),
	(4, 7, 2016, 7),
	(4, 7, 2017, 2),
	(5, 1, 2017, 5),
	(5, 2, 2017, 5),
	(5, 3, 2017, 5),
	(5, 4, 2017, 5),
	(5, 5, 2017, 5),
	(6, 1, 2017, 0),
	(6, 2, 2017, 0),
	(6, 3, 2017, 0),
	(6, 4, 2017, 0),
	(6, 5, 2017, 0),
	(7, 1, 2015, 10),
	(7, 1, 2016, 1),
	(7, 1, 2017, 4),
	(7, 2, 2015, 10),
	(7, 2, 2016, 1),
	(7, 2, 2017, 5),
	(7, 3, 2015, 10),
	(7, 3, 2016, 1),
	(7, 3, 2017, 10),
	(7, 4, 2015, 10),
	(7, 4, 2016, 1),
	(7, 4, 2017, 4),
	(7, 5, 2015, 10),
	(7, 5, 2016, 1),
	(7, 5, 2017, 6),
	(7, 6, 2015, 10),
	(7, 6, 2016, 1),
	(7, 6, 2017, 10),
	(7, 7, 2015, 10),
	(7, 7, 2016, 1),
	(7, 7, 2017, 10);
/*!40000 ALTER TABLE `alumno_has_asignatura` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.alumno_has_habitacion
DROP TABLE IF EXISTS `alumno_has_habitacion`;
CREATE TABLE IF NOT EXISTS `alumno_has_habitacion` (
  `alumno_id` int(11) NOT NULL,
  `anio` int(4) NOT NULL,
  `habitacion_id` int(11) NOT NULL,
  PRIMARY KEY (`alumno_id`,`anio`),
  KEY `fk_alumno_has_habitacion_habitacion1_idx` (`habitacion_id`),
  KEY `fk_alumno_has_habitacion_alumno1_idx` (`alumno_id`),
  KEY `anio` (`anio`),
  CONSTRAINT `fk_alumno_has_habitacion_alumno1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_has_habitacion_habitacion1` FOREIGN KEY (`habitacion_id`) REFERENCES `habitacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.alumno_has_habitacion: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno_has_habitacion` DISABLE KEYS */;
REPLACE INTO `alumno_has_habitacion` (`alumno_id`, `anio`, `habitacion_id`) VALUES
	(6, 2016, 2),
	(2, 2017, 3),
	(7, 2016, 3),
	(2, 2016, 4),
	(5, 2017, 4);
/*!40000 ALTER TABLE `alumno_has_habitacion` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.alumno_has_partido_quidditch
DROP TABLE IF EXISTS `alumno_has_partido_quidditch`;
CREATE TABLE IF NOT EXISTS `alumno_has_partido_quidditch` (
  `alumno_id` int(11) NOT NULL,
  `partido_quidditch_id` int(11) NOT NULL,
  PRIMARY KEY (`alumno_id`,`partido_quidditch_id`),
  KEY `fk_alumno_has_partido_quidditch_partido_quidditch1_idx` (`partido_quidditch_id`),
  KEY `fk_alumno_has_partido_quidditch_alumno1_idx` (`alumno_id`),
  CONSTRAINT `fk_alumno_has_partido_quidditch_alumno1` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumno_has_partido_quidditch_partido_quidditch1` FOREIGN KEY (`partido_quidditch_id`) REFERENCES `partido_quidditch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.alumno_has_partido_quidditch: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno_has_partido_quidditch` DISABLE KEYS */;
REPLACE INTO `alumno_has_partido_quidditch` (`alumno_id`, `partido_quidditch_id`) VALUES
	(1, 1),
	(2, 1),
	(4, 1),
	(5, 1),
	(6, 1),
	(1, 2),
	(2, 2),
	(3, 2),
	(3, 3),
	(7, 3),
	(4, 4),
	(5, 4),
	(6, 4),
	(7, 4);
/*!40000 ALTER TABLE `alumno_has_partido_quidditch` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.asignatura
DROP TABLE IF EXISTS `asignatura`;
CREATE TABLE IF NOT EXISTS `asignatura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.asignatura: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `asignatura` DISABLE KEYS */;
REPLACE INTO `asignatura` (`id`, `nombre`) VALUES
	(1, 'Transformaciones'),
	(2, 'Encantamientos'),
	(3, 'Pociones'),
	(4, 'Historia de la Magia'),
	(5, 'Defensa Contra las Artes Oscuras'),
	(6, 'Astronomía'),
	(7, 'Herbología');
/*!40000 ALTER TABLE `asignatura` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.casa
DROP TABLE IF EXISTS `casa`;
CREATE TABLE IF NOT EXISTS `casa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `profesor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_casa_profesor1_idx` (`profesor_id`),
  CONSTRAINT `fk_casa_profesor1` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.casa: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `casa` DISABLE KEYS */;
REPLACE INTO `casa` (`id`, `nombre`, `profesor_id`) VALUES
	(1, 'Griffindor', 1),
	(2, 'Hufflelpuff', 2),
	(3, 'Ravenclaw', 3),
	(4, 'Slytherin', 4);
/*!40000 ALTER TABLE `casa` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.casa_has_partido_quidditch
DROP TABLE IF EXISTS `casa_has_partido_quidditch`;
CREATE TABLE IF NOT EXISTS `casa_has_partido_quidditch` (
  `casa_id` int(11) NOT NULL,
  `partido_quidditch_id` int(11) NOT NULL,
  `puntuacion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`casa_id`,`partido_quidditch_id`),
  KEY `fk_casa_has_partido_quidditch_partido_quidditch1_idx` (`partido_quidditch_id`),
  KEY `fk_casa_has_partido_quidditch_casa1_idx` (`casa_id`),
  CONSTRAINT `fk_casa_has_partido_quidditch_casa1` FOREIGN KEY (`casa_id`) REFERENCES `casa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_casa_has_partido_quidditch_partido_quidditch1` FOREIGN KEY (`partido_quidditch_id`) REFERENCES `partido_quidditch` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.casa_has_partido_quidditch: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `casa_has_partido_quidditch` DISABLE KEYS */;
REPLACE INTO `casa_has_partido_quidditch` (`casa_id`, `partido_quidditch_id`, `puntuacion`) VALUES
	(1, 1, 150),
	(1, 2, 220),
	(2, 1, 100),
	(2, 3, 10),
	(2, 4, 450),
	(3, 3, 650),
	(4, 2, 400),
	(4, 4, 0);
/*!40000 ALTER TABLE `casa_has_partido_quidditch` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.habitacion
DROP TABLE IF EXISTS `habitacion`;
CREATE TABLE IF NOT EXISTS `habitacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `camas` int(11) NOT NULL,
  `ubicacion` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.habitacion: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
REPLACE INTO `habitacion` (`id`, `camas`, `ubicacion`) VALUES
	(1, 5, 'Tercer piso a la derecha'),
	(2, 10, 'Debajo de la sala de Fluffy'),
	(3, 6, 'Al lado de los baños del 5º piso'),
	(4, 5, 'Donde cago el moro');
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.partido_quidditch
DROP TABLE IF EXISTS `partido_quidditch`;
CREATE TABLE IF NOT EXISTS `partido_quidditch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `arbitro` int(11) NOT NULL,
  `MVP` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_partido_quidditch_profesor1_idx` (`arbitro`),
  KEY `fk_partido_quidditch_alumno1_idx` (`MVP`),
  CONSTRAINT `fk_partido_quidditch_alumno1` FOREIGN KEY (`MVP`) REFERENCES `alumno` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_partido_quidditch_profesor1` FOREIGN KEY (`arbitro`) REFERENCES `profesor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.partido_quidditch: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `partido_quidditch` DISABLE KEYS */;
REPLACE INTO `partido_quidditch` (`id`, `fecha`, `arbitro`, `MVP`) VALUES
	(1, '2017-06-17', 7, 2),
	(2, '2016-08-28', 5, 2),
	(3, '2017-06-27', 5, 7),
	(4, '2017-09-09', 4, 5);
/*!40000 ALTER TABLE `partido_quidditch` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.profesor
DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.profesor: ~7 rows (aproximadamente)
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
REPLACE INTO `profesor` (`id`, `nombre`, `apellidos`) VALUES
	(1, 'Godric ', 'Gryffindor'),
	(2, 'Helga ', 'Hufflepuff '),
	(3, 'Rowena ', 'Ravenclaw'),
	(4, 'Salazar ', 'Slytherin'),
	(5, 'Alguien', 'Algo'),
	(6, 'Enrieta', 'Hety'),
	(7, 'Ander', 'Uraga');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;

-- Volcando estructura para tabla hogwarts.profesor_has_asignatura
DROP TABLE IF EXISTS `profesor_has_asignatura`;
CREATE TABLE IF NOT EXISTS `profesor_has_asignatura` (
  `profesor_id` int(11) NOT NULL,
  `asignatura_id` int(11) NOT NULL,
  `anio` int(4) NOT NULL,
  PRIMARY KEY (`profesor_id`,`anio`),
  KEY `fk_profesor_has_asignatura_asignatura1_idx` (`asignatura_id`),
  KEY `fk_profesor_has_asignatura_profesor1_idx` (`profesor_id`),
  KEY `anio` (`anio`),
  CONSTRAINT `fk_profesor_has_asignatura_asignatura1` FOREIGN KEY (`asignatura_id`) REFERENCES `asignatura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesor_has_asignatura_profesor1` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla hogwarts.profesor_has_asignatura: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `profesor_has_asignatura` DISABLE KEYS */;
REPLACE INTO `profesor_has_asignatura` (`profesor_id`, `asignatura_id`, `anio`) VALUES
	(1, 1, 2015),
	(1, 1, 2016),
	(1, 1, 2017),
	(6, 2, 2017),
	(3, 4, 2014),
	(3, 4, 2017),
	(2, 5, 2017),
	(7, 5, 2014),
	(5, 6, 2017),
	(7, 6, 2016),
	(2, 7, 2016),
	(7, 7, 2017);
/*!40000 ALTER TABLE `profesor_has_asignatura` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;