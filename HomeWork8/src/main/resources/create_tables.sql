CREATE TYPE ticket_type AS ENUM ('DAY', 'WEEK', 'MONTH', 'YEAR');

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS tickets (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) NOT NULL,
    ticket_type ticket_type NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);