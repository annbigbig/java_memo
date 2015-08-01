CREATE TABLE IF NOT EXISTS TB_USER (
username VARCHAR(14) NOT NULL,
password VARCHAR(14) NOT NULL,
email VARCHAR(30) NOT NULL,
PRIMARY KEY(username)
);

INSERT INTO TB_USER (username,password,email) VALUES('naruto','narutopass','naroto@gmail.com');
INSERT INTO TB_USER (username,password,email) VALUES('sasuke','sasukepass','sasuke@gmail.com');