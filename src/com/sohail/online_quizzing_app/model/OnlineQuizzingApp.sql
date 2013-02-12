SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `OnlineQuizzingApp` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `OnlineQuizzingApp` ;

-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid` VARCHAR(45) NOT NULL ,
  `username` VARCHAR(128) NOT NULL ,
  `password` VARCHAR(60) NOT NULL ,
  `first_name` VARCHAR(45) NOT NULL ,
  `middle_name` VARCHAR(45) NULL ,
  `last_name` VARCHAR(45) NOT NULL ,
  `email1` VARCHAR(255) NOT NULL ,
  `email2` VARCHAR(255) NULL ,
  `phone` VARCHAR(45) NULL ,
  `mobile` VARCHAR(45) NULL ,
  `address` TEXT(255) NULL ,
  `dob` DATE NOT NULL ,
  `date_of_joining` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email1_UNIQUE` (`email1` ASC) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) ,
  UNIQUE INDEX `uuid_user_UNIQUE` (`uuid` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`admin`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`admin` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid_user` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `uuid_admin_UNIQUE` (`uuid_user` ASC) ,
  CONSTRAINT `uuid_admin_fk`
    FOREIGN KEY (`uuid_user` )
    REFERENCES `OnlineQuizzingApp`.`users` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`quiz`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`quiz` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid` VARCHAR(45) NOT NULL ,
  `subject` VARCHAR(255) NOT NULL ,
  `topic` VARCHAR(255) NOT NULL ,
  `total_questions` INT NULL ,
  `total_questions_to_solve` INT NULL ,
  `time_limit` INT NOT NULL ,
  `due_date` DATE NOT NULL ,
  `description` TEXT(1024) NULL ,
  `submission_date` DATE NOT NULL ,
  `author_uuid` VARCHAR(45) NOT NULL ,
  `highest_score` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `uuid_quiz_UNIQUE` (`uuid` ASC) ,
  INDEX `author_uuid_idx` (`author_uuid` ASC) ,
  CONSTRAINT `author_uuid_fk`
    FOREIGN KEY (`author_uuid` )
    REFERENCES `OnlineQuizzingApp`.`admin` (`uuid_user` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`questions`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`questions` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid` VARCHAR(45) NOT NULL ,
  `uuid_quiz` VARCHAR(45) NOT NULL ,
  `question_number` TINYINT UNSIGNED NOT NULL ,
  `question` TEXT NOT NULL ,
  `question_image` BLOB NULL ,
  `difficulty` VARCHAR(15) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `uuid_question_UNIQUE` (`uuid` ASC) ,
  INDEX `uuid_quiz_question_idx` (`uuid_quiz` ASC) ,
  CONSTRAINT `uuid_quiz_question_fk`
    FOREIGN KEY (`uuid_quiz` )
    REFERENCES `OnlineQuizzingApp`.`quiz` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`options`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`options` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid` VARCHAR(45) NOT NULL ,
  `uuid_quiz` VARCHAR(45) NOT NULL ,
  `uuid_question` VARCHAR(45) NOT NULL ,
  `option_number` TINYINT UNSIGNED NOT NULL ,
  `option` TEXT NOT NULL ,
  `option_image` BLOB NULL ,
  `correct_answer` BINARY NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `uuid_option_UNIQUE` (`uuid` ASC) ,
  INDEX `uuid_question_option_idx` (`uuid_question` ASC) ,
  INDEX `uuid_quiz_option_idx` (`uuid_quiz` ASC) ,
  CONSTRAINT `uuid_question_option_fk`
    FOREIGN KEY (`uuid_question` )
    REFERENCES `OnlineQuizzingApp`.`questions` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `uuid_quiz_option_fk`
    FOREIGN KEY (`uuid_quiz` )
    REFERENCES `OnlineQuizzingApp`.`quiz` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`students`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`students` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid_user` VARCHAR(45) NOT NULL ,
  `branch` VARCHAR(45) NOT NULL ,
  `roll_number` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `uuid_student_UNIQUE` (`uuid_user` ASC) ,
  CONSTRAINT `uuid_student_fk`
    FOREIGN KEY (`uuid_user` )
    REFERENCES `OnlineQuizzingApp`.`users` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`quiz_solved`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`quiz_solved` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid_quiz` VARCHAR(45) NOT NULL ,
  `uuid_student` VARCHAR(45) NOT NULL ,
  `total_score` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `uuid_student_solved_fk`
    FOREIGN KEY (`uuid_student` )
    REFERENCES `OnlineQuizzingApp`.`students` (`uuid_user` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `uuid_quiz_solved_fk`
    FOREIGN KEY (`uuid_quiz` )
    REFERENCES `OnlineQuizzingApp`.`quiz` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OnlineQuizzingApp`.`submitted_answers`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `OnlineQuizzingApp`.`submitted_answers` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `uuid_quiz` VARCHAR(45) NOT NULL ,
  `uuid_question` VARCHAR(45) NOT NULL ,
  `uuid_option` VARCHAR(45) NOT NULL ,
  `uuid_student` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `uuid_student_submitted_fk`
    FOREIGN KEY (`uuid_student` )
    REFERENCES `OnlineQuizzingApp`.`students` (`uuid_user` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `uuid_quiz_submitted_fk`
    FOREIGN KEY (`uuid_quiz` )
    REFERENCES `OnlineQuizzingApp`.`quiz` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `uuid_question_submitted_fk`
    FOREIGN KEY (`uuid_question` )
    REFERENCES `OnlineQuizzingApp`.`questions` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `uuid_option_submitted_fk`
    FOREIGN KEY (`uuid_option` )
    REFERENCES `OnlineQuizzingApp`.`options` (`uuid` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

USE `OnlineQuizzingApp` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
