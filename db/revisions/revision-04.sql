ALTER TABLE GameCategory MODIFY COLUMN Cname VARCHAR(20);
ALTER TABLE GameCategory MODIFY COLUMN Title VARCHAR(30);
ALTER TABLE Ticket MODIFY TicketID INTEGER AUTO_INCREMENT;
ALTER TABLE Ticket MODIFY COLUMN Body VARCHAR(1024);
ALTER TABLE Ticket ADD COLUMN CreatedDate DATETIME;
ALTER TABLE Ticket ADD COLUMN Resolved BOOLEAN DEFAULT FALSE;
ALTER TABLE Comment ADD COLUMN PostedDate DATETIME;


DROP TABLE UserComment;
DROP TABLE Comment;

CREATE TABLE `Comment` (
    `CommentId` INT,
    `Gtitle` VARCHAR(30),
    `Body` VARCHAR(200),
    PRIMARY KEY (`CommentId`, `Gtitle`),
    FOREIGN KEY (`Gtitle`) REFERENCES `Game`(`Gtitle`)
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
