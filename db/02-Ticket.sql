CREATE TABLE `Ticket` (
    `TicketID` INT PRIMARY KEY,
    `Title` VARCHAR(20),
    `Body` VARCHAR(1024),
    `Username` VARCHAR (20),
    FOREIGN KEY (`Username`) REFERENCES `User` (`Username`)
);
