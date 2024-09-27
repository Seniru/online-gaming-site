CREATE TABLE Ticket (
    TicketID INT PRIMARY KEY,
    Title VARCHAR(20),
    Body VARCHAR(200),
    Username VARCHAR (20) PRIMARY KEY,
    FOREIGN KEY (Username) REFERENCES User (Username)


);
