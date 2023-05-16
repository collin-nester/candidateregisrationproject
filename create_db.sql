DROP SCHEMA IF EXISTS `candidate_registration`;
CREATE SCHEMA IF NOT EXISTS `candidate_registration`;

DROP TABLE IF EXISTS `candidate_registration`.`candidate`;
DROP TABLE IF EXISTS `candidate_registration`.`active_positions`;
DROP TABLE IF EXISTS `candidate_registration`.`position_candidate_join`;

CREATE TABLE IF NOT EXISTS `candidate_registration`.`candidate` (
  `user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(63) NULL DEFAULT NULL,
  `password` CHAR(60) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(63) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `candidate_registration`.`active_positions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `position_name` VARCHAR(63) NULL DEFAULT NULL,
  `position_description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `candidate_registration`.`position_candidate_join` (
  `position_id` INT(11) NOT NULL,
  `candidate_id` INT(11) NOT NULL,
  PRIMARY KEY (`candidate_id`, `position_id`),
  INDEX `position_id_idx` (`position_id` ASC),
  INDEX `candidate_id_idx` (`candidate_id` ASC),
  CONSTRAINT `candidate_id`
    FOREIGN KEY (`candidate_id`)
    REFERENCES `candidate_registration`.`candidate` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `position_id`
    FOREIGN KEY (`position_id`)
    REFERENCES `candidate_registration`.`active_positions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;