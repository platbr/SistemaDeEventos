-- MySQL dump 10.13  Distrib 5.5.19, for Win32 (x86)
--
-- Host: localhost    Database: eventos
-- ------------------------------------------------------
-- Server version	5.5.19

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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) DEFAULT NULL,
  `valor` decimal(5,2) DEFAULT NULL,
  `id_evento` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_area` (`id_evento`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `nome` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `nome` varchar(40) DEFAULT NULL,
  `inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fim` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `local` varchar(40) DEFAULT NULL,
  `id` int(5) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES ('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',1),('Corrida Maluca','2014-12-20 02:00:00','2014-12-20 02:00:00','Autodromo de Goiania',2),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',3),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',4),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',5),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',6),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',7),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',8),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',9),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',10),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',11),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',12),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',13),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',14),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',15),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',16),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',17),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',18),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',19),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',20),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',21),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',22),('Corrida Maluca','2014-12-20 02:00:00','2014-12-20 02:00:00','Autodromo de Goiania',23),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',24),('Corrida Maluca','2014-12-20 02:00:00','2014-12-20 02:00:00','Autodromo de Goiania',25),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',26),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',27),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',28),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',29),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',30),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',31),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',32),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',33),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',34),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',35),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',36),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',37),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',38),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',39),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',40),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',41),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',42),('Corrida Maluca','2014-12-20 02:00:00','2014-12-20 02:00:00','Autodromo de Goiania',43),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',44),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',45),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',46),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',47),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',48),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',49),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',50),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',51),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',52),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',53),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',54),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',55),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',56),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',57),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',58),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',59),('Corrida Maluca','2015-01-20 02:00:00','2015-01-20 02:00:00','Autodromo de Goiania',60);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresso`
--

DROP TABLE IF EXISTS `ingresso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingresso` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresso`
--

LOCK TABLES `ingresso` WRITE;
/*!40000 ALTER TABLE `ingresso` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operador`
--

DROP TABLE IF EXISTS `operador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operador` (
  `nome` varchar(40) DEFAULT NULL,
  `usuario` varchar(40) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nivel_acesso` enum('Gerencial','Operacional') DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_usuario` (`usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operador`
--

LOCK TABLES `operador` WRITE;
/*!40000 ALTER TABLE `operador` DISABLE KEYS */;
/*!40000 ALTER TABLE `operador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `status_venda` enum('Confirmado','Cancelado') DEFAULT NULL,
  `id_cliente` int(10) DEFAULT NULL,
  `id_operador` int(10) DEFAULT NULL,
  `id_ingresso` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `fk_id_operador` (`id_operador`),
  KEY `fk_id_ingresso` (`id_ingresso`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-20 22:17:25
