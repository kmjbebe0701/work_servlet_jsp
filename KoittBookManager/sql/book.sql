CREATE DATABASE bookmgr;



CREATE TABLE Book(
		isbn				INT				NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		title				VARCHAR(30)		NOT NULL,
		author				VARCHAR(30)		NOT NULL,
		publisher			VARCHAR(30)		NOT NULL,
		price				INT				NOT NULL,
		description			VARCHAR(255)	NOT NULL			
);