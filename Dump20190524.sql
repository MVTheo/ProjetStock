-- MySQL dump 10.13  Distrib 5.7.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projetstock
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `piece`
--

DROP TABLE IF EXISTS `piece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piece` (
  `idPiece` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`idPiece`),
  KEY `index_nom` (`nom`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piece`
--

LOCK TABLES `piece` WRITE;
/*!40000 ALTER TABLE `piece` DISABLE KEYS */;
INSERT INTO `piece` VALUES (1,'GPU',7),(2,'CPU',33),(3,'RAM',8),(4,'Roue',15),(5,'Retro',8),(6,'Boulon',2),(7,'Vis',3),(8,'écrou',272),(9,'jante',193),(10,'Filtre',883),(11,'Courroie',407),(12,'Volant',244),(13,'Embrayage',631),(14,'Boite de vitesse',308),(15,'Moteur',70);
/*!40000 ALTER TABLE `piece` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger trg_before_piece_update
        before update on piece
        for each row 
        begin 
            INSERT into piece_audit
            set 
                operation = 'update',
                piece_id = new.idPiece,
                piece_name = OLD.nom,
                quantiteRestante = new.quantite,
                QuantiteEnelever = OLD.quantite - new.quantite,
                temps = now();
        end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `piece_audit`
--

DROP TABLE IF EXISTS `piece_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `piece_audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operation` varchar(50) DEFAULT NULL,
  `piece_id` int(11) NOT NULL,
  `piece_name` varchar(50) DEFAULT NULL,
  `quantiteRestante` int(11) NOT NULL,
  `QuantiteEnelever` int(11) NOT NULL,
  `temps` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piece_audit`
--

LOCK TABLES `piece_audit` WRITE;
/*!40000 ALTER TABLE `piece_audit` DISABLE KEYS */;
INSERT INTO `piece_audit` VALUES (30,'update',9,'jante',196,1,'2019-05-23 17:29:22'),(31,'update',10,'Filtre',888,2,'2019-05-23 17:29:22'),(32,'update',11,'Courroie',414,3,'2019-05-23 17:29:22'),(33,'update',12,'Volant',250,4,'2019-05-23 17:29:22'),(34,'update',13,'Embrayage',637,5,'2019-05-23 17:29:22'),(35,'update',14,'Boite de vitesse',316,7,'2019-05-23 17:29:49'),(36,'update',15,'Moteur',79,8,'2019-05-23 17:29:49'),(37,'update',8,'écrou',272,1,'2019-05-23 17:30:38'),(38,'update',9,'jante',194,2,'2019-05-23 17:30:38'),(39,'update',10,'Filtre',885,3,'2019-05-23 17:30:38'),(40,'update',11,'Courroie',410,4,'2019-05-23 17:30:38'),(41,'update',12,'Volant',245,5,'2019-05-23 17:30:38'),(42,'update',15,'Moteur',71,8,'2019-05-23 17:30:38'),(43,'update',12,'Volant',244,1,'2019-05-23 17:31:24'),(44,'update',13,'Embrayage',635,2,'2019-05-23 17:31:24'),(45,'update',14,'Boite de vitesse',313,3,'2019-05-23 17:31:24'),(46,'update',3,'RAM',8,0,'2019-05-23 17:33:25'),(47,'update',4,'Roue',15,0,'2019-05-23 17:33:25'),(48,'update',3,'RAM',8,0,'2019-05-23 17:33:37'),(49,'update',2,'CPU',33,0,'2019-05-23 17:33:37'),(50,'update',4,'Roue',15,0,'2019-05-23 17:33:37'),(51,'update',5,'Retro',8,0,'2019-05-23 17:33:37'),(52,'update',8,'écrou',272,0,'2019-05-23 17:33:37'),(53,'update',11,'Courroie',410,0,'2019-05-23 17:33:37'),(54,'update',9,'jante',193,1,'2019-05-23 17:34:10'),(55,'update',10,'Filtre',883,2,'2019-05-23 17:34:10'),(56,'update',11,'Courroie',407,3,'2019-05-23 17:34:10'),(57,'update',13,'Embrayage',631,4,'2019-05-23 17:34:10'),(58,'update',14,'Boite de vitesse',308,5,'2019-05-23 17:34:10'),(59,'update',15,'Moteur',70,1,'2019-05-23 17:37:16');
/*!40000 ALTER TABLE `piece_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sortie`
--

DROP TABLE IF EXISTS `sortie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sortie` (
  `idsortie` int(11) NOT NULL AUTO_INCREMENT,
  `nbPiece` int(11) NOT NULL,
  `Piece_idPiece` int(11) NOT NULL,
  PRIMARY KEY (`idsortie`),
  KEY `fk_sortie_Piece` (`Piece_idPiece`),
  CONSTRAINT `fk_sortie_Piece` FOREIGN KEY (`Piece_idPiece`) REFERENCES `piece` (`idPiece`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sortie`
--

LOCK TABLES `sortie` WRITE;
/*!40000 ALTER TABLE `sortie` DISABLE KEYS */;
INSERT INTO `sortie` VALUES (1,452,3),(2,452,3),(3,452,4),(4,47,1),(5,47,5),(6,42,4),(7,42,5),(8,121,5),(9,121,2),(10,47,3),(11,87,4),(12,4,3),(13,96,5),(14,8,1),(15,8,1),(16,0,2),(17,28,3),(18,8,3),(19,8,3),(20,1,3),(21,5,5),(22,4,7),(23,9,8),(24,1,4),(25,8,3),(26,8,5),(27,2,6),(28,3,7),(29,5,13),(30,2,14),(31,5,1),(32,2,2),(33,2,1),(34,2,1),(35,2,2),(36,4,2),(37,1,1),(38,2,2),(39,2,2),(40,1,4),(41,2,9),(42,2,8),(43,2,9),(44,2,10),(45,3,10),(46,1,9),(47,2,10),(48,3,11),(49,4,12),(50,5,13),(51,7,14),(52,8,15),(53,1,8),(54,2,9),(55,3,10),(56,4,11),(57,5,12),(58,8,15),(59,1,12),(60,2,13),(61,3,14),(62,0,3),(63,0,4),(64,0,3),(65,0,2),(66,0,4),(67,0,5),(68,0,8),(69,0,11),(70,1,9),(71,2,10),(72,3,11),(73,4,13),(74,5,14),(75,1,15);
/*!40000 ALTER TABLE `sortie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'projetstock'
--

--
-- Dumping routines for database 'projetstock'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-24 18:46:22
