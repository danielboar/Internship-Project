CREATE TABLE transaction(
    transaction_id INT PRIMARY KEY,
    account_id INT NOT NULL,
    date DATE,
    amount FLOAT,
    type VARCHAR(10),
    description TEXT,
    category VARCHAR(50),
    merchant_name VARCHAR(50),
    merchant_location VARCHAR(100),
    FOREIGN KEY (account_id) REFERENCES account(account_id)
);