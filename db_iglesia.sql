-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.31-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para db_iglesia
CREATE DATABASE IF NOT EXISTS `db_iglesia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_iglesia`;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabla que contiene la informacion de las comunidades y a que sector pertenese\r\n';

-- Volcando datos para la tabla db_iglesia.comunidad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `comunidad` DISABLE KEYS */;
REPLACE INTO `comunidad` (`id`, `nombre`, `estado`, `id_sector`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Sagrada familia', 1, 1, '2020-03-01', NULL, 1);
/*!40000 ALTER TABLE `comunidad` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.evento
CREATE TABLE IF NOT EXISTS `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_tipo_evento` int(11) NOT NULL,
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
  KEY `id_tipo_evento` (`id_tipo_evento`),
  CONSTRAINT `FK__lugarBoda` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id`),
  CONSTRAINT `FK__sacerdoteBoda` FOREIGN KEY (`id_sacerdote`) REFERENCES `sacerdote` (`id`),
  CONSTRAINT `FK__usuarioBoda` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_evento_tipo_evento` FOREIGN KEY (`id_tipo_evento`) REFERENCES `tipo_evento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla que representa todos los eventos posibles en la parroquia';

-- Volcando datos para la tabla db_iglesia.evento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='tabla justifica que tipo de moviemiento es ';

-- Volcando datos para la tabla db_iglesia.justificacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `justificacion` DISABLE KEYS */;
REPLACE INTO `justificacion` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Colaboracion por Boda', 1, '2020-02-23', NULL, 1),
	(2, 'Colaboracion por Matrimonio', 1, '2020-02-23', NULL, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='tabla llevar control de lugar de locacion';

-- Volcando datos para la tabla db_iglesia.lugar: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
REPLACE INTO `lugar` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Carpinelo', 1, '2020-02-23', NULL, 1),
	(2, 'Valvanera', 1, '2020-02-23', NULL, 1);
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.movimiento
CREATE TABLE IF NOT EXISTS `movimiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla lleva los movimientos de dinero';

-- Volcando datos para la tabla db_iglesia.movimiento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `direccion` varchar(250) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `nit` varchar(17) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuarioPersona` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla lleva los datos de las personas';

-- Volcando datos para la tabla db_iglesia.persona: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
REPLACE INTO `persona` (`id`, `nombres`, `apellidos`, `direccion`, `dui`, `nit`, `fecha_nacimiento`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Juan Javier', 'Perez', 'Col. el Ivu Santa Ana, Santa Ana', '06859832-1', '1020-140586-120-2', '1986-05-14', 1, '2020-02-23', NULL, 1),
	(2, 'Roberto Eduardo', 'Galdamez', 'Lamatepec, Santa Ana, Santa Ana', '06529863-1', '1020-210786-102-1', '1986-07-21', 1, '2020-02-23', NULL, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='tabla lleva la relacion de las personas';

-- Volcando datos para la tabla db_iglesia.relacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `relacion` DISABLE KEYS */;
REPLACE INTO `relacion` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Padre', 1, '2020-02-23', NULL, 1),
	(2, 'Madre', 1, '2020-02-23', NULL, 1);
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.responsable_evento
CREATE TABLE IF NOT EXISTS `responsable_evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_relacion` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
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
  CONSTRAINT `FK__personaResponsable` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  CONSTRAINT `FK__relacionResponsable` FOREIGN KEY (`id_relacion`) REFERENCES `relacion` (`id`),
  CONSTRAINT `FK__usuarioResponsable` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_responsable_bautizo_evento` FOREIGN KEY (`id_evento`) REFERENCES `evento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla relacion bautizo personas y relacion';

-- Volcando datos para la tabla db_iglesia.responsable_evento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `responsable_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable_evento` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.sacerdote
CREATE TABLE IF NOT EXISTS `sacerdote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(75) NOT NULL,
  `apellidos` varchar(75) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `nit` varchar(17) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='tabla para llevar control de sacerdote';

-- Volcando datos para la tabla db_iglesia.sacerdote: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `sacerdote` DISABLE KEYS */;
REPLACE INTO `sacerdote` (`id`, `nombres`, `apellidos`, `dui`, `nit`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Oscar', 'Romero', '01485238-6', '1001-010101-010-1', 1, '2020-03-01', NULL, 1),
	(2, 'Predro', 'Aponte', '01485238-6', '1001-010101-010-1', 1, '2020-03-01', NULL, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabla de informacion de sectores por la paroquia\r\n';

-- Volcando datos para la tabla db_iglesia.sector: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
REPLACE INTO `sector` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Sector Uno', 1, '2020-03-01', NULL, 1);
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.tipo_evento
CREATE TABLE IF NOT EXISTS `tipo_evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK_tipo_evento_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='Tabla catalogo de los diferentes tipos de eventos posibles en la parroquia(bautizo, boda, confirmacion, etc)';

-- Volcando datos para la tabla db_iglesia.tipo_evento: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_evento` DISABLE KEYS */;
REPLACE INTO `tipo_evento` (`id`, `nombre`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'BODA', 1, '2020-02-23', NULL, 1),
	(2, 'BAUTIZO', 1, '2020-02-23', NULL, 1),
	(3, 'CONFIRMACION', 1, '2020-02-23', NULL, 1);
/*!40000 ALTER TABLE `tipo_evento` ENABLE KEYS */;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='tabla para llevar el control de usuario';

-- Volcando datos para la tabla db_iglesia.usuario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
REPLACE INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `usuario`, `clave`, `estado`, `fecha_creacion`, `fecha_actualizacion`) VALUES
	(1, 'wilber', 'mezquita', 'will', '123', 1, '2020-02-23', '0000-00-00'),
	(2, 'juan', 'perez', 'juan', 'juan', 1, '2020-02-09', NULL),
	(3, 'Ronald', 'Mezquita', 'rems', '123', 0, '2020-02-23', NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
