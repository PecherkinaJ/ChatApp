CREATE TABLE IF NOT EXISTS users (
     id INT AUTO_INCREMENT PRIMARY KEY,
     email varchar(50) NOT NULL,
     password varchar(500) NOT NULL,
     nickname varchar(50) NOT NULL
);