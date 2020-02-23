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

-- Volcando datos para la tabla db_iglesia.evento: ~0 rows (aproximadamente)
DELETE FROM `evento`;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.justificacion: ~0 rows (aproximadamente)
DELETE FROM `justificacion`;
/*!40000 ALTER TABLE `justificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `justificacion` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.lugar: ~0 rows (aproximadamente)
DELETE FROM `lugar`;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.movimiento: ~0 rows (aproximadamente)
DELETE FROM `movimiento`;
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.persona: ~2 rows (aproximadamente)
DELETE FROM `persona`;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` (`id`, `nombres`, `apellidos`, `direccion`, `dui`, `nit`, `fecha_nacimiento`, `estado`, `fecha_creacion`, `fecha_actualizacion`, `id_usuario`) VALUES
	(1, 'Juan Javier', 'Perez', 'Col. el Ivu Santa Ana, Santa Ana', '06859832-1', '1020-140586-120-2', '1986-05-14', 1, '2020-02-23', NULL, 1),
	(2, 'Roberto Eduardo', 'Galdamez', 'Lamatepec, Santa Ana, Santa Ana', '06529863-1', '1020-210786-102-1', '1986-07-21', 1, '2020-02-23', NULL, 1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.relacion: ~0 rows (aproximadamente)
DELETE FROM `relacion`;
/*!40000 ALTER TABLE `relacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.responsable_evento: ~0 rows (aproximadamente)
DELETE FROM `responsable_evento`;
/*!40000 ALTER TABLE `responsable_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable_evento` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.sacerdote: ~0 rows (aproximadamente)
DELETE FROM `sacerdote`;
/*!40000 ALTER TABLE `sacerdote` DISABLE KEYS */;
/*!40000 ALTER TABLE `sacerdote` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.tipo_evento: ~0 rows (aproximadamente)
DELETE FROM `tipo_evento`;
/*!40000 ALTER TABLE `tipo_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_evento` ENABLE KEYS */;

-- Volcando datos para la tabla db_iglesia.usuario: ~3 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `usuario`, `clave`, `estado`, `fecha_creacion`, `fecha_actualizacion`) VALUES
	(1, 'wilber', 'mezquita', 'will', '1234', 0, '2020-02-02', '0000-00-00'),
	(2, 'juan', 'perez', 'juan', 'juan', 1, '2020-02-09', NULL),
	(3, 'Ronald', 'Mezquita', 'rems', '1234', 1, '2020-02-16', NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
