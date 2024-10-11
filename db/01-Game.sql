CREATE TABLE `Game` (
    `Gtitle` VARCHAR(30) PRIMARY KEY ,
    `Image` VARCHAR(100),
    `URL` VARCHAR(200),
    `Description` VARCHAR(1024)
);

CREATE TABLE `Comment` (
    `CommentId` INT,
    `Gtitle` VARCHAR(30),
    `Body` VARCHAR(200),
    `PostedDate` DATETIME,
    PRIMARY KEY (`CommentId`, `Gtitle`),
    FOREIGN KEY (`Gtitle`) REFERENCES `Game`(`Gtitle`)
);

CREATE TABLE `Category` (
    `Cname` VARCHAR (20) PRIMARY KEY,
    `Icon` VARCHAR (100),
    `Color` VARCHAR (20)
);

CREATE TABLE `GameCategory` (
     `Cname` VARCHAR(20) PRIMARY KEY,
     `Title` VARCHAR(30),
     FOREIGN KEY (`Cname`) REFERENCES `Category` (`Cname`),
     FOREIGN KEY (`Title`) REFERENCES `Game` (`Gtitle`)
);

CREATE TABLE `UserComment` (
     `CommentId` INT,
     `Gtitle` VARCHAR(30),
     `Username` VARCHAR(20),
     PRIMARY KEY (`CommentId`, `Gtitle`, `Username`),
     FOREIGN KEY (`CommentId`) REFERENCES `Comment`(`CommentId`),
     FOREIGN KEY (`Gtitle`) REFERENCES `Game`(`Gtitle`),
     FOREIGN KEY (`Username`) REFERENCES `User`(`Username`)
); 
