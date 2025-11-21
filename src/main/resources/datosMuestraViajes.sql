INSERT INTO Personas (nombre, email) VALUES
                                         ('Ana García', 'ana.garcia@email.com'),     -- ID 1
                                         ('Luis Pérez', 'luis.perez@email.com'),     -- ID 2
                                         ('Marta Ruiz', 'marta.ruiz@email.com'),     -- ID 3
                                         ('Pedro López', 'pedro.lopez@email.com');   -- ID 4
INSERT INTO Destinos (nombre_destino, pais) VALUES
                                                ('Kioto', 'Japón'),             -- ID 1
                                                ('Machu Picchu', 'Perú'),       -- ID 2
                                                ('Cataratas del Iguazú', 'Argentina');  -- ID 3

INSERT INTO Viajes (organizador_id, destino_id, fecha_inicio, fecha_fin, presupuesto_estimado) VALUES
                                                                                                   (1, 1, '2026-03-01', '2026-03-10', 2500.00), -- Viaje 1: Ana organiza a Kioto
                                                                                                   (2, 2, '2026-07-15', '2026-07-22', 1800.50), -- Viaje 2: Luis organiza a Machu Picchu
                                                                                                   (3, 3, '2026-11-05', '2026-11-12', 1200.00); -- Viaje 3: Marta organiza a Iguazú

INSERT INTO Participantes_Viaje (viaje_id, persona_id) VALUES
-- Participantes del Viaje 1 (Kioto, organizado por Ana - ID 1)
(1, 1), -- Ana
(1, 2), -- Luis
(1, 3), -- Marta

-- Participantes del Viaje 2 (Machu Picchu, organizado por Luis - ID 2)
(2, 2), -- Luis
(2, 4), -- Pedro

-- Participantes del Viaje 3 (Iguazú, organizado por Marta - ID 3)
(3, 3), -- Marta
(3, 1), -- Ana
(3, 4); -- Pedro