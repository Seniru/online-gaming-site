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
