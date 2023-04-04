CREATE TABLE IF NOT EXISTS users_table (
     id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     email varchar(50) NOT NULL,
     password varchar(50) NOT NULL,
     nickname varchar(50) NOT NULL
);