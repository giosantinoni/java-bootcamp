-- MySQL dump 10.13  Distrib 5.6.23, for Linux (x86_64)
--
-- Host: localhost    Database: high-school
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `hoursByWeek` float NOT NULL,
  `Teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Course_Teacher_idx` (`Teacher_id`),
  CONSTRAINT `fk_Course_Teacher` FOREIGN KEY (`Teacher_id`) REFERENCES `Teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES (1,'The power of microeconomics',3,1),(2,'How Things Work',3,2),(3,'Organic Solar Cells',3,2),(4,'Physics 1',3,1),(5,'Bacteria and Chronic Infections',3,3);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Registration`
--

DROP TABLE IF EXISTS `Registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Registration` (
  `Course_id` int(11) NOT NULL,
  `Student_id` int(11) NOT NULL,
  `partialNote1` int(11) DEFAULT NULL,
  `partialNote2` int(11) DEFAULT NULL,
  `partialNote3` int(11) DEFAULT NULL,
  `finalNote` int(11) DEFAULT NULL,
  PRIMARY KEY (`Course_id`,`Student_id`),
  KEY `fk_Course_has_Student_Student1_idx` (`Student_id`),
  KEY `fk_Course_has_Student_Course1_idx` (`Course_id`),
  CONSTRAINT `fk_Course_has_Student_Course1` FOREIGN KEY (`Course_id`) REFERENCES `Course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Course_has_Student_Student1` FOREIGN KEY (`Student_id`) REFERENCES `Student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Registration`
--

LOCK TABLES `Registration` WRITE;
/*!40000 ALTER TABLE `Registration` DISABLE KEYS */;
INSERT INTO `Registration` VALUES (1,1,9,10,3,4),(1,2,5,9,3,6),(1,3,2,7,8,4),(1,4,9,10,9,1),(1,5,4,9,2,8),(1,6,2,1,2,2),(1,7,1,7,2,8),(1,8,6,9,10,6),(1,9,2,5,7,8),(1,10,1,9,8,1),(1,11,10,3,7,6),(1,12,1,3,2,6),(1,13,9,5,7,8),(1,14,6,10,7,7),(1,15,9,5,10,5),(1,16,9,6,4,3),(1,17,5,8,10,6),(1,18,7,2,3,5),(1,19,4,2,10,2),(1,20,2,5,5,2),(2,21,1,6,6,9),(2,22,1,7,1,1),(2,23,5,7,9,7),(2,24,4,1,10,10),(2,25,1,2,2,9),(2,26,3,7,2,10),(2,27,5,9,5,9),(2,28,1,2,3,1),(2,29,1,9,1,10),(2,30,7,9,7,4),(2,31,9,6,1,2),(2,32,10,2,6,8),(2,33,3,10,6,3),(2,34,4,5,9,3),(2,35,7,1,10,3),(2,36,4,2,7,10),(2,37,4,7,10,4),(2,38,10,6,4,7),(2,39,7,6,2,8),(2,40,8,2,10,9),(3,41,10,4,7,5),(3,42,5,6,4,7),(3,43,9,2,7,2),(3,44,2,9,6,1),(3,45,6,5,10,5),(3,46,10,6,6,8),(3,47,5,9,9,5),(3,48,6,1,4,4),(3,49,8,6,10,7),(3,50,7,7,6,3),(3,51,5,1,9,2),(3,52,4,5,8,3),(3,53,1,10,10,1),(3,54,7,3,10,8),(3,55,4,7,4,3),(3,56,4,6,9,7),(3,57,2,7,8,6),(3,58,7,6,2,9),(3,59,2,9,5,5),(3,60,8,2,9,4),(4,61,8,10,7,7),(4,62,4,3,2,8),(4,63,9,6,9,8),(4,64,8,10,7,10),(4,65,7,8,1,2),(4,66,5,4,6,2),(4,67,7,8,7,6),(4,68,9,1,3,9),(4,69,10,8,10,1),(4,70,2,6,9,1),(4,71,6,10,1,7),(4,72,7,9,8,4),(4,73,10,9,3,2),(4,74,10,5,6,9),(4,75,7,4,2,4),(4,76,1,3,7,4),(4,77,8,10,7,10),(4,78,10,7,3,7),(4,79,1,7,8,10),(4,80,1,3,7,2),(5,81,2,2,1,1),(5,82,7,6,9,2),(5,83,2,8,8,5),(5,84,5,9,8,2),(5,85,8,9,3,10),(5,86,8,1,8,8),(5,87,2,10,10,9),(5,88,10,7,3,8),(5,89,1,9,7,8),(5,90,10,6,8,1),(5,91,2,9,2,5),(5,92,1,7,9,5),(5,93,7,5,9,2),(5,94,10,9,7,9),(5,95,2,3,8,2),(5,96,10,7,5,3),(5,97,3,1,3,2),(5,98,6,10,5,1),(5,99,3,7,2,1),(5,100,1,4,5,1);
/*!40000 ALTER TABLE `Registration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Schedule`
--

DROP TABLE IF EXISTS `Schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `day` varchar(10) NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `Course_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Schedule_Course1_idx` (`Course_id`),
  CONSTRAINT `fk_Schedule_Course1` FOREIGN KEY (`Course_id`) REFERENCES `Course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Schedule`
--

LOCK TABLES `Schedule` WRITE;
/*!40000 ALTER TABLE `Schedule` DISABLE KEYS */;
INSERT INTO `Schedule` VALUES (7,'Monday','09:00:00','10:30:00',1),(8,'Wednesday','09:00:00','10:30:00',1),(9,'Tuesday','09:00:00','10:30:00',2),(10,'Thursday','09:00:00','10:30:00',2),(11,'Wednesday','10:30:00','12:00:00',3),(12,'Friday','09:00:00','10:30:00',3),(13,'Monday','15:00:00','16:30:00',4),(14,'Wednesday','15:00:00','16:30:00',4),(15,'Tuesday','15:00:00','16:30:00',5),(16,'Thursday','15:00:00','16:30:00',5);
/*!40000 ALTER TABLE `Schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `index2` (`lastName`)
) ENGINE=InnoDB AUTO_INCREMENT=361 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,'Bart','Simpson','1990-07-08'),(2,'Lisa','Simpson','1992-01-02'),(3,'Margaret','Simpson','1995-11-02'),(4,'Rod','Flanders','1990-05-08'),(5,'Tod','Flanders','1992-05-08'),(6,'Milhouse','Van Houten','1990-05-08'),(7,'Martin','Prince','1990-05-08'),(8,'Jessica','Lovejoy','1992-05-08'),(9,'Nelson','Muntz','1989-05-08'),(10,'Gummy','Spuckler','1992-05-08'),(11,'Tiffany','Spuckler','1990-05-08'),(12,'Lizzie','Spuckler','1990-05-08'),(13,'Jackson','Spuckler','1992-12-15'),(14,'Heather','Spuckler','1992-12-15'),(15,'Lauren','Spuckler','1988-12-08'),(16,'Corky','Jones','1988-01-08'),(17,'Terry','Something','1990-05-08'),(18,'Sherry','Something','1990-04-08'),(19,'Alex','Withney','1992-05-06'),(20,'Ralph','Wiggum','1992-05-28'),(21,'Jonah','Velasquez','1996-12-11'),(22,'Hiroko','Tucker','1990-04-05'),(23,'Beatrice','Workman','1992-05-18'),(24,'Xandra','Mays','1992-04-16'),(25,'Hector','Fitzgerald','1995-10-28'),(26,'Chadwick','Wynn','1992-06-20'),(27,'Thor','Juarez','1998-05-13'),(28,'Jelani','Peck','1990-07-24'),(29,'Tatyana','Bowman','1991-05-29'),(30,'Basil','Nichols','1997-04-25'),(31,'Amena','Brooks','1997-08-04'),(32,'Nathaniel','Garner','1991-07-22'),(33,'Gray','Ramsey','1991-05-20'),(34,'Phoebe','Johnson','1998-04-07'),(35,'Echo','Sloan','1999-03-20'),(36,'Yasir','Pitts','1992-05-30'),(37,'Harper','Bond','1990-07-02'),(38,'Louis','Clemons','1995-04-22'),(39,'Fitzgerald','Silva','1993-05-15'),(40,'Jack','Norton','1998-07-20'),(41,'Mira','Bradshaw','2000-01-01'),(42,'Zahir','Dodson','1991-11-15'),(43,'Nomlanga','Hull','1989-04-22'),(44,'Joelle','Stafford','1993-08-20'),(45,'Nora','Griffith','1993-04-23'),(46,'Justin','Harding','1996-10-01'),(47,'John','Gibson','1995-09-23'),(48,'Cheyenne','Kent','1991-04-30'),(49,'Wing','Oneal','1995-01-06'),(50,'Debra','Grant','1999-05-02'),(51,'Dacey','Wall','1998-11-26'),(52,'Colleen','Pearson','1993-12-11'),(53,'Sebastian','Burton','1994-04-26'),(54,'Andrew','Fisher','1994-01-23'),(55,'Grady','Colon','1992-12-05'),(56,'Chava','Byers','1997-04-07'),(57,'Drake','Cochran','1995-02-12'),(58,'Tobias','Booker','1996-02-24'),(59,'Hall','Holmes','1997-10-25'),(60,'Robert','Stewart','1996-07-09'),(61,'Russell','Mckay','1989-08-08'),(62,'Zephr','Conway','1995-12-23'),(63,'Kiona','Guerrero','1994-03-26'),(64,'Ian','Chavez','1997-04-29'),(65,'Noah','Mullen','1995-04-20'),(66,'Mona','Noel','1994-11-14'),(67,'Mari','Spencer','1990-02-24'),(68,'Wallace','Strickland','1994-04-30'),(69,'Hakeem','Scott','1989-06-07'),(70,'Geoffrey','Marquez','1992-05-24'),(71,'Armando','Bishop','1999-09-29'),(72,'Preston','Greene','1996-09-25'),(73,'Rahim','Gilliam','1991-09-05'),(74,'Rudyard','Burks','1989-02-03'),(75,'Gregory','Taylor','1992-08-19'),(76,'Melanie','Gates','1997-04-02'),(77,'Daria','Sparks','1991-04-30'),(78,'Armando','Buck','1994-06-26'),(79,'Kadeem','Frazier','1999-04-20'),(80,'Emerson','Reynolds','1989-09-16'),(81,'Branden','Christensen','1996-05-05'),(82,'Oscar','Rice','1995-04-20'),(83,'Magee','Jacobson','1999-06-03'),(84,'Quyn','Walters','1992-04-14'),(85,'Ira','Delgado','1995-12-12'),(86,'Jane','Ray','1996-04-10'),(87,'Mona','Reynolds','1991-02-04'),(88,'Nehru','Collins','1994-01-23'),(89,'Chiquita','Keith','1992-02-29'),(90,'Fleur','Mcclure','1991-06-17'),(91,'Shaine','Russo','1994-02-07'),(92,'Melvin','Guerra','1991-12-24'),(93,'Cynthia','Griffith','1990-02-05'),(94,'Ivana','Spence','1997-05-30'),(95,'Kimberley','Holden','1996-02-20'),(96,'Regina','Horn','1992-05-31'),(97,'Dennis','Collier','1999-11-06'),(98,'Lois','Santiago','2000-01-31'),(99,'Herman','Johnson','1994-05-02'),(100,'Cullen','Collins','1996-06-28'),(101,'Nelle','Williamson','1991-12-12'),(102,'Tashya','Haney','1995-09-06'),(103,'Lani','Martinez','1994-12-02'),(104,'Echo','Watson','1990-06-07'),(105,'Kaitlin','Jordan','1994-03-06'),(106,'Yoshi','Stone','1996-04-20'),(107,'Haviva','Kemp','1997-10-20'),(108,'Steven','Boone','1999-05-29'),(109,'Tamekah','Olsen','1995-02-19'),(110,'Cynthia','Hooper','1997-07-07'),(111,'Kessie','Walker','1994-09-02'),(112,'Madaline','Merritt','1998-11-25'),(113,'Violet','Burgess','1989-10-13'),(114,'Chanda','Morales','1993-10-23'),(115,'Urielle','Whitaker','1993-05-29'),(116,'Ali','Jones','1989-08-19'),(117,'Karen','Holman','1992-06-07'),(118,'Talon','Collins','1989-04-11'),(119,'Knox','Silva','1999-09-03'),(120,'Yeo','Wooten','1996-01-05');
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (1,'Sheldon','Cooper','1979-04-08'),(2,'Leonard','Hofstadter','1979-05-06'),(3,'Bernadette','Rostenkowski','1981-05-28');
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-05 12:50:09
