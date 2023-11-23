-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: userprofile
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `idExercise` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(45) DEFAULT NULL,
  `Duration` float DEFAULT NULL,
  `Intensity` varchar(45) DEFAULT NULL,
  `doe` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `cals` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idExercise`),
  UNIQUE KEY `idExercise_UNIQUE` (`idExercise`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
INSERT INTO `exercise` VALUES (50,'walking',55,'medium','1111-11-11','asd',NULL),(51,'walking',44,'low','1111-11-11','asd',NULL),(52,'walking',55,'medium','1111-11-11','asd',NULL),(53,'walking',5,'low','1111-11-11','asd',NULL),(54,'running',4,'medium','2223-10-22','asd',NULL),(55,'running',31,'low','1111-11-11',NULL,NULL),(56,'swimming',11,'medium','0223-10-22','Dattro',NULL),(57,'walking',55,'low','2223-10-22','Dattro',NULL),(58,'swimming',55,' very high','3335-10-03','gtr',NULL),(59,'running',11,'medium','3335-10-03','Dattro',NULL),(60,'running',11,'medium','5559-08-24','ha',NULL),(61,'running',55,'medium','0447-09-13','hela','270.0'),(62,'walking',33,'medium','3335-10-03','hela','270.0'),(63,'running',30,'medium','5559-08-24','hela','270.0'),(64,'running',5,'high','2023-11-20','ha','60.0'),(65,'swimming',44,'very high','4445-10-22','hela','616.0'),(66,'running',11,'medium','0360-10-03','hela','99.0'),(67,'walking',11,'medium','2223-10-22','hela','38.5'),(68,'running',11,'medium','2223-10-22','Dattro','99.0'),(69,'running',22,'high','2223-10-22','hela','264.0'),(70,'biking',44,'high','8895-06-27','Dattro','396.0'),(71,'running',33,'very high','0444-04-04','ha','495.0'),(72,'walking',6,'high','2023-11-21','Dattro','30.0'),(73,'running',22,'medium','3335-10-03','hela','198.0'),(74,'running',33,'medium','3233-10-22','hela','297.0'),(75,'running',40,'high','2023-12-02','abc','480.0');
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-22 20:05:36
