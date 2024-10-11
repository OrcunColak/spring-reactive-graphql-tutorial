CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL, -- Use "titles" here
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
