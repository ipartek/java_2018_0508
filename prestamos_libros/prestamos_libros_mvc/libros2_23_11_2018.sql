CREATE DATABASE  IF NOT EXISTS `libros2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `libros2`;
-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: libros2
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `idalumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) NOT NULL,
  PRIMARY KEY (`idalumno`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (52,'456'),(49,'567575'),(10,'Adriana Prado Alonso'),(4,'Ainara Goitia Arenaza'),(2,'Alain Muñoz Arrizabalaga'),(41,'AlumnoAserege'),(35,'AlumnoDesdePrestamo'),(39,'AlumnoXXXX'),(9,'Andrea Maria Perez Millan'),(5,'Asier Cornejo Panduro'),(7,'Carlos Léon Montero'),(44,'coyotePeyote'),(15,'drohne'),(48,'Drohne enhord'),(21,'drohne1'),(12,'Eneko Sanchez Retolaza'),(45,'erFreaky'),(42,'ertertertert'),(14,'Guillermo Sánchez Zabala'),(11,'Joseba Ramirez Freire'),(1,'Lince'),(53,'ñjkll'),(8,'Raquel Pastor Villarroel'),(3,'Raul Abejon Delgado'),(51,'trueeeeer'),(55,'tu'),(54,'tus'),(13,'Valeria Valencia García'),(37,'yepale'),(50,'ytyu');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editorial` (
  `ideditorial` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`ideditorial`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` VALUES (76,'1poi'),(68,'asdasdasdasda'),(1,'canaya'),(54,'edicion'),(59,'edicion2'),(2,'Eni'),(74,'fghfghfghf'),(73,'fghfghfhfgh'),(75,'kjljkljklj'),(67,'NuevaEditDesdeLibro'),(69,'NuevaEditoEdito'),(70,'qwertyyyyyyyy'),(62,'swager'),(72,'zxcvb');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `idlibro` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(120) DEFAULT NULL,
  `isbn` varchar(19) NOT NULL,
  `id_editorial` int(11) NOT NULL,
  PRIMARY KEY (`idlibro`),
  KEY `fk_libro_editorial_idx` (`id_editorial`),
  CONSTRAINT `fk_libro_editorial` FOREIGN KEY (`id_editorial`) REFERENCES `editorial` (`ideditorial`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'asdasdsadasdsadsa','978-84-415-2348-7',2),(2,'Java SEaaaaaa','978-84-415-2348-7',1),(3,'MySql 5.1','978-84-415-2523-8',1),(5,'MySql 5.1','978-84-415-2523-8',1),(6,'HTML5, CSS3 y JavaScript','978-84-415-3527-3',1),(7,'HTML5, CSS3 y JavaScript','978-84-415-3527-3',2),(8,'HTML 5 y CSS 3 Domine los estándares de la creación de sitios web','978-2-409-00702-6',2),(9,'Aprenda los lenguajes HTML5, CSS3 y JavaScript para crear su primer sitio web','978-2-7460-9669-1',2),(10,'JAVA 8 Los fundamentos del lenguaje java (Con ejericios prácticos corregidos)','978-2-7460-9347-8',2),(11,'Libro desde  postmant','978-84-415-2348-7',1),(12,'Libro desde  postmant','978-84-415-2348-7',1),(13,'Libro desde  postmant','978-84-415-2348-7',1),(14,'Libro desde  postmantxdddddd','978-84-415-2348-7',1),(15,'Libro desde  postmantxdddddd','978-84-415-2348-7',1),(16,'Libro desde  postmantxdddddd','978-84-415-2348-7',1),(17,'Libro desde  postmantxdddddd','978-84-415-2348-7',1),(20,'pepe','978-84-415-2348-7',1),(22,'pruebaaaaaa','978-84-415-2348-7',1),(23,'prueba lunes','12345678901234',59),(24,'prueba lunes','12345678901234',59),(25,'Libro Prueba ','12345678901234',67),(26,'Libro Prueba ','12345678901234',67),(27,'Libroxxx','123456789012',70),(28,'python','asdasdasdasdasda',70),(29,'1212','1234567890123',70),(30,'fdgdfg','1234567890123',70),(31,'asdasdasdqwe','1234567890123',74),(32,'desdePrestamos','asdasdasdasdasda',74),(33,'gfhfghf','fhfhfhfghfghf',75),(36,'thfghfg','123456789012',75),(37,'231','123456789012',76),(38,'1','123456789012',76),(39,'3242','123456789012',76),(40,'aasd','123456789012',76),(41,'dfgdgdgd','123456789012',76);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `id_libro` int(11) NOT NULL,
  `id_alumno` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_retorno` date DEFAULT NULL,
  PRIMARY KEY (`id_libro`,`id_alumno`,`fecha_inicio`),
  KEY `prestamo_has_alumno_idx` (`id_alumno`),
  CONSTRAINT `prestamo_has_alumno` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`idalumno`),
  CONSTRAINT `prestamo_has_libro` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`idlibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (1,15,'2018-11-20','2018-12-05',NULL),(1,41,'2018-11-20','2018-12-05','2018-11-20'),(2,4,'2018-11-19','2018-12-04',NULL),(3,2,'2018-11-20','2018-12-05',NULL),(3,2,'2018-11-30','2018-12-12','2018-11-20'),(5,5,'2018-11-19','2018-12-04',NULL),(5,5,'2018-11-22','2018-12-07',NULL),(5,48,'2018-11-20','2018-12-05',NULL),(6,10,'2018-01-01','2018-01-16',NULL),(6,10,'2018-11-20','2018-12-05','2018-11-20'),(7,21,'2018-11-23','2018-12-08',NULL),(8,37,'2018-11-19','2018-12-04',NULL),(9,3,'2018-11-19','2018-12-04',NULL),(9,49,'2018-11-23','2018-12-08',NULL),(10,41,'2018-11-20','2018-12-05',NULL),(11,3,'2018-11-19','2018-11-19','2018-11-20'),(11,9,'2018-11-20','2018-12-05',NULL),(12,1,'2018-11-20','2018-12-05',NULL),(13,13,'2018-11-20','2018-12-05',NULL),(14,7,'2018-11-19','2018-12-04',NULL),(15,12,'2018-11-19','2018-12-04',NULL),(16,14,'2018-11-19','2018-12-04',NULL),(17,11,'2018-11-19','2018-12-04',NULL),(20,15,'2018-11-19','2018-12-04',NULL),(22,42,'2018-11-19','2018-11-20',NULL),(23,35,'2018-11-19','2018-12-04',NULL),(24,5,'2018-11-20','2018-12-05',NULL),(25,39,'2018-11-20','2018-12-05',NULL),(26,54,'2018-11-20','2018-12-05',NULL),(27,44,'2018-11-20','2018-12-05','2018-11-20'),(27,55,'2018-11-20','2018-12-05',NULL),(32,44,'2018-11-20','2018-12-05',NULL),(36,51,'2018-11-20','2018-12-05',NULL),(37,53,'2018-11-20','2018-12-05',NULL),(38,52,'2018-11-20','2018-12-05',NULL),(41,8,'2018-11-23','2018-12-08',NULL);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `prestamo_BEFORE_INSERT` BEFORE INSERT ON `prestamo` FOR EACH ROW BEGIN
SET NEW.fecha_fin = DATE_ADD(NEW.fecha_inicio, INTERVAL 15 DAY);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'libros2'
--

--
-- Dumping routines for database 'libros2'
--
/*!50003 DROP FUNCTION IF EXISTS `CALCULAR_DIAS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `CALCULAR_DIAS`(
 	`pInicio` DATE,
  `pFin` DATE
) RETURNS int(11)
    COMMENT 'Calcul los dias entre dos fechas'
BEGIN
	IF pFin IS NULL THEN 
		SET pFin = NOW();	
	END IF;
	RETURN DATEDIFF(pFin,pInicio);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alumnoDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoDelete`(
	IN `p_id` INT
)
BEGIN
DELETE FROM alumno WHERE idalumno = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alumnoGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoGetAll`()
BEGIN
SELECT idalumno, nombre FROM alumno;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alumnoGetAllDisponible` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoGetAllDisponible`()
BEGIN
SELECT  *
FROM alumno as a 
WHERE idalumno NOT IN 
(SELECT 
 p.id_alumno
	FROM prestamo as p 
    WHERE fecha_retorno IS NULL) ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alumnoGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoGetById`(
	IN `p_id` INT
)
BEGIN
SELECT idalumno, nombre FROM alumno WHERE idalumno = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alumnoInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoInsert`(
	IN `p_nombre` VARCHAR(120)

,
	OUT `o_id` INT
)
BEGIN
INSERT INTO alumno (nombre) VALUES (p_nombre);
SET o_id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alumnoUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoUpdate`(
	IN `p_id` INT,
	IN `p_nombre` VARCHAR(120)
)
BEGIN
UPDATE alumno 
SET nombre = p_nombre
WHERE idalumno = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `devolverPrestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `devolverPrestamo`(
	IN `p_id_libro` INT,
	IN `p_id_alumno` INT,
	IN `p_fecha` INT
)
BEGIN

UPDATE prestamo SET devuelto = 1 
WHERE id_libro = p_id_libro AND id_alumno = p_id_alumno AND fecha_inicio = p_fecha;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `editorialDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialDelete`(
	IN `p_id` INT


)
BEGIN
DELETE FROM editorial WHERE ideditorial = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `editorialGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialGetAll`()
BEGIN
SELECT ideditorial, nombre FROM editorial ORDER BY ideditorial DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `editorialGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialGetById`(
	IN `p_id` INT
)
BEGIN
SELECT ideditorial,nombre FROM editorial WHERE ideditorial = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `editorialInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialInsert`(
	IN `p_nombre` VARCHAR(50)

,
	OUT `o_id` INT

)
BEGIN
INSERT INTO editorial (nombre) VALUES (p_nombre);
SET o_id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `editorialUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialUpdate`(
	IN `p_nombre` VARCHAR(50)
,
	IN `p_id` INT
)
BEGIN
UPDATE editorial
SET nombre = p_nombre
WHERE ideditorial = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `libroDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroDelete`(
	IN `p_id` INT
)
BEGIN
DELETE FROM libro WHERE idlibro = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `libroGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroGetAll`()
BEGIN
SELECT idlibro, titulo, isbn, id_editorial, e.nombre FROM libro
INNER JOIN editorial as e ON id_editorial = e.ideditorial ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `libroGetAllDisponible` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroGetAllDisponible`()
BEGIN

SELECT distinct  *
FROM libro as l , editorial as e
WHERE idlibro NOT IN 
(SELECT 
 p.id_libro
	FROM prestamo as p 
    WHERE fecha_retorno IS NULL) and e.ideditorial = l.id_editorial ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `libroGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroGetById`(
	IN `p_id` INT

)
BEGIN
SELECT idlibro, titulo, isbn, id_editorial, e.nombre FROM libro
INNER JOIN editorial as e ON id_editorial = e.ideditorial
WHERE idlibro = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `libroInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroInsert`(
	IN `p_titulo` VARCHAR(120),
	IN `p_isbn` VARCHAR(19),
	IN `p_id_editorial` INT

,
	OUT `o_id` INT,
    OUT `o_nombreEditorial` VARCHAR(45)


)
BEGIN
INSERT INTO libro (titulo, isbn, id_editorial) VALUES (p_titulo, p_isbn, p_id_editorial);
SET o_id = LAST_INSERT_ID(), o_nombreEditorial := (Select nombre from editorial as e where e.ideditorial = p_id_editorial ) ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `libroUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroUpdate`(
	IN `p_id` INT,
	IN `p_titulo` VARCHAR(120),
	IN `p_isbn` VARCHAR(19),
	IN `p_editorial` INT,
    OUT `o_nombreEditorial` VARCHAR(45),
    OUT `o_id` INT
    
)
BEGIN
UPDATE libro 
SET titulo = p_titulo, isbn = p_isbn, id_editorial = p_editorial 
WHERE idlibro = p_id;
SET o_nombreEditorial := (Select nombre from editorial as e where e.ideditorial = p_editorial );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prestamoDevolver` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoDevolver`(
	IN `p_id_alumno` INT,
    IN `p_id_libro` INT,
    IN `p_fecha_inicio` DATE,
    IN `p_fecha_retorno` DATE
)
BEGIN

UPDATE prestamo SET fecha_retorno = p_fecha_retorno
 WHERE id_alumno = p_id_alumno AND id_libro = p_id_libro AND fecha_inicio = p_fecha_inicio;



END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prestamoGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetAll`()
BEGIN
SELECT a.nombre, p.id_alumno, l.titulo,l.isbn, p.id_libro, p.fecha_inicio, p.fecha_fin, p.fecha_retorno, e.ideditorial, e.nombre as nombre_editorial
FROM prestamo as p
INNER JOIN alumno as a ON a.idalumno = p.id_alumno
INNER JOIN libro as l ON l.idlibro = p.id_libro
INNER JOIN editorial as e ON e.ideditorial = l.id_editorial;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prestamoGetAllActivo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetAllActivo`()
BEGIN

SELECT a.nombre, p.id_alumno, l.titulo,l.isbn, p.id_libro, p.fecha_inicio, p.fecha_fin, p.fecha_retorno, e.ideditorial, e.nombre as nombre_editorial
FROM prestamo as p
INNER JOIN alumno as a ON a.idalumno = p.id_alumno
INNER JOIN libro as l ON l.idlibro = p.id_libro
INNER JOIN editorial as e ON e.ideditorial = l.id_editorial
WHERE p.fecha_retorno IS NULL;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prestamoGetAllHistorico` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetAllHistorico`()
BEGIN

SELECT p.id_alumno, p.id_libro, a.nombre, l.titulo, l.isbn, p.fecha_inicio, p.fecha_fin, p.fecha_retorno, e.ideditorial,e.nombre as nombre_editorial
FROM  prestamo AS p INNER JOIN libro AS l
ON p.id_libro = l.idlibro
INNER JOIN alumno AS a ON p.id_alumno = a.idalumno
INNER JOIN editorial as e ON e.ideditorial = l.id_editorial

WHERE  p.fecha_retorno IS NOT NULL;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prestamoGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetById`(
    IN `p_alumno` INT,
    IN `p_libro` INT,
    IN `p_fecha` DATE
)
BEGIN

SELECT p.id_alumno, p.id_libro, a.nombre, l.titulo, l.isbn, p.fecha_inicio, p.fecha_fin, p.fecha_retorno, e.ideditorial,e.nombre as nombre_editorial
FROM alumno as a
INNER JOIN prestamo as p ON p.id_alumno = a.idalumno
INNER JOIN libro as l ON p.id_libro = l.idlibro
INNER JOIN editorial as e ON e.ideditorial = l.id_editorial
WHERE p.id_alumno = p_alumno AND p.id_libro = p_libro AND p.fecha_inicio = p_fecha;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prestamoInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoInsert`(
	IN `p_alumno` INT,
	IN `p_libro` INT,
	IN `p_fecha` DATE
)
BEGIN

INSERT INTO prestamo (id_libro, id_alumno, fecha_inicio) VALUES (p_libro, p_alumno, p_fecha);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `prestamoUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoUpdate`(
IN p_alumno INT, 
IN p_libro INT,
IN p_inicio DATE,
IN p_nuevoAlumno INT,
IN p_nuevoLibro INT, 
IN p_nuevaFecha DATE,
IN p_fin DATE,
IN p_retorno DATE
)
BEGIN

UPDATE prestamo SET id_alumno = p_nuevoAlumno, id_libro = p_nuevoLibro, fecha_inicio = p_nuevaFecha, fecha_fin = p_fin, fecha_retorno = p_retorno
WHERE id_alumno = p_alumno AND id_libro = p_libro AND fecha_inicio = p_inicio;

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

-- Dump completed on 2018-11-23 22:38:19
