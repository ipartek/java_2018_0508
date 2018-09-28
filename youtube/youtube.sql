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


-- Volcando estructura de base de datos para youtube
DROP DATABASE IF EXISTS `youtube`;
CREATE DATABASE IF NOT EXISTS `youtube` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `youtube`;

-- Volcando estructura para tabla youtube.video
DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) NOT NULL COMMENT 'identificador del video en youtube',
  `nombre` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.video: ~5 rows (aproximadamente)
DELETE FROM `video`;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` (`id`, `codigo`, `nombre`) VALUES
	(1, 'i_cVJgIz_Cs', 'No te olvides de poner el Where en el Delete From. (Una canción para programadores)'),
	(3, 'Ctwju5_Qflw', 'Windy Reggae'),
	(5, 'iUXs4Nt3Y7Y', 'Fito & Fitipaldis - Por la boca vive el pez'),
	(6, 'SblzGUy_sHQ', 'Manu Chao Clandestino- esperando la ultima ola... Full Album'),
	(7, 'TiCxqhu9cio', 'Bruce Springsteen - Waitin\' on a Sunny Day');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
