CREATE TABLE taxes (
    id SERIAL PRIMARY KEY,
    country VARCHAR(255) NOT NULL,
    percentage INTEGER NOT NULL
);
