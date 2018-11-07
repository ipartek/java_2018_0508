-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.12 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5293
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para libros
CREATE DATABASE IF NOT EXISTS `libros` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `libros`;

-- Volcando estructura para tabla libros.alumno
CREATE TABLE IF NOT EXISTS `alumno` (
  `idalumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(120) NOT NULL,
  PRIMARY KEY (`idalumno`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla libros.alumno: ~4 rows (aproximadamente)
DELETE FROM `alumno`;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` (`idalumno`, `nombre`) VALUES
	(2, 'Adrian'),
	(4, 'Alex'),
	(1, 'Luis'),
	(3, 'Raul');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

-- Volcando estructura para procedimiento libros.alumnoDelete
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoDelete`(
	IN `p_id` INT
)
BEGIN
DELETE FROM alumno WHERE idalumno = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.alumnoGetAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoGetAll`()
BEGIN
SELECT idalumno, nombre FROM alumno;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.alumnoGetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoGetById`(
	IN `p_id` INT
)
BEGIN
SELECT idalumno, nombre FROM alumno WHERE idalumno = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.alumnoInsert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoInsert`(
	IN `p_nombre` VARCHAR(120)

,
	OUT `o_id` INT
)
BEGIN
INSERT INTO alumno (nombre) VALUES (p_nombre);
SET o_id = LAST_INSERT_ID();
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.alumnoUpdate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoUpdate`(
	IN `p_id` INT,
	IN `p_nombre` VARCHAR(120)
)
BEGIN
UPDATE alumno 
SET nombre = p_nombre
WHERE idalumno = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.devolverPrestamo
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `devolverPrestamo`(
	IN `p_id_libro` INT,
	IN `p_id_alumno` INT,
	IN `p_fecha` INT
)
BEGIN

UPDATE prestamo SET devuelto = 1 
WHERE id_libro = p_id_libro AND id_alumno = p_id_alumno AND fecha_inicio = p_fecha;

END//
DELIMITER ;

-- Volcando estructura para tabla libros.editorial
CREATE TABLE IF NOT EXISTS `editorial` (
  `ideditorial` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`ideditorial`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla libros.editorial: ~3 rows (aproximadamente)
DELETE FROM `editorial`;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
INSERT INTO `editorial` (`ideditorial`, `nombre`) VALUES
	(2, 'Amaya'),
	(3, 'modificado'),
	(1, 'prueba1');
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;

-- Volcando estructura para procedimiento libros.editorialDelete
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialDelete`(
	IN `p_id` INT


)
BEGIN
DELETE FROM editorial WHERE ideditorial = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.editorialGetAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialGetAll`()
BEGIN
SELECT ideditorial, nombre FROM editorial;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.editorialGetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialGetById`(
	IN `p_id` INT
)
BEGIN
SELECT nombre FROM editorial WHERE ideditorial = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.editorialInsert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialInsert`(
	IN `p_nombre` VARCHAR(50)

,
	OUT `o_id` INT

)
BEGIN
INSERT INTO editorial (nombre) VALUES (p_nombre);
SET o_id = LAST_INSERT_ID();
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.editorialUpdate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialUpdate`(
	IN `p_nombre` VARCHAR(50)
,
	IN `p_id` INT
)
BEGIN
UPDATE editorial
SET nombre = p_nombre
WHERE ideditorial = p_id;
END//
DELIMITER ;

-- Volcando estructura para tabla libros.libro
CREATE TABLE IF NOT EXISTS `libro` (
  `idlibro` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(120) DEFAULT NULL,
  `isbn` varchar(19) NOT NULL,
  `id_editorial` int(11) NOT NULL,
  PRIMARY KEY (`idlibro`),
  UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  KEY `fk_libro_editorial_idx` (`id_editorial`),
  CONSTRAINT `fk_libro_editorial` FOREIGN KEY (`id_editorial`) REFERENCES `editorial` (`ideditorial`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla libros.libro: ~0 rows (aproximadamente)
DELETE FROM `libro`;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` (`idlibro`, `titulo`, `isbn`, `id_editorial`) VALUES
	(1, 'test', 'qwertyu', 1);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;

-- Volcando estructura para procedimiento libros.libroDelete
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroDelete`(
	IN `p_id` INT
)
BEGIN
DELETE FROM libro WHERE idlibro = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.libroGetAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroGetAll`()
BEGIN
SELECT idlibro, titulo, isbn, id_editorial FROM libro;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.libroGetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroGetById`(
	IN `p_id` INT
)
BEGIN
SELECT idlibro, titulo, isbn, num_ejemplares, id_editorial FROM libro WHERE idlibro = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.libroInsert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroInsert`(
	IN `p_titulo` VARCHAR(120),
	IN `p_isbn` VARCHAR(19),
	IN `p_num` INT,
	IN `p_id_editorial` INT

,
	OUT `o_id` INT
)
BEGIN
INSERT INTO libro (titulo, isbn, num_ejemplares, id_editorial) VALUES (p_titulo, p_isbn, p_num, p_id_editorial);
SET o_id = LAST_INSERT_ID();
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.libroUpdate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroUpdate`(
	IN `p_id` INT,
	IN `p_titulo` VARCHAR(120),
	IN `p_isbn` VARCHAR(19),
	IN `p_editorial` INT
)
BEGIN
UPDATE libro 
SET titulo = p_titulo, isbn = p_isbn, id_editorial = p_editorial
WHERE idlibro = p_id;
END//
DELIMITER ;

-- Volcando estructura para tabla libros.prestamo
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id_libro` int(11) NOT NULL,
  `id_alumno` int(11) NOT NULL,
  `fecha_inicio` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_fin` datetime DEFAULT NULL,
  `devuelto` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id_libro`,`id_alumno`,`fecha_inicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla libros.prestamo: ~0 rows (aproximadamente)
DELETE FROM `prestamo`;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` (`id_libro`, `id_alumno`, `fecha_inicio`, `fecha_fin`, `devuelto`) VALUES
	(1, 1, '2018-10-25 12:28:14', NULL, 0);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;

-- Volcando estructura para procedimiento libros.prestamoGetAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetAll`()
BEGIN
SELECT p.id_alumno, p.id_libro, p.fecha_inicio, p.fecha_fin, p.devuelto
FROM prestamo as p;
END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.prestamoGetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetById`(
	IN `p_alumno` INT,
	IN `p_libro` INT,
	IN `p_fecha` DATE
)
BEGIN

SELECT a.nombre, l.titulo, p.fecha_inicio, p.fecha_fin 
FROM alumno as a INNER JOIN prestamo as p ON p.id_alumno = a.idalumno
INNER JOIN libro as l ON p.id_libro = l.idlibro 
WHERE p.id_alumno = p_alumno AND p.id_libro = p_libro AND p.fecha_inicio = p_fecha;

END//
DELIMITER ;

-- Volcando estructura para procedimiento libros.prestamoInsert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoInsert`(
	IN `p_alumno` INT,
	IN `p_libro` INT,
	IN `p_fecha` INT,
	IN `o_fecha_fin` INT


)
BEGIN

SET @fecha_fin = DATEADD(DAY, @fecha, 15);
INSERT INTO prestamo (id_libro, id_alumno, fecha_fin) VALUES (p_libro, p_alumno, @fecha_fin);

END//
DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
