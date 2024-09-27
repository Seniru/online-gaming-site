CREATE TABLE Game (
    Gtitle VARCHAR(10) PRIMARY KEY ,
    Image VARCHAR(100),
    URL VARCHAR(200),
    Description VARCHAR(100);



);

CREATE TABLE Comment (
    CommentId INT PRIMARY key,
    Gtitle VARCHAR(10),
    Body VARCHAR(200),
    FOREIGN KEY (Gtitle) REFERENCES Game(Gtitle),



    

);

CREATE TABLE  Category (
    Cname VARCHAR (10) PRIMARY key,
    Icon VARCHAR (100),
    Color VARCHAR (20);


);

CREATE TABLE GameCategory (
     Cname VARCHAR (10),
     Title VARCHAR(10),
     FOREIGN KEY (Cname) REFERENCES Category(Cname),
     FOREIGN KEY (Gtitle) REFERENCES Game(Gtitle);

);

CREATE TABLE UserComment (
     CommentId INT,
     Gtitle VARCHAR,
     Username VARCHAR(20)''
     FOREIGN KEY (CommentId) REFERENCES Comment(CommentId),
     FOREIGN KEY (Gtitle) REFERENCES Game(Gtitle),
     FOREIGN KEY (Username) REFERENCES User(Username),
); 
