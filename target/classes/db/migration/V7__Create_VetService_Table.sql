CREATE TABLE vet_service (
    id SERIAL PRIMARY KEY,
    vet_id BIGINT,
    service_name VARCHAR(255) NOT NULL,
    service_price DOUBLE PRECISION NOT NULL,
    FOREIGN KEY (vet_id) REFERENCES vets(id)
);
