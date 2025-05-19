-- Tabla persons
CREATE TABLE persons (
    identification VARCHAR(13) PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    gender         VARCHAR(50),
    age            INTEGER,
    direction      VARCHAR(255),
    phone          VARCHAR(50)
);

-- Tabla clients
CREATE TABLE clients (
    client_id   CHAR(36) PRIMARY KEY,
    password    VARCHAR(255) NOT NULL,
    state       BOOLEAN NOT NULL,
    persona_id  VARCHAR(13) NOT NULL,
    CONSTRAINT fk_client_person FOREIGN KEY (persona_id)
        REFERENCES persons (identification)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);
