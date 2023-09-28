-- Crear la base de datos si aún no existe
CREATE DATABASE IF NOT EXISTS bd_farmacia;

-- Usar la base de datos
USE bd_farmacia;

-- Crear la tabla "medicamentos"
CREATE TABLE medicamentos (
    idmedicamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    descripcion TEXT,
    categoria VARCHAR(50),
    precio DECIMAL(10, 2),
    stock INT,
    fechaVencimiento date,
    proveedor VARCHAR(100)
);

-- Insertar algunos registros de ejemplo
INSERT INTO medicamentos (nombre, descripcion, categoria, precio, stock, fechaVencimiento, proveedor) VALUES
    ('Paracetamol', 'Analgésico común', 'Analgésico', 5, 100, '2024-12-31', 'Genérico Pharma'),
    ('Amoxicilina', 'Antibiótico', 'Antibiótico', 10.50, 50, '2023-11-15', 'Farmacia A'),
     ('Vitamina C', 'Suplemento Vitamínico', 'Vitaminas', 8.75, 75, '2024-08-01', 'Proveedor B'),
      ('Ibuprofeno', 'Antiinflamatorio', 'Analgésico', 6.25, 60, '2023-10-20', 'Genérico Pharma'),
    ('Omeprazol', 'Medicamento GI', 'GI', 12.3, 40, '2023-12-10', 'Famacia A');

-- Verificar la creación de la tabla
SELECT * FROM medicamentos;