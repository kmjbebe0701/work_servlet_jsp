CREATE DATABASE bookmgr;

DROP TABLE Book;

CREATE TABLE Book(
		isbn				INT				NOT NULL		 PRIMARY KEY AUTO_INCREMENT,
		title				VARCHAR(30)		NOT NULL,
		author				VARCHAR(10)		NOT NULL,
		publisher			VARCHAR(30)		NOT NULL,
		price				INT				NOT NULL,
		description			VARCHAR(255)		NULL			
);

INSERT INTO Book (title, author, publisher, price, description)
	VALUES ('1', '1', '1', 1, '1');
	
SELECT * FROM book ;