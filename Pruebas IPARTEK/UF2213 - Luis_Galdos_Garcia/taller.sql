-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema taller
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `taller` ;

-- -----------------------------------------------------
-- Schema taller
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `taller` DEFAULT CHARACTER SET utf8 ;
USE `taller` ;

-- -----------------------------------------------------
-- Table `taller`.`rol_trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`rol_trabajador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(120) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taller`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`trabajador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(90) NOT NULL,
  `tlfn` INT NULL,
  `id_rol` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_trabajador_rol_trabajador_idx` (`id_rol` ASC),
  CONSTRAINT `fk_trabajador_rol_trabajador`
    FOREIGN KEY (`id_rol`)
    REFERENCES `taller`.`rol_trabajador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taller`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `telefono` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taller`.`vehiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`vehiculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `num_bastidor` VARCHAR(17) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `matricula` VARCHAR(15) NOT NULL,
  `diesel` TINYINT NOT NULL,
  `fecha_reparacion` DATETIME NOT NULL,
  `precio` FLOAT NOT NULL,
  `observaciones` TINYTEXT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id`, `id_cliente`, `fecha_reparacion`),
  UNIQUE INDEX `num_bastidor_UNIQUE` (`num_bastidor` ASC),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC),
  INDEX `fk_vehiculo_cliente1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_vehiculo_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `taller`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `taller`.`reparacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `taller`.`reparacion` (
  `id_vehiculo` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  `fecha_reparacion` DATETIME NOT NULL,
  `id_trabajador` INT NOT NULL,
  `precio` FLOAT NULL,
  `observaciones` TINYTEXT NULL,
  PRIMARY KEY (`id_vehiculo`, `id_cliente`, `fecha_reparacion`, `id_trabajador`),
  INDEX `fk_vehiculo_has_trabajador_trabajador1_idx` (`id_trabajador` ASC),
  INDEX `fk_vehiculo_has_trabajador_vehiculo1_idx` (`id_vehiculo` ASC, `id_cliente` ASC, `fecha_reparacion` ASC),
  CONSTRAINT `fk_vehiculo_has_trabajador_vehiculo1`
    FOREIGN KEY (`id_vehiculo` , `id_cliente` , `fecha_reparacion`)
    REFERENCES `taller`.`vehiculo` (`id` , `id_cliente` , `fecha_reparacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_has_trabajador_trabajador1`
    FOREIGN KEY (`id_trabajador`)
    REFERENCES `taller`.`trabajador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
