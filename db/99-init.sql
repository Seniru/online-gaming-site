ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';

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