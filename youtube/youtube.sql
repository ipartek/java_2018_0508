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

-- Volcando estructura para tabla youtube.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `rol` int(11) NOT NULL DEFAULT '1' COMMENT '0: Administrador\n1: usuario normal',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.usuario: ~2 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `rol`) VALUES
	(1, 'admin', 'admin', 0),
	(2, 'manoli', 'manoli', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.video
DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) NOT NULL COMMENT 'identificador del video en youtube',
  `nombre` varchar(150) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `video_has_usuario_idx` (`id_usuario`),
  CONSTRAINT `video_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.video: ~14 rows (aproximadamente)
DELETE FROM `video`;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` (`id`, `codigo`, `nombre`, `id_usuario`) VALUES
	(1, 'i_cVJgIz_Cs', 'No te olvides de poner el Where en el Delete From. (Una canción para programadores)', 1),
	(3, 'Ctwju5_Qflw', 'Windy Reggae', 1),
	(31, 'jJllPxkHGPE', 'Blancanieves y los siete enanitos: Ay ho/Cavar, cavar', 1),
	(32, 'UtF6Jej8yb4', 'Avicii I\'s - The Nights', 1),
	(33, '4yld459xLJ4', 'Ramoninos - Ya no quiero ser yo (La Polla Records) (Kalikenyo Rock XII 2017)', 1),
	(38, 'aL6xNZ9pnbI', 'Miku Hatsune (Vocaloid) - Senbonzakura', 1),
	(40, 'sVwrQ2n13eQ', 'Autos de choque del FARY', 1),
	(41, 'bQMjEkkbHmU', 'Tijuana In Blue -- Enamorado de la muerte (cover)', 1),
	(42, 'Pzqr3rVZNso', 'EL RENO RENARDO - Camino Moria (videolyric by Azzurro)', 1),
	(43, 'p32b5nNq1zw', 'Iron Maiden - Fear of The Dark (HQ)', 1),
	(44, 'NFSyl3pwa-A', '"Maricarmen" - La Pegatina (videoclip oficial)', 1),
	(45, '0fgiBri5ZoA', 'Banda Bassotti - Juri Gagarin', 1),
	(46, 'wkjUEumfjFM', 'Banda Bassotti - Mockba \'993', 1),
	(47, 'j--2L3_FN08', 'aaaaaaaaaaaaaaaaaSOZIEDAD ALKOHOLIKA - Piedra Contra Tijera (Video Oficial)', 1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
