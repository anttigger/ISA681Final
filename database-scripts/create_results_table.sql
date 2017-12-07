CREATE TABLE `final_project`.`results` (
  `result_id` INT NOT NULL,
  `user` VARCHAR(45) NOT NULL,
  `quiz_category` VARCHAR(45) NOT NULL,
  `score` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`result_id`),
  INDEX `user_email_idx` (`user` ASC),
  CONSTRAINT `user_email`
    FOREIGN KEY (`user`)
    REFERENCES `final_project`.`user_table` (`user_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);