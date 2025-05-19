CREATE TABLE persona (
    persona_id CHAR(36) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(10),
    edad INT,
    identificacion VARCHAR(20) UNIQUE,
    direccion VARCHAR(255),
    telefono VARCHAR(15)
);

CREATE TABLE cliente (
    cliente_id CHAR(36) PRIMARY KEY, -- UUID
    persona_id CHAR(36) NOT NULL,
    password VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (persona_id) REFERENCES persona(persona_id)
);

