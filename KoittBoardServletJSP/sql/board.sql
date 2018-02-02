#DDL(Data Definition Language)
DROP TABLE board;

CREATE TABLE board (
	no INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(30) NOT NULL,
	content VARCHAR(255) NULL,
	writer VARCHAR(10) NOT NULL,
	regdate DATE NOT NULL
);

#DML(Data Manipulation Language)
INSERT INTO board (title, content, writer, regdate)
	VALUES ('제목-1', '내용-1', '작성자-1', STR_TO_DATE('2018-02-01', '%Y-%m-%d'));
	
INSERT INTO board (title, content, writer, regdate)
	VALUES ('제목-2', '내용-2', '작성자-2', STR_TO_DATE('2018-02-01', '%Y-%m-%d'));
	
INSERT INTO board (title, content, writer, regdate)
	VALUES ('제목-3', '내용-3', '작성자-3', STR_TO_DATE('2018-02-01', '%Y-%m-%d'));
	
#DQL(Data Query Language)
SELECT * FROM board;
