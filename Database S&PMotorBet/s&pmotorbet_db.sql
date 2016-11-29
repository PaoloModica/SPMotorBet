SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `bookmaker` DEFAULT CHARACTER SET latin1 ;
CREATE SCHEMA IF NOT EXISTS `s&pmotorbet` DEFAULT CHARACTER SET utf8 ;
USE `bookmaker` ;

-- -----------------------------------------------------
-- Table `bookmaker`.`campionati`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmaker`.`campionati` (
  `denominazione` CHAR(30) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookmaker`.`gare`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmaker`.`gare` (
  `denominazione` CHAR(50) NOT NULL,
  `citta` CHAR(30) NOT NULL,
  `nazione` CHAR(30) NOT NULL,
  `campionato` CHAR(30) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookmaker`.`piloti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmaker`.`piloti` (
  `nome` CHAR(30) NOT NULL,
  `cognome` CHAR(30) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bookmaker`.`quote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookmaker`.`quote` (
  `nomepilota` CHAR(30) NOT NULL,
  `cognomepilota` CHAR(30) NOT NULL,
  `gara` CHAR(50) NOT NULL,
  `campionato` CHAR(30) NOT NULL,
  `posizione` INT(11) NOT NULL,
  `quota` FLOAT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `s&pmotorbet` ;

-- -----------------------------------------------------
-- Table `s&pmotorbet`.`bet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s&pmotorbet`.`bet` (
  `id` CHAR(10) NOT NULL,
  `cf` CHAR(20) NOT NULL,
  `data` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `importo` FLOAT NOT NULL,
  `vincita_potenziale` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `s&pmotorbet`.`betline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s&pmotorbet`.`betline` (
  `id` CHAR(10) NOT NULL,
  `nomepilota` CHAR(50) NOT NULL,
  `cognomepilota` CHAR(50) NOT NULL,
  `campionato` CHAR(50) NOT NULL,
  `gara` CHAR(50) NOT NULL,
  `posizione` INT(50) NOT NULL,
  `quota` DOUBLE NOT NULL,
  `cf` CHAR(20) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `s&pmotorbet`.`clienti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s&pmotorbet`.`clienti` (
  `nome` CHAR(20) NOT NULL,
  `cognome` CHAR(20) NOT NULL,
  `cf` CHAR(16) NOT NULL,
  `data_di_nascita` CHAR(10) NOT NULL,
  `indirizzo` CHAR(20) NOT NULL,
  `telefono` CHAR(13) NOT NULL,
  `username` CHAR(20) NOT NULL,
  `password` CHAR(8) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `s&pmotorbet`.`conti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s&pmotorbet`.`conti` (
  `cf` CHAR(16) NOT NULL,
  `saldo` FLOAT NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `s&pmotorbet`.`movimenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s&pmotorbet`.`movimenti` (
  `cf` CHAR(16) NOT NULL,
  `importo` FLOAT NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
