CREATE TABLE exchange_rate(
  currency_pair VARCHAR(10) PRIMARY KEY,
  rate FLOAT,
  last_updated DATE
);