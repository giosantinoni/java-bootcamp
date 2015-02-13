-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: shopping_cart
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
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `billing_addess` varchar(45) NOT NULL,
  `open_date` datetime NOT NULL,
  `close_date` datetime DEFAULT NULL,
  `is_closed` tinyint(1) DEFAULT NULL,
  `payment_id` int(11) NOT NULL,
  PRIMARY KEY (`account_id`),
  KEY `fk_Account_Payment1` (`payment_id`),
  CONSTRAINT `fk_Account_Payment1` FOREIGN KEY (`payment_id`) REFERENCES `Payment` (`payment_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES (1,'9623 Facilisis, Road','2005-09-07 01:56:27',NULL,NULL,34),(2,'134-3453 Libero St.','2006-12-28 13:51:51',NULL,NULL,42),(3,'Ap #291-119 Eu St.','2012-03-04 17:48:42',NULL,NULL,20),(4,'Ap #805-5137 Nec St.','2011-09-30 15:11:31',NULL,NULL,42),(5,'Ap #906-437 Ac Road','2013-10-27 07:13:58',NULL,NULL,45),(6,'Ap #603-3097 Aenean Road','2004-10-26 18:23:21',NULL,NULL,38),(7,'6168 Est Rd.','2007-10-20 22:50:16',NULL,NULL,4),(8,'P.O. Box 968, 3724 Fringilla Road','2012-07-18 19:30:38',NULL,NULL,49),(9,'P.O. Box 284, 870 In St.','2008-05-04 07:12:21',NULL,NULL,7),(10,'2766 Interdum. St.','2005-02-09 06:29:29',NULL,NULL,25),(11,'P.O. Box 664, 3925 Sed Ave','2009-04-10 09:41:38',NULL,NULL,30),(12,'Ap #495-1147 Dolor Road','2010-08-05 15:23:25',NULL,NULL,26),(13,'P.O. Box 539, 2197 Porttitor Street','2011-04-17 22:08:09',NULL,NULL,48),(14,'6214 Consequat Av.','2009-10-01 19:34:40',NULL,NULL,1),(15,'Ap #816-2051 Dolor, Rd.','2005-06-12 19:39:17',NULL,NULL,9),(16,'P.O. Box 411, 1274 Auctor, Av.','2013-02-22 01:33:06',NULL,NULL,28),(17,'P.O. Box 879, 2280 Ac, Rd.','2008-06-27 23:26:25',NULL,NULL,32),(18,'733-194 Vulputate, Ave','2004-08-20 06:18:59',NULL,NULL,43),(19,'Ap #391-2895 Sed, Rd.','2013-03-10 16:31:19',NULL,NULL,12),(20,'592-2810 Risus. Ave','2012-12-10 08:45:20',NULL,NULL,47);
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(45) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `user_login_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `fk_Customer_WebUser` (`user_login_id`),
  KEY `fk_Customer_Account1` (`account_id`),
  CONSTRAINT `fk_Customer_WebUser` FOREIGN KEY (`user_login_id`) REFERENCES `WebUser` (`login_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_Account1` FOREIGN KEY (`account_id`) REFERENCES `Account` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (1,'249-9707 Hymenaeos. St.','070 0718 3061','aliquet.sem@velquam.edu',2,5),(2,'381-6527 Magna. Rd.','056 4911 1961','turpis@Vivamusnibh.com',27,2),(3,'1444 Quam. Avenue','(016977) 6575','Aenean.eget@mattisornarelectus.edu',20,12),(4,'Ap #135-9855 Mattis Rd.','(026) 4865 9890','ipsum@Nullainterdum.edu',34,13),(5,'859-6932 Mauris Av.','055 7542 5407','lacus.varius.et@sed.edu',1,10),(6,'904-2400 Felis St.','(0181) 941 9501','Nulla@Proinmi.org',5,9),(7,'8938 Odio Avenue','0800 1111','vel@eleifendnondapibus.org',18,20),(8,'1416 At St.','056 4980 2614','Donec.est@nullaIntegerurna.ca',10,5),(9,'Ap #213-2904 Rhoncus St.','0800 002148','Nullam.vitae.diam@ipsumPhasellus.org',48,7),(10,'P.O. Box 365, 346 Augue. Av.','07624 025790','dignissim@ac.edu',24,19);
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payment`
--

DROP TABLE IF EXISTS `Payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `paid` datetime NOT NULL,
  `total` double NOT NULL,
  `detail` varchar(100) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment`
--

LOCK TABLES `Payment` WRITE;
/*!40000 ALTER TABLE `Payment` DISABLE KEYS */;
INSERT INTO `Payment` VALUES (1,'2011-12-20 17:03:29',8106,'Mauris nulla. Integer urna. Vivamus molestie'),(2,'1999-07-23 05:23:14',1054,'fringilla, porttitor vulputate, posuere vulputate, lacus.'),(3,'2009-09-04 10:55:12',9853,'vestibulum massa rutrum magna. Cras convallis'),(4,'2009-05-28 19:15:36',9848,'Aenean sed pede nec ante blandit'),(5,'1998-02-18 11:43:09',6546,'In ornare sagittis felis. Donec tempor,'),(6,'1996-06-30 22:03:12',3612,'tempor, est ac mattis semper, dui'),(7,'2013-12-14 18:34:05',3855,'ipsum. Suspendisse sagittis. Nullam vitae diam.'),(8,'2005-08-12 09:41:56',9360,'rutrum, justo. Praesent luctus. Curabitur egestas'),(9,'2000-02-05 07:42:59',4541,'diam luctus lobortis. Class aptent taciti'),(10,'2004-07-17 09:36:12',7784,'ac urna. Ut tincidunt vehicula risus.'),(11,'2001-08-31 13:51:58',3091,'risus quis diam luctus lobortis. Class'),(12,'2010-04-30 10:35:41',4362,'purus mauris a nunc. In at'),(13,'2004-11-24 16:02:45',2086,'Nunc pulvinar arcu et pede. Nunc'),(14,'2008-08-08 12:13:16',9792,'lorem lorem, luctus ut, pellentesque eget,'),(15,'2014-07-08 16:37:30',5433,'fermentum convallis ligula. Donec luctus aliquet'),(16,'2005-01-16 22:43:48',5403,'In lorem. Donec elementum, lorem ut'),(17,'1998-02-21 18:09:42',3451,'sem eget massa. Suspendisse eleifend. Cras'),(18,'1997-08-15 18:37:20',8054,'sodales purus, in molestie tortor nibh'),(19,'2005-08-20 20:47:50',6246,'et pede. Nunc sed orci lobortis'),(20,'2011-05-16 08:36:17',366,'lorem, vehicula et, rutrum eu, ultrices'),(21,'2001-11-17 03:50:48',1385,'eleifend, nunc risus varius orci, in'),(22,'1999-06-25 17:04:46',9544,'nulla ante, iaculis nec, eleifend non,'),(23,'2001-08-20 18:16:45',3797,'Aliquam rutrum lorem ac risus. Morbi'),(24,'2009-04-04 12:05:56',7190,'vitae erat vel pede blandit congue.'),(25,'1998-05-14 20:28:41',7692,'risus. In mi pede, nonummy ut,'),(26,'2010-05-08 06:34:05',5160,'a mi fringilla mi lacinia mattis.'),(27,'2008-06-05 11:16:13',2517,'convallis est, vitae sodales nisi magna'),(28,'1997-01-12 18:26:45',1383,'Ut nec urna et arcu imperdiet'),(29,'1996-08-07 14:57:53',2846,'faucibus ut, nulla. Cras eu tellus'),(30,'2005-06-23 11:45:50',5761,'ipsum porta elit, a feugiat tellus'),(31,'1996-02-26 20:05:39',5660,'Phasellus libero mauris, aliquam eu, accumsan'),(32,'2010-01-26 10:07:41',6687,'semper. Nam tempor diam dictum sapien.'),(33,'2014-08-10 04:14:56',1275,'In nec orci. Donec nibh. Quisque'),(34,'2004-07-04 20:52:29',4887,'consectetuer, cursus et, magna. Praesent interdum'),(35,'2002-11-21 09:16:38',4032,'sed pede. Cum sociis natoque penatibus'),(36,'2008-12-16 04:38:16',3042,'egestas. Duis ac arcu. Nunc mauris.'),(37,'2011-03-06 18:09:59',9300,'montes, nascetur ridiculus mus. Aenean eget'),(38,'2003-05-01 12:41:57',9877,'eu erat semper rutrum. Fusce dolor'),(39,'2008-09-29 01:54:42',7616,'lorem, luctus ut, pellentesque eget, dictum'),(40,'2010-05-07 15:39:37',6725,'tellus non magna. Nam ligula elit,'),(41,'2004-10-04 19:07:55',6839,'gravida sit amet, dapibus id, blandit'),(42,'1999-01-22 02:24:25',1839,'erat eget ipsum. Suspendisse sagittis. Nullam'),(43,'2006-03-13 15:56:48',8449,'nostra, per inceptos hymenaeos. Mauris ut'),(44,'2001-02-20 08:33:44',9972,'porttitor scelerisque neque. Nullam nisl. Maecenas'),(45,'2015-01-15 22:58:40',8259,'turpis. In condimentum. Donec at arcu.'),(46,'2006-02-17 01:06:01',8958,'felis, adipiscing fringilla, porttitor vulputate, posuere'),(47,'2006-05-17 15:15:21',8970,'mi. Aliquam gravida mauris ut mi.'),(48,'2010-02-17 13:31:50',5307,'sit amet lorem semper auctor. Mauris'),(49,'2006-02-27 13:25:00',4999,'ullamcorper magna. Sed eu eros. Nam'),(50,'1998-05-13 01:28:29',9903,'feugiat placerat velit. Quisque varius. Nam');
/*!40000 ALTER TABLE `Payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,'laoreet ipsum. Curabitur consequat,',7318),(2,'natoque penatibus et magnis',5303),(3,'Suspendisse ac metus vitae',4155),(4,'commodo hendrerit. Donec porttitor',8218),(5,'gravida molestie arcu. Sed',9258),(6,'augue scelerisque mollis. Phasellus',6239),(7,'nibh lacinia orci, consectetuer',5251),(8,'purus ac tellus. Suspendisse',6477),(9,'et malesuada fames ac',5049),(10,'lectus rutrum urna, nec',2873),(11,'mi tempor lorem, eget',7407),(12,'pede nec ante blandit',5884),(13,'neque sed sem egestas',115),(14,'Donec tempor, est ac',9041),(15,'et, eros. Proin ultrices.',9048),(16,'luctus et ultrices posuere',2677),(17,'arcu iaculis enim, sit',9660),(18,'Sed eu nibh vulputate',3018),(19,'Duis risus odio, auctor',8714),(20,'ullamcorper. Duis at lacus.',828),(21,'dolor. Fusce feugiat. Lorem',968),(22,'fringilla. Donec feugiat metus',4929),(23,'elementum purus, accumsan interdum',9781),(24,'laoreet, libero et tristique',4779),(25,'cursus a, enim. Suspendisse',1645),(26,'quis turpis vitae purus',6573),(27,'nec enim. Nunc ut',245),(28,'inceptos hymenaeos. Mauris ut',2239),(29,'auctor odio a purus.',9543),(30,'bibendum fermentum metus. Aenean',6793),(31,'convallis erat, eget tincidunt',905),(32,'malesuada vel, convallis in,',9257),(33,'a, scelerisque sed, sapien.',9597),(34,'blandit enim consequat purus.',4159),(35,'dignissim lacus. Aliquam rutrum',823),(36,'ipsum. Suspendisse sagittis. Nullam',7205),(37,'lacinia orci, consectetuer euismod',5060),(38,'Sed eu eros. Nam',9588),(39,'lacus pede sagittis augue,',7923),(40,'gravida sit amet, dapibus',958),(41,'sociis natoque penatibus et',9570),(42,'Etiam laoreet, libero et',1094),(43,'nonummy ut, molestie in,',9110),(44,'rutrum non, hendrerit id,',9159),(45,'Cras interdum. Nunc sollicitudin',8575),(46,'Fusce mollis. Duis sit',1338),(47,'tincidunt adipiscing. Mauris molestie',5133),(48,'Sed nec metus facilisis',5477),(49,'dictum eleifend, nunc risus',5664),(50,'venenatis lacus. Etiam bibendum',5730);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WebUser`
--

DROP TABLE IF EXISTS `WebUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WebUser` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `state` varchar(10) NOT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1 COMMENT='Store information about users.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WebUser`
--

LOCK TABLES `WebUser` WRITE;
/*!40000 ALTER TABLE `WebUser` DISABLE KEYS */;
INSERT INTO `WebUser` VALUES (1,'NYH11KYD8KL','banned'),(2,'YLA40PAX2LG','active'),(3,'MCF37IXR0KF','blocked'),(4,'MCX92BBP2WO','active'),(5,'FIG37CNV9AM','new'),(6,'DXR18ACO2PR','active'),(7,'QVT50RQW7TN','new'),(8,'UVS50MRB7XP','active'),(9,'UTY62IWB4KV','blocked'),(10,'YSF99THB1OP','active'),(11,'GEW08PIL0KF','active'),(12,'DQT73SSD0KT','banned'),(13,'IDU70QGO0PC','banned'),(14,'ZNF68GIW8GZ','active'),(15,'TMB23ERL8UR','blocked'),(16,'ZDQ88GTN2RY','new'),(17,'TAJ53YSN8TL','banned'),(18,'YVA23TQA4LY','banned'),(19,'BWK99YTB0GC','banned'),(20,'JIR60OXD4QF','banned'),(21,'WLR28IKZ4AN','banned'),(22,'CYG33TIO4NR','new'),(23,'ILF34HRB3ZL','banned'),(24,'IBQ13WLE5WS','active'),(25,'CQE33OKA0VE','banned'),(26,'UZP47TNQ7GN','blocked'),(27,'QCS09KLC3YN','banned'),(28,'MTR08HKE8WZ','new'),(29,'CIY31MXZ3VU','blocked'),(30,'FBK67GIC4NJ','new'),(31,'XWX08IYG8GP','active'),(32,'QJA31CEW1IF','active'),(33,'IEA98AWO7NO','active'),(34,'FFX25OTP7BK','banned'),(35,'TQD31IYZ2ZO','active'),(36,'SOL18XZQ4DB','banned'),(37,'KLU84DRG8FL','blocked'),(38,'LTK53TVF3YU','new'),(39,'CVA10YLL5MA','blocked'),(40,'MDU48SMO0YJ','new'),(41,'OAS70TDB4WR','new'),(42,'DQV45VWY4WY','active'),(43,'ESC29IIB9PD','active'),(44,'GRH94UEU2BX','blocked'),(45,'NER56VNK2YL','banned'),(46,'FPA34DYQ5PH','active'),(47,'CKQ39ROM5AV','new'),(48,'KWH50MHH1NA','blocked'),(49,'JAP20AGD4QP','new'),(50,'UID86LVV0EU','new');
/*!40000 ALTER TABLE `WebUser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-12 23:58:50
