-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_api
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `id` bigint NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,30.099745,-1.963477,'Cargo-1'),(2,30.101236,-1.963681,'Cargo-2'),(3,30.1038,-1.964603,'Cargo-3'),(4,30.102974,-1.962979,'Cargo-4'),(5,30.105088,-1.962089,'Cargo-5'),(6,29.336334,-2.227734,'Cargo-6-karongi'),(7,29.361345,-2.079626,'Cargo-7-karongi'),(8,29.353364,-2.084461,'Cargo-8-karongi');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo_drink`
--

DROP TABLE IF EXISTS `cargo_drink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo_drink` (
  `id` bigint NOT NULL,
  `cargo_id` bigint DEFAULT NULL,
  `drink_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcb01clyvhqdcipdar6ebf9e8x` (`cargo_id`),
  KEY `FK3omnyv36rwxic8olptvjs8xq5` (`drink_id`),
  CONSTRAINT `FK3omnyv36rwxic8olptvjs8xq5` FOREIGN KEY (`drink_id`) REFERENCES `drink` (`id`),
  CONSTRAINT `FKcb01clyvhqdcipdar6ebf9e8x` FOREIGN KEY (`cargo_id`) REFERENCES `cargo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo_drink`
--

LOCK TABLES `cargo_drink` WRITE;
/*!40000 ALTER TABLE `cargo_drink` DISABLE KEYS */;
INSERT INTO `cargo_drink` VALUES (24,2,23),(25,2,22),(26,2,21),(27,2,20),(28,2,19),(29,2,18),(30,2,17),(32,3,17),(33,3,18),(34,3,19),(35,3,20),(36,3,21),(37,3,23),(39,4,23),(40,4,22),(41,4,21),(42,4,20),(43,4,19),(44,4,18),(45,4,17),(47,4,17),(48,5,17),(49,5,18),(50,5,19),(51,5,20),(52,5,21),(53,5,22),(54,5,23),(55,6,23),(56,6,22),(57,6,21),(58,6,20),(59,6,18),(60,6,17),(61,7,17),(62,7,18),(63,7,19),(64,7,20),(65,7,21),(66,7,22),(67,7,23),(68,8,23),(69,8,22),(70,8,21),(71,8,20),(72,8,19),(73,8,18),(74,8,17);
/*!40000 ALTER TABLE `cargo_drink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` bigint NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (9,29.353364,-2.084461,'Client-1-karongi'),(10,29.351227,-2.114573,'Client-2-karongi'),(11,29.34669,-2.118699,'Client-3-karongi'),(12,29.346819,-2.118903,'Client-3-karongi'),(13,29.346819,-2.118903,'Client-4-karongi'),(14,30.111216,-1.972852,'Client-5-kigali'),(15,30.099359,-1.963874,'client-5-kigali'),(16,30.110544,-1.958725,'client-6-kigali');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drink`
--

DROP TABLE IF EXISTS `drink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drink` (
  `id` bigint NOT NULL,
  `consumed_times` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink`
--

LOCK TABLES `drink` WRITE;
/*!40000 ALTER TABLE `drink` DISABLE KEYS */;
INSERT INTO `drink` VALUES (17,0,'heinken',1200,'alcohol'),(18,0,'primus',1300,'45000'),(19,0,'Mango Juice',500,'Juice'),(20,0,'Yoghut',1000,'Inyanjye'),(21,0,'Yoghut',1000,'Inyanjye strawbelly'),(22,0,'Skol',1000,'beer'),(23,0,'Amstel',1500,'beer');
/*!40000 ALTER TABLE `drink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (79);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_drinks`
--

DROP TABLE IF EXISTS `order_drinks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_drinks` (
  `id` bigint NOT NULL,
  `drink_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdk991epo8xpvch33i442kjrvh` (`drink_id`),
  KEY `FK2ntduplwud4inwkaegk7w1kig` (`order_id`),
  CONSTRAINT `FK2ntduplwud4inwkaegk7w1kig` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKdk991epo8xpvch33i442kjrvh` FOREIGN KEY (`drink_id`) REFERENCES `cargo_drink` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_drinks`
--

LOCK TABLES `order_drinks` WRITE;
/*!40000 ALTER TABLE `order_drinks` DISABLE KEYS */;
INSERT INTO `order_drinks` VALUES (77,28,76),(78,29,76);
/*!40000 ALTER TABLE `order_drinks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL,
  `number_of_drinks` int NOT NULL,
  `status` int DEFAULT NULL,
  `total_price` double NOT NULL,
  `client_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK17yo6gry2nuwg2erwhbaxqbs9` (`client_id`),
  CONSTRAINT `FK17yo6gry2nuwg2erwhbaxqbs9` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (76,2,0,1800,9);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-26  7:00:24
