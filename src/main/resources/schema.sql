CREATE TABLE IF NOT EXISTS users (
 id INT AUTO_INCREMENT PRIMARY KEY,
 email varchar_ignorecase(50) NOT NULL,
 password varchar_ignorecase(500) NOT NULL,
 nickname varchar(50) NOT NULL,
);