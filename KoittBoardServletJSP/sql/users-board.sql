
INSERT INTO users (email, password, name)
	VALUES ('m_@_m.com', '1234', '슈퍼맨');
	
INSERT INTO users (email, password, name)
	VALUES ('o_@-.com', '1234', '땡글이');
	
INSERT INTO users (email, password, name)
	VALUES ('m_@_j.com', '1234', '미지');
	
SELECT * FROM users ORDER BY no DESC;

INSERT INTO board (title, content, user_no, regdate)
	VALUES ('안녕', '안녕하세여', 15, CURDATE());
	
SELECT * FROM board ORDER BY no DESC;

SELECT b.no, b.title, b.content, u.email, b.regdate 
FROM board b, users u 
WHERE b.user_no = u.no;