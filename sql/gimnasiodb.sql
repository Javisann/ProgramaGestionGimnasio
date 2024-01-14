CREATE DATABASE  IF NOT EXISTS `gimnasiodb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gimnasiodb`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gimnasiodb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad` (
  `nombre` varchar(30) NOT NULL,
  `duracion` decimal(6,2) NOT NULL,
  `sesiones` int NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES ('crossfit',1.00,4),('karate',1.50,3),('natacion',2.00,2),('spinning',1.00,2),('yoga',1.00,2);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `limpieza`
--

DROP TABLE IF EXISTS `limpieza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `limpieza` (
  `idlimpieza` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`idlimpieza`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `limpieza`
--

LOCK TABLES `limpieza` WRITE;
/*!40000 ALTER TABLE `limpieza` DISABLE KEYS */;
INSERT INTO `limpieza` VALUES ('l1','David'),('l2','Clara'),('l3','Daniel'),('l4','Maria');
/*!40000 ALTER TABLE `limpieza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monitores`
--

DROP TABLE IF EXISTS `monitores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitores` (
  `idmonitores` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`idmonitores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitores`
--

LOCK TABLES `monitores` WRITE;
/*!40000 ALTER TABLE `monitores` DISABLE KEYS */;
INSERT INTO `monitores` VALUES ('m1','Javi'),('m2','Iker'),('m3','Victor'),('m4','Guille');
/*!40000 ALTER TABLE `monitores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suscripcionesindividuales`
--

DROP TABLE IF EXISTS `suscripcionesindividuales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suscripcionesindividuales` (
  `codSuscripcion` varchar(10) NOT NULL,
  `pagado` tinyint(1) NOT NULL,
  `precio` decimal(7,2) NOT NULL,
  `nombreCliente` varchar(50) NOT NULL,
  `dni` varchar(9) NOT NULL,
  PRIMARY KEY (`codSuscripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suscripcionesindividuales`
--

LOCK TABLES `suscripcionesindividuales` WRITE;
/*!40000 ALTER TABLE `suscripcionesindividuales` DISABLE KEYS */;
INSERT INTO `suscripcionesindividuales` VALUES ('s1',1,30.00,'Juan','c1'),('s2',1,30.00,'Maria','c2'),('s3',0,25.00,'Cristian','c3'),('s4',1,25.00,'Carlos','c4'),('s5',0,25.00,'David','c5'),('s6',1,25.00,'Iker','c6'),('s7',1,25.00,'Victor','c7'),('s8',0,25.00,'Luis','c8'),('s9',1,25.00,'Hugo','c9');
/*!40000 ALTER TABLE `suscripcionesindividuales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suscripcionindividual`
--

DROP TABLE IF EXISTS `suscripcionindividual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suscripcionindividual` (
  `codSuscripcion` varchar(30) NOT NULL,
  `pagado` tinyint(1) NOT NULL,
  `precio` decimal(6,2) NOT NULL,
  `dni_clientes` varchar(30) NOT NULL,
  PRIMARY KEY (`codSuscripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suscripcionindividual`
--

LOCK TABLES `suscripcionindividual` WRITE;
/*!40000 ALTER TABLE `suscripcionindividual` DISABLE KEYS */;
INSERT INTO `suscripcionindividual` VALUES ('sf1',1,60.00,'[c1, c2, c3, c4]'),('sf2',0,60.00,'[c6, c7, c8]'),('sf3',1,60.00,'[c5, c10, c9]');
/*!40000 ALTER TABLE `suscripcionindividual` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-29 16:35:37
