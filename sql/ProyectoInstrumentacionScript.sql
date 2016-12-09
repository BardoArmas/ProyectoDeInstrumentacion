-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema proyecto_instrumentacion
-- -----------------------------------------------------
-- Base de datos para el proyecto de instrumentacion para el almacenado de informacion y control de usuarios
-- 

-- -----------------------------------------------------
-- Schema proyecto_instrumentacion
--
-- Base de datos para el proyecto de instrumentacion para el almacenado de informacion y control de usuarios
-- 
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `proyecto_instrumentacion` DEFAULT CHARACTER SET utf8 ;
USE `proyecto_instrumentacion` ;

-- -----------------------------------------------------
-- Table `proyecto_instrumentacion`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_instrumentacion`.`usuario` ;

CREATE TABLE IF NOT EXISTS `proyecto_instrumentacion`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `paterno` VARCHAR(45) NOT NULL,
  `materno` VARCHAR(45) NOT NULL,
  `nickUsuario` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proyecto_instrumentacion`.`reporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `proyecto_instrumentacion`.`reporte` ;

CREATE TABLE IF NOT EXISTS `proyecto_instrumentacion`.`reporte` (
  `idReporte` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `fecha` DATE NOT NULL,
  `xy1` LONGBLOB NOT NULL,
  `xy2` LONGBLOB NOT NULL,
  `xy3` LONGBLOB NOT NULL,
  `datos` LONGBLOB NOT NULL,
  PRIMARY KEY (`idReporte`, `idUsuario`),
  INDEX `fk_reporte_usuario_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_reporte_usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `proyecto_instrumentacion`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `proyecto_instrumentacion`.`usuario`
-- -----------------------------------------------------
START TRANSACTION;
USE `proyecto_instrumentacion`;
INSERT INTO `proyecto_instrumentacion`.`usuario` (`idUsuario`, `nombre`, `paterno`, `materno`, `nickUsuario`, `contrasenia`, `email`) VALUES (1, 'Valentin', 'Avecias', 'Angeles', 'nash', 'holamundo', 'aveciasnash@gmail.com');

COMMIT;

