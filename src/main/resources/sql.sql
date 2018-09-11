/*
SQLyog Professional v12.09 (64 bit)
MySQL - 8.0.12 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `kline` (
	`symbol` varchar (135),
	`open` float ,
	`high` float ,
	`low` float ,
	`end` float ,
	`tradeSize` float ,
	`time` varchar (450),
	`create_time` date ,
	`id` int (11),
	`rate` varchar (90),
	`timeformat` varchar (270)
); 
