/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.11-MariaDB : Database - db_ejemplo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_ejemplo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `db_ejemplo`;

/*Table structure for table `administrador` */

DROP TABLE IF EXISTS `administrador`;

CREATE TABLE `administrador` (
  `cod_admin` int(3) NOT NULL AUTO_INCREMENT,
  `em_admin` varchar(30) NOT NULL,
  `pass_admin` varchar(35) NOT NULL,
  `cod_usu` int(1) NOT NULL,
  PRIMARY KEY (`cod_admin`),
  KEY `cod_usu` (`cod_usu`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`cod_usu`) REFERENCES `usuarios` (`cod_usu`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `administrador` */

insert  into `administrador`(`cod_admin`,`em_admin`,`pass_admin`,`cod_usu`) values (1,'Admin@gmail.com','123',5),(6,'J.Escobar02@Administracion.cl','JuanEs123',16);

/*Table structure for table `autores` */

DROP TABLE IF EXISTS `autores`;

CREATE TABLE `autores` (
  `cod_autor` int(4) NOT NULL AUTO_INCREMENT,
  `nom_autor` varchar(128) NOT NULL,
  `pseu_autor` varchar(64) DEFAULT NULL,
  `fec_naci` varchar(10) DEFAULT NULL,
  `fec_def` varchar(10) DEFAULT NULL,
  `cod_nac` int(4) NOT NULL,
  PRIMARY KEY (`cod_autor`),
  KEY `cod_nac` (`cod_nac`),
  CONSTRAINT `autores_ibfk_1` FOREIGN KEY (`cod_nac`) REFERENCES `nacionalidades` (`cod_nac`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

/*Data for the table `autores` */

insert  into `autores`(`cod_autor`,`nom_autor`,`pseu_autor`,`fec_naci`,`fec_def`,`cod_nac`) values (4,'Carlos','Segundo',NULL,NULL,3),(10,'Matta Editado','Matta Pseudonimo','1490-05-02','1520-04-01',2),(11,'Autor3','Pseu 3','','',2);

/*Table structure for table `detalle_prestamo` */

DROP TABLE IF EXISTS `detalle_prestamo`;

CREATE TABLE `detalle_prestamo` (
  `cod_detallep` int(9) NOT NULL AUTO_INCREMENT,
  `obser_detallep` varchar(512) NOT NULL,
  `cod_prestamo` int(5) NOT NULL,
  `cod_obra` int(5) NOT NULL,
  PRIMARY KEY (`cod_detallep`),
  KEY `cod_prestamo` (`cod_prestamo`),
  KEY `cod_obra` (`cod_obra`),
  CONSTRAINT `detalle_prestamo_ibfk_1` FOREIGN KEY (`cod_prestamo`) REFERENCES `prestamos` (`cod_prestamo`),
  CONSTRAINT `detalle_prestamo_ibfk_2` FOREIGN KEY (`cod_obra`) REFERENCES `obradearte` (`cod_obra`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `detalle_prestamo` */

insert  into `detalle_prestamo`(`cod_detallep`,`obser_detallep`,`cod_prestamo`,`cod_obra`) values (8,'Observacion de Ejemplo ',5,6);

/*Table structure for table `devoluciones` */

DROP TABLE IF EXISTS `devoluciones`;

CREATE TABLE `devoluciones` (
  `cod_devolucion` int(8) NOT NULL AUTO_INCREMENT,
  `fec_devolucion` date NOT NULL,
  `docs_devolucion` varchar(1024) NOT NULL,
  `comen_devolucion` varchar(1024) NOT NULL,
  `cod_prestamo` int(8) NOT NULL,
  PRIMARY KEY (`cod_devolucion`),
  KEY `cod_prestamo` (`cod_prestamo`),
  CONSTRAINT `devoluciones_ibfk_1` FOREIGN KEY (`cod_prestamo`) REFERENCES `prestamos` (`cod_prestamo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `devoluciones` */

insert  into `devoluciones`(`cod_devolucion`,`fec_devolucion`,`docs_devolucion`,`comen_devolucion`,`cod_prestamo`) values (4,'2020-06-01','Documentos Devolucion 1','Comentarios de Ejemplo',3),(5,'2020-06-10','Documentos Devolucion 2','Comentarios de ejemplo 2',3);

/*Table structure for table `devolucionseguro` */

DROP TABLE IF EXISTS `devolucionseguro`;

CREATE TABLE `devolucionseguro` (
  `cod_devoseg` int(8) NOT NULL AUTO_INCREMENT,
  `cod_devolucion` int(8) NOT NULL,
  `cod_segurodev` int(8) DEFAULT NULL,
  PRIMARY KEY (`cod_devoseg`),
  KEY `cod_segurodev` (`cod_segurodev`),
  KEY `cod_devolucion` (`cod_devolucion`),
  CONSTRAINT `devolucionseguro_ibfk_1` FOREIGN KEY (`cod_segurodev`) REFERENCES `segurosdevo` (`cod_segurodev`),
  CONSTRAINT `devolucionseguro_ibfk_2` FOREIGN KEY (`cod_devolucion`) REFERENCES `devoluciones` (`cod_devolucion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `devolucionseguro` */

insert  into `devolucionseguro`(`cod_devoseg`,`cod_devolucion`,`cod_segurodev`) values (3,5,1);

/*Table structure for table `especialidades` */

DROP TABLE IF EXISTS `especialidades`;

CREATE TABLE `especialidades` (
  `cod_especialidad` int(3) NOT NULL AUTO_INCREMENT,
  `nom_especialidad` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `especialidades` */

insert  into `especialidades`(`cod_especialidad`,`nom_especialidad`) values (1,'Restaurador'),(2,'Guia Turistico');

/*Table structure for table `especialidadusuario` */

DROP TABLE IF EXISTS `especialidadusuario`;

CREATE TABLE `especialidadusuario` (
  `cod_eu` int(5) NOT NULL AUTO_INCREMENT,
  `cod_usu` int(5) NOT NULL,
  `cod_especialidad` int(3) NOT NULL,
  PRIMARY KEY (`cod_eu`),
  KEY `cod_usu` (`cod_usu`),
  KEY `cod_especialidad` (`cod_especialidad`),
  CONSTRAINT `especialidadusuario_ibfk_1` FOREIGN KEY (`cod_usu`) REFERENCES `usuarios` (`cod_usu`),
  CONSTRAINT `especialidadusuario_ibfk_2` FOREIGN KEY (`cod_especialidad`) REFERENCES `especialidades` (`cod_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `especialidadusuario` */

insert  into `especialidadusuario`(`cod_eu`,`cod_usu`,`cod_especialidad`) values (1,39,1);

/*Table structure for table `estadoprestamo` */

DROP TABLE IF EXISTS `estadoprestamo`;

CREATE TABLE `estadoprestamo` (
  `cod_estadop` int(2) NOT NULL AUTO_INCREMENT,
  `nom_estadop` varchar(64) NOT NULL,
  PRIMARY KEY (`cod_estadop`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `estadoprestamo` */

insert  into `estadoprestamo`(`cod_estadop`,`nom_estadop`) values (1,'Aprobado'),(2,'Denegado'),(3,'En proceso');

/*Table structure for table `estadorestauracion` */

DROP TABLE IF EXISTS `estadorestauracion`;

CREATE TABLE `estadorestauracion` (
  `cod_estado` int(1) NOT NULL AUTO_INCREMENT,
  `nom_estado` varchar(128) NOT NULL,
  PRIMARY KEY (`cod_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `estadorestauracion` */

insert  into `estadorestauracion`(`cod_estado`,`nom_estado`) values (1,'Aprobada'),(2,'Denegada'),(3,'En Espera');

/*Table structure for table `evento` */

DROP TABLE IF EXISTS `evento`;

CREATE TABLE `evento` (
  `cod_ev` int(3) NOT NULL AUTO_INCREMENT,
  `nom_ev` varchar(30) NOT NULL,
  `fec_ini` date NOT NULL,
  `fec_fin` date NOT NULL,
  `cod_gal` int(3) NOT NULL,
  `cod_tev` int(2) NOT NULL,
  PRIMARY KEY (`cod_ev`),
  KEY `cod_texpo` (`cod_tev`),
  KEY `cod_gal` (`cod_gal`),
  CONSTRAINT `evento_ibfk_2` FOREIGN KEY (`cod_tev`) REFERENCES `tipoevento` (`cod_tev`),
  CONSTRAINT `evento_ibfk_3` FOREIGN KEY (`cod_gal`) REFERENCES `galerias` (`cod_gal`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `evento` */

insert  into `evento`(`cod_ev`,`nom_ev`,`fec_ini`,`fec_fin`,`cod_gal`,`cod_tev`) values (1,'Tributo a Star Wars Clone Wars','2020-05-07','2020-05-30',21,2),(3,'Tributo a Lolito','2020-05-05','2020-06-07',15,2),(5,'Evento Ejemplo','2020-05-05','2020-05-19',21,2),(7,'Tributo a John Williams','2020-05-19','2020-05-21',8,1);

/*Table structure for table `galeria_obra` */

DROP TABLE IF EXISTS `galeria_obra`;

CREATE TABLE `galeria_obra` (
  `cod_galob` int(6) NOT NULL AUTO_INCREMENT,
  `cod_gal` int(6) NOT NULL,
  `cod_ob` int(6) NOT NULL,
  PRIMARY KEY (`cod_galob`),
  KEY `cod_gal` (`cod_gal`),
  KEY `cod_ob` (`cod_ob`),
  CONSTRAINT `galeria_obra_ibfk_1` FOREIGN KEY (`cod_gal`) REFERENCES `galerias` (`cod_gal`),
  CONSTRAINT `galeria_obra_ibfk_2` FOREIGN KEY (`cod_ob`) REFERENCES `obradearte` (`cod_obra`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `galeria_obra` */

insert  into `galeria_obra`(`cod_galob`,`cod_gal`,`cod_ob`) values (5,15,4),(6,21,6),(7,21,6);

/*Table structure for table `galerias` */

DROP TABLE IF EXISTS `galerias`;

CREATE TABLE `galerias` (
  `cod_gal` int(9) NOT NULL AUTO_INCREMENT,
  `nom_gal` varchar(25) NOT NULL,
  `cod_ubi` int(3) NOT NULL,
  PRIMARY KEY (`cod_gal`),
  KEY `cod_ubi` (`cod_ubi`),
  CONSTRAINT `galerias_ibfk_1` FOREIGN KEY (`cod_ubi`) REFERENCES `ubicacion` (`cod_ubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

/*Data for the table `galerias` */

insert  into `galerias`(`cod_gal`,`nom_gal`,`cod_ubi`) values (8,'Obras Publicas',5),(15,'Literatura',5),(21,'Pinturas',7);

/*Table structure for table `museos` */

DROP TABLE IF EXISTS `museos`;

CREATE TABLE `museos` (
  `cod_museo` int(5) NOT NULL AUTO_INCREMENT,
  `nom_museo` varchar(256) NOT NULL,
  `dir_museo` varchar(256) NOT NULL,
  `contac_museo` varchar(256) NOT NULL,
  `cod_paism` int(3) NOT NULL,
  PRIMARY KEY (`cod_museo`),
  KEY `cod_paism` (`cod_paism`),
  CONSTRAINT `museos_ibfk_1` FOREIGN KEY (`cod_paism`) REFERENCES `paism` (`cod_paism`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `museos` */

insert  into `museos`(`cod_museo`,`nom_museo`,`dir_museo`,`contac_museo`,`cod_paism`) values (1,'Bellas Artes','Providencia #236, Santiago','BellasArtes@gob.Santiago.cl',81);

/*Table structure for table `nacionalidades` */

DROP TABLE IF EXISTS `nacionalidades`;

CREATE TABLE `nacionalidades` (
  `cod_nac` int(3) NOT NULL AUTO_INCREMENT,
  `desc_nac` varchar(64) NOT NULL,
  `cod_pais` int(3) NOT NULL,
  PRIMARY KEY (`cod_nac`),
  KEY `cod_pais` (`cod_pais`),
  CONSTRAINT `nacionalidades_ibfk_1` FOREIGN KEY (`cod_pais`) REFERENCES `pais` (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `nacionalidades` */

insert  into `nacionalidades`(`cod_nac`,`desc_nac`,`cod_pais`) values (2,'Sueco',3),(3,'Chileno',2),(9,'Chileno',6),(12,'DXDXDXDXD',6),(14,'Aleman',4);

/*Table structure for table `obradearte` */

DROP TABLE IF EXISTS `obradearte`;

CREATE TABLE `obradearte` (
  `cod_obra` int(4) NOT NULL AUTO_INCREMENT,
  `tit_obra` varchar(128) NOT NULL,
  `fcrea_obra` varchar(12) NOT NULL,
  `fing_obra` varchar(12) NOT NULL,
  `cod_autor` int(8) NOT NULL,
  `cod_tipo` int(2) NOT NULL,
  PRIMARY KEY (`cod_obra`),
  KEY `cod_autor` (`cod_autor`),
  KEY `cod_tipo` (`cod_tipo`),
  CONSTRAINT `obradearte_ibfk_1` FOREIGN KEY (`cod_autor`) REFERENCES `autores` (`cod_autor`),
  CONSTRAINT `obradearte_ibfk_2` FOREIGN KEY (`cod_tipo`) REFERENCES `tipodeobra` (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `obradearte` */

insert  into `obradearte`(`cod_obra`,`tit_obra`,`fcrea_obra`,`fing_obra`,`cod_autor`,`cod_tipo`) values (1,'La Mona Aspera','1500-01-09','2001-12-03',11,3),(4,'La suerte del Carlos','2019-03-09','2020-02-05',4,2),(6,'El ingenierio Triste Llorando por un 7','2019-03-09','2020-05-04',4,2);

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `cod_pais` int(3) NOT NULL AUTO_INCREMENT,
  `nom_pais` varchar(64) NOT NULL,
  PRIMARY KEY (`cod_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pais` */

insert  into `pais`(`cod_pais`,`nom_pais`) values (2,'Chile'),(3,'Argentina'),(4,'Suecia'),(6,'Nueva Zelanda');

/*Table structure for table `paism` */

DROP TABLE IF EXISTS `paism`;

CREATE TABLE `paism` (
  `cod_paism` int(3) NOT NULL AUTO_INCREMENT,
  `nom_paism` varchar(128) NOT NULL,
  PRIMARY KEY (`cod_paism`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4;

/*Data for the table `paism` */

insert  into `paism`(`cod_paism`,`nom_paism`) values (1,'Australia'),(2,'Austria'),(3,'Azerbaiyán'),(4,'Anguilla'),(5,'Argentina'),(6,'Armenia'),(7,'Bielorrusia'),(8,'Belice'),(9,'Bélgica'),(10,'Bermudas'),(11,'Bulgaria'),(12,'Brasil'),(13,'Reino Unido'),(14,'Hungría'),(15,'Vietnam'),(16,'Haiti'),(17,'Guadalupe'),(18,'Alemania'),(19,'Países Bajos, Holanda'),(20,'Grecia'),(21,'Georgia'),(22,'Dinamarca'),(23,'Egipto'),(24,'Israel'),(25,'India'),(26,'Irán'),(27,'Irlanda'),(28,'España'),(29,'Italia'),(30,'Kazajstán'),(31,'Camerún'),(32,'Canadá'),(33,'Chipre'),(34,'Kirguistán'),(35,'China'),(36,'Costa Rica'),(37,'Kuwait'),(38,'Letonia'),(39,'Libia'),(40,'Lituania'),(41,'Luxemburgo'),(42,'México'),(43,'Moldavia'),(44,'Mónaco'),(45,'Nueva Zelanda'),(46,'Noruega'),(47,'Polonia'),(48,'Portugal'),(49,'Reunión'),(50,'Rusia'),(51,'El Salvador'),(52,'Eslovaquia'),(53,'Eslovenia'),(54,'Surinam'),(55,'Estados Unidos'),(56,'Tadjikistan'),(57,'Turkmenistan'),(58,'Islas Turcas y Caicos'),(59,'Turquía'),(60,'Uganda'),(61,'Uzbekistán'),(62,'Ucrania'),(63,'Finlandia'),(64,'Francia'),(65,'República Checa'),(66,'Suiza'),(67,'Suecia'),(68,'Estonia'),(69,'Corea del Sur'),(70,'Japón'),(71,'Croacia'),(72,'Rumanía'),(73,'Hong Kong'),(74,'Indonesia'),(75,'Jordania'),(76,'Malasia'),(77,'Singapur'),(78,'Taiwan'),(79,'Bosnia y Herzegovina'),(80,'Bahamas'),(81,'Chile'),(82,'Colombia'),(83,'Islandia'),(84,'Corea del Norte'),(85,'Macedonia'),(86,'Malta'),(87,'Pakistán'),(88,'Papúa-Nueva Guinea'),(89,'Perú'),(90,'Filipinas'),(91,'Arabia Saudita'),(92,'Tailandia'),(93,'Emiratos árabes Unidos'),(94,'Groenlandia'),(95,'Venezuela'),(96,'Zimbabwe'),(97,'Kenia'),(98,'Algeria'),(99,'Líbano'),(100,'Botsuana'),(101,'Tanzania'),(102,'Namibia'),(103,'Ecuador'),(104,'Marruecos'),(105,'Ghana'),(106,'Siria'),(107,'Nepal'),(108,'Mauritania'),(109,'Seychelles'),(110,'Paraguay'),(111,'Uruguay'),(112,'Congo (Brazzaville)'),(113,'Cuba'),(114,'Albania'),(115,'Nigeria'),(116,'Zambia'),(117,'Mozambique'),(119,'Angola'),(120,'Sri Lanka'),(121,'Etiopía'),(122,'Túnez'),(123,'Bolivia'),(124,'Panamá'),(125,'Malawi'),(126,'Liechtenstein'),(127,'Bahrein'),(128,'Barbados'),(130,'Chad'),(131,'Man, Isla de'),(132,'Jamaica'),(133,'Malí'),(134,'Madagascar'),(135,'Senegal'),(136,'Togo'),(137,'Honduras'),(138,'República Dominicana'),(139,'Mongolia'),(140,'Irak'),(141,'Sudáfrica'),(142,'Aruba'),(143,'Gibraltar'),(144,'Afganistán'),(145,'Andorra'),(147,'Antigua y Barbuda'),(149,'Bangladesh'),(151,'Benín'),(152,'Bután'),(154,'Islas Virgenes Británicas'),(155,'Brunéi'),(156,'Burkina Faso'),(157,'Burundi'),(158,'Camboya'),(159,'Cabo Verde'),(164,'Comores'),(165,'Congo (Kinshasa)'),(166,'Cook, Islas'),(168,'Costa de Marfil'),(169,'Djibouti, Yibuti'),(171,'Timor Oriental'),(172,'Guinea Ecuatorial'),(173,'Eritrea'),(175,'Feroe, Islas'),(176,'Fiyi'),(178,'Polinesia Francesa'),(180,'Gabón'),(181,'Gambia'),(184,'Granada'),(185,'Guatemala'),(186,'Guernsey'),(187,'Guinea'),(188,'Guinea-Bissau'),(189,'Guyana'),(193,'Jersey'),(195,'Kiribati'),(196,'Laos'),(197,'Lesotho'),(198,'Liberia'),(200,'Maldivas'),(201,'Martinica'),(202,'Mauricio'),(205,'Myanmar'),(206,'Nauru'),(207,'Antillas Holandesas'),(208,'Nueva Caledonia'),(209,'Nicaragua'),(210,'Níger'),(212,'Norfolk Island'),(213,'Omán'),(215,'Isla Pitcairn'),(216,'Qatar'),(217,'Ruanda'),(218,'Santa Elena'),(219,'San Cristobal y Nevis'),(220,'Santa Lucía'),(221,'San Pedro y Miquelón'),(222,'San Vincente y Granadinas'),(223,'Samoa'),(224,'San Marino'),(225,'San Tomé y Príncipe'),(226,'Serbia y Montenegro'),(227,'Sierra Leona'),(228,'Islas Salomón'),(229,'Somalia'),(232,'Sudán'),(234,'Swazilandia'),(235,'Tokelau'),(236,'Tonga'),(237,'Trinidad y Tobago'),(239,'Tuvalu'),(240,'Vanuatu'),(241,'Wallis y Futuna'),(242,'Sáhara Occidental'),(243,'Yemen'),(246,'Puerto Rico');

/*Table structure for table `prestamos` */

DROP TABLE IF EXISTS `prestamos`;

CREATE TABLE `prestamos` (
  `cod_prestamo` int(5) NOT NULL AUTO_INCREMENT,
  `fec_prestamo` date NOT NULL,
  `comen_prestamo` varchar(4096) NOT NULL,
  `costo_asociado` int(11) NOT NULL,
  `cod_museo` int(5) NOT NULL,
  `cod_estadop` int(2) NOT NULL,
  PRIMARY KEY (`cod_prestamo`),
  KEY `cod_museo` (`cod_museo`),
  KEY `cod_estadop` (`cod_estadop`),
  CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`cod_museo`) REFERENCES `museos` (`cod_museo`),
  CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`cod_estadop`) REFERENCES `estadoprestamo` (`cod_estadop`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `prestamos` */

insert  into `prestamos`(`cod_prestamo`,`fec_prestamo`,`comen_prestamo`,`costo_asociado`,`cod_museo`,`cod_estadop`) values (3,'2020-05-06','Comentario de Ejemplo Editado',148520000,1,2),(4,'2020-05-07','Comentario de Ejemplo 2',12300000,1,3),(5,'2021-06-05','Comentario de Ejemplo',14000000,1,1);

/*Table structure for table `prestamoseguro` */

DROP TABLE IF EXISTS `prestamoseguro`;

CREATE TABLE `prestamoseguro` (
  `cod_preseg` int(8) NOT NULL AUTO_INCREMENT,
  `cod_prestamo` int(8) NOT NULL,
  `cod_seguro` int(8) NOT NULL,
  PRIMARY KEY (`cod_preseg`),
  KEY `cod_prestamo` (`cod_prestamo`),
  KEY `cod_seguro` (`cod_seguro`),
  CONSTRAINT `prestamoseguro_ibfk_1` FOREIGN KEY (`cod_prestamo`) REFERENCES `prestamos` (`cod_prestamo`),
  CONSTRAINT `prestamoseguro_ibfk_2` FOREIGN KEY (`cod_seguro`) REFERENCES `seguros` (`cod_seguro`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

/*Data for the table `prestamoseguro` */

insert  into `prestamoseguro`(`cod_preseg`,`cod_prestamo`,`cod_seguro`) values (11,3,1),(12,3,2);

/*Table structure for table `restauracionobra` */

DROP TABLE IF EXISTS `restauracionobra`;

CREATE TABLE `restauracionobra` (
  `cod_restauracion` int(5) NOT NULL AUTO_INCREMENT,
  `fecha_progra` date NOT NULL,
  `fecha_estimada` date NOT NULL,
  `cod_obra` int(5) NOT NULL,
  `cod_eu` int(2) NOT NULL,
  `cod_estado` int(1) NOT NULL,
  PRIMARY KEY (`cod_restauracion`),
  KEY `cod_obra` (`cod_obra`),
  KEY `cod_estado` (`cod_estado`),
  KEY `cod_eu` (`cod_eu`),
  CONSTRAINT `restauracionobra_ibfk_2` FOREIGN KEY (`cod_obra`) REFERENCES `obradearte` (`cod_obra`),
  CONSTRAINT `restauracionobra_ibfk_3` FOREIGN KEY (`cod_estado`) REFERENCES `estadorestauracion` (`cod_estado`),
  CONSTRAINT `restauracionobra_ibfk_4` FOREIGN KEY (`cod_eu`) REFERENCES `especialidadusuario` (`cod_eu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `restauracionobra` */

insert  into `restauracionobra`(`cod_restauracion`,`fecha_progra`,`fecha_estimada`,`cod_obra`,`cod_eu`,`cod_estado`) values (1,'2020-06-02','2020-06-03',6,1,1);

/*Table structure for table `rol` */

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `rol_cod` int(2) NOT NULL AUTO_INCREMENT,
  `rol_nom` varchar(50) NOT NULL,
  PRIMARY KEY (`rol_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

/*Data for the table `rol` */

insert  into `rol`(`rol_cod`,`rol_nom`) values (9,'Acceso a la Plataforma'),(10,'Usuario'),(13,'Guia Turistico'),(16,'Administrador'),(19,'Catalogo y Mantencion'),(20,'Prestamos y Devoluciones'),(21,'Restaurador');

/*Table structure for table `seguros` */

DROP TABLE IF EXISTS `seguros`;

CREATE TABLE `seguros` (
  `cod_seguro` int(8) NOT NULL AUTO_INCREMENT,
  `desc_seguro` varchar(1024) NOT NULL,
  `fec_seguro` date NOT NULL,
  `monto_seguro` int(11) NOT NULL,
  PRIMARY KEY (`cod_seguro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `seguros` */

insert  into `seguros`(`cod_seguro`,`desc_seguro`,`fec_seguro`,`monto_seguro`) values (1,'Seguro para deterioro','2020-06-07',1250000),(2,'Seguro para accidentes hacia museo destino','2023-06-03',45000000);

/*Table structure for table `segurosdevo` */

DROP TABLE IF EXISTS `segurosdevo`;

CREATE TABLE `segurosdevo` (
  `cod_segurodev` int(8) NOT NULL AUTO_INCREMENT,
  `desc_segurodev` varchar(1024) NOT NULL,
  `fec_segurodev` date NOT NULL,
  `monto_segurodev` int(11) NOT NULL,
  PRIMARY KEY (`cod_segurodev`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `segurosdevo` */

insert  into `segurosdevo`(`cod_segurodev`,`desc_segurodev`,`fec_segurodev`,`monto_segurodev`) values (1,'Descripcion Seguro Devolucion 1','2020-06-03',12000000);

/*Table structure for table `tipodeobra` */

DROP TABLE IF EXISTS `tipodeobra`;

CREATE TABLE `tipodeobra` (
  `cod_tipo` int(2) NOT NULL AUTO_INCREMENT,
  `nom_tipo` varchar(64) NOT NULL,
  PRIMARY KEY (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipodeobra` */

insert  into `tipodeobra`(`cod_tipo`,`nom_tipo`) values (1,'Libro'),(2,'Escultura'),(3,'Pintura2'),(8,'asdasd');

/*Table structure for table `tipoevento` */

DROP TABLE IF EXISTS `tipoevento`;

CREATE TABLE `tipoevento` (
  `cod_tev` int(3) NOT NULL AUTO_INCREMENT,
  `nom_tev` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_tev`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipoevento` */

insert  into `tipoevento`(`cod_tev`,`nom_tev`) values (1,'Exposicion'),(2,'Muestra');

/*Table structure for table `ubicacion` */

DROP TABLE IF EXISTS `ubicacion`;

CREATE TABLE `ubicacion` (
  `cod_ubicacion` int(2) NOT NULL AUTO_INCREMENT,
  `nom_ubicacion` varchar(40) NOT NULL,
  PRIMARY KEY (`cod_ubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `ubicacion` */

insert  into `ubicacion`(`cod_ubicacion`,`nom_ubicacion`) values (5,'Ubi1'),(6,'Ubicacion 3'),(7,'Ubicacion 44'),(11,'asasas');

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `cod_usu` int(4) NOT NULL AUTO_INCREMENT,
  `nom_usu` varchar(30) NOT NULL,
  `pass_usu` varchar(160) NOT NULL,
  `p_nombre` varchar(45) NOT NULL,
  `em_usu` varchar(128) NOT NULL,
  `codRol` int(2) NOT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `codRol` (`codRol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`codRol`) REFERENCES `rol` (`rol_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;

/*Data for the table `usuarios` */

insert  into `usuarios`(`cod_usu`,`nom_usu`,`pass_usu`,`p_nombre`,`em_usu`,`codRol`) values (5,'carlos1','40bd001563085fc35165329ea1ff5c5ecbdbbeef','Carlos Guzman Rojas','carlos@gmail.com',9),(7,'alonso1','40bd001563085fc35165329ea1ff5c5ecbdbbeef','Alonso Rojas','alonsor@gmail.com',19),(11,'rojas1','40bd001563085fc35165329ea1ff5c5ecbdbbeef','Sebastian Rojas','S.Rojas1@gmail.com',20),(16,'J.Escobar02','123','Juan Henrique Escobar Villaroel','J.Escobar02@ElMuseo.cl',9),(21,'J.Escobar','7c4a8d09ca3762af61e59520943dc26494f8941b','Jose Alberto Rojas Rodriguez','JoseRojas@gmail.com',9),(22,'M.Mujica','7c4a8d09ca3762af61e59520943dc26494f8941b','Martin Alejandro Mujica','Mujica12@gmail.com',21),(35,'carlos2','40bd001563085fc35165329ea1ff5c5ecbdbbeef','car','carlos2',16),(39,'C.Guzman','40bd001563085fc35165329ea1ff5c5ecbdbbeef','Carlos Guzman Rojas','C.Guzman098@gmail.com',21);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
