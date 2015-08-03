CREATE TABLE IF NOT EXISTS TB_ROLES (
username VARCHAR(14) NOT NULL,
ROLE VARCHAR(10) DEFAULT 'ROLE_USER',
CONSTRAINT fk_roles_username FOREIGN KEY(username) REFERENCES TB_USERS (username)
ON DELETE CASCADE
ON UPDATE RESTRICT,
PRIMARY KEY(username,ROLE)
);

INSERT INTO TB_ROLES (username,ROLE) VALUES ('tony','ROLE_USER');
INSERT INTO TB_ROLES (username,ROLE) VALUES ('stark','ROLE_USER');
INSERT INTO TB_ROLES (username,ROLE) VALUES ('stark','ROLE_ADMIN');