-- MySQL Script generated by MySQL Workbench
-- Sun Dec 15 02:41:11 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema puntoVenta
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema puntoVenta
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `puntoVenta` DEFAULT CHARACTER SET utf8 ;
USE `puntoVenta` ;

-- -----------------------------------------------------
-- Table `puntoVenta`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta`.`User` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `lastName1` VARCHAR(45) NULL,
  `lastName2` VARCHAR(45) NULL,
  `userName` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `pass` VARCHAR(45) NULL,
  `born` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `userType` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta`.`Direction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta`.`Direction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exactAddress` VARCHAR(45) NULL,
  `canton` VARCHAR(45) NULL,
  `province` VARCHAR(45) NULL,
  `kilometersToRestaurant` VARCHAR(45) NULL,
  `idUser` INT NOT NULL,
  `district` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Direction_User_idx` (`idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Direction_User`
    FOREIGN KEY (`idUser`)
    REFERENCES `puntoVenta`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta`.`Product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  `descript` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `puntoVenta`.`ComboPlates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `puntoVenta`.`ComboPlates` (
  `idCombo` INT NOT NULL,
  `idPlate` INT NOT NULL,
  PRIMARY KEY (`idCombo`, `idPlate`),
  INDEX `fk_Product_has_Product_Product2_idx` (`idPlate` ASC) VISIBLE,
  INDEX `fk_Product_has_Product_Product1_idx` (`idCombo` ASC) VISIBLE,
  CONSTRAINT `fk_Product_has_Product_Product1`
    FOREIGN KEY (`idCombo`)
    REFERENCES `puntoVenta`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Product_Product2`
    FOREIGN KEY (`idPlate`)
    REFERENCES `puntoVenta`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;