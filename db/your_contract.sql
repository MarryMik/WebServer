-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: your_contract
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `acesscode`
--

DROP TABLE IF EXISTS `acesscode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acesscode` (
  `Acesscode_ID` int NOT NULL AUTO_INCREMENT,
  `Acesscode` varchar(30) NOT NULL,
  PRIMARY KEY (`Acesscode_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acesscode`
--

LOCK TABLES `acesscode` WRITE;
/*!40000 ALTER TABLE `acesscode` DISABLE KEYS */;
INSERT INTO `acesscode` VALUES (1,'11111111');
/*!40000 ALTER TABLE `acesscode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `Client_ID` int NOT NULL AUTO_INCREMENT,
  `Client_Name` varchar(400) NOT NULL,
  `PHONE_NUMBER` varchar(20) NOT NULL,
  `Client_Passw` varchar(10) DEFAULT NULL,
  `Client_email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Client_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Alex','+380668761542',NULL,NULL),(2,'Mariia','+380988765744',NULL,NULL),(5,'Hanna','+380668764522',NULL,NULL),(6,'Oleg','+380508332314',NULL,NULL),(7,'Lesya','+380662223344',NULL,NULL),(12,'Петро','+380222444333',NULL,NULL),(13,'Mariia','3809765',NULL,NULL),(14,'Mariia','38075923895',NULL,NULL),(15,'Mariia','3809765',NULL,NULL),(16,'Mariia','+349494940',NULL,NULL),(17,'Марія','+380983758475',NULL,NULL),(18,'Марія','+38090493849384',NULL,NULL),(19,'Марія','+3349385938',NULL,NULL),(20,'Марія','+359459459459',NULL,NULL),(21,'Іван','098-76-611',NULL,NULL),(22,'Марія','098-76-876',NULL,NULL),(23,'Mariia','+380988765744',NULL,NULL),(24,'Mariia','+380988765744',NULL,NULL),(25,'Mariia','+380988765744',NULL,NULL),(26,'Mariia','+380988765744',NULL,NULL),(27,'Mariia','+380988765744',NULL,NULL),(28,'Mariia','+380988765744',NULL,NULL),(29,'Mariia','+380988765744',NULL,NULL),(30,'Lesya','+380662223344',NULL,NULL),(31,'Lesya','+380662223344',NULL,NULL),(32,'Hanna','+380668764522',NULL,NULL),(33,'Alex','+380668761542',NULL,NULL),(34,'Alex','+380668761542',NULL,NULL),(35,'Alex','+380668761542',NULL,NULL),(36,'Петро','+380222444333',NULL,NULL),(37,'Петро','+380222444333',NULL,NULL),(38,'Alex','+380668761542',NULL,NULL),(39,'Alex','+380668761542',NULL,NULL),(40,'Alex','+380668761542',NULL,NULL),(41,'Oleg','+380508332314',NULL,NULL),(42,'Марія','+380975555555',NULL,NULL),(43,'Alex','+380668761542',NULL,NULL),(44,'Mariia','3809765',NULL,NULL),(45,'Mariia','3809765',NULL,NULL),(46,'Mariia','3809765',NULL,NULL),(47,'Mariia','38075923895',NULL,NULL),(48,'Mariia','38075923895',NULL,NULL),(49,'Mariia','3809765',NULL,NULL),(50,'Mariia','3809765',NULL,NULL),(51,'Mariia','+349494940',NULL,NULL),(52,'Марія','+380983758475',NULL,NULL),(53,'Mariia','3809765',NULL,NULL),(54,'Mariia','3809765',NULL,NULL),(55,'Mariia','+380955554444',NULL,NULL),(56,'Кирило','+380911347890',NULL,NULL),(57,'Kateryna','+380748903434',NULL,NULL),(58,'Mariia','3809765',NULL,NULL),(59,'Mariia','3809765',NULL,NULL),(60,'Mariia','3809765',NULL,NULL),(61,'Mariia','3809765',NULL,NULL),(62,'Mariia','38075923895',NULL,NULL),(63,'Mariia','38075923895',NULL,NULL),(64,'Mariia','38075923895',NULL,NULL),(65,'Mariia','38075923895',NULL,NULL),(66,'Mariia','38075923895',NULL,NULL),(67,'Mariia','38075923895',NULL,NULL),(68,'Mariia','38075923895',NULL,NULL),(69,'Марія','+380978989800',NULL,NULL),(70,'Mariia','38075923895',NULL,NULL),(71,'Mariia','38075923895',NULL,NULL),(72,'Mariia','38075923895',NULL,NULL),(73,'Mariia','38075923895',NULL,NULL),(74,'Mariia','38075923895',NULL,NULL),(75,'Mariia','38075923895',NULL,NULL),(76,'Mariia','3809765',NULL,NULL),(77,'Mariia','38075923895',NULL,NULL),(78,'Mariia','38075923895',NULL,NULL),(79,'Mariia','38075923895',NULL,NULL),(80,'Mariia','38075923895',NULL,NULL),(81,'Mariia','38075923895',NULL,NULL),(82,'Mariia','38075923895',NULL,NULL),(83,'Mariia','38075923895',NULL,NULL),(84,'Mariia','38075923895',NULL,NULL),(85,'Mariia','38075923895',NULL,NULL),(86,'Mariia','38075923895',NULL,NULL),(87,'Mariia','38075923895',NULL,NULL),(88,'Mariia','38075923895',NULL,NULL),(89,'Mariia','3809765',NULL,NULL),(90,'Марія','+380567892345',NULL,NULL),(91,'Mariia','38075923895',NULL,NULL),(92,'Mariia','38075923895',NULL,NULL);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator_type`
--

DROP TABLE IF EXISTS `operator_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operator_type` (
  `Operator_Type_ID` int NOT NULL AUTO_INCREMENT,
  `Operator_Type_Name` varchar(15) NOT NULL,
  PRIMARY KEY (`Operator_Type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator_type`
--

LOCK TABLES `operator_type` WRITE;
/*!40000 ALTER TABLE `operator_type` DISABLE KEYS */;
INSERT INTO `operator_type` VALUES (1,'Basic'),(2,'Expert');
/*!40000 ALTER TABLE `operator_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operators`
--

DROP TABLE IF EXISTS `operators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operators` (
  `Operator_ID` int NOT NULL AUTO_INCREMENT,
  `Operator_Name` varchar(300) DEFAULT '1',
  `Operator_Type_ID` int DEFAULT NULL,
  `Operator_email` varchar(40) NOT NULL,
  `Operator_passw` varchar(30) NOT NULL,
  `Is_Available` tinyint(1) DEFAULT NULL,
  `Acesscode_ID` int DEFAULT NULL,
  PRIMARY KEY (`Operator_ID`),
  KEY `FK_Operator_Acesscode_ID` (`Acesscode_ID`),
  KEY `FK_Operators_Operator_Type_ID` (`Operator_Type_ID`),
  CONSTRAINT `FK_Operator_Acesscode_ID` FOREIGN KEY (`Acesscode_ID`) REFERENCES `acesscode` (`Acesscode_ID`),
  CONSTRAINT `FK_Operators_Operator_Type_ID` FOREIGN KEY (`Operator_Type_ID`) REFERENCES `operator_type` (`Operator_Type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operators`
--

LOCK TABLES `operators` WRITE;
/*!40000 ALTER TABLE `operators` DISABLE KEYS */;
INSERT INTO `operators` VALUES (1,'Sviatislav',1,'+380977777777','1111',1,1),(2,'Iryna',2,'+380585858855','2222',1,1),(4,'Oleg',1,'+380000000000','111116',1,1),(5,'Сашко',1,'+380767676767','5745875',1,1);
/*!40000 ALTER TABLE `operators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `requests`
--

DROP TABLE IF EXISTS `requests`;
/*!50001 DROP VIEW IF EXISTS `requests`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `requests` AS SELECT 
 1 AS `Ticket_ID`,
 1 AS `PHONE_NUMBER`,
 1 AS `Ticket_Type_Name`,
 1 AS `Ticket_Status_Name`,
 1 AS `Operator_email`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ticket_status`
--

DROP TABLE IF EXISTS `ticket_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_status` (
  `Ticket_Status_ID` int NOT NULL AUTO_INCREMENT,
  `Ticket_Status_Name` varchar(20) NOT NULL,
  PRIMARY KEY (`Ticket_Status_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_status`
--

LOCK TABLES `ticket_status` WRITE;
/*!40000 ALTER TABLE `ticket_status` DISABLE KEYS */;
INSERT INTO `ticket_status` VALUES (1,'NEW'),(2,'INPROGRESS'),(3,'CLOSED');
/*!40000 ALTER TABLE `ticket_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_type`
--

DROP TABLE IF EXISTS `ticket_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket_type` (
  `Ticket_Type_ID` int NOT NULL AUTO_INCREMENT,
  `Ticket_Type_Name` varchar(100) NOT NULL,
  PRIMARY KEY (`Ticket_Type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_type`
--

LOCK TABLES `ticket_type` WRITE;
/*!40000 ALTER TABLE `ticket_type` DISABLE KEYS */;
INSERT INTO `ticket_type` VALUES (1,'Загальна консультація'),(2,'Публічний договір'),(3,'Договір приєднання'),(4,'Попередній договір'),(5,'Договір на користь третьої особи'),(6,'Консультація'),(7,'Нова послуга');
/*!40000 ALTER TABLE `ticket_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `Ticket_ID` int NOT NULL AUTO_INCREMENT,
  `Topic` varchar(200) DEFAULT NULL,
  `Descript` varchar(4000) DEFAULT NULL,
  `Client_ID` int NOT NULL,
  `Ticket_Type_ID` int NOT NULL,
  `Ticket_Status_ID` int NOT NULL DEFAULT '1',
  `Resolution` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`Ticket_ID`),
  KEY `FK_Tickets_Ticket_Type_ID` (`Ticket_Type_ID`),
  KEY `FK_Ticket_Client_ID` (`Client_ID`),
  KEY `FK_Ticket_Ticket_Status_ID` (`Ticket_Status_ID`),
  CONSTRAINT `FK_Ticket_Client_ID` FOREIGN KEY (`Client_ID`) REFERENCES `clients` (`Client_ID`),
  CONSTRAINT `FK_Ticket_Ticket_Status_ID` FOREIGN KEY (`Ticket_Status_ID`) REFERENCES `ticket_status` (`Ticket_Status_ID`),
  CONSTRAINT `FK_Tickets_Ticket_Type_ID` FOREIGN KEY (`Ticket_Type_ID`) REFERENCES `ticket_type` (`Ticket_Type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,NULL,NULL,1,2,3,NULL),(2,NULL,NULL,2,3,3,NULL),(3,NULL,NULL,6,5,2,NULL),(4,NULL,NULL,7,4,3,NULL),(5,NULL,NULL,5,2,3,NULL),(6,NULL,NULL,1,1,3,NULL),(7,NULL,NULL,12,3,2,NULL),(8,NULL,NULL,13,1,3,NULL),(9,NULL,NULL,14,4,2,NULL),(10,NULL,NULL,13,1,2,NULL),(11,NULL,NULL,16,1,1,NULL),(12,NULL,NULL,17,3,1,NULL),(13,NULL,NULL,18,1,1,NULL),(14,NULL,NULL,19,1,1,NULL),(15,NULL,NULL,20,1,1,NULL),(16,NULL,NULL,21,3,1,NULL),(17,NULL,NULL,22,1,1,NULL),(18,NULL,NULL,42,1,1,NULL),(19,NULL,NULL,55,2,1,NULL),(20,NULL,NULL,56,4,1,NULL),(21,NULL,NULL,57,3,1,NULL),(22,NULL,NULL,69,3,1,NULL),(23,NULL,NULL,90,5,1,NULL);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets_assignments`
--

DROP TABLE IF EXISTS `tickets_assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets_assignments` (
  `Ticket_ID` int NOT NULL,
  `OPERATOR_ID` int NOT NULL,
  `Is_Active` tinyint(1) NOT NULL DEFAULT '0',
  `Resolution_Comment` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`Ticket_ID`,`OPERATOR_ID`),
  KEY `FK_Ticket_Assignment_Operator_ID` (`OPERATOR_ID`),
  CONSTRAINT `FK_Tickets_Assignments_Operator_ID` FOREIGN KEY (`OPERATOR_ID`) REFERENCES `operators` (`Operator_ID`),
  CONSTRAINT `FK_Tickets_Assignments_Ticket_ID` FOREIGN KEY (`Ticket_ID`) REFERENCES `tickets` (`Ticket_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets_assignments`
--

LOCK TABLES `tickets_assignments` WRITE;
/*!40000 ALTER TABLE `tickets_assignments` DISABLE KEYS */;
INSERT INTO `tickets_assignments` VALUES (1,5,0,NULL),(2,1,0,NULL),(3,2,0,NULL),(4,1,0,NULL),(5,1,0,NULL),(6,1,0,NULL),(7,5,0,NULL),(8,1,0,NULL),(9,1,0,NULL),(10,4,0,NULL);
/*!40000 ALTER TABLE `tickets_assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `requests`
--

/*!50001 DROP VIEW IF EXISTS `requests`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`YourContract`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `requests` AS select `t`.`Ticket_ID` AS `Ticket_ID`,`c`.`PHONE_NUMBER` AS `PHONE_NUMBER`,`p`.`Ticket_Type_Name` AS `Ticket_Type_Name`,`s`.`Ticket_Status_Name` AS `Ticket_Status_Name`,`o`.`Operator_email` AS `Operator_email` from (((((`tickets` `t` join `clients` `c` on((`t`.`Client_ID` = `c`.`Client_ID`))) join `ticket_type` `p` on((`t`.`Ticket_Type_ID` = `p`.`Ticket_Type_ID`))) join `ticket_status` `s` on((`t`.`Ticket_Status_ID` = `s`.`Ticket_Status_ID`))) left join `tickets_assignments` `a` on((`t`.`Ticket_ID` = `a`.`Ticket_ID`))) left join `operators` `o` on((`a`.`OPERATOR_ID` = `o`.`Operator_ID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-17 16:02:55
