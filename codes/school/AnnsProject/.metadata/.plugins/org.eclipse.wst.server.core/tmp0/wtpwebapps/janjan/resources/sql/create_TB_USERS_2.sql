CREATE TABLE IF NOT EXISTS TB_USERS (
id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
username VARCHAR(14) NOT NULL,
password VARCHAR(14) NOT NULL,
email VARCHAR(30) NOT NULL,
nickname VARCHAR(20),
realname VARCHAR(20),
gender VARCHAR(6) DEFAULT 'MALE',
birthday DATE,
telephone VARCHAR(13),
address VARCHAR(70),
mobile VARCHAR(12),
zipcode VARCHAR(5),
createdTime DATETIME DEFAULT CURRENT_TIMESTAMP,
lastModified DATETIME DEFAULT CURRENT_TIMESTAMP,
errorCounters TINYINT UNSIGNED DEFAULT 0,
enabled TINYINT UNSIGNED DEFAULT 0,
UNIQUE(username),
PRIMARY KEY(id)
);

INSERT INTO TB_USERS (username,password,email,enabled) VALUES ('admin','admin','admin@email.com',1);
INSERT INTO TB_USERS (username,password,email) VALUES ('tony','tony','tony@email.com');

SELECT u.id,u.username,r.role FROM TB_USERS u LEFT OUTER JOIN TB_ROLES r ON u.id = r.user_id;
