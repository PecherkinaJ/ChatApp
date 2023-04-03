CREATE TABLE IF NOT EXISTS users_table (
     id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     email varchar_ignorecase(50) NOT NULL,
     password varchar_ignorecase(500) NOT NULL,
     nickname varchar_ignorecase(50) NOT NULL
);