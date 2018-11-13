-- MySQL Workbench Forward Engineering

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema finalproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema finalproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `finalproject` DEFAULT CHARACTER SET utf8 ;
USE `finalproject` ;

-- -----------------------------------------------------
-- Table `finalproject`.`attachments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalproject`.`attachments` (
  `AttachmentID` INT(11) NOT NULL AUTO_INCREMENT,
  `Faceshot` LONGTEXT NOT NULL,
  `IDShot` LONGTEXT NOT NULL,
  `Signature` LONGTEXT NOT NULL,
  `DriverLicense` LONGTEXT NOT NULL,
  `PreviousTachCard` LONGTEXT NULL DEFAULT NULL,
  `PreviousEUCard` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`AttachmentID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finalproject`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalproject`.`users` (
  `UserID` INT(11) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(254) NOT NULL,
  `Password` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`UserID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finalproject`.`requests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalproject`.`requests` (
  `RequestID` INT(11) NOT NULL AUTO_INCREMENT,
  `RequestType` ENUM('TYPE_NEW', 'TYPE_EXCHANGE', 'TYPE_REPLACE', 'TYPE_RENEW') NOT NULL,
  `RequestStatus` ENUM('REQUEST_NEW', 'REQUEST_APPROVED', 'REQUEST_DISAPPROVED', 'REQUEST_WAITING') NOT NULL,
  `RequestDate` VARCHAR(20) NOT NULL,
  `RequestReason` ENUM('REASON_LOST', 'REASON_STOLEN', 'REASON_MALFUNCTIONING', 'REASON_DAMAGED', 'REASON_ADDRESS_CHANGE', 'REASON_NAME_CHANGE', 'REASON_PHOTO_CHANGE','REASON_EXPIRED', 'REASON_DUE_TO_EXPIRE', 'REASON_SUSPENDED', 'REASON_WITHDRAWN') NULL DEFAULT NULL,
  `Requests_UserID` INT(11) NOT NULL,
  `Requests_AttachmentID` INT(11) NOT NULL,
  `PreviousCountryOfIssuing` VARCHAR(25) NULL DEFAULT NULL,
  `PreviousIssuingAuthority` VARCHAR(20) NULL DEFAULT NULL,
  `PreviousTachCardNum` VARCHAR(25) NULL DEFAULT NULL,
  `PreviousDateOfExpiry` VARCHAR(10) NULL DEFAULT NULL,
  `PreviousLostDate` VARCHAR(10) NULL DEFAULT NULL,
  `PreviousLostPlace` VARCHAR(45) NULL DEFAULT NULL,
  `CurrentCountryOfIssuing` VARCHAR(25) NULL DEFAULT NULL,
  `CurrentTachCardNum` VARCHAR(25) NULL DEFAULT NULL,
  `CurrentDriverLicenseCountryOfIssuing` VARCHAR(25) NULL DEFAULT NULL,
  `CurrentDriverLicenseNumber` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`RequestID`),
  INDEX `UserID_idx` (`Requests_UserID` ASC),
  INDEX `fk_requests_attatchemts1_idx` (`Requests_AttachmentID` ASC),
  CONSTRAINT `UserID`
    FOREIGN KEY (`Requests_UserID`)
    REFERENCES `finalproject`.`users` (`UserID`),
  CONSTRAINT `fk_requests_attatchemts1`
    FOREIGN KEY (`Requests_AttachmentID`)
    REFERENCES `finalproject`.`attachments` (`AttachmentID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 296
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finalproject`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalproject`.`roles` (
  `RoleID` INT(11) NOT NULL,
  `RoleName` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`RoleID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finalproject`.`user_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalproject`.`user_info` (
  `UserInfoID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(256) NOT NULL,
  `FirstNameCyrillic` NVARCHAR(256) NOT NULL,
  `LastName` VARCHAR(30) NOT NULL,
  `LastNameCyrillic` NVARCHAR(45) NOT NULL,
  `PersonalNumber` VARCHAR(20) NOT NULL,
  `Address` VARCHAR(100) NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `DateOfBirth` VARCHAR(25) NOT NULL,
  `UserInfo_UserID` INT(11) NOT NULL,
  `Email` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`UserInfoID`),
  INDEX `fk_user_info_users1_idx` (`UserInfo_UserID` ASC),
  CONSTRAINT `fk_user_info_users1`
    FOREIGN KEY (`UserInfo_UserID`)
    REFERENCES `finalproject`.`users` (`UserID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `finalproject`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `finalproject`.`user_role` (
  `UserID` INT(11) NOT NULL,
  `RoleID` INT(11) NOT NULL,
  PRIMARY KEY (`UserID`, `RoleID`),
  INDEX `FK_RoleID` (`RoleID` ASC),
  CONSTRAINT `FK_RoleID`
    FOREIGN KEY (`RoleID`)
    REFERENCES `finalproject`.`roles` (`RoleID`),
  CONSTRAINT `FK_UserID`
    FOREIGN KEY (`UserID`)
    REFERENCES `finalproject`.`users` (`UserID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- Insert part
INSERT INTO `roles` (`RoleID`, `RoleName`)
VALUES
(1,'ADMIN'), (2, 'USER');
INSERT INTO `users` (`UserID`, `Username`, `Password`)
VALUES
	(1,'alexanderrusev','$2a$04$v0HDZi99MrlDsm6Hx92TjOP7CDlV9UTaKTaqhohWrcfpd7YUGfQlu'),
(2,'randomuser','$2a$04$R1PhPLjVBz2LqsfCVLi0ROAK/mIFetmDCNDZSrGz4aM6SZJq6nTo6');
INSERT INTO `user_role` (`UserID`, `RoleID`)
VALUES (1,1), (1,2), (2, 2);
-- End of insert part

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

