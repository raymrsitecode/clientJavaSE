-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sgcpagos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sgcpagos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sgcpagos` DEFAULT CHARACTER SET utf8 ;
USE `sgcpagos` ;

-- -----------------------------------------------------
-- Table `sgcpagos`.`sgc_t001_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgcpagos`.`sgc_t001_users` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `date_register` DATE NULL DEFAULT NULL,
  `date_down` DATE NULL DEFAULT NULL,
  `user` VARCHAR(45) NULL DEFAULT NULL,
  `access_token` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgcpagos`.`sgc_t003_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgcpagos`.`sgc_t003_card` (
  `card_id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` ENUM('credit', 'debit') NULL DEFAULT NULL,
  `vigency` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`card_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgcpagos`.`sgc_t005_msi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgcpagos`.`sgc_t005_msi` (
  `msi_id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(150) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NULL DEFAULT NULL,
  PRIMARY KEY (`msi_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgcpagos`.`sgc_t002_transactions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgcpagos`.`sgc_t002_transactions` (
  `transaction_id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `amount` DOUBLE NULL DEFAULT NULL,
  `type_payment` ENUM('MSI', 'PAYMENT_CASH') NULL DEFAULT NULL,
  `date_amount_register` DATE NULL DEFAULT NULL,
  `date_register` DATE NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `card_id` INT(11) NOT NULL,
  `msi_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  INDEX `fk_sgc_t002_transactions_sgc_t001_users_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_sgc_t002_transactions_sgc_t003_card1_idx` (`card_id` ASC) VISIBLE,
  INDEX `fk_sgc_t002_transactions_sgc_t005_msi1_idx` (`msi_id` ASC) VISIBLE,
  CONSTRAINT `fk_sgc_t002_transactions_sgc_t001_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `sgcpagos`.`sgc_t001_users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sgc_t002_transactions_sgc_t003_card1`
    FOREIGN KEY (`card_id`)
    REFERENCES `sgcpagos`.`sgc_t003_card` (`card_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sgc_t002_transactions_sgc_t005_msi1`
    FOREIGN KEY (`msi_id`)
    REFERENCES `sgcpagos`.`sgc_t005_msi` (`msi_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgcpagos`.`sgc_t004_information_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgcpagos`.`sgc_t004_information_card` (
  `information_card_id` INT(11) NOT NULL AUTO_INCREMENT,
  `historical_amount` DOUBLE NULL DEFAULT NULL,
  `date_last_update` DATE NULL DEFAULT NULL,
  `date_register` DATE NULL DEFAULT NULL,
  `sgc_t003_card_card_id` INT(11) NOT NULL,
  PRIMARY KEY (`information_card_id`),
  INDEX `fk_sgc_t004_information_card_sgc_t003_card1_idx` (`sgc_t003_card_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_sgc_t004_information_card_sgc_t003_card1`
    FOREIGN KEY (`sgc_t003_card_card_id`)
    REFERENCES `sgcpagos`.`sgc_t003_card` (`card_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgcpagos`.`sgc_t006_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgcpagos`.`sgc_t006_comment` (
  `comment_id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(250) NOT NULL,
  `sgc_t002_transactions_transaction_id` INT(11) NOT NULL,
  `date_register` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `fk_sgc_t006_comment_sgc_t002_transactions1_idx` (`sgc_t002_transactions_transaction_id` ASC) VISIBLE,
  CONSTRAINT `fk_sgc_t006_comment_sgc_t002_transactions1`
    FOREIGN KEY (`sgc_t002_transactions_transaction_id`)
    REFERENCES `sgcpagos`.`sgc_t002_transactions` (`transaction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sgcpagos`.`sgc_t007_breakdown`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgcpagos`.`sgc_t007_breakdown` (
  `breakdown_id` INT(11) NOT NULL AUTO_INCREMENT,
  `amount` VARCHAR(45) NOT NULL,
  `isPayed` VARCHAR(45) NULL DEFAULT NULL,
  `date_register` TIMESTAMP NULL DEFAULT NULL,
  `date_payout` TIMESTAMP NULL DEFAULT NULL,
  `sgc_t002_transactions_transaction_id` INT(11) NOT NULL,
  PRIMARY KEY (`breakdown_id`),
  INDEX `fk_sgc_t007_breakdown_sgc_t002_transactions1_idx` (`sgc_t002_transactions_transaction_id` ASC) VISIBLE,
  CONSTRAINT `fk_sgc_t007_breakdown_sgc_t002_transactions1`
    FOREIGN KEY (`sgc_t002_transactions_transaction_id`)
    REFERENCES `sgcpagos`.`sgc_t002_transactions` (`transaction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
