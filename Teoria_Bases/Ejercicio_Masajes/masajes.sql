-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: masajes
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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(120) COLLATE utf8_bin DEFAULT NULL,
  `dni` varchar(9) COLLATE utf8_bin DEFAULT NULL,
  `servicios_has_trabajador_id_servicio` int(11) NOT NULL,
  `servicios_has_trabajador_id_trabajador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cliente_servicios_has_trabajador1_idx` (`servicios_has_trabajador_id_servicio`,`servicios_has_trabajador_id_trabajador`),
  CONSTRAINT `fk_cliente_servicios_has_trabajador1` FOREIGN KEY (`servicios_has_trabajador_id_servicio`, `servicios_has_trabajador_id_trabajador`) REFERENCES `servicios_has_trabajador` (`id_servicio`, `id_trabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `servicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) COLLATE utf8_bin NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios_has_trabajador`
--

DROP TABLE IF EXISTS `servicios_has_trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `servicios_has_trabajador` (
  `id_servicio` int(11) NOT NULL,
  `id_trabajador` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha` timestamp NOT NULL,
  `id_valoracion` int(11) NOT NULL,
  `reseña` text COLLATE utf8_bin,
  PRIMARY KEY (`id_servicio`,`id_trabajador`,`id_cliente`,`fecha`),
  KEY `fk_servicios_has_trabajador_trabajador1_idx` (`id_trabajador`),
  KEY `fk_servicios_has_trabajador_servicios_idx` (`id_servicio`),
  KEY `servicio_has_valoracion_idx` (`id_valoracion`),
  CONSTRAINT `fk_servicios_has_trabajador_servicios` FOREIGN KEY (`id_servicio`) REFERENCES `servicios` (`id`),
  CONSTRAINT `fk_servicios_has_trabajador_trabajador1` FOREIGN KEY (`id_trabajador`) REFERENCES `trabajador` (`id`),
  CONSTRAINT `servicio_has_valoracion` FOREIGN KEY (`id_valoracion`) REFERENCES `valoracion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios_has_trabajador`
--

LOCK TABLES `servicios_has_trabajador` WRITE;
/*!40000 ALTER TABLE `servicios_has_trabajador` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios_has_trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trabajador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8_bin NOT NULL,
  `apellidos` varchar(45) COLLATE utf8_bin NOT NULL,
  `dni` varchar(9) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoracion`
--

DROP TABLE IF EXISTS `valoracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `valoracion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valoracion` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoracion`
--

LOCK TABLES `valoracion` WRITE;
/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-18 11:44:58
