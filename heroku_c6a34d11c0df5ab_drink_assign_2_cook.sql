-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: us-cdbr-east-04.cleardb.com    Database: heroku_c6a34d11c0df5ab
-- ------------------------------------------------------
-- Server version	5.6.50-log

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
-- Table structure for table `drink_assign_2_cook`
--

DROP TABLE IF EXISTS `drink_assign_2_cook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drink_assign_2_cook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cook_employee_id` int(11) DEFAULT NULL,
  `drink_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqcr6ja52rotpvwk3dduaug7v4` (`cook_employee_id`),
  KEY `FKavkefb1ou8y10b2bef5n5e1jl` (`drink_id`),
  CONSTRAINT `FKavkefb1ou8y10b2bef5n5e1jl` FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`id`),
  CONSTRAINT `FKqcr6ja52rotpvwk3dduaug7v4` FOREIGN KEY (`cook_employee_id`) REFERENCES `cook_employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink_assign_2_cook`
--

LOCK TABLES `drink_assign_2_cook` WRITE;
/*!40000 ALTER TABLE `drink_assign_2_cook` DISABLE KEYS */;
INSERT INTO `drink_assign_2_cook` VALUES (1,201,100),(2,201,101),(3,202,200),(4,202,201),(5,202,400),(6,200,900);
/*!40000 ALTER TABLE `drink_assign_2_cook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-12 19:18:21
