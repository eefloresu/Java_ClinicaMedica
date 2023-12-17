USE SISTEMA_CLINICAMEDICA;

INSERT INTO pacientes (pacIdentificacion, pacNombre, pacApellidos, pacFechaNacimiento, pacSexo) VALUES
('P123456', 'Ana', 'González', '1990-03-15', 'Femenino'),
('P789012', 'Javier', 'López', '1985-08-22', 'Masculino'),
('P345678', 'María', 'Martínez', '2000-05-10', 'Femenino'),
('P901234', 'Pedro', 'Sánchez', '1978-11-30', 'Masculino'),
('P567890', 'Laura', 'Gómez', '1995-07-05', 'Femenino');

INSERT INTO medicos ( medidentificacion, mednombres, medapellidos, medEspecialidad, medtelefono, medcorreo) VALUES
('M123456', 'Dr. Juan', 'Pérez', 'Cardiología', '123-456-7890', 'juan.perez@example.com'),
('M789012', 'Dra. María', 'Gómez', 'Dermatología', '987-654-3210', 'maria.gomez@example.com'),
('M345678', 'Dr. Roberto', 'Martínez', 'Pediatría', '555-123-4567', 'roberto.martinez@example.com'),
('M901234', 'Dra. Laura', 'López', 'Gastroenterología', '333-999-8888', 'laura.lopez@example.com'),
('M567890', 'Dr. Carlos', 'Rodríguez', 'Neurología', '777-222-1111', 'carlos.rodriguez@example.com');

INSERT INTO especialidades (esp_Nombre) VALUES
('Cardiología'),
('Dermatología'),
('Pediatría'),
('Gastroenterología'),
('Neurología');

INSERT INTO consultorios (conNombre) VALUES
('Consultorio 1'),
('Consultorio 2'),
('Consultorio 3'),
('Consultorio 4'),
('Consultorio 5');

INSERT INTO citas (citfecha, cithora, citPaciente, citMedico, citConsultorio, citestado, citobservaciones) VALUES
('2023-01-01', '08:00:00', 1, 1, 1, 'Asignado', 'Observaciones de la cita 1'),
('2023-02-15', '10:30:00', 2, 2, 2, 'atendido', 'Observaciones de la cita 2'),
('2023-03-10', '14:45:00', 3, 3, 3, 'Asignado', 'Observaciones de la cita 3'),
('2023-04-20', '16:00:00', 4, 4, 4, 'atendido', 'Observaciones de la cita 4'),
('2023-05-05', '09:15:00', 5, 5, 5, 'Asignado', 'Observaciones de la cita 5');







