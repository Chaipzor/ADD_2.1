-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: p21
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `nombre` varchar(15) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefono` int(15) NOT NULL,
  `pass` varchar(300) NOT NULL,
  `rol_admin` tinyint(1) NOT NULL DEFAULT 0,
  `id` int(11) NOT NULL,
  `idioma` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('Angel','Sanchez','chaip@gmail.com',1234,'4/0EXWN2c9ENck8mNhGV/1LMqFufPPPd8UVUQvOFn4Z1pt5yjgsTYkZ8VROVCGrY',1,1,'en'),('Antonio','Sanchez','antonio@gmail.com',999999999,'4/0EXWN2c9ENck8mNhGV/1LMqFufPPPd8UVUQvOFn4Z1pt5yjgsTYkZ8VROVCGrY',0,7,'es'),('Clara','Fernandez','clara@gmail.com',111222333,'4/0EXWN2c9ENck8mNhGV/1LMqFufPPPd8UVUQvOFn4Z1pt5yjgsTYkZ8VROVCGrY',0,8,'es'),('Prueba','Prueba','prueba@prueba.es',1234,'4/0EXWN2c9ENck8mNhGV/1LMqFufPPPd8UVUQvOFn4Z1pt5yjgsTYkZ8VROVCGrY',0,9,'en'),('Admin','Admin','admin@admin.es',1234,'GCUIhlNaWp7wmXsFAMVIpabN8S6VeKYRK5xNnDDsHTlcwg3Pa477A75rEX4gkBrE',1,10,'en');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-01 21:54:21
