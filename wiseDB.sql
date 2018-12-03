-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.2.3-MariaDB-log - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for wise
CREATE DATABASE IF NOT EXISTS `wise` /*!40100 DEFAULT CHARACTER SET latin2 */;
USE `wise`;

-- Dumping structure for table wise.bills
CREATE TABLE IF NOT EXISTS `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `items` varchar(255) DEFAULT NULL,
  `totalPrice` varchar(255) DEFAULT NULL,
  `PriceAfterDiscount` varchar(255) DEFAULT NULL,
  `ArrivalDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin2;

-- Dumping data for table wise.bills: ~2 rows (approximately)
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` (`id`, `firstname`, `lastname`, `phonenumber`, `address`, `gender`, `date`, `items`, `totalPrice`, `PriceAfterDiscount`, `ArrivalDate`) VALUES
	(1, 'dsf', 'fdsf', 'erw', 'dsfdsf', 'female', '23/4/2013', '\nRise and grand \nRise and grand \nThe Winds of Winter\nThe secret\nLittle bit of angels ', '680.0', '970.0', '23/5/2017'),
	(2, 'dsfwer', 'DFSDF', 'DSFDS', 'WER', 'female', '22/5/2014', '\nThe Rogue Prince\nA storm of swords\nThe secret\nThe secret\nDream of Spring', '1740.0', '1700.0', '20/6/2014'),
	(3, 'asdas', 'qwe', 'ert', 'dsfd', 'male', '23/7/2014', '\nAssassin\'s Creed\nLittle bit of angels \nIve been thinking\nclash of Kings\nclash of Kings', '1132.0', '222.0', '23/8/2014');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;

-- Dumping structure for table wise.book
CREATE TABLE IF NOT EXISTS `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `ISBN` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin2;

-- Dumping data for table wise.book: ~14 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`id`, `author`, `name`, `ISBN`, `image`, `genre`, `price`, `description`) VALUES
	(1, 'Ann Crispin', 'Rise and grand ', '125895', '9780804189958.jpg', 'Business & money ', 40, ''),
	(2, 'Elaine clayton', 'Little bit of angels ', '789654', '9781454928713.jpg', 'Fantasy', 30, NULL),
	(3, 'Oliver brown', 'The secret', '879541', 'the secrete.jpg', 'Self-help', 70, NULL),
	(4, 'George Martin', 'Assassin\'s Creed', '147852', 'Assassin\'s Creed.jpg', 'Action/Adventure', 90, NULL),
	(5, 'George Martin', 'Dream of Spring', '885236', 'GOT7_A Dream of Spring.jpg', 'Drama', 600, NULL),
	(6, 'George Martin', 'The Winds of Winter', '036974', 'GOT6_The Winds of Winter.jpg', 'Drama', 500, NULL),
	(7, 'marilyn monroe', 'My Story', '774586', 'My Story.jpg', 'Drama', 150, NULL),
	(8, 'Jeff nathanson', 'Pirates of the Caribbean', '118963', 'Pirates of the Caribbean.jpg', 'Adventure ', 100, NULL),
	(9, 'Pedro domingos', 'The master algorithm', '477854', 'he master algorithm.jpg', 'Science  ', 60, NULL),
	(10, 'George Martin', 'clash of Kings', '586254', 'GOT2_A clash Of Kings.jpg', 'Fantasy', 500, NULL),
	(11, 'George Martin', 'A storm of swords', '457525', 'GOT8_A Storm of Swords I- Steel and Snow.jpg', 'Fantasy', 500, NULL),
	(12, 'George Martin', 'The Rogue Prince', '447777', 'GOT9_The Rogue Prince.jpg', 'Fantasy', 500, NULL),
	(13, 'Steve hawking', 'Brief history of time', '447852', 'A brief histort of time.jpg', 'Cosmology', 150, NULL),
	(14, 'Tara Westover', 'Educated', '112433', 'GOT5_A Dance With Dragons.jpg', 'Biography', 50, NULL),
	(15, 'Maria Shriver', 'Ive been thinking', '976427', 'GOT4_Feast for the crows.jpg', 'Drama', 12, NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Dumping structure for table wise.cartlist
CREATE TABLE IF NOT EXISTS `cartlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin2;

-- Dumping data for table wise.cartlist: ~8 rows (approximately)
/*!40000 ALTER TABLE `cartlist` DISABLE KEYS */;
INSERT INTO `cartlist` (`id`, `user_id`, `item_id`, `type`) VALUES
	(1, 2, 12, 'book'),
	(2, 2, 11, 'book'),
	(3, 2, 3, 'book'),
	(4, 2, 3, 'book'),
	(5, 2, 5, 'book'),
	(6, 1, 4, 'book'),
	(7, 1, 2, 'book'),
	(8, 1, 15, 'book'),
	(9, 1, 10, 'book'),
	(10, 1, 10, 'book'),
	(11, 7, 14, 'book');
/*!40000 ALTER TABLE `cartlist` ENABLE KEYS */;

-- Dumping structure for table wise.magazin
CREATE TABLE IF NOT EXISTS `magazin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `Publishing` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin2;

-- Dumping data for table wise.magazin: ~9 rows (approximately)
/*!40000 ALTER TABLE `magazin` DISABLE KEYS */;
INSERT INTO `magazin` (`id`, `name`, `image`, `Publishing`, `price`, `genre`, `description`) VALUES
	(1, 'Decor', 'img_1360278291_308.jpg', 'Decoration ', 10, 'Decoration', NULL),
	(2, 'Sydati', 's3.jpg', 'Sydati ', 30, 'Sydati', NULL),
	(3, 'Laha', 'laha3.jpg', 'Laha', 40, 'Laha', NULL),
	(4, 'Business management', 'b1.jpeg', 'Newyork ', 100, 'Business ', NULL),
	(5, 'cook', 'cook1.jpg', 'Chefs ', 50, 'Cook', NULL),
	(6, 'sydati', 's1.jpg', 'Sydati ', 50, 'Sydati ', NULL),
	(7, 'sydati', 's2.jpg', 'Sydati ', 60, 'Sydati ', NULL),
	(8, 'Laha', 'laha1.jpeg', 'Laha', 70, 'Laha', NULL),
	(9, 'Laha', 'laha2.jpg', 'Laha', 40, 'Laha', NULL),
	(10, 'Business', 'page_1.jpg', 'Newyork ', 150, 'Business', NULL);
/*!40000 ALTER TABLE `magazin` ENABLE KEYS */;

-- Dumping structure for table wise.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin2;

-- Dumping data for table wise.users: ~7 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `email`, `password`) VALUES
	(1, 'usernaem 1', 'test@test.com', '123123'),
	(2, 'dsf', 'sad@sad.com', 'sdfsdf'),
	(3, 'dfg', 'dfg', 'dfg@dfsd'),
	(4, 'sf', 'sf', 'sdf.com'),
	(5, 'sdf', 'dsf', 'sdf'),
	(6, 'admin', 'admin@admin', '123123'),
	(7, 'dsf', 'sdfwer', 'sdfsdf');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
