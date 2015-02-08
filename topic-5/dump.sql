-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: high-school
-- ------------------------------------------------------
-- Server version	5.5.41-0+wheezy1

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id_course` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `hours_by_week` int(11) NOT NULL,
  `fk_id_schedule` int(11) NOT NULL,
  PRIMARY KEY (`id_course`),
  KEY `fk_course_schedule1_idx` (`fk_id_schedule`),
  CONSTRAINT `fk_course_schedule1` FOREIGN KEY (`fk_id_schedule`) REFERENCES `schedule` (`id_schedule`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'velit in',5,2),(2,'a sollicitudin',5,5),(3,'Vestibulum',4,4),(4,'Mauris non',5,2),(5,'Nullam',3,1),(6,'lorem',3,1),(7,'nibh. Quisque',5,3),(8,'magna. Suspendisse',4,4),(9,'habitant',4,5),(10,'tempus,',4,2);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result`
--

DROP TABLE IF EXISTS `exam_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_result` (
  `id_exam` int(11) NOT NULL AUTO_INCREMENT,
  `note1` double NOT NULL,
  `note2` double NOT NULL,
  `note3` double NOT NULL,
  `final_note` double NOT NULL,
  PRIMARY KEY (`id_exam`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result`
--

LOCK TABLES `exam_result` WRITE;
/*!40000 ALTER TABLE `exam_result` DISABLE KEYS */;
INSERT INTO `exam_result` VALUES (1,4,4,6,3),(2,5,5,9,4),(3,1,4,10,8),(4,8,4,8,5),(5,1,8,6,1),(6,4,2,9,7),(7,8,1,2,4),(8,5,3,4,10),(9,10,2,4,7),(10,4,1,9,6),(11,7,6,10,10),(12,10,2,6,3),(13,3,4,10,5),(14,1,10,9,8),(15,1,6,8,8),(16,10,7,9,2),(17,2,8,10,6),(18,10,10,9,1),(19,7,3,9,6),(20,8,7,2,4);
/*!40000 ALTER TABLE `exam_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `id_schedule` int(11) NOT NULL AUTO_INCREMENT,
  `day` varchar(45) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`id_schedule`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'Monday','08:00:00','12:00:00'),(2,'Tuesday','08:00:00','12:00:00'),(3,'Wednesday','08:00:00','12:00:00'),(4,'Thursday','08:00:00','12:00:00'),(5,'Saturday','08:00:00','12:00:00');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id_student` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `registration_number` int(11) NOT NULL,
  `date_of_birth` date NOT NULL,
  `fk_id_course` int(11) NOT NULL,
  `fk_id_exam` int(11) NOT NULL,
  PRIMARY KEY (`id_student`),
  KEY `fk_student_course_idx` (`fk_id_course`),
  KEY `fk_student_exam_result1_idx` (`fk_id_exam`),
  CONSTRAINT `fk_student_course` FOREIGN KEY (`fk_id_course`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_exam_result1` FOREIGN KEY (`fk_id_exam`) REFERENCES `exam_result` (`id_exam`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'George','Sharpe',3273,'1995-12-08',1,15),(2,'Omar','Riddle',9310,'1992-04-26',1,7),(3,'Fletcher','Randall',9180,'1992-04-12',1,9),(4,'Ronan','Hatfield',2359,'1990-01-16',1,15),(5,'Colt','Salas',9384,'1989-10-29',1,12),(6,'Plato','Hansen',1291,'1998-05-31',1,6),(7,'Brody','Finley',3128,'1992-09-03',1,12),(8,'Colorado','Lang',2543,'1993-01-08',1,3),(9,'Clarke','Kaufman',2858,'2000-06-28',1,17),(10,'Cole','Gomez',5910,'1989-10-30',1,13),(11,'Ashton','Cannon',5177,'1997-04-12',1,7),(12,'Damon','Tyler',5188,'2000-05-22',1,12),(13,'Byron','Byers',4451,'1994-03-11',1,4),(14,'Lucius','Shields',6518,'1993-02-16',1,4),(15,'Trevor','Baxter',5632,'1999-10-01',1,16),(16,'Sean','Barlow',1283,'1995-07-08',1,15),(17,'Raphael','Merrill',9807,'1999-08-24',1,16),(18,'Zachary','Cochran',2068,'1994-05-12',1,6),(19,'Orson','Kerr',5983,'1993-02-11',1,10),(20,'Abbot','Kelly',9976,'1997-05-11',1,20),(21,'Cadman','Decker',4672,'1991-05-30',2,11),(22,'Asher','Kirby',1634,'2000-11-16',2,8),(23,'Kirk','Cervantes',2446,'1990-05-14',2,8),(24,'Clarke','Francis',2274,'1998-07-07',2,3),(25,'Christopher','Randall',5377,'1992-03-28',2,7),(26,'Herrod','Horn',1662,'1999-12-10',2,18),(27,'Kaseem','Reeves',3911,'1997-12-21',2,20),(28,'Ethan','Murray',4909,'1998-09-06',2,7),(29,'Gareth','Myers',4751,'1991-05-13',2,11),(30,'Wesley','Rios',1770,'1998-12-10',2,5),(31,'Kasimir','Blackwell',9506,'1993-06-20',2,10),(32,'Joseph','Monroe',7844,'2000-01-16',2,10),(33,'Vernon','Hartman',9619,'1995-08-15',2,17),(34,'Jerome','Rivers',4712,'1998-02-22',2,5),(35,'Yoshio','Dillon',2316,'1991-02-20',2,1),(36,'Emery','Parrish',8004,'1989-12-29',2,15),(37,'Malik','Hawkins',5721,'1996-04-29',2,9),(38,'Lance','Gregory',2080,'1997-01-13',2,17),(39,'Kane','Salinas',5593,'1995-09-01',2,9),(40,'Aladdin','Cantrell',7320,'1989-04-16',2,19),(41,'Zeph','Downs',6253,'2000-05-09',3,5),(42,'Timon','Smith',6916,'1998-04-05',3,9),(43,'Jordan','Goodman',2815,'2000-01-09',3,19),(44,'Garth','Morrow',8030,'1999-06-06',3,3),(45,'Devin','Tran',4909,'1990-08-13',3,11),(46,'Fritz','Todd',4731,'1998-02-24',3,1),(47,'Zachary','House',4909,'1989-02-16',3,15),(48,'Carlos','Gross',9402,'1996-05-28',3,6),(49,'Dalton','Bass',3747,'1992-01-12',3,8),(50,'Brett','Bolton',9734,'1998-09-02',3,13),(51,'Orlando','Harris',9588,'1991-03-19',3,19),(52,'Conan','Ray',4471,'1992-12-27',3,7),(53,'John','Rowe',4850,'1989-02-16',3,11),(54,'Ferdinand','Yates',2754,'1991-01-05',3,9),(55,'Vaughan','Alston',3505,'1991-07-30',3,10),(56,'Xenos','Moses',5746,'1997-11-03',3,20),(57,'Clark','Clemons',7551,'1994-10-20',3,20),(58,'Fletcher','Macdonald',8542,'1992-09-06',3,16),(59,'Yardley','Perez',6112,'1993-02-19',3,13),(60,'Graham','Daniels',4173,'1994-09-13',3,8),(61,'Malcolm','Shepherd',1175,'1992-01-25',4,3),(62,'Jin','Bright',4477,'1996-08-25',4,18),(63,'Victor','Reed',3904,'1989-12-08',4,12),(64,'Dale','Price',7191,'1989-08-22',4,18),(65,'Blaze','Watts',4999,'2000-04-27',4,8),(66,'Nolan','Stout',4719,'1995-07-19',4,3),(67,'Howard','Oconnor',5884,'1989-11-29',4,11),(68,'Dale','Hurley',7182,'1995-11-06',4,7),(69,'Acton','Terry',1588,'1992-10-23',4,1),(70,'Steven','Kerr',9657,'1999-08-16',4,13),(71,'Boris','Chan',9285,'1999-03-04',4,18),(72,'Bevis','Camacho',2304,'1989-11-25',4,11),(73,'Otto','Nixon',3710,'1997-11-04',4,19),(74,'Dorian','Holloway',3799,'1994-04-20',4,14),(75,'Harlan','May',4296,'1998-05-20',4,11),(76,'Carlos','Nicholson',7310,'1990-01-03',4,16),(77,'Lance','Patton',7210,'1991-03-07',4,2),(78,'Nathaniel','Mccall',5326,'1998-11-08',4,10),(79,'Alvin','Acosta',7019,'1993-01-09',4,20),(80,'Vernon','Martinez',8185,'1997-02-12',4,13),(81,'Carlos','Becker',5980,'1995-02-23',5,15),(82,'Kenneth','Sanchez',9788,'1996-05-15',5,4),(83,'Baker','Vinson',5267,'1996-10-16',5,3),(84,'Troy','Parker',7590,'1999-11-24',5,10),(85,'Cyrus','Battle',9605,'1993-11-23',5,9),(86,'Amir','Rivas',1659,'1996-06-23',5,9),(87,'Keegan','Jarvis',8291,'1996-08-20',5,6),(88,'Ciaran','Pierce',9078,'1998-04-08',5,10),(89,'Jackson','Stein',3623,'1999-05-03',5,15),(90,'Declan','Fuller',3211,'1989-07-02',5,15),(91,'Tobias','Mckay',3225,'1994-11-06',5,12),(92,'Calvin','Hyde',5721,'1999-12-06',5,18),(93,'Baker','Sparks',7888,'1995-06-25',5,16),(94,'Berk','Atkins',8484,'1994-04-14',5,8),(95,'Vernon','Harvey',8996,'1991-08-23',5,11),(96,'Cody','Small',5803,'1999-05-15',5,17),(97,'Zephania','Goff',4886,'1995-01-01',5,8),(98,'Hall','Larsen',3932,'1993-10-05',5,19),(99,'Stewart','Mcdonald',4033,'1991-04-13',5,20),(100,'Dale','Perry',9470,'1995-08-10',5,13);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id_teacher` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `date_of_birth` date NOT NULL,
  `fk_id_course` int(11) NOT NULL,
  PRIMARY KEY (`id_teacher`),
  KEY `fk_teacher_course1_idx` (`fk_id_course`),
  CONSTRAINT `fk_teacher_course1` FOREIGN KEY (`fk_id_course`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Selma','Kline','1980-10-18',7),(2,'Olympia','Cooley','1981-05-24',4),(3,'Eden','Kane','1982-03-27',9),(4,'Regina','Jefferson','1980-02-29',2),(5,'Lila','Ballard','1982-03-04',8),(6,'Melanie','Austin','1980-04-01',4),(7,'Kessie','Morton','1982-11-29',1),(8,'Sandra','Morrison','1982-06-14',2),(9,'Janna','Christensen','1982-08-12',6),(10,'Cara','Heath','1983-09-01',4);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'high-school'
--
/*!50003 DROP PROCEDURE IF EXISTS `getStudentIdByName` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentIdByName`(
    in studentFirstName varchar(20), 
    in studentLastName varchar(15), 
    out id int
)
BEGIN
    select id_student into id
    from student as s
    where s.first_name = studentFirstName
        and s.last_name = studentLastName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getStudentIdByRegNumber` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStudentIdByRegNumber`(in studentRegNumber varchar(15), out id int)
BEGIN
    select id_student into id 
    from student as s 
    where s.registration_number = studentRegNumber;  
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-08 12:46:12
