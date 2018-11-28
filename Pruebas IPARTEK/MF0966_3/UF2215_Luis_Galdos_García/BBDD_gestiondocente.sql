DROP SCHEMA IF EXISTS `gestiondocente`;
CREATE DATABASE  IF NOT EXISTS `gestiondocente` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `gestiondocente`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestiondocente
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT COMMENT 'el campo clave de la tabla. Es auto generado.',
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `direccion` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) unsigned zerofill DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `dni` varchar(9) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `nHermanos` int(2) DEFAULT '0',
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (0,'alumno','sin asignar',NULL,NULL,NULL,00000,0,'aaaaaaa@aaaaa.com','0000000x',0,0),(1,'Don Pimpom','aparicio vargas','1977-12-01','','',00000,944110293,'aaaa@aaaa.com','44974398z',0,1),(2,'marilo','monasterio','1986-11-11','','',48007,944110293,'mmonasterio@ipartek.com','16071559x',0,1),(4,'enrique javier','ruiz jimenez','2017-02-14','','',00048,944110239,'enriqueFErnandexz@gmail.com','45677362y',0,1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `telefono` int(9) NOT NULL,
  `direccion` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) unsigned zerofill DEFAULT NULL,
  `identificador` varchar(15) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (0,'Sin Definir','aaaaaa@aaaaa.com',9444,NULL,NULL,NULL,'#######',0),(1,'SERIKAT CONSULTORÍA E INFORMÁTICA, S.A.','info@serikat.es',944250100,'c/ Ercilla 19','Bilbao',48009,'A-48476006',1),(2,'lanbide - servicio vasco de empleo','info@lanbide.net',945160601,'Jose Atxotegi 1','Vitoria-Gazteiz',01009,'Q0100571l',1),(3,'hobetuz','bizkaia@hobetuz.eus',944150808,'gran vía, 35-6º',NULL,NULL,'g48850127',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `curso` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `identificador` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fInicio` date DEFAULT NULL,
  `fFin` date DEFAULT NULL,
  `nHoras` int(4) NOT NULL,
  `temario` text CHARACTER SET utf8 COLLATE utf8_bin,
  `activo` tinyint(4) DEFAULT '1',
  `cliente_codigo` int(11) DEFAULT NULL,
  `precio` double(8,2) DEFAULT '0.00',
  `profesor_codigo` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_curso_cliente_codigo_idx` (`cliente_codigo`),
  KEY `fk_curso_profesor_codigo_idx` (`profesor_codigo`),
  CONSTRAINT `fk_curso_cliente_codigo` FOREIGN KEY (`cliente_codigo`) REFERENCES `cliente` (`codigo`),
  CONSTRAINT `fk_curso_profesor_codigo` FOREIGN KEY (`profesor_codigo`) REFERENCES `profesor` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Desarrrollo de Aplicaciones con Tecnologias Web','18482675','2017-01-09','2017-06-13',510,NULL,1,2,300000.00,1),(2,'Desarrollo de Bases de Datos y Programacion orientada a Objetos','18488225','2017-02-20','2017-09-29',630,'IFCD0112_FIC.pdf',1,2,400000.00,1),(3,'Publicidad en internet','18482678','2017-03-27','2017-03-30',10,NULL,1,3,1500.00,2),(4,'Programación en Bases de Datos relaciones con Oracle 12c','CI67','2017-05-02','2017-05-30',30,'CI67.pdf',1,3,3500.00,2);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imparticion`
--

DROP TABLE IF EXISTS `imparticion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `imparticion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `curso_codigo` int(11) NOT NULL,
  `alumno_codigo` int(11) NOT NULL,
  `fMatriculacion` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_imparticion_alumno_codigo_idx` (`alumno_codigo`),
  KEY `fk_imparticion_curso_codigo_idx` (`curso_codigo`),
  CONSTRAINT `fk_imparticion_alumno_codigo` FOREIGN KEY (`alumno_codigo`) REFERENCES `alumno` (`codigo`),
  CONSTRAINT `fk_imparticion_curso_codigo` FOREIGN KEY (`curso_codigo`) REFERENCES `curso` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imparticion`
--

LOCK TABLES `imparticion` WRITE;
/*!40000 ALTER TABLE `imparticion` DISABLE KEYS */;
INSERT INTO `imparticion` VALUES (9,3,2,NULL),(10,3,4,NULL),(15,2,1,NULL),(16,2,2,NULL),(17,2,4,NULL),(48,1,1,NULL),(49,1,2,NULL),(50,1,4,NULL);
/*!40000 ALTER TABLE `imparticion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesor` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `NSS` bigint(12) DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fNacimiento` date DEFAULT NULL,
  `DNI` varchar(9) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `direccion` varchar(250) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `poblacion` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `codigopostal` int(5) unsigned zerofill DEFAULT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `activo` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (0,0,'profesor','sin asignar',NULL,'00000000z',NULL,NULL,NULL,0,'aaaaaaaa@aaaaa.aaa',0),(1,481234567840,'Urko','Sapiems','1976-11-24','30693142x','Av. Mazustegi 9','Bilbao',48009,944110293,'sapimens@ipartek.com',1),(2,481234567840,'Ander','Uraga',NULL,'1111111H','barrio semana','bilbao',48003,666555444,'auraga@ipartek.com',1);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestiondocente'
--

--
-- Dumping routines for database 'gestiondocente'
--
/*!50003 DROP PROCEDURE IF EXISTS `cursoGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoGetAll`()
BEGIN

SELECT 
	c.codigo as 'codigo_curso' , 
	c.nombre as 'nombre_curso',
	c.identificador, 
	c.nHoras, 
	p.codigo as 'codigo_profesor', 
	p.nombre as 'nombre_profesor',
	p.apellidos
FROM curso as c INNER JOIN profesor as p
ON c.profesor_codigo = p.codigo;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cursoGetAlumnos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoGetAlumnos`(
	IN `p_id_curso` INT
)
BEGIN

SELECT 
	a.codigo, 
	a.nombre, 
	a.apellidos 

FROM alumno as a INNER JOIN imparticion as i 
ON a.codigo = i.alumno_codigo 
WHERE i.curso_codigo = p_id_curso;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cursoGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cursoGetById`(
	IN `p_id` INT


)
BEGIN

SELECT 
	c.codigo as 'codigo_curso' , 
	c.nombre as 'nombre_curso',
	c.identificador, 
	c.nHoras, 
	p.codigo as 'codigo_profesor', 
	p.nombre as 'nombre_profesor',
	p.apellidos
FROM curso as c INNER JOIN profesor as p
ON c.profesor_codigo = p.codigo
WHERE c.codigo = p_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-22 10:55:34
