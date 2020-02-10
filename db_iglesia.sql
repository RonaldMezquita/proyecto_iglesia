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


-- Volcando estructura de base de datos para db_iglesia
CREATE DATABASE IF NOT EXISTS `db_iglesia` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_iglesia`;

-- Volcando estructura para tabla db_iglesia.bautizo
CREATE TABLE IF NOT EXISTS `bautizo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
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
  CONSTRAINT `FK__lugarBautizo` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id`),
  CONSTRAINT `FK__sacerdoteBautizo` FOREIGN KEY (`id_sacerdote`) REFERENCES `sacerdote` (`id`),
  CONSTRAINT `FK__usuarioBautizo` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla lleve informacion de bautizo';

-- Volcando datos para la tabla db_iglesia.bautizo: ~0 rows (aproximadamente)
DELETE FROM `bautizo`;
/*!40000 ALTER TABLE `bautizo` DISABLE KEYS */;
/*!40000 ALTER TABLE `bautizo` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.boda
CREATE TABLE IF NOT EXISTS `boda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
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
  CONSTRAINT `FK__lugarBoda` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id`),
  CONSTRAINT `FK__sacerdoteBoda` FOREIGN KEY (`id_sacerdote`) REFERENCES `sacerdote` (`id`),
  CONSTRAINT `FK__usuarioBoda` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla con informacion relevante a la boda';

-- Volcando datos para la tabla db_iglesia.boda: ~0 rows (aproximadamente)
DELETE FROM `boda`;
/*!40000 ALTER TABLE `boda` DISABLE KEYS */;
/*!40000 ALTER TABLE `boda` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.justificacion
CREATE TABLE IF NOT EXISTS `justificacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuarioJustificacion` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla justifica que tipo de moviemiento es ';

-- Volcando datos para la tabla db_iglesia.justificacion: ~0 rows (aproximadamente)
DELETE FROM `justificacion`;
/*!40000 ALTER TABLE `justificacion` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla llevar control de lugar de locacion';

-- Volcando datos para la tabla db_iglesia.lugar: ~0 rows (aproximadamente)
DELETE FROM `lugar`;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.movimiento
CREATE TABLE IF NOT EXISTS `movimiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monto` double NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `id_bautizo` int(11) NOT NULL,
  `id_justificacion` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_bautizo` (`id_bautizo`),
  KEY `id_justificacion` (`id_justificacion`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__bautizoMovimiento` FOREIGN KEY (`id_bautizo`) REFERENCES `bautizo` (`id`),
  CONSTRAINT `FK__justificacionMovimiento` FOREIGN KEY (`id_justificacion`) REFERENCES `justificacion` (`id`),
  CONSTRAINT `FK__usuarioMovimiento` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla lleva los movimientos de dinero';

-- Volcando datos para la tabla db_iglesia.movimiento: ~0 rows (aproximadamente)
DELETE FROM `movimiento`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla lleva los datos de las personas';

-- Volcando datos para la tabla db_iglesia.persona: ~0 rows (aproximadamente)
DELETE FROM `persona`;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla lleva la relacion de las personas';

-- Volcando datos para la tabla db_iglesia.relacion: ~0 rows (aproximadamente)
DELETE FROM `relacion`;
/*!40000 ALTER TABLE `relacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.responsable_bautizo
CREATE TABLE IF NOT EXISTS `responsable_bautizo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_relacion` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `id_bautizo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_relacion` (`id_relacion`),
  KEY `id_persona` (`id_persona`),
  KEY `id_bautizo` (`id_bautizo`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__bautizoResponsable` FOREIGN KEY (`id_bautizo`) REFERENCES `bautizo` (`id`),
  CONSTRAINT `FK__personaResponsable` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  CONSTRAINT `FK__relacionResponsable` FOREIGN KEY (`id_relacion`) REFERENCES `relacion` (`id`),
  CONSTRAINT `FK__usuarioResponsable` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla relacion bautizo personas y relacion';

-- Volcando datos para la tabla db_iglesia.responsable_bautizo: ~0 rows (aproximadamente)
DELETE FROM `responsable_bautizo`;
/*!40000 ALTER TABLE `responsable_bautizo` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable_bautizo` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.responsable_boda
CREATE TABLE IF NOT EXISTS `responsable_boda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_relacion` int(11) NOT NULL,
  `id_persona` int(11) NOT NULL,
  `id_boda` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_relacion` (`id_relacion`),
  KEY `id_persona` (`id_persona`),
  KEY `id_boda` (`id_boda`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__bodaResponsable` FOREIGN KEY (`id_boda`) REFERENCES `boda` (`id`),
  CONSTRAINT `FK__personaResponsableBoda` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  CONSTRAINT `FK__relacionResponsableBoda` FOREIGN KEY (`id_relacion`) REFERENCES `relacion` (`id`),
  CONSTRAINT `FK__usuarioResponsableBoda` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='tabla con informacion relevante a la persona responsable de la boda como personas en boda';

-- Volcando datos para la tabla db_iglesia.responsable_boda: ~0 rows (aproximadamente)
DELETE FROM `responsable_boda`;
/*!40000 ALTER TABLE `responsable_boda` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable_boda` ENABLE KEYS */;

-- Volcando estructura para tabla db_iglesia.sacerdote
CREATE TABLE IF NOT EXISTS `sacerdote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(75) NOT NULL,
  `apellidos` varchar(75) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_actualizacion` date DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `FK__usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabla para llevar control de sacerdote';

-- Volcando datos para la tabla db_iglesia.sacerdote: ~0 rows (aproximadamente)
DELETE FROM `sacerdote`;
/*!40000 ALTER TABLE `sacerdote` DISABLE KEYS */;
/*!40000 ALTER TABLE `sacerdote` ENABLE KEYS */;

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

-- Volcando datos para la tabla db_iglesia.usuario: ~1 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `usuario`, `clave`, `estado`, `fecha_creacion`, `fecha_actualizacion`) VALUES
	(1, 'wilber', 'mezquita', 'will', '1234', 0, '2020-02-02', '0000-00-00'),
	(2, 'juan', 'perez', 'juan', 'juan', 1, '2020-02-09', NULL),
	(3, 'Ronald', 'Mezquita', 'rems', '1234', 0, '2020-02-09', NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
