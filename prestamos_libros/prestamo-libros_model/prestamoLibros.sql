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


-- Volcando estructura de base de datos para prestamo_libros
CREATE DATABASE IF NOT EXISTS `prestamo_libros` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `prestamo_libros`;

-- Volcando estructura para tabla prestamo_libros.alumno
CREATE TABLE IF NOT EXISTS `alumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  UNIQUE KEY `apellidos_UNIQUE` (`apellidos`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla prestamo_libros.alumno: ~9 rows (aproximadamente)
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
REPLACE INTO `alumno` (`id`, `nombre`, `apellidos`) VALUES
	(1, 'Asier', 'Cornejo'),
	(2, 'Adrian', 'Garcia Santos'),
	(3, 'Ainara', 'Goitia Arenaza'),
	(4, 'Alain', 'Muñoz Arrizabalaga'),
	(5, 'Raul', 'Abejon Delgado'),
	(6, 'Andrea Mª', 'Perez Millan'),
	(7, 'Adriana', 'Prado Alonso'),
	(8, 'Valeria', 'Valencia Bautista'),
	(9, 'Luis', 'Galdos García');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;

-- Volcando estructura para tabla prestamo_libros.libro
CREATE TABLE IF NOT EXISTS `libro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `id_tipo_editorial` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_libro_tipo_editorial_idx` (`id_tipo_editorial`),
  CONSTRAINT `fk_libro_tipo_editorial` FOREIGN KEY (`id_tipo_editorial`) REFERENCES `tipo_editorial` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla prestamo_libros.libro: ~12 rows (aproximadamente)
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
REPLACE INTO `libro` (`id`, `titulo`, `isbn`, `id_tipo_editorial`) VALUES
	(1, 'HTML5,CSS3 y JavaScript', '879-84-345-2348-5', 1),
	(2, 'HTML5,CSS3 y JavaScript', '978-84-415-2348-5', 1),
	(3, 'Java SE 6', '978-84-415-2348-7', 1),
	(4, 'Java 8', '978-2-7460-9347-8', 2),
	(5, 'HTML5,CSS3 y JavaScript', '978-2-7460-9669-1', 2),
	(6, 'MySQL 5.1', '978-84-415-2523-8', 1),
	(7, 'MySQL 5.1', '978-84-415-2523-8', 1),
	(8, 'MySQL 5.1', '978-84-415-2523-8', 1),
	(9, 'Java 7', '978-84-415-2988-5', 1),
	(10, 'HTML5 y CSS3', '978-2-409-00702-6', 2),
	(11, 'HTML5 y CSS3', '978-2-409-00702-6', 2);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;

-- Volcando estructura para tabla prestamo_libros.prestado
CREATE TABLE IF NOT EXISTS `prestado` (
  `id_libro` int(11) NOT NULL,
  `id_alumno` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_final` date DEFAULT NULL COMMENT 'mas 15 días desde la fecha de inicio(usamos un trigger).',
  `fecha_devuelto` date DEFAULT NULL COMMENT 'Si NULL no se ha devuelto el libro',
  PRIMARY KEY (`id_libro`,`id_alumno`,`fecha_inicio`),
  KEY `fk_libro_has_alumno_alumno1_idx` (`id_alumno`),
  KEY `fk_libro_has_alumno_libro1_idx` (`id_libro`),
  CONSTRAINT `fk_libro_has_alumno_alumno1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id`),
  CONSTRAINT `fk_libro_has_alumno_libro1` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla prestamo_libros.prestado: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `prestado` DISABLE KEYS */;
REPLACE INTO `prestado` (`id_libro`, `id_alumno`, `fecha_inicio`, `fecha_final`, `fecha_devuelto`) VALUES
	(7, 7, '2018-11-15', '2018-11-30', '2018-11-19'),
	(8, 8, '2018-11-15', '2018-11-30', NULL);
/*!40000 ALTER TABLE `prestado` ENABLE KEYS */;

-- Volcando estructura para tabla prestamo_libros.tipo_editorial
CREATE TABLE IF NOT EXISTS `tipo_editorial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `editorial` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `editorial_UNIQUE` (`editorial`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla prestamo_libros.tipo_editorial: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_editorial` DISABLE KEYS */;
REPLACE INTO `tipo_editorial` (`id`, `editorial`) VALUES
	(3, 'Alfaguara'),
	(1, 'Anaya'),
	(2, 'Eni'),
	(4, 'S&M');
/*!40000 ALTER TABLE `tipo_editorial` ENABLE KEYS */;

-- Volcando estructura para procedimiento prestamo_libros.alumnoDelete
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoDelete`(

	IN `p_id` INT

)
BEGIN

DELETE FROM alumno WHERE id=p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.alumnoGetAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoGetAll`()
BEGIN

SELECT id, nombre, apellidos FROM alumno ORDER BY id; 

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.alumnoGetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoGetById`(

	IN `id` INT

)
BEGIN

SELECT id, nombre, apellidos FROM alumno WHERE alumno.id=id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.alumnoInsert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoInsert`(

	IN `p_nombre` VARCHAR(50),
    IN `p_apellidos` VARCHAR(150),

	OUT `o_id` INT

)
BEGIN

INSERT INTO alumno (nombre, apellidos)  VALUES(p_nombre, p_apellidos);

SET o_id = LAST_INSERT_ID();

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.alumnoUpdate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `alumnoUpdate`(

	IN `p_id` INT,

	IN `p_nombre` VARCHAR(50),
    
    IN `p_apellidos` VARCHAR(150)

)
BEGIN



UPDATE alumno SET id= p_id , nombre= p_nombre, apellidos = p_apellidos WHERE id = p_id;



END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.editorialDelete
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialDelete`(

	IN `p_id` INT

)
BEGIN

DELETE FROM tipo_editorial WHERE id=p_id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.editorialGetAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialGetAll`()
BEGIN

SELECT id, editorial FROM tipo_editorial ORDER BY id; 

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.editorialGetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialGetById`(

	IN `id` INT

)
BEGIN

SELECT id,editorial FROM tipo_editorial WHERE tipo_editorial.id=id;

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.editorialInsert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialInsert`(

	IN `p_editorial` VARCHAR(50),

	OUT `o_id` INT

)
BEGIN

INSERT INTO tipo_editorial (editorial)  VALUES(p_editorial);

SET o_id = LAST_INSERT_ID();

END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.editorialUpdate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `editorialUpdate`(

	IN `p_id` INT,

	IN `p_editorial` VARCHAR(50)

)
BEGIN



UPDATE tipo_editorial SET id= p_id , editorial= p_editorial WHERE id = p_id;



END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.libroDelete
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroDelete`(
	IN `p_id` INT
)
BEGIN
DELETE FROM libro WHERE id=p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.libroGetAll
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroGetAll`()
BEGIN
SELECT l.id, l.titulo, l.isbn, l.id_tipo_editorial, te.editorial 
FROM libro as l 
INNER JOIN tipo_editorial as te ON l.id_tipo_editorial = te.id
LEFT JOIN prestado as p ON l.id = p.id_libro;


END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.libroGetById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroGetById`(
	IN `p_id` INT

)
BEGIN
SELECT l.id, l.titulo, l.isbn, l.id_tipo_editorial, te.editorial
FROM libro as l, tipo_editorial as te
WHERE l.id_tipo_editorial = te.id AND l.id = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.libroInsert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroInsert`(
	IN `p_titulo` VARCHAR(150),
    IN `p_isbn` VARCHAR(50),
    IN `p_id_tipo_editorial` INT,
    OUT `o_id` INT
)
BEGIN
INSERT INTO libro (titulo, isbn, id_tipo_editorial) VALUES (p_titulo, p_isbn, p_id_tipo_editorial);
SET o_id = last_insert_id();
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.libroUpdate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `libroUpdate`(
	IN `p_id` INT,
    IN `p_titulo` VARCHAR(150),
    IN `p_isbn` VARCHAR(50),
    IN `p_id_tipo_editorial` INT
)
BEGIN
UPDATE libro SET titulo = p_titulo, isbn = p_isbn, id_tipo_editorial = p_id_tipo_editorial WHERE id = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoDevolver
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoDevolver`(
	IN `p_id_alumno` INT,
	IN `p_id_libro` INT,
	IN `p_fecha_inicio` DATE,
	IN `p_fecha_devuelto` DATE

)
BEGIN
UPDATE prestado SET prestado.fecha_devuelto=p_fecha_devuelto  WHERE id_alumno=p_id_alumno AND id_libro=p_id_libro AND fecha_inicio=p_fecha_inicio;
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoGetAlumnosDisponibles
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetAlumnosDisponibles`()
BEGIN
SELECT  id, nombre, apellidos
FROM alumno as a 
WHERE id NOT IN (
SELECT id_alumno FROM prestado WHERE fecha_devuelto IS NULL);
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoGetHistorico
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetHistorico`()
BEGIN
SELECT p.id_libro,p.id_alumno,p.fecha_inicio,p.fecha_final,e.editorial,e.id as id_editorial,p.fecha_devuelto,l.titulo,a.nombre,a.apellidos
FROM prestado as p
INNER JOIN libro AS l ON l.id=p.id_libro
INNER JOIN alumno AS a ON a.id=p.id_alumno
INNER JOIN tipo_editorial AS e ON e.id=l.id_tipo_editorial
WHERE fecha_devuelto IS NOT NULL
ORDER BY p.fecha_devuelto DESC;
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoGetLibrosDisponibles
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetLibrosDisponibles`()
SELECT l.id,l.titulo,l.id_tipo_editorial, te.editorial FROM libro as l
INNER JOIN tipo_editorial te ON te.id=l.id_tipo_editorial
 WHERE l.id NOT IN(
SELECT id_libro FROM prestado WHERE fecha_devuelto IS NULL)//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoGetPrestados
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoGetPrestados`()
BEGIN
SELECT p.id_libro,p.id_alumno,p.fecha_inicio,p.fecha_final,l.titulo,l.isbn,e.editorial,e.id as id_editorial,a.nombre, a.apellidos,p.fecha_devuelto
FROM prestado as p
INNER JOIN libro AS l ON l.id=p.id_libro
INNER JOIN alumno AS a ON a.id=p.id_alumno
INNER JOIN tipo_editorial AS e ON e.id=l.id_tipo_editorial
WHERE fecha_devuelto IS NULL
order by p.fecha_devuelto desc;
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoModificarHistorico
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoModificarHistorico`(
	IN `p_id_libro` INT,
	IN `p_id_alumno` INT,
	IN `p_fecha_inicio` DATE,
	IN `p_fecha_final` DATE,
	IN `p_fecha_devolver` DATE,
	IN `p_old_id_libro` INT,
	IN `p_old_id_alumno` INT,
	IN `p_old_fecha_inicio` DATE
)
BEGIN
UPDATE prestado SET id_libro = p_id_libro, id_alumno = p_id_alumno, fecha_inicio = p_fecha_inicio, fecha_final = p_fecha_final,fecha_devuelto=p_fecha_devolver
WHERE id_libro = p_old_id_libro AND id_alumno = p_old_id_alumno AND fecha_inicio = p_old_fecha_inicio;
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoPrestar
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoPrestar`(
	IN `p_id_libro` INT,
	IN `p_id_alumno` INT,
	IN `p_fecha_inicio` DATE
,
	OUT `o_fecha_final` DATE
)
BEGIN
INSERT INTO prestado (id_libro, id_alumno, fecha_inicio) VALUES (p_id_libro, p_id_alumno, p_fecha_inicio);
SET o_fecha_final:=(Select fecha_final from prestado where p_id_libro=id_libro and id_alumno=p_id_alumno and fecha_inicio=p_fecha_inicio);
END//
DELIMITER ;

-- Volcando estructura para procedimiento prestamo_libros.prestamoUpdate
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `prestamoUpdate`(
	IN `p_idLibro` INT,
    IN `p_idAlumno` INT,
    IN `p_fechaInicio` DATE,
    IN `p_fechaFin` DATE,
	IN `p_oldIdLibro` INT,
    IN `p_oldIdAlumno` INT,
    IN `p_oldFechaInicio` DATE
)
BEGIN

UPDATE prestado SET id_libro = p_idLibro, id_alumno = p_idAlumno, fecha_inicio = p_fechaInicio, fecha_final = p_fechaFin
WHERE id_libro = p_oldIdLibro AND id_alumno = p_oldIdAlumno AND fecha_inicio = p_oldFechaInicio;

END//
DELIMITER ;

-- Volcando estructura para disparador prestamo_libros.TAIprestamo
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `TAIprestamo` BEFORE INSERT ON `prestado` FOR EACH ROW BEGIN 
 SET NEW.fecha_final= (ADDDATE(NEW.fecha_inicio, INTERVAL 15 DAY));
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
