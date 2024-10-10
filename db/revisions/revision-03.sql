ALTER TABLE `Game` ADD COLUMN `DeveloperName` VARCHAR(30);
ALTER TABLE `Game` ADD CONSTRAINT `fk_DeveloperName` FOREIGN KEY (`DeveloperName`) REFERENCES `User` (`Username`);

CREATE TABLE `Play` (
    `ID` INT PRIMARY KEY AUTO_INCREMENT,
    `Gtitle` VARCHAR(30),
    `Username` VARCHAR(20),
    FOREIGN KEY (`Gtitle`) REFERENCES `Game` (`Gtitle`),
    FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)
);

CREATE TABLE `Favourites` (
    `Gtitle` VARCHAR(30),
    `Username` VARCHAR(20),
	PRIMARY KEY (`Gtitle`, `Username`),
    FOREIGN KEY (`Gtitle`) REFERENCES `Game` (`Gtitle`),
    FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)
);
