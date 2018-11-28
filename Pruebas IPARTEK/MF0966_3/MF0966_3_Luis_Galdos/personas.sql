-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: personas
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
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido1` varchar(45) DEFAULT NULL,
  `apellido2` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'12277015Y','Ted','Upton','Sant Andreu De La Barca','tedfupton@mailinator.com','TRABAJADOR'),(2,'39503517M','Susan','Ball','Carre?o','SusanJBall@trashymail.com','TRABAJADOR'),(3,'10161153Y','Scott','Broadway','Quintanar Del Rey','ScottJBroadway@mailinator.com','TRABAJADOR'),(4,'25918258H','Alexis','Matney','Forfoleda','AlexisJMatney@mailinator.com','TRABAJADOR'),(5,'83409853P','Tammy','Channel','Santany?','TammyMChannel@trashymail.com','JEFE'),(6,'52899659G','Michelle','Williams','Lobeira','MichelleEWilliams@mailinator.com','TRABAJADOR'),(7,'7476627V','Sofia','Gutierrez','Pontedeume','SofiaJGutierrez@spambob.com','TRABAJADOR'),(8,'730804W','Mark','Ellis','Gibrale?n','MarkGEllis@dodgit.com','JEFE'),(9,'32562603P','Jennifer','Harrell','Guardamar Del Segura','JenniferRHarrell@mailinator.com','TRABAJADOR'),(10,'60949098H','Charles','Lam','Aledo','CharlesCLam@mailinator.com','TRABAJADOR'),(11,'78681631B','Helen','Gale','Beri?in','HelenBGale@mailinator.com','TRABAJADOR'),(12,'37382958T','Douglas','Hicks','Ibai Peroxa','DouglasMHicks@mailinator.com','TRABAJADOR'),(13,'63056684E','Terry','Suttle','Valverde Del Camino','TerryMSuttle@mailinator.com','TRABAJADOR'),(14,'3186045Q','Goldie','Nelson','Pedro Abad','GoldieRNelson@mailinator.com','TRABAJADOR'),(15,'71255654K','Mildred','Rivera','Ares','MildredRRivera@dodgit.com','TRABAJADOR'),(16,'7475599R','Mildred','Bernhard','Cella','MildredGBernhard@trashymail.com','TRABAJADOR'),(17,'36276449K','Dennis','Shake','Carratraca','DennisCShake@pookmail.com','TRABAJADOR'),(18,'93093261W','William','Spicer','Castell? De La Ribera','WilliamGSpicer@spambob.com','CLIENTE'),(19,'93247459P','Jennifer','Fujii','Ajamil','JenniferJFujii@spambob.com','TRABAJADOR'),(20,'35260345B','Heather','Jones','San Mart?n De La Vega','HeatherKJones@trashymail.com','TRABAJADOR'),(21,'63655957F','Derick','Morris','Montmel?','DerickKMorris@mailinator.com','TRABAJADOR'),(22,'19134576W','Abe','Hudson','Armilla','AbeVHudson@pookmail.com','TRABAJADOR'),(23,'86974465B','Dorothy','Choe','Ba?ares','DorothyRChoe@spambob.com','TRABAJADOR'),(24,'54760700T','Jerry','Stanton','Sant Vicenc Dels Horts','JerryBStanton@spambob.com','JEFE'),(25,'63685159E','Pat','Baker','Herguijuela Del Campo','PatZBaker@dodgit.com','JEFE'),(26,'63748058Q','Rhonda','Serra','Horcajo De Los Montes','RhondaDSerra@trashymail.com','JEFE'),(27,'96063787D','Amanda','Peterson','Fuente Del Maestre','AmandaEPeterson@dodgit.com','TRABAJADOR'),(28,'40297894P','Leonard','Hayes','Orce','LeonardSHayes@spambob.com','TRABAJADOR'),(29,'40700667M','Carla','Johnson','Triacastela','CarlaMJohnson@mailinator.com','TRABAJADOR'),(30,'57982420H','Christopher','Morgan','Loiu','ChristopherJMorgan@dodgit.com','TRABAJADOR'),(31,'80521185W','Dennis','Mcallister','Galar','DennisSMcallister@spambob.com','TRABAJADOR'),(32,'64520492H','Brian','Sieber','Tur?gano','BrianHSieber@pookmail.com','TRABAJADOR'),(33,'9175667R','Susan','Stine','Alc?cer','SusanBStine@dodgit.com','TRABAJADOR'),(34,'58525003P','Robert','Hicks','Fontiveros','RobertJHicks@trashymail.com','TRABAJADOR'),(35,'11551259S','Evangeline','Sauer','Pedrosillo El Ralo','EvangelineMSauer@pookmail.com','TRABAJADOR'),(36,'66866825Y','Dianne','Fernandez','Zaragoza','DianneLFernandez@mailinator.com','TRABAJADOR'),(37,'15375109T','Louise','Gross','Finestrat','LouiseWGross@mailinator.com','TRABAJADOR'),(38,'74978232A','Carolyn','Williams','Alcaudete','CarolynMWilliams@pookmail.com','JEFE'),(39,'20637003T','Anna','Wilmer','Ripoll','AnnaBWilmer@dodgit.com','JEFE'),(40,'99250638A','Arthur','Cooper','Camarma De Esteruelas','ArthurMCooper@dodgit.com','TRABAJADOR'),(41,'74446908W','Henry','Stalvey','Navacerrada','HenryJStalvey@mailinator.com','TRABAJADOR'),(42,'12486924V','James','Adamski','Aldeatejada','JamesJAdamski@mailinator.com','TRABAJADOR'),(43,'52796537Z','Linda','Arthur','Garganta De Los Montes','LindaLArthur@pookmail.com','TRABAJADOR'),(44,'78222072S','Thomas','Cox','Allande','ThomasNCox@mailinator.com','TRABAJADOR'),(45,'56920792R','Ana','Brown','Mequinenza','AnaGBrown@pookmail.com','TRABAJADOR'),(46,'85030892F','Kenneth','Alexander','Lanjar?n','KennethEAlexander@dodgit.com','JEFE'),(47,'61466128P','John','Nolen','Espiel','JohnKNolen@dodgit.com','TRABAJADOR'),(48,'90994893Q','Elaine','Mae','Calatayud','ElaineCMae@pookmail.com','TRABAJADOR'),(49,'49358222S','Susan','Short','El Cubo De Don Sancho','SusanKShort@trashymail.com','JEFE'),(50,'98852473Z','Reuben','Olivarez','Nerja','ReubenGOlivarez@pookmail.com','TRABAJADOR');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'personas'
--

--
-- Dumping routines for database 'personas'
--
/*!50003 DROP PROCEDURE IF EXISTS `personaDelete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaDelete`(
IN p_id INT)
BEGIN

DELETE FROM persona WHERE idpersona = p_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `personaGetAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaGetAll`()
BEGIN

SELECT * FROM persona ORDER BY idpersona DESC LIMIT 50;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `personaGetById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaGetById`(
IN p_id INT
)
BEGIN

SELECT * FROM persona WHERE idpersona = p_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `personaInsert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaInsert`(
IN p_nombre VARCHAR(45),
IN p_apellido1 VARCHAR(45),
IN p_apellido2 VARCHAR(45),
IN p_mail VARCHAR(45),
IN p_dni VARCHAR(9),
IN p_rol VARCHAR(45)

,
OUT o_id INT)
BEGIN

INSERT INTO persona (nombre, apellido1, apellido2, dni, email, rol) 
VALUES (p_nombre, p_apellido1, p_apellido2, p_dni, p_mail, p_rol);

SET o_id = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `personaUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `personaUpdate`(
IN p_id INT,
IN p_nombre VARCHAR(45),
IN p_apellido1 VARCHAR(45),
IN p_apellido2 VARCHAR(45),
IN p_email VARCHAR(45),
IN p_dni VARCHAR(9),
IN p_rol VARCHAR(45)

)
BEGIN

UPDATE persona SET nombre = p_nombre, apellido1 = p_apellido1, apellido2 = p_apellido2, email = p_email,
dni = p_dni, rol = p_rol 
WHERE idpersona = p_id;
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

-- Dump completed on 2018-11-26 14:25:59
