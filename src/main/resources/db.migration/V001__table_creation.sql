CREATE TABLE incident (
    id_incident BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(200),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    closed_at TIMESTAMP
);

