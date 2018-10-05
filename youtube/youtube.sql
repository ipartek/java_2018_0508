
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: youtube
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE `youtube`;
CREATE DATABASE  IF NOT EXISTS `youtube`;
USE `youtube`;


--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET latin1 NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `rol` int(11) NOT NULL DEFAULT '1' COMMENT '0: Administrador\n1: usuario normal',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin',0),(17,'manolo','12345',1),(25,'  maNolito  ','12345',1),(26,'       manolito    ','12345',1),(29,'maria','12345678',1),(34,'Javier','098765432',1),(44,'David','1234',1),(51,'Jose','1234567890',1),(52,'marta','1234567890',1),(53,'joserra','1234567890',1),(54,'DON PIMPOM','12345',1),(57,'TXEMA','12345+6',0),(59,'','',1),(67,'palotes222','',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) NOT NULL COMMENT 'identificador del video en youtube',
  `nombre` varchar(150) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `video_has_usuario_idx` (`id_usuario`),
  CONSTRAINT `video_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'i_cVJgIz_Cs','No te olvides de poner el Where en el Delete From. (Una canción para programadores)',1),(3,'Ctwju5_Qflw','Windy Reggae',1),(31,'jJllPxkHGPE','Blancanieves y los siete enanitos: Ay ho/Cavar, cavar',1),(32,'UtF6Jej8yb4','Avicii I\'s - The Nights',1),(33,'4yld459xLJ4','Ramoninos - Ya no quiero ser yo (La Polla Records) (Kalikenyo Rock XII 2017)',1),(38,'aL6xNZ9pnbI','Miku Hatsune (Vocaloid) - Senbonzakura',1),(40,'sVwrQ2n13eQ','Autos de choque del FARY',1),(41,'bQMjEkkbHmU','Tijuana In Blue -- Enamorado de la muerte (cover)',1),(42,'Pzqr3rVZNso','EL RENO RENARDO - Camino Moria (videolyric by Azzurro)',1),(43,'p32b5nNq1zw','Iron Maiden - Fear of The Dark (HQ)',1),(44,'NFSyl3pwa-A','\"Maricarmen\" - La Pegatina (videoclip oficial)',1),(45,'0fgiBri5ZoA','Banda Bassotti - Juri Gagarin',1),(46,'wkjUEumfjFM','Banda Bassotti - Mockba \'993',1),(47,'j--2L3_FN08','SOZIEDAD ALKOHOLIKA - Piedra Contra Tijera (Video Oficial)',1);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-05 11:44:21
