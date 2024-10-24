CREATE TABLE IF NOT EXISTS monedas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tipos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor NUMERIC(10, 5) NOT NULL,
    fecha DATE NOT NULL,
    moneda_id BIGINT    
);
ALTER TABLE tipos
    ADD FOREIGN KEY (moneda_id) 
    REFERENCES monedas(id);


CREATE TABLE IF NOT EXISTS montos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    actual NUMERIC(10, 5) NOT NULL,
    convertido NUMERIC(10, 5) NOT NULL,
    fecha DATE NOT NULL NOT NULL,
    tipo_id BIGINT,
    moneda_origen_id BIGINT
);
ALTER TABLE montos
    ADD FOREIGN KEY (tipo_id) 
    REFERENCES tipos(id);
 ALTER TABLE montos
    ADD FOREIGN KEY (moneda_origen_id) 
    REFERENCES monedas(id);