CREATE TABLE client(
    client_id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(100),
    date_of_birth DATE,
    gender VARCHAR(10),
    nationality VARCHAR(20),
    occupation VARCHAR(30),
    annual_income FLOAT,
    marital_status VARCHAR(20),
    customer_since DATE
);