CREATE TABLE expenses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    categories VARCHAR(255) NOT NULL,
    expense_value DECIMAL(10, 2) NOT NULL,
    expense_name VARCHAR(255) NOT NULL,
    expense_date DATE NOT NULL
);