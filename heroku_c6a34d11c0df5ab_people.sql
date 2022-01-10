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
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=465 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (55,'1991-12-06','asdf@gjk.com','test4','asdf','sdf','user4'),(85,'1992-02-22','asdf@gmail.com','creationfromeditor','Maya','changepass123','testtodelete'),(100,'1989-03-02',NULL,'boss','wu','ffs','BossIsMe'),(135,'1992-02-03','asdf@gmail.com','testtodelete','masy','s;ldkfj','asjdf;'),(155,'1992-02-03','asdf@gmail.com','testtodelete','masy','s;ldkfj','asjdf;'),(185,'1992-02-03','asdf@gmail.com','testtodelete','masy','s;ldkfj','asjdf;'),(200,'1999-01-01',NULL,NULL,NULL,'cook','chefIsme'),(201,'1990-03-02','sdf@gmail.com','guo','bao','wer','LoveCookBoba'),(202,'1995-02-01','sdf@gmail.com','chayin','chen','fjidls;','LoveCookTea'),(225,'1992-02-03','asdf@gmail.com','testtodelete','masy','s;ldkfj','asjdf;'),(255,'1992-02-03','asdf@gmail.com','testtodelete','masy','s;ldkfj','asjdf;'),(265,'1992-02-03','asdf@gmail.com','testtodelete','masy','s;ldkfj','asjdf;'),(275,'1992-03-01','asfd@gmail.com','testadd','wer','a;lsd','asfd'),(285,'1992-03-01','asfd@gmail.com','testadd','wer','a;lsd','asfd'),(300,'1994-08-24',NULL,NULL,NULL,NULL,'IlikeDelivery'),(301,'1993-02-22',NULL,'vhi','lu','sdf','lovedelivery'),(305,NULL,NULL,'addtry','tryme','asdf','tryadd'),(315,'2000-01-02',NULL,'adduserid','sdf','as','sdf'),(325,NULL,NULL,'adduserid','sdf','as','sdf'),(335,NULL,NULL,'adduserid','sdf','as','sdf'),(345,NULL,NULL,'add','w','ff','sdfas'),(355,NULL,NULL,'tryadd','add','awer','asdf'),(365,'1985-05-23','asdfnew@gmail.com','test12/12new','wangnew','sdf-new','angeqa-new'),(375,'1992-01-01','asdf@gmailc.om','test12120540','wang','asdf','asfd'),(405,'1992-02-01',NULL,'test','test',NULL,NULL),(415,'1993-12-21','asd','test12120602','asdf','asd','asd'),(425,'2001-12-12',NULL,'aaaaa','aaaaaaa',NULL,NULL),(435,'1992-02-03','asdf','test120617','st','asd','asd'),(445,'1992-01-01',NULL,'tetstbirhday',NULL,NULL,NULL),(900,'1991-12-30','asdf@gmail.com','ange','sdf','asdf','test'),(901,'1992-01-30','assdfdf@gmail.com','cindy','w','asdf','wersf');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-12 19:18:23
