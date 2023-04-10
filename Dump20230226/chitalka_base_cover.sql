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
-- Table structure for table `cover`
--

DROP TABLE IF EXISTS `cover`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cover` (
  `created` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated` datetime(6) DEFAULT NULL,
  `name_file` varchar(255) DEFAULT NULL,
  `book_id` bigint NOT NULL,
  PRIMARY KEY (`book_id`),
  CONSTRAINT `FK7joelp33tnsu71vupv6krkrem` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cover`
--

LOCK TABLES `cover` WRITE;
/*!40000 ALTER TABLE `cover` DISABLE KEYS */;
INSERT INTO `cover` VALUES ('2023-02-03 09:25:11.491000','ACTIVE','2023-02-03 09:25:11.491000','1675416311475_2gZ817whI04.jpg',1),('2023-01-19 23:33:27.019000',NULL,'2023-02-03 09:25:00.184000','1675416300105_bGnvBJxVbio.jpg',2),('2023-01-20 00:07:26.917000',NULL,'2023-01-20 00:07:26.917000','1674173246880_photo_2022-10-10_12-10-41.jpg',3),('2023-02-03 16:50:08.665000','ACTIVE','2023-02-03 17:04:27.742000','1675443867654_xt-PRuQEvNc.jpg',4),('2023-02-03 09:35:06.908000','ACTIVE','2023-02-03 09:35:06.908000','1675416906896_GyjS35tJNwg.jpg',5),('2023-02-03 16:45:15.248000','ACTIVE','2023-02-21 23:27:22.104000','NoneBookImg.jpg',6),('2023-01-20 08:14:37.173000','ACTIVE','2023-01-20 08:14:37.173000','1674202477094_71c7e7b4b5c348bd9eb5a55c14548bac.jpg',8),('2023-01-21 16:23:22.293000','ACTIVE','2023-01-21 16:23:22.293000','1674318202192_71c7e7b4b5c348bd9eb5a55c14548bac.jpg',9),('2023-01-21 19:00:11.031000','ACTIVE','2023-01-21 19:00:11.031000','1674327610953_bc08e3d530be4359a522ba5dcbd954c8.jpg',10),('2023-01-21 19:02:38.321000','ACTIVE','2023-01-21 19:02:38.321000','1674327758249_bc08e3d530be4359a522ba5dcbd954c8.jpg',11),('2023-02-07 16:39:20.110000','ACTIVE','2023-02-21 23:13:04.169000','NoneBookImg.jpg',13);
/*!40000 ALTER TABLE `cover` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-26 18:21:50
