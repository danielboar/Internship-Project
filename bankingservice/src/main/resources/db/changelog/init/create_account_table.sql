CREATE TABLE account(
    account_id INT PRIMARY KEY,
    client_id INT NOT NULL,
    account_type VARCHAR(20),
    balance FLOAT,
    currency VARCHAR(10),
    created_date DATE,
    last_transaction_date DATE,
    status VARCHAR(20),
    FOREIGN KEY (client_id) REFERENCES client(client_id)
);