-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: casas_rurales
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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actividad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `nivel` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alojamiento`
--

DROP TABLE IF EXISTS `alojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alojamiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `id_contacto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `direccion_UNIQUE` (`direccion`),
  KEY `alojamiento_has_persona_contacto_idx` (`id_contacto`),
  CONSTRAINT `alojamiento_has_persona_contacto` FOREIGN KEY (`id_contacto`) REFERENCES `personal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamiento`
--

LOCK TABLES `alojamiento` WRITE;
/*!40000 ALTER TABLE `alojamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `alojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experiencia`
--

DROP TABLE IF EXISTS `experiencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `experiencia` (
  `dia` varchar(45) NOT NULL,
  `horario` varchar(45) NOT NULL,
  `precio` varchar(45) NOT NULL,
  `id_alojamiento` int(11) NOT NULL,
  `id_actividad` int(11) NOT NULL,
  PRIMARY KEY (`dia`,`id_actividad`,`id_alojamiento`),
  KEY `experencia_has_alojamiento_idx` (`id_alojamiento`),
  KEY `experencia_has_actividad_idx` (`id_actividad`),
  CONSTRAINT `experencia_has_actividad` FOREIGN KEY (`id_actividad`) REFERENCES `actividad` (`id`),
  CONSTRAINT `experencia_has_alojamiento` FOREIGN KEY (`id_alojamiento`) REFERENCES `alojamiento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experiencia`
--

LOCK TABLES `experiencia` WRITE;
/*!40000 ALTER TABLE `experiencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `experiencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `habitacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `baño` tinyint(4) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `id_alojamiento` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `habitacion_has_alojamiento_idx` (`id_alojamiento`),
  KEY `habitacion_has_tipo_idx` (`id_tipo`),
  CONSTRAINT `habitacion_has_alojamiento` FOREIGN KEY (`id_alojamiento`) REFERENCES `alojamiento` (`id`),
  CONSTRAINT `habitacion_has_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `habitacion_tipo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion_tipo`
--

DROP TABLE IF EXISTS `habitacion_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `habitacion_tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion_tipo`
--

LOCK TABLES `habitacion_tipo` WRITE;
/*!40000 ALTER TABLE `habitacion_tipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitacion_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `personal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `nif` varchar(11) NOT NULL,
  `id_responsable` int(11) DEFAULT NULL,
  `id_alojamiento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `personal_has_alojamiento_idx` (`id_alojamiento`),
  KEY `es_responsable_idx` (`id_responsable`),
  CONSTRAINT `es_responsable` FOREIGN KEY (`id_responsable`) REFERENCES `personal` (`id`),
  CONSTRAINT `personal_has_alojamiento` FOREIGN KEY (`id_alojamiento`) REFERENCES `alojamiento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-17 14:09:57
