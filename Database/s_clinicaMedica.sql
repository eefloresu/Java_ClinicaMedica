-- CREATE DATABASE SISTEMA_CLINICAMEDICA;
USE SISTEMA_CLINICAMEDICA;

CREATE TABLE pacientes (
  idPaciente int(11) NOT NULL AUTO_INCREMENT,
  pacIdentificacion char(15) COLLATE utf8_spanish_ci NOT NULL,
  pacNombre varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  pacApellidos varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  pacFechaNacimiento date NOT NULL,
  pacSexo enum('Femenino','Masculino') NOT NULL,
  PRIMARY KEY (idPaciente),
  UNIQUE KEY pacIdentificacion (pacIdentificacion)
);

CREATE TABLE medicos (
  idMedico int(11) NOT NULL AUTO_INCREMENT,
  medidentificacion char(15) NOT NULL,
  mednombres varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  medapellidos varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  medEspecialidad varchar(50) NOT NULL,
  medtelefono char(15) NOT NULL,
  medcorreo varchar(50) NOT NULL,
  PRIMARY KEY (idMedico),
  UNIQUE KEY medidentificacion (medidentificacion)
);

CREATE TABLE especialidades (
  id_especialidad int(11) NOT NULL AUTO_INCREMENT,
  esp_Nombre varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (id_especialidad),
  UNIQUE KEY espNombre (esp_Nombre)
);

CREATE TABLE consultorios (
  idConsultorio int(11) NOT NULL AUTO_INCREMENT,
  conNombre char(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (idConsultorio),
  UNIQUE KEY conNombre (conNombre)
); 

CREATE TABLE citas (
  idcita int(11) NOT NULL,
  citfecha date NOT NULL,
  cithora time NOT NULL,
  citPaciente int(11) NOT NULL,
  citMedico int(11) NOT NULL,
  citConsultorio int(11) NOT NULL,
  citestado enum('Asignado','atendido') NOT NULL,
  citobservaciones text NOT NULL,
  PRIMARY KEY (idcita),
  KEY cithora (cithora),
  KEY idPaciente (citPaciente),
  KEY idMedico (citMedico),
  KEY idConsultorio (citConsultorio)
); 

ALTER TABLE `citas`
  MODIFY `idcita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;