-- 00-User.sql
CREATE TABLE `User` (
	`Username` VARCHAR(20) PRIMARY KEY,
	`Email` VARCHAR(50) UNIQUE NOT NULL,
	`Password` VARCHAR(20) NOT NULL
);

CREATE TABLE `ProUser` (
	`Username` VARCHAR(20) PRIMARY KEY,
	FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)
);

CREATE TABLE `DevUser` (
	`Username` VARCHAR(20) PRIMARY KEY,
	FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)
);

CREATE TABLE `SupportAgent` (
	`Username` VARCHAR(20) PRIMARY KEY,
	FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)
);

CREATE TABLE `Admin` (
	`Username` VARCHAR(20) PRIMARY KEY,
	FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)
);

-- 01-Game.sql
CREATE TABLE `Game` (
    `Gtitle` VARCHAR(10) PRIMARY KEY ,
    `Image` VARCHAR(100),
    `URL` VARCHAR(200),
    `Description` VARCHAR(100)
);

CREATE TABLE `Comment` (
    `CommentId` INT PRIMARY KEY,
    `Gtitle` VARCHAR(10),
    `Body` VARCHAR(200),
    FOREIGN KEY (`Gtitle`) REFERENCES `Game`(`Gtitle`)
);

CREATE TABLE  `Category` (
    `Cname` VARCHAR (10) PRIMARY KEY,
    `Icon` VARCHAR (100),
    `Color` VARCHAR (20)
);

CREATE TABLE `GameCategory` (
     `Cname` VARCHAR(10) PRIMARY KEY,
     `Title` VARCHAR(10),
     FOREIGN KEY (`Cname`) REFERENCES `Category` (`Cname`),
     FOREIGN KEY (`Title`) REFERENCES `Game` (`Gtitle`)
);

CREATE TABLE `UserComment` (
     `CommentId` INT,
     `Gtitle` VARCHAR(10),
     `Username` VARCHAR(20),
     PRIMARY KEY (`CommentId`, `Gtitle`, `Username`),
     FOREIGN KEY (`CommentId`) REFERENCES `Comment`(`CommentId`),
     FOREIGN KEY (`Gtitle`) REFERENCES `Game`(`Gtitle`),
     FOREIGN KEY (`Username`) REFERENCES `User`(`Username`)
); 

-- 02-Ticket.sql
CREATE TABLE `Ticket` (
    `TicketID` INT PRIMARY KEY,
    `Title` VARCHAR(20),
    `Body` VARCHAR(200),
    `Username` VARCHAR (20),
    FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)


);

-- 99-init.sql
-- Insert records into User table
INSERT INTO `User` (`Username`, `Email`, `Password`) VALUES
('john_doe', 'john@example.com', 'password123'),
('jane_smith', 'jane@example.com', 'securepass'),
('alice_jones', 'alice@example.com', 'mypassword');

-- Insert records into Game table
INSERT INTO `Game` (`Gtitle`, `Image`, `URL`, `Description`) VALUES
('Game1', 'image1.jpg', 'http://example.com/game1', 'Exciting adventure game'),
('Game2', 'image2.jpg', 'http://example.com/game2', 'Challenging puzzle game'),
('Game3', 'image3.jpg', 'http://example.com/game3', 'Fun and educational game');

