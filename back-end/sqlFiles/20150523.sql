--  sql statements
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT auto_increment PRIMARY KEY ,
  name CHAR(100) NOT NULL UNIQUE ,
  email CHAR(100) NOT NULL ,
  password VARCHAR(255) NOT NULL
);