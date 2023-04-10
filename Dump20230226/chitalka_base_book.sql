-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: chitalka_base
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status_book` varchar(255) DEFAULT NULL,
  `viseble_book` varchar(255) DEFAULT NULL,
  `cyle_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbc8rthsvrb3e63ufsbiv1hj6b` (`cyle_id`),
  CONSTRAINT `FKbc8rthsvrb3e63ufsbiv1hj6b` FOREIGN KEY (`cyle_id`) REFERENCES `cycle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'2023-01-07 12:41:28.275000','ACTIVE','2023-02-21 22:38:56.050000','','Костянной трон','PROCESS','PUBLIC',2),(2,'2023-01-19 23:33:26.941000','ACTIVE','2023-02-07 14:26:45.764000','','000000007','PROCESS','PUBLIC',NULL),(3,'2023-01-20 00:07:26.892000','ACTIVE','2023-01-20 00:07:26.892000','test','gggg',NULL,'PUBLIC',NULL),(4,'2023-01-20 07:49:42.518000','ACTIVE','2023-02-03 17:04:27.701000','gfgg','Чебуратор','PROCESS','PUBLIC',NULL),(5,'2023-01-20 07:54:35.800000','ACTIVE','2023-02-03 09:35:06.902000','','gggg','PROCESS','PUBLIC',1),(6,'2023-01-20 07:57:35.060000','ACTIVE','2023-02-03 16:45:15.208000','','gggg','PROCESS','PUBLIC',NULL),(7,'2023-01-20 08:05:40.562000','ACTIVE','2023-01-20 08:05:40.562000','','Чебуратор','PROCESS','PUBLIC',NULL),(8,'2023-01-20 08:14:37.126000','ACTIVE','2023-01-20 08:14:37.126000','','444747477477','PROCESS','PRIVATE',NULL),(9,'2023-01-21 16:23:22.222000','ACTIVE','2023-01-21 16:23:22.222000','','gggg','PROCESS','PUBLIC',NULL),(10,'2023-01-21 19:00:10.982000','ACTIVE','2023-01-21 19:00:10.982000','','Сверх Гена','PROCESS','PUBLIC',NULL),(11,'2023-01-21 19:02:38.277000','ACTIVE','2023-02-03 09:08:26.470000','','Дода Бу','PROCESS','PUBLIC',NULL),(12,'2023-02-07 16:39:20.033000','ACTIVE','2023-02-07 16:39:20.033000','','jjjjsd9999','PROCESS','PRIVATE',1),(13,'2023-02-07 16:39:20.097000','ACTIVE','2023-02-07 16:39:20.097000','','jjjjsd9999','PROCESS','PRIVATE',NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-26 18:21:49
