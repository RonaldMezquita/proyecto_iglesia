-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.18 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla db_iglesia.comunidad
CREATE TABLE IF NOT EXISTS `comunidad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_sector` int(11) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_sector` (`id_sector`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__comunidad_sector` FOREIGN KEY (`id_sector`) REFERENCES `sector` (`id`),
  CONSTRAINT `FK__comunidad_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Tabla que contiene la informacion de las comunidades y a que sector pertenese\r\n';

-- Volcando datos para la tabla db_iglesia.comunidad: ~2 rows (aproximadamente)
DELETE FROM `comunidad`;
/*!40000 ALTER TABLE `comunidad` DISABLE KEYS */;
INSERT INTO `comunidad` (`id`, `nombre`, `estado`, `id_sector`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Sagrada familia', 1, 2, '2020-03-10', NULL, 1),
	(2, 'Nazareno', 1, 3, '2020-03-30', NULL, 1);
/*!40000 ALTER TABLE `comunidad` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.departamento
CREATE TABLE IF NOT EXISTS `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pais` int(11) NOT NULL,
  `nombre` varchar(75) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_pais` (`id_pais`),
  CONSTRAINT `FK_departamento_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`),
  CONSTRAINT `FK_departamento_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla que almacenara los departamentos del pais';

-- Volcando datos para la tabla db_iglesia.departamento: ~14 rows (aproximadamente)
DELETE FROM `departamento`;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` (`id`, `id_pais`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 1, 'Ahuachapán', 1, '2020-03-24', NULL, 1),
	(2, 1, 'Cabañas', 1, '2020-03-24', NULL, 1),
	(3, 1, 'Chalatenango', 1, '2020-03-24', NULL, 1),
	(4, 1, 'Cuscatlán', 1, '2020-03-24', NULL, 1),
	(5, 1, 'La Libertad', 1, '2020-03-24', NULL, 1),
	(6, 1, 'La Paz', 1, '2020-03-24', NULL, 1),
	(7, 1, 'La Unión', 1, '2020-03-24', NULL, 1),
	(8, 1, 'Morazán', 1, '2020-03-24', NULL, 1),
	(9, 1, 'San Miguel', 1, '2020-03-24', NULL, 1),
	(10, 1, 'San Salvador', 1, '2020-03-24', NULL, 1),
	(11, 1, 'San Vicente', 1, '2020-03-24', NULL, 1),
	(12, 1, 'Santa Ana', 1, '2020-03-24', NULL, 1),
	(13, 1, 'Sonsonate', 1, '2020-03-24', NULL, 1),
	(14, 1, 'Usulután', 1, '2020-03-24', NULL, 1);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.evento
CREATE TABLE IF NOT EXISTS `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_tipo_sacramento` int(11) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  `id_sacerdote` int(11) NOT NULL,
  `tomo` varchar(50) NOT NULL,
  `folio` varchar(50) NOT NULL,
  `numero` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_lugar` (`id_lugar`),
  KEY `id_sacerdote` (`id_sacerdote`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_tipo_evento` (`id_tipo_sacramento`),
  CONSTRAINT `FK__lugarBoda` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id`),
  CONSTRAINT `FK__sacerdoteBoda` FOREIGN KEY (`id_sacerdote`) REFERENCES `sacerdote` (`id`),
  CONSTRAINT `FK__usuarioBoda` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_evento_tipo_sacramento` FOREIGN KEY (`id_tipo_sacramento`) REFERENCES `tipo_sacramentos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Tabla que representa todos los eventos posibles en la parroquia';

-- Volcando datos para la tabla db_iglesia.evento: ~3 rows (aproximadamente)
DELETE FROM `evento`;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` (`id`, `fecha`, `id_tipo_sacramento`, `id_lugar`, `id_sacerdote`, `tomo`, `folio`, `numero`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, '2020-03-22', 2, 2, 1, '12', '123', '1524', 1, '2020-03-23', NULL, 1),
	(2, '2020-03-22', 1, 2, 1, 'V', 'VII', '5345', 1, '2020-03-23', NULL, 1),
	(3, '2020-03-22', 3, 2, 1, 'VII', 'XV', '1524', 1, '2020-03-25', NULL, 1);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.justificacion
CREATE TABLE IF NOT EXISTS `justificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuarioJustificacion` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla justifica que tipo de moviemiento es ';

-- Volcando datos para la tabla db_iglesia.justificacion: ~2 rows (aproximadamente)
DELETE FROM `justificacion`;
/*!40000 ALTER TABLE `justificacion` DISABLE KEYS */;
INSERT INTO `justificacion` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Colaboracion por Boda', 1, '2020-02-23', NULL, 1),
	(2, 'Colaboracion por Bautizo', 1, '2020-03-27', NULL, 1);
/*!40000 ALTER TABLE `justificacion` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.lugar
CREATE TABLE IF NOT EXISTS `lugar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuarioLugar` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla llevar control de lugar de locacion';

-- Volcando datos para la tabla db_iglesia.lugar: ~2 rows (aproximadamente)
DELETE FROM `lugar`;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Maria Consoladora del Carpinelo', 1, '2020-02-23', NULL, 1),
	(2, 'Nuestra Señora de Valvanera', 1, '2020-02-23', NULL, 1),
	(3, 'Lugar desconocido', 1, '2020-03-18', NULL, 1);
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.movimiento
CREATE TABLE IF NOT EXISTS `movimiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_mov` date NOT NULL,
  `monto` decimal(12,2) NOT NULL,
  `tipo` enum('ENTRADA','SALIDA') NOT NULL,
  `id_evento` int(11) DEFAULT NULL,
  `id_justificacion` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_justificacion` (`id_justificacion`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_evento` (`id_evento`),
  CONSTRAINT `FK__justificacionMovimiento` FOREIGN KEY (`id_justificacion`) REFERENCES `justificacion` (`id`),
  CONSTRAINT `FK__usuarioMovimiento` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_movimiento_evento` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='Tabla lleva los movimientos de dinero';

-- Volcando datos para la tabla db_iglesia.movimiento: ~1 rows (aproximadamente)
DELETE FROM `movimiento`;
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT INTO `movimiento` (`id`, `fecha_mov`, `monto`, `tipo`, `id_evento`, `id_justificacion`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, '2020-03-22', 175.00, 'ENTRADA', 2, 1, 1, '2020-04-02', NULL, 1),
	(2, '2020-03-22', 200.00, 'ENTRADA', 1, 2, 1, '2020-04-02', NULL, 1);
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.pais
CREATE TABLE IF NOT EXISTS `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK_pais_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla que almacenara los diferentes paises';

-- Volcando datos para la tabla db_iglesia.pais: ~0 rows (aproximadamente)
DELETE FROM `pais`;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'El Salvador', 1, '2020-03-24', NULL, 1);
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `id_depto_origen` int(11) DEFAULT NULL,
  `dui` varchar(10) DEFAULT NULL,
  `nit` varchar(17) DEFAULT NULL,
  `genero` enum('M','F') NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_depto_origen` (`id_depto_origen`),
  CONSTRAINT `FK_persona_departamento` FOREIGN KEY (`id_depto_origen`) REFERENCES `departamento` (`id`),
  CONSTRAINT `FK_persona_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla lleva los datos de las personas';

-- Volcando datos para la tabla db_iglesia.persona: ~13 rows (aproximadamente)
DELETE FROM `persona`;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`id`, `nombres`, `apellidos`, `direccion`, `id_depto_origen`, `dui`, `nit`, `genero`, `fecha_nacimiento`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Juan Javier', 'Perez', 'Col. el Ivu Santa Ana, Santa Ana', 12, '06859832-1', '1020-140586-120-2', 'M', '1986-05-14', 1, '2020-02-23', NULL, 1),
	(2, 'Roberto Eduardo', 'Galdamez', 'Lamatepec, Santa Ana, Santa Ana', 12, '06529863-1', '1020-210786-102-1', 'M', '1986-07-21', 1, '2020-02-23', NULL, 1),
	(3, 'Juana', 'Galdamez', 'Lamatepec,Santra Ana,Santa Ana', 10, '06529862-1', '1020-210785-102-1', 'F', '1988-03-05', 1, '2020-03-05', NULL, 1),
	(4, 'Abigail', 'Perez', 'Col. el Ivu Santa Ana, Santa Ana', 10, '06859833-1', '1020-140687-102-1', 'F', '1987-03-07', 1, '2020-03-07', NULL, 1),
	(5, 'Abraham', 'Perez', 'Santa Ana', 12, NULL, NULL, 'M', '2018-03-07', 1, '2020-03-07', NULL, 1),
	(6, 'Caty Elizabeth', 'Herrera Osorio', 'Col. El nazareno pol 3 casa 21 santa ana ', 12, '05032326-1', '5112-121215-112-1', 'F', '1986-06-27', 0, '2020-03-14', NULL, 1),
	(7, 'Godofredo', 'Sorto', '', 12, '11111111-1', '1111-111111-111-1', 'M', '1990-03-05', 1, '2020-03-14', NULL, 1),
	(8, 'Pablo', 'Herrera', '', 12, '44444444-4', '5555-555555-555-5', 'M', '1955-03-07', 1, '2020-03-19', NULL, 1),
	(9, 'Catalina', 'Flores', 'Col Ilamatepec, Santa Ana, Santa Ana', 12, '65654545-4', '4444-444444-444-4', 'F', '1955-03-28', 1, '2020-03-23', NULL, 1),
	(10, 'Miguel Angel', 'Romero', 'Col. el nazareno, Santa Ana', 12, '99999999-9', '9999-999999-999-9', 'M', '1970-04-15', 1, '2020-03-23', NULL, 1),
	(11, 'Rafael Ernesto', 'Mezquita Aguirre', 'Agua caliente, Chalatenango', 3, '15151515-1', '1515-151515-151-5', 'M', '1948-07-09', 1, '2020-03-25', NULL, 1),
	(12, 'Geraldine Stephannie', 'Mezquita Sosa', 'Col. El Nazareno pol.4 casa #21', 12, '53535353-5', '5353-535353-535-3', 'F', '1993-05-09', 1, '2020-03-25', NULL, 1),
	(13, 'Wilber Alexis', 'Mezquita Sosa', 'Santa Ana', 12, '95959599-5', '9595-959595-959-9', 'M', '1984-07-24', 1, '2020-03-25', NULL, 1),
	(14, 'Juana de Jesus', 'Sosa de Mezquita', 'Santa Ana, Santa Ana', 12, '95959595-9', '9595-959595-959-5', 'F', '1955-06-24', 1, '2020-03-25', NULL, 1),
	(15, 'Rigoberto', 'Gonzales', 'Sonsonate, Sonsonate', 13, '96969696-9', '9696-969696-969-6', 'M', '1971-10-06', 1, '2020-03-25', NULL, 1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.relacion
CREATE TABLE IF NOT EXISTS `relacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuarioRelacion` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla de configuracion de las  relaciones de las personas en los diferentes eventos';

-- Volcando datos para la tabla db_iglesia.relacion: ~6 rows (aproximadamente)
DELETE FROM `relacion`;
/*!40000 ALTER TABLE `relacion` DISABLE KEYS */;
INSERT INTO `relacion` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Padrino', 1, '2020-02-23', NULL, 1),
	(2, 'Madrina', 1, '2020-02-23', NULL, 1),
	(3, 'Novio', 1, '2020-03-04', NULL, 1),
	(4, 'Novia', 1, '2020-03-04', NULL, 1),
	(5, 'Testigo', 1, '2020-03-04', NULL, 1),
	(6, 'Sacramentado', 1, '2020-03-05', NULL, 1);
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.responsable_evento
CREATE TABLE IF NOT EXISTS `responsable_evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_relacion` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `id_padre` int(11) DEFAULT NULL,
  `id_madre` int(11) DEFAULT NULL,
  `id_evento` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_relacion` (`id_relacion`),
  KEY `id_persona` (`id_persona`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_evento` (`id_evento`),
  KEY `FK_responsable_evento_personaPadre` (`id_padre`),
  KEY `FK_responsable_evento_personaMadre` (`id_madre`),
  CONSTRAINT `FK__personaResponsable` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  CONSTRAINT `FK__relacionResponsable` FOREIGN KEY (`id_relacion`) REFERENCES `relacion` (`id`),
  CONSTRAINT `FK__usuarioResponsable` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_responsable_bautizo_evento` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id`),
  CONSTRAINT `FK_responsable_evento_personaMadre` FOREIGN KEY (`id_madre`) REFERENCES `persona` (`id`),
  CONSTRAINT `FK_responsable_evento_personaPadre` FOREIGN KEY (`id_padre`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 COMMENT='Tabla relacion bautizo personas y relacion';

-- Volcando datos para la tabla db_iglesia.responsable_evento: ~9 rows (aproximadamente)
DELETE FROM `responsable_evento`;
/*!40000 ALTER TABLE `responsable_evento` DISABLE KEYS */;
INSERT INTO `responsable_evento` (`id`, `id_relacion`, `id_persona`, `id_padre`, `id_madre`, `id_evento`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 2, 4, NULL, NULL, 1, 1, '2020-03-23', NULL, 1),
	(2, 6, 1, 2, 3, 1, 1, '2020-03-23', NULL, 1),
	(3, 1, 5, NULL, NULL, 1, 1, '2020-03-23', NULL, 1),
	(4, 5, 8, NULL, NULL, 2, 1, '2020-03-23', NULL, 1),
	(5, 5, 9, NULL, NULL, 2, 1, '2020-03-23', NULL, 1),
	(6, 4, 4, 5, 6, 2, 1, '2020-03-23', NULL, 1),
	(7, 3, 1, 2, 3, 2, 1, '2020-03-23', NULL, 1),
	(8, 6, 15, 1, 4, 3, 1, '2020-03-25', NULL, 1),
	(9, 1, 7, NULL, NULL, 3, 1, '2020-03-25', NULL, 1),
	(10, 2, 6, NULL, NULL, 3, 1, '2020-03-25', NULL, 1);
/*!40000 ALTER TABLE `responsable_evento` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.sacerdote
CREATE TABLE IF NOT EXISTS `sacerdote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(75) NOT NULL,
  `apellidos` varchar(75) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `nit` varchar(17) NOT NULL,
  `parroco` tinyint(1) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla para llevar control de sacerdote';

-- Volcando datos para la tabla db_iglesia.sacerdote: ~2 rows (aproximadamente)
DELETE FROM `sacerdote`;
/*!40000 ALTER TABLE `sacerdote` DISABLE KEYS */;
INSERT INTO `sacerdote` (`id`, `nombres`, `apellidos`, `dui`, `nit`, `parroco`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Francisco', 'Barrera Moya', '00188486-3', '0108-290173-101-2', 1, 1, '2020-03-07', NULL, 1),
	(2, 'Predro', 'Aponte', '01485238-6', '1001-010101-010-1', 0, 1, '2020-03-30', NULL, 1);
/*!40000 ALTER TABLE `sacerdote` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.sector
CREATE TABLE IF NOT EXISTS `sector` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__sector_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Tabla de informacion de sectores por la paroquia\r\n';

-- Volcando datos para la tabla db_iglesia.sector: ~3 rows (aproximadamente)
DELETE FROM `sector`;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Sector Uno', 1, '2020-03-01', NULL, 1),
	(2, 'Sector Dos', 1, '2020-03-07', NULL, 1),
	(3, 'Sector Divina Providencia', 1, '2020-03-29', NULL, 1);
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.tipo_sacramentos
CREATE TABLE IF NOT EXISTS `tipo_sacramentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK_tipo_evento_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla catalogo de los diferentes tipos de tipo_sacramentos posibles en la parroquia(bautizo, boda, confirmacion, etc)';

-- Volcando datos para la tabla db_iglesia.tipo_sacramentos: ~3 rows (aproximadamente)
DELETE FROM `tipo_sacramentos`;
/*!40000 ALTER TABLE `tipo_sacramentos` DISABLE KEYS */;
INSERT INTO `tipo_sacramentos` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'BODA', 1, '2020-02-23', NULL, 1),
	(2, 'BAUTIZO', 1, '2020-02-23', NULL, 1),
	(3, 'CONFIRMACION', 1, '2020-02-23', NULL, 1);
/*!40000 ALTER TABLE `tipo_sacramentos` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla para llevar el control de usuario';

-- Volcando datos para la tabla db_iglesia.usuario: ~3 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `usuario`, `clave`, `estado`, `fecha_creacion`, `fecha_actualizacion`) VALUES
	(1, 'wilber', 'mezquita', 'will', '123', 1, '2020-02-23', '0000-00-00'),
	(2, 'juan', 'perez', 'juan', 'juan', 1, '2020-02-09', NULL),
	(3, 'Ronald', 'Mezquita', 'rems', '123', 0, '2020-02-23', NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
