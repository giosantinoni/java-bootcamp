-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: high-school
-- ------------------------------------------------------
-- Server version	5.5.40-1

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'languages 1',5,2),(2,'languages 2',3,1),(3,'languages 3',4,3),(4,'practice 1',3,2),(5,'practice 2',5,3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enrollment` (
  `pk_id_student` int(11) NOT NULL,
  `pk_id_course` int(11) NOT NULL,
  PRIMARY KEY (`pk_id_student`,`pk_id_course`),
  KEY `fk_student_has_course_course1_idx` (`pk_id_course`),
  KEY `fk_student_has_course_student1_idx` (`pk_id_student`),
  CONSTRAINT `fk_student_has_course_student1` FOREIGN KEY (`pk_id_student`) REFERENCES `student` (`id_student`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_has_course_course1` FOREIGN KEY (`pk_id_course`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(15,3),(16,3),(17,3),(18,3),(19,3),(20,3),(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(9,4),(10,4),(11,4),(12,4),(13,4),(14,4),(15,4),(16,4),(17,4),(18,4),(19,4),(20,4),(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),(13,5),(14,5),(15,5),(16,5),(17,5),(18,5),(19,5),(20,5);
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result`
--

DROP TABLE IF EXISTS `exam_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_result` (
  `id_exam` int(11) NOT NULL AUTO_INCREMENT,
  `note1` int(11) NOT NULL,
  `note2` int(11) NOT NULL,
  `note3` int(11) NOT NULL,
  `final_note` int(11) NOT NULL,
  `fk_id_student` int(11) NOT NULL,
  `fk_id_course` int(11) NOT NULL,
  PRIMARY KEY (`id_exam`),
  KEY `fk_exam_result_student1_idx` (`fk_id_student`),
  KEY `fk_exam_result_course1_idx` (`fk_id_course`),
  CONSTRAINT `fk_exam_result_student1` FOREIGN KEY (`fk_id_student`) REFERENCES `student` (`id_student`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_result_course1` FOREIGN KEY (`fk_id_course`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result`
--

LOCK TABLES `exam_result` WRITE;
/*!40000 ALTER TABLE `exam_result` DISABLE KEYS */;
INSERT INTO `exam_result` VALUES (1,8,2,10,8,1,5),(2,9,2,7,4,12,1),(3,4,7,5,1,18,3),(4,7,10,6,5,1,1),(5,10,4,10,5,3,1),(6,10,7,10,2,8,3),(7,3,9,5,6,20,1),(8,1,6,10,7,10,5),(9,5,5,7,7,11,1);
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
  `day` varchar(10) NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  PRIMARY KEY (`id_schedule`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'tuesday','05:57:42','00:00:00'),(2,'sunday','10:48:46','13:51:49'),(3,'thursday','15:05:22','18:08:25'),(4,'tuesday','11:40:45','14:43:48'),(5,'sunday','09:23:08','12:26:11'),(6,'friday','02:08:15','05:11:18');
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
  `registration_number` int(11) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id_student`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'mike1','cash1',1,'1980-01-01'),(2,'mike2','cash2',2,'1981-02-02'),(3,'mike3','cash3',3,'1982-03-03'),(4,'mike4','cash4',4,'1982-04-04'),(5,'mike5','cash5',5,'1983-05-05'),(6,'mike6','cash6',6,'1984-06-06'),(7,'mike7','cash7',7,'1985-07-07'),(8,'mike8','cash8',8,'1986-08-08'),(9,'mike9','cash9',9,'1987-09-09'),(10,'mike10','cash10',10,'1988-09-09'),(11,'mike11','cash11',11,'1989-10-23'),(12,'mike12','cash12',12,'1981-11-11'),(13,'mike13','cash13',13,'1984-12-12'),(14,'mike14','cash14',14,'1984-12-03'),(15,'mike15','cash15',15,'1986-04-30'),(16,'mike16','cash16',16,'1987-03-12'),(17,'mike17','cash17',17,'1989-09-11'),(18,'mike18','cash18',18,'1984-05-05'),(19,'mike19','cash19',19,'1980-12-19'),(20,'mike20','cash20',20,'1983-12-12');
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
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id_teacher`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'john','doe','1980-12-12'),(2,'john','doe','1980-02-01'),(3,'mary','jane','1988-04-09'),(4,'peter','green','1981-04-19');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_has_course`
--

DROP TABLE IF EXISTS `teacher_has_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_has_course` (
  `pk_id_teacher` int(11) NOT NULL,
  `pk_id_course` int(11) NOT NULL,
  PRIMARY KEY (`pk_id_teacher`,`pk_id_course`),
  KEY `fk_teacher_has_course_course1_idx` (`pk_id_course`),
  KEY `fk_teacher_has_course_teacher1_idx` (`pk_id_teacher`),
  CONSTRAINT `fk_teacher_has_course_teacher1` FOREIGN KEY (`pk_id_teacher`) REFERENCES `teacher` (`id_teacher`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_has_course_course1` FOREIGN KEY (`pk_id_course`) REFERENCES `course` (`id_course`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_has_course`
--

LOCK TABLES `teacher_has_course` WRITE;
/*!40000 ALTER TABLE `teacher_has_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_has_course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-06  1:09:01
