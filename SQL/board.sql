CREATE TABLE `board` (
    `no` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `writer` VARCHAR(100) NOT NULL,
    `content` TEXT NULL,
    `reg_date` TIMESTAMP NOT NULL DEFAULT now(),
    `upd_date` TIMESTAMP NOT NULL DEFAULT now(),
    `view` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`no`));