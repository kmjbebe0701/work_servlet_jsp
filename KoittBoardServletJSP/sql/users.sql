# no : 회원번호
# email : 이메일 (아이디 용도)
# password : 비밀번호
# name : 이름

DROP TABLE users;

CREATE TABLE users (
	no			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	email		VARCHAR(255) NOT NULL,
	password	VARCHAR(255) NOT NULL,
	name		VARCHAR(255) NOT NULL,
	UNIQUE (email)
);

INSERT INTO users (email, password, name)
	VALUES ('teachertophoon@gmail.com', '1234', '정상훈');
INSERT INTO users (email, password, name)
	VALUES ('gildong@gmail.com', '5678', '홍길동');
INSERT INTO users (email, password, name)
	VALUES ('younghee@gmail.com', '7788', '김영희');