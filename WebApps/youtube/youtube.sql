DROP DATABASE IF EXISTS `youtube`;
CREATE DATABASE  IF NOT EXISTS `youtube` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `youtube`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: youtube
-- ------------------------------------------------------
-- Server version	5.7.8-rc-log

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

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) NOT NULL,
  PRIMARY KEY (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Rock and Roll'),(2,'Flamenco'),(3,'Pop'),(4,'Heavy Metal'),(5,'Rap'),(6,'Hip Hop'),(7,'Blues'),(8,'Jazz'),(9,'BSO'),(10,'Country'),(11,'Folk');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idcomentario` int(11) NOT NULL AUTO_INCREMENT,
  `texto` text NOT NULL,
  `aprobado` tinyint(4) DEFAULT '0',
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_video` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idcomentario`),
  KEY `comentario_has_video_idx` (`id_video`),
  KEY `comentario_has_usuario_idx` (`id_usuario`),
  CONSTRAINT `comentario_has_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comentario_has_video` FOREIGN KEY (`id_video`) REFERENCES `video` (`idvideo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (1,'Madre mía como está la muchacha! Le metía de todo menos miedo jajajaja :3',0,'2018-10-11 22:24:24',1,1),(2,'Joder joder joder! No se me ocurre nada más que decir ante semejante belleza xD',0,'2018-10-11 22:25:10',1,2);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idrol`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido_1` varchar(45) NOT NULL,
  `apellido_2` varchar(45) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `password` varchar(50) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `fecha_alta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0: Baja, 1: Activo, 2: Baneado',
  `id_rol` int(11) DEFAULT NULL,
  `descripcion` tinytext NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `usuario_has_rol_idx` (`id_rol`),
  CONSTRAINT `usuario_has_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Luis','Galdos','García','admin','correo@gmail.com','c/Gran Vía, 8','admin','https://d6ce0no7ktiq.cloudfront.net/images/stickers/1511.png','2018-10-16 21:20:25',1,1,'“Nos dicen que recordemos los ideales, no al hombre, porque un hombre se puede acabar. Pueden detenerle, pueden matarle, pueden olvidarle, pero 400 años más tarde los ideales pueden seguir cambiando el mundo.” '),(2,'Pepe','Habichuela','Losantos','pepe','pepe@gmail.com','c/Mazarredo, 48','12345678','https://icon2.kisspng.com/20180626/yqb/kisspng-yogi-bear-boo-boo-ranger-smith-cindy-bear-cartoon-yogi-bear-5b32c3a4cf8079.3564737115300535408499.jpg','2018-10-16 21:20:25',1,2,'\"Yo soy más listo que un oso común.\"'),(3,'Lola','Mento','Mucho','manoli','lolitalola@gmail.com','c/Piruleta, 10','12345678','https://www.clipartmax.com/png/middle/114-1143891_gifs-y-fondos-paz-enla-tormenta-im-genes-de-minnie-minnie-mouse.png','2018-10-16 21:20:25',1,2,'“Piensa, Sueña, Cree y Atrévete.”'),(4,'Armando','Bronca','Segura','broncas','armandobronca@gmail.com','c/No me encuentro, 12','12345678','https://www.clipartmax.com/png/middle/0-6256_new-mickey-mouse-mickey-mouse-transparent-background.png','2018-10-16 21:24:24',1,1,'“Hacer lo imposible es una forma de diversión.”');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `idvideo` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT '1',
  PRIMARY KEY (`idvideo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `video_has_categoria_idx` (`id_categoria`),
  CONSTRAINT `video_has_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'QIedr_9_9hA','SEMBLANT - What Lies Ahead (Official Video)',1,4),(2,'qllRVZnpttM','Crystallion - Crystal Clear',1,4),(3,'WC5FdFlUcl0','Audioslave - Be Yourself',1,1),(4,'7QU1nvuxaMA','Audioslave - Like a Stone (Official Video)',1,1),(5,'nkll0StZJLA','Starset - My Demons (Official Music Video)',1,1),(6,'BtV1-gJ_bm0','Zombie - The Cranberries',1,1),(7,'TR3Vdo5etCQ','No Doubt - Don\'t Speak',1,1),(8,'bx1Bh8ZvH84','Oasis - Wonderwall',1,1),(9,'d8ekz_CSBVg','Three Days Grace - I Hate Everything About You',1,1),(10,'Qg45AqakB5k','Sexy Rock\'n\'Roll',1,1),(11,'_9PLPqh__SM','El Suso - Mi secreto (Videoclip Oficial)',1,2);
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

-- Dump completed on 2018-10-18 22:37:14
