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
CREATE DATABASE IF NOT EXISTS `youtube` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `youtube`;

-- Volcando estructura para tabla youtube.comentario
CREATE TABLE IF NOT EXISTS `comentario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `texto` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `aprobado` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0=Sin aprobar\n1=Aprobado',
  `id_video` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `comentario_has_usuario_idx` (`id_usuario`),
  KEY `comentario_has_video_idx` (`id_video`),
  CONSTRAINT `comentario_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comentario_has_video` FOREIGN KEY (`id_video`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.comentario: ~0 rows (aproximadamente)
DELETE FROM `comentario`;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` (`id`, `fecha`, `texto`, `aprobado`, `id_video`, `id_usuario`) VALUES
	(1, '2018-10-15 13:02:46', 'qwerty', 1, 5, 7),
	(2, '2018-10-15 13:02:46', 'qwerty', 1, 5, 7),
	(3, '2018-10-15 13:02:46', 'qwerty', 0, 5, 7),
	(4, '2018-10-15 13:02:46', 'qwerty', 0, 5, 7);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla youtube.rol: ~3 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(1, 'administrador'),
	(3, 'editor'),
	(2, 'usuario normal');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `rol` int(11) NOT NULL DEFAULT '1' COMMENT '0: admin\n1: usuario',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `usuario_has_rol_id_idx` (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.usuario: ~9 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `rol`) VALUES
	(1, 'admin', 'admin', 0),
	(2, 'manoli', 'manoli', 0),
	(3, 'pepe', 'pepe', 1),
	(4, 'qwert', 'qwert', 1),
	(5, 'adrian', 'adrian', 1),
	(6, 'raul', 'raul', 1),
	(7, 'andrea', 'andrea', 1),
	(8, 'pedro', 'pedro', 1),
	(9, 'pablo', 'pablo', 3),
	(14, 'eevee', 'eevee', 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.video: ~7 rows (aproximadamente)
DELETE FROM `video`;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` (`id`, `codigo`, `nombre`, `id_usuario`) VALUES
	(5, 'iUXs4Nt3Y7Y', 'Fito & Fitipaldis - Por la boca vive el pez', 1),
	(7, 'TiCxqhu9cio', 'Bruce Springsteen - Waitin\' on a Sunny Day', 1),
	(8, 'UYQa7bQE0to', 'RAMONINOS EN REPEROCK -- Conciertazo!!!', 1),
	(11, 'sB-TVciAc5A', 'Non Servium - Todos al suelo ', 1),
	(13, 'nBIBJc2XPHc', 'M.C.D - De ningun sitio a ninguna parte [Album]', 2),
	(14, 'X4WXf3Ez1K0', 'The Maytals - Monkey Man FULL ALBUM', 2),
	(15, 'DD65K4VR6Lw', 'Wardruna - Helvegen (The Way To Hel)', 2);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
