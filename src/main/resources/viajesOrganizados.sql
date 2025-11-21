-- 1. CREACIÓN DE LA BASE DE DATOS
CREATE DATABASE IF NOT EXISTS viajes_db;
USE viajes_db;

-- 2. TABLA PERSONAS
CREATE TABLE Personas (
                          persona_id INT PRIMARY KEY AUTO_INCREMENT,
                          nombre VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL
);

-- 3. TABLA DESTINOS
CREATE TABLE Destinos (
                          destino_id INT PRIMARY KEY AUTO_INCREMENT,
                          nombre_destino VARCHAR(100) NOT NULL,
                          pais VARCHAR(100) NOT NULL
);

-- 4. TABLA VIAJES
CREATE TABLE Viajes (
                        viaje_id INT PRIMARY KEY AUTO_INCREMENT,
                        organizador_id INT NOT NULL,
                        destino_id INT NOT NULL,
                        fecha_inicio DATE NOT NULL,
                        fecha_fin DATE NOT NULL,
                        presupuesto_estimado DECIMAL(10, 2),

                        FOREIGN KEY (organizador_id) REFERENCES Personas(persona_id),
                        FOREIGN KEY (destino_id) REFERENCES Destinos(destino_id)
);

-- 5. TABLA PARTICIPANTES_VIAJE
CREATE TABLE Participantes_Viaje (
    -- 1. Clave Primaria Simple
                                     participacion_id INT PRIMARY KEY AUTO_INCREMENT,

    -- 2. Claves Foráneas
                                     viaje_id INT NOT NULL,
                                     persona_id INT NOT NULL,

    -- 3. Restricción de Unicidad (para evitar que una persona esté dos veces en el mismo viaje)
                                     UNIQUE KEY uk_viaje_persona (viaje_id, persona_id),

    -- 4. Definición de las Claves Foráneas (relaciones con otras tablas)
                                     FOREIGN KEY (viaje_id) REFERENCES Viajes(viaje_id),
                                     FOREIGN KEY (persona_id) REFERENCES Personas(persona_id)
);