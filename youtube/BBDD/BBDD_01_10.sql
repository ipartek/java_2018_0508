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


-- Volcando estructura de base de datos para youtube
CREATE DATABASE IF NOT EXISTS `youtube` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `youtube`;

-- Volcando estructura para tabla youtube.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `rol` int(11) NOT NULL DEFAULT '1' COMMENT '0: admin\n1: usuario',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.usuario: ~0 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `rol`) VALUES
	(1, 'admin', 'admin', 0),
	(2, 'manoli', 'manoli', 0),
	(3, 'pepe', 'pepe', 1),
	(4, 'qwert', 'qwert', 1),
	(5, 'adrian', 'adrian', 1),
	(6, 'raul', 'raul', 1),
	(7, 'andrea', 'andrea', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.video
CREATE TABLE IF NOT EXISTS `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) NOT NULL COMMENT 'identificador del video en youtube',
  `nombre` varchar(150) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `video_has_usuario_idx` (`id_usuario`),
  CONSTRAINT `video_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.video: ~5 rows (aproximadamente)
DELETE FROM `video`;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` (`id`, `codigo`, `nombre`, `id_usuario`) VALUES
	(5, 'iUXs4Nt3Y7Y', 'Fito & Fitipaldis - Por la boca vive el pez', 1),
	(7, 'TiCxqhu9cio', 'Bruce Springsteen - Waitin\' on a Sunny Day', 1),
	(8, 'UYQa7bQE0to', 'RAMONINOS EN REPEROCK -- Conciertazo!!!', 1),
	(11, 'sB-TVciAc5A', 'Non Servium - Todos al suelo (Kalikenyo Rock XI 2016 / El Resurgir)', 1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
