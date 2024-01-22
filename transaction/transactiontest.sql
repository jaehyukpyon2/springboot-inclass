CREATE DATABASE transaction_test;

USE transaction_test;

SELECT *
FROM tb_account ta ;

CREATE TABLE tb_account (
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(20) NULL DEFAULT '',
	balance int NULL DEFAULT 0
);


INSERT INTO tb_account (name, balance) VALUES ('sender', 10000);
INSERT INTO tb_account (name, balance) VALUES ('receiver', 0);