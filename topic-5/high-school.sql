-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema high-school
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `high-school` ;

-- -----------------------------------------------------
-- Schema high-school
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `high-school` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `high-school` ;

-- -----------------------------------------------------
-- Table `high-school`.`student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`student` ;

CREATE TABLE IF NOT EXISTS `high-school`.`student` (
  `id_student` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(15) NOT NULL,
  `registration_number` INT NULL,
  `date_of_birth` DATE NULL,
  PRIMARY KEY (`id_student`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`teacher` ;

CREATE TABLE IF NOT EXISTS `high-school`.`teacher` (
  `id_teacher` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(15) NOT NULL,
  `date_of_birth` DATE NULL,
  PRIMARY KEY (`id_teacher`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`course` ;

CREATE TABLE IF NOT EXISTS `high-school`.`course` (
  `id_course` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `hours_by_week` INT NULL,
  PRIMARY KEY (`id_course`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `high-school`.`enrollment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`enrollment` ;

CREATE TABLE IF NOT EXISTS `high-school`.`enrollment` (
  `pk_id_student` INT NOT NULL,
  `pk_id_course` INT NOT NULL,
  PRIMARY KEY (`pk_id_student`, `pk_id_course`),
  CONSTRAINT `fk_student_has_course_student1`
    FOREIGN KEY (`pk_id_student`)
    REFERENCES `high-school`.`student` (`id_student`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_course_course1`
    FOREIGN KEY (`pk_id_course`)
    REFERENCES `high-school`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_student_has_course_course1_idx` ON `high-school`.`enrollment` (`pk_id_course` ASC);

CREATE INDEX `fk_student_has_course_student1_idx` ON `high-school`.`enrollment` (`pk_id_student` ASC);


-- -----------------------------------------------------
-- Table `high-school`.`teacher_has_course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`teacher_has_course` ;

CREATE TABLE IF NOT EXISTS `high-school`.`teacher_has_course` (
  `pk_id_teacher` INT NOT NULL,
  `pk_id_course` INT NOT NULL,
  PRIMARY KEY (`pk_id_teacher`, `pk_id_course`),
  CONSTRAINT `fk_teacher_has_course_teacher1`
    FOREIGN KEY (`pk_id_teacher`)
    REFERENCES `high-school`.`teacher` (`id_teacher`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_has_course_course1`
    FOREIGN KEY (`pk_id_course`)
    REFERENCES `high-school`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_teacher_has_course_course1_idx` ON `high-school`.`teacher_has_course` (`pk_id_course` ASC);

CREATE INDEX `fk_teacher_has_course_teacher1_idx` ON `high-school`.`teacher_has_course` (`pk_id_teacher` ASC);


-- -----------------------------------------------------
-- Table `high-school`.`exam_result`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `high-school`.`exam_result` ;

CREATE TABLE IF NOT EXISTS `high-school`.`exam_result` (
  `id_exam` INT NOT NULL AUTO_INCREMENT,
  `note1` INT NOT NULL,
  `note2` INT NOT NULL,
  `note3` INT NOT NULL,
  `final_note` INT NOT NULL,
  `fk_id_student` INT NOT NULL,
  `fk_id_course` INT NOT NULL,
  PRIMARY KEY (`id_exam`),
  CONSTRAINT `fk_exam_result_student1`
    FOREIGN KEY (`fk_id_student`)
    REFERENCES `high-school`.`student` (`id_student`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_result_course1`
    FOREIGN KEY (`fk_id_course`)
    REFERENCES `high-school`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_exam_result_student1_idx` ON `high-school`.`exam_result` (`fk_id_student` ASC);

CREATE INDEX `fk_exam_result_course1_idx` ON `high-school`.`exam_result` (`fk_id_course` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
