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
  `id_usuario` int(11) NOT NULL,
  `id_video` int(11) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `texto` text NOT NULL,
  `aprobado` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0=sin aprobar, 1=aprobado',
  PRIMARY KEY (`id`),
  KEY `comentario_has_usuario` (`id_usuario`),
  KEY `comentario_has_video` (`id_video`),
  CONSTRAINT `comentario_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comentario_has_video` FOREIGN KEY (`id_video`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.comentario: ~0 rows (aproximadamente)
DELETE FROM `comentario`;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` (`id`, `id_usuario`, `id_video`, `fecha`, `texto`, `aprobado`) VALUES
	(1, 2, 1, '2018-10-11 09:10:09', 'Me he reido mucho, gran video', 0),
	(2, 3, 1, '2018-10-11 09:11:30', 'Vaya mierda de video', 0);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla youtube.rol: ~4 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(0, 'administrador'),
	(1, 'usuario'),
	(5, 'dedede'),
	(9, 'lollo');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET latin1 NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `id_rol` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `usuario_has_rol` (`id_rol`),
  CONSTRAINT `usuario_has_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.usuario: ~13 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `id_rol`) VALUES
	(1, 'admin', 'admin', 0),
	(2, 'Manolo', '12345', 1),
	(3, 'Pepi', '12345', 1),
	(30, 'Asier', 'lola', 1),
	(45, 'luis', 'luis', 1),
	(49, 'jone', 'juana', 1),
	(51, 'fumito', 'ueda', 1),
	(52, 'hideo', 'kojima', 1),
	(53, 'shigeru', 'miyamoto', 1),
	(54, 'kenji', 'inafune', 1),
	(55, 'phil', 'spencer', 1),
	(56, 'Yolanda', 'layolu', 1),
	(57, 'estitxu', 'lokitxu', 1),
	(58, 'irune', 'otaku', 1),
	(73, 'desedesdes', 'aswerd', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla youtube.video
CREATE TABLE IF NOT EXISTS `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) NOT NULL COMMENT 'identificador del video en youtube',
  `nombre` varchar(150) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `video_has_usuario_idx` (`id_usuario`),
  CONSTRAINT `video_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla youtube.video: ~15 rows (aproximadamente)
DELETE FROM `video`;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` (`id`, `codigo`, `nombre`, `id_usuario`) VALUES
	(1, 'i_cVJgIz_Cs', 'No te olvides de poner el Where en el Delete From. (Una canciÃ³n para programadores)', 30),
	(3, 'Ctwju5_Qflw', 'Windy Reggae', 1),
	(31, 'jJllPxkHGPE', 'Blancanieves y los siete enanitos: Ay ho/Cavar, cavar', 30),
	(32, 'UtF6Jej8yb4', 'Avicii I\'s - The Nights', 1),
	(33, '4yld459xLJ4', 'Ramoninos - Ya no quiero ser yo (La Polla Records) (Kalikenyo Rock XII 2017)', 1),
	(38, 'aL6xNZ9pnbI', 'Miku Hatsune (Vocaloid) - Senbonzakura', 1),
	(40, 'sVwrQ2n13eQ', 'Avicii I\'s - The Nights', 1),
	(41, 'bQMjEkkbHmU', 'Tijuana In Blue -- Enamorado de la muerte (cover)', 1),
	(43, 'p32b5nNq1zw', 'Iron Maiden - Fear of The Dark (HQ)', 1),
	(44, 'NFSyl3pwa-A', '"Maricarmen" - La Pegatina (videoclip oficial)', 1),
	(45, '0fgiBri5ZoA', 'Banda Bassotti - Juri Gagarin', 1),
	(46, 'wkjUEumfjFM', 'Banda Bassotti - Mockba \'993', 1),
	(47, 'j--2L3_FN08', 'SOZIEDAD ALKOHOLIKA - Piedra Contra Tijera (Video Oficial)', 45);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
