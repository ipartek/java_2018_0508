-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema empadronamiento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empadronamiento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empadronamiento` DEFAULT CHARACTER SET utf8 ;
USE `empadronamiento` ;

-- -----------------------------------------------------
-- Table `empadronamiento`.`municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`municipio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`vivienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`vivienda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(45) NULL,
  `calle` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NULL,
  `id_municipio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vivienda_municipio_idx` (`id_municipio` ASC),
  CONSTRAINT `fk_vivienda_municipio`
    FOREIGN KEY (`id_municipio`)
    REFERENCES `empadronamiento`.`municipio` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empadronamiento`.`propiedades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empadronamiento`.`propiedades` (
  `id_persona` INT NOT NULL,
  `id_vivienda` INT NOT NULL,
  `empadronado` TINYINT NULL DEFAULT 0 COMMENT '0 no empradomnado\n1 empadronado',
  PRIMARY KEY (`id_persona`, `id_vivienda`),
  INDEX `fk_persona_has_vivienda_vivienda1_idx` (`id_vivienda` ASC),
  INDEX `fk_persona_has_vivienda_persona1_idx` (`id_persona` ASC),
  CONSTRAINT `fk_persona_has_vivienda_persona1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `empadronamiento`.`persona` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_persona_has_vivienda_vivienda1`
    FOREIGN KEY (`id_vivienda`)
    REFERENCES `empadronamiento`.`vivienda` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
