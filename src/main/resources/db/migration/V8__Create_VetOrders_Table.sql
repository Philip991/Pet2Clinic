CREATE TABLE vet_orders (
    id SERIAL PRIMARY KEY,
    pet_id BIGINT,
    vet_id BIGINT,
    vet_service_id BIGINT,
    payment_method VARCHAR(255) NOT NULL,
    amount DOUBLE NOT NULL,
    tax DOUBLE NOT NULL,
    total DOUBLE NOT NULL,
    status VARCHAR(255) NOT NULL,
    FOREIGN KEY (pet_id) REFERENCES pet(id),
    FOREIGN KEY (vet_id) REFERENCES vet(id),
    FOREIGN KEY (vet_service_id) REFERENCES vet_service(id)
);
