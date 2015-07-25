-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2014 at 05:52 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `inventory_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `addtovehical`
--

CREATE TABLE IF NOT EXISTS `addtovehical` (
  `vehicalNo` varchar(100) NOT NULL,
  `invoiceNo` int(11) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `quantity_Pack` int(11) NOT NULL,
  `quantity_Unit` int(11) NOT NULL,
  PRIMARY KEY (`vehicalNo`,`invoiceNo`,`itemName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addtovehical`
--

INSERT INTO `addtovehical` (`vehicalNo`, `invoiceNo`, `itemName`, `date`, `quantity_Pack`, `quantity_Unit`) VALUES
('Mama Vehical', 1, 'Jelly Bottle (5/-)', '2014-10-17', 5, 750);

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE IF NOT EXISTS `bill` (
  `billNo` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`billNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`billNo`, `date`) VALUES
(1, '2014-10-08'),
(9, '2014-10-28'),
(66, '2014-10-27'),
(95, '2014-10-27'),
(100, '2014-10-28'),
(111, '2014-10-28'),
(300, '2014-10-28'),
(344, '2014-10-28'),
(400, '2014-10-28'),
(555, '2014-10-28'),
(988, '2014-10-28'),
(1111, '2014-10-28'),
(4354, '2014-10-28'),
(9876, '2014-10-28'),
(65456, '2014-10-28'),
(95135, '2014-10-28'),
(99999, '2014-10-28');

-- --------------------------------------------------------

--
-- Table structure for table `bill_item`
--

CREATE TABLE IF NOT EXISTS `bill_item` (
  `billNo` int(11) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `quantity_Unit` int(11) NOT NULL,
  `reason` varchar(500) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`billNo`,`itemName`,`status`,`quantity_Unit`),
  KEY `itemName` (`itemName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_item`
--

INSERT INTO `bill_item` (`billNo`, `itemName`, `status`, `quantity_Unit`, `reason`, `price`) VALUES
(1, 'Jelly Bottle (5/-)', 'issued', 50, '', '0.00'),
(1, 'Jelly Jumbo Bottle (20/-)', 'issued', 25, '', '0.00'),
(1, 'Jelly Jumbo Bottle (20/-)', 'returned', 5, 'expired', '0.00'),
(66, 'Jelly Bottle (5/-)', 'Issued', 65, '', '0.00'),
(95, 'Jelly Bottle (5/-)', 'Issued', 2, '', '0.00'),
(95, 'my item', 'Issued', 2, '', '0.00'),
(100, 'Jelly Bottle (5/-)', 'Issued', 500, '', '0.00'),
(111, 'Jelly Bottle (5/-)', 'Issued', 2, 'Issued', '7.54'),
(344, 'Jelly Bottle (5/-)', 'Issued', 3, 'Issued', '11.31'),
(400, 'Jelly Bottle (5/-)', 'Issued', 50, 'Issued', '189.00'),
(555, 'Jelly Bottle (5/-)', 'Issued', 50, 'Issued', '189.00'),
(4354, 'Jelly Bottle (5/-)', 'Issued', 30, 'Issued', '113.10'),
(9876, 'ice cream', 'Issued', 2500, 'Issued', '22500.00'),
(9876, 'Jelly Bottle (5/-)', 'Issued', 36, 'Issued', '135.72'),
(9876, 'Jelly Jumbo Bottle (20/-)', 'Issued', 25, 'Issued', '437.50'),
(65456, 'Jelly Bottle (5/-)', 'Issued', 3, 'Issued', '11.31'),
(65456, 'Jelly Jumbo Bottle (20/-)', 'Issued', 500, 'Issued', '8750.00'),
(95135, 'ice cream', 'Issued', 570, 'Issued', '5130.00'),
(95135, 'Jelly Bottle (5/-)', 'Issued', 5, 'Issued', '18.85'),
(95135, 'Jelly Jumbo Bottle (20/-)', 'Issued', 57, 'Issued', '997.50'),
(99999, 'Jelly Bottle (5/-)', 'Issued', 20, 'Issued', '75.40');

-- --------------------------------------------------------

--
-- Table structure for table `cheque`
--

CREATE TABLE IF NOT EXISTS `cheque` (
  `chequeNo` int(11) NOT NULL,
  `Bank` varchar(100) NOT NULL,
  `exDate` date NOT NULL,
  `Amount` decimal(10,2) NOT NULL,
  `paymentId` int(11) NOT NULL,
  PRIMARY KEY (`chequeNo`,`Bank`),
  KEY `paymentId` (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cheque`
--

INSERT INTO `cheque` (`chequeNo`, `Bank`, `exDate`, `Amount`, `paymentId`) VALUES
(3214568, 'Ceylon bank', '2014-10-25', '2000.00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE IF NOT EXISTS `company` (
  `name` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`name`, `id`, `phone`) VALUES
('Rubi', 1, '+94412222222'),
('HiCompany', 2, '9471'),
('abc', 3, '02ee');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE IF NOT EXISTS `invoice` (
  `invoiceNo` int(11) NOT NULL,
  `date` date NOT NULL,
  `companyName` varchar(100) NOT NULL,
  PRIMARY KEY (`invoiceNo`),
  KEY `companyName` (`companyName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoiceNo`, `date`, `companyName`) VALUES
(1, '2014-10-16', 'Rubi'),
(123, '2014-10-27', 'abc'),
(234, '2014-10-26', 'rubi'),
(321, '2014-10-26', 'rubi'),
(369, '2014-10-26', 'rubi'),
(549, '2014-10-26', 'rubi'),
(555, '2014-10-28', 'rubi'),
(569, '2014-10-28', 'rubi'),
(654, '2014-10-26', 'rubi'),
(753, '2014-10-26', 'rubi'),
(951, '2014-10-26', 'rubi'),
(963, '2014-10-26', 'rubi'),
(999, '2014-10-28', 'rubi'),
(1111, '2014-10-28', 'rubi'),
(3215, '2014-10-28', 'rubi'),
(4444, '2014-10-28', 'rubi'),
(7777, '2014-10-28', 'rubi'),
(65485, '2014-10-27', 'rubi'),
(98523, '2014-10-28', 'rubi'),
(333333, '2014-10-28', 'rubi');

-- --------------------------------------------------------

--
-- Table structure for table `invoice_item`
--

CREATE TABLE IF NOT EXISTS `invoice_item` (
  `invoiceNo` int(11) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `noOfBox` int(11) NOT NULL,
  `agentPrice_Pack` decimal(10,2) NOT NULL,
  `wsPrice_Pack` decimal(10,2) NOT NULL,
  `retailPrice_Pack` decimal(10,2) NOT NULL,
  `remainingCapacity_Box` int(11) NOT NULL,
  `total` decimal(10,0) NOT NULL,
  PRIMARY KEY (`invoiceNo`,`itemName`),
  KEY `invoiceNo` (`invoiceNo`),
  KEY `itemName` (`itemName`),
  KEY `invoiceNo_2` (`invoiceNo`),
  KEY `itemName_2` (`itemName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice_item`
--

INSERT INTO `invoice_item` (`invoiceNo`, `itemName`, `noOfBox`, `agentPrice_Pack`, `wsPrice_Pack`, `retailPrice_Pack`, `remainingCapacity_Box`, `total`) VALUES
(1, 'Jelly Bottle (5/-)', 50, '452.80', '566.00', '750.00', 50, '0'),
(123, 'ice cream', 12, '65.00', '87.00', '98.00', 12, '0'),
(123, 'my item', 12, '45.00', '5.00', '34.00', 12, '0'),
(234, 'Jelly Bottle (5/-)', 65, '452.80', '566.00', '750.00', 65, '0'),
(321, 'Jelly Bottle (5/-)', 95, '452.80', '566.00', '750.00', 95, '0'),
(369, 'Jelly Bottle (5/-)', 78, '452.80', '566.00', '750.00', 78, '0'),
(549, 'Jelly Bottle (5/-)', 150, '452.80', '566.00', '750.00', 150, '0'),
(555, 'Jelly Bottle (5/-)', 2, '452.80', '566.00', '750.00', 2, '906'),
(569, 'Jelly Bottle (5/-)', 4, '452.80', '566.00', '750.00', 4, '0'),
(963, 'Jelly Bottle (5/-)', 95, '452.80', '566.00', '750.00', 95, '0'),
(999, 'Hi Item', 20000, '20.00', '25.00', '30.00', 20000, '400000'),
(999, 'ice cream', 20000, '65.00', '87.00', '98.00', 20000, '1300000'),
(999, 'Jelly Bottle (5/-)', 20000, '452.80', '566.00', '750.00', 20000, '9056000'),
(999, 'my item', 3, '45.00', '5.00', '34.00', 3, '135'),
(1111, 'ice cream', 12, '65.00', '87.00', '98.00', 12, '780'),
(1111, 'Jelly Bottle (5/-)', 2, '452.80', '566.00', '750.00', 2, '906'),
(1111, 'my item', 4, '45.00', '5.00', '34.00', 4, '180'),
(3215, 'Jelly Bottle (5/-)', 10, '452.80', '566.00', '750.00', 10, '4528'),
(3215, 'my item', 2, '45.00', '5.00', '34.00', 2, '90'),
(4444, 'Jelly Bottle (5/-)', 3, '452.80', '566.00', '750.00', 3, '1358'),
(7777, 'Jelly Bottle (5/-)', 2, '452.80', '566.00', '750.00', 2, '906'),
(98523, 'Jelly Bottle (5/-)', 1, '452.80', '566.00', '750.00', 1, '0'),
(98523, 'Jelly Jumbo Bottle (20/-)', 12, '504.00', '630.00', '720.00', 12, '0'),
(333333, 'Jelly Bottle (5/-)', 2, '452.80', '566.00', '750.00', 2, '906');

-- --------------------------------------------------------

--
-- Table structure for table `issuebill`
--

CREATE TABLE IF NOT EXISTS `issuebill` (
  `vehicalName` varchar(100) NOT NULL,
  `billNo` int(11) NOT NULL,
  `shopName` varchar(100) NOT NULL,
  PRIMARY KEY (`billNo`),
  KEY `vehicalNo` (`vehicalName`,`shopName`),
  KEY `shopName` (`shopName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuebill`
--

INSERT INTO `issuebill` (`vehicalName`, `billNo`, `shopName`) VALUES
('Kandy Lorry', 4354, 'HelloShop'),
('Kandy Lorry', 9876, 'HelloShop'),
('Kandy Lorry', 65456, 'HelloShop'),
('Kandy Lorry', 95135, 'HelloShop'),
('Kandy Lorry', 99999, 'HelloShop'),
('Mama Vehical', 1, 'HelloShop');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `itemId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `agentPrice_Pack` decimal(10,2) NOT NULL,
  `wsPrice_Pack` decimal(10,2) NOT NULL,
  `retailPrice_Pack` decimal(10,2) NOT NULL,
  `agentPrice_Unit` decimal(10,2) NOT NULL,
  `wsPrice_Unit` decimal(10,2) NOT NULL,
  `retailPrice_Unit` decimal(10,2) NOT NULL,
  `unitPerBox` int(11) NOT NULL,
  `currentStock` int(11) DEFAULT '0',
  PRIMARY KEY (`itemId`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`itemId`, `name`, `agentPrice_Pack`, `wsPrice_Pack`, `retailPrice_Pack`, `agentPrice_Unit`, `wsPrice_Unit`, `retailPrice_Unit`, `unitPerBox`, `currentStock`) VALUES
(1, 'Jelly Bottle (5/-)', '452.80', '566.00', '750.00', '3.02', '3.77', '5.00', 150, 20030),
(2, 'Jelly Jumbo Bottle (20/-)', '504.00', '630.00', '720.00', '12.60', '17.50', '20.00', 36, 12),
(4, 'Hi Item', '20.00', '25.00', '30.00', '0.20', '0.25', '0.30', 10, 20000),
(5, 'my item', '45.00', '5.00', '34.00', '43.00', '43.00', '23.00', 43, 39),
(6, 'ice cream', '65.00', '87.00', '98.00', '7.00', '9.00', '8.00', 32, 20024);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE IF NOT EXISTS `payment` (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `billNo` int(11) NOT NULL,
  `paymentType` varchar(100) NOT NULL COMMENT 'cheque or cash or loan',
  `status` varchar(100) NOT NULL COMMENT 'pending or paid or credited',
  `paidDate` date NOT NULL,
  `inout` varchar(100) NOT NULL COMMENT 'income or outgoing',
  `totalAmount` decimal(10,2) NOT NULL,
  `paidAmount` int(11) NOT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `billNo` (`billNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentId`, `billNo`, `paymentType`, `status`, `paidDate`, `inout`, `totalAmount`, `paidAmount`) VALUES
(2, 1, 'cheque', 'pending', '2014-10-16', 'income', '4000.00', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `payment_invoice`
--

CREATE TABLE IF NOT EXISTS `payment_invoice` (
  `invoiceId` int(11) NOT NULL,
  `paymentId` int(11) NOT NULL,
  PRIMARY KEY (`invoiceId`,`paymentId`),
  KEY `paymentId` (`paymentId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

CREATE TABLE IF NOT EXISTS `shop` (
  `name` varchar(100) NOT NULL,
  `address` varchar(500) NOT NULL,
  `registrateDate` date NOT NULL,
  `remainingAmount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shop`
--

INSERT INTO `shop` (`name`, `address`, `registrateDate`, `remainingAmount`) VALUES
('HelloShop', 'Address', '2014-10-17', '2000.00');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`username`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`username`, `password`, `id`) VALUES
('Admin', 'Adminpwd', 1);

-- --------------------------------------------------------

--
-- Table structure for table `vehical`
--

CREATE TABLE IF NOT EXISTS `vehical` (
  `vehicalNo` varchar(100) NOT NULL,
  `vehicalName` varchar(100) NOT NULL,
  `remainingCapacity_Uni` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`vehicalNo`),
  UNIQUE KEY `vehicalName` (`vehicalName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehical`
--

INSERT INTO `vehical` (`vehicalNo`, `vehicalName`, `remainingCapacity_Uni`) VALUES
('1', 'Mama Vehical', 1500),
('12345', 'Matara Lorry', 0),
('9875', 'Kandy Lorry', -500);

-- --------------------------------------------------------

--
-- Table structure for table `vehicalinventory`
--

CREATE TABLE IF NOT EXISTS `vehicalinventory` (
  `vehicalName` varchar(100) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `quantity_unit` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`vehicalName`,`itemName`),
  KEY `itemName` (`itemName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicalinventory`
--

INSERT INTO `vehicalinventory` (`vehicalName`, `itemName`, `quantity_unit`) VALUES
('Kandy Lorry', 'Hi Item', 0),
('Kandy Lorry', 'ice cream', 2572),
('Kandy Lorry', 'Jelly Bottle (5/-)', 208),
('Kandy Lorry', 'Jelly Jumbo Bottle (20/-)', 418),
('Kandy Lorry', 'my item', 0),
('Matara Lorry', 'Hi Item', 0),
('Matara Lorry', 'ice cream', 0),
('Matara Lorry', 'Jelly Bottle (5/-)', 0),
('Matara Lorry', 'Jelly Jumbo Bottle (20/-)', 0),
('Matara Lorry', 'my item', 0);

-- --------------------------------------------------------

--
-- Table structure for table `vehical_item`
--

CREATE TABLE IF NOT EXISTS `vehical_item` (
  `vehicalName` varchar(100) NOT NULL,
  `itemName` varchar(100) NOT NULL,
  `quantity_unit` int(11) NOT NULL,
  `date` date NOT NULL,
  `quantity_Box` int(11) NOT NULL,
  PRIMARY KEY (`vehicalName`,`itemName`,`date`),
  KEY `itemName` (`itemName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehical_item`
--

INSERT INTO `vehical_item` (`vehicalName`, `itemName`, `quantity_unit`, `date`, `quantity_Box`) VALUES
('Kandy Lorry', 'Jelly Bottle (5/-)', 300, '2014-10-01', 2),
('Kandy Lorry', 'Jelly Bottle (5/-)', 300, '2014-10-28', 2),
('Mama Vehical', 'Jelly Bottle (5/-)', 300, '2014-10-28', 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill_item`
--
ALTER TABLE `bill_item`
  ADD CONSTRAINT `bill_item_ibfk_1` FOREIGN KEY (`billNo`) REFERENCES `bill` (`billNo`),
  ADD CONSTRAINT `bill_item_ibfk_2` FOREIGN KEY (`itemName`) REFERENCES `item` (`name`);

--
-- Constraints for table `cheque`
--
ALTER TABLE `cheque`
  ADD CONSTRAINT `cheque_ibfk_1` FOREIGN KEY (`paymentId`) REFERENCES `payment` (`paymentId`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`companyName`) REFERENCES `company` (`name`);

--
-- Constraints for table `invoice_item`
--
ALTER TABLE `invoice_item`
  ADD CONSTRAINT `invoice_item_ibfk_1` FOREIGN KEY (`invoiceNo`) REFERENCES `invoice` (`invoiceNo`),
  ADD CONSTRAINT `invoice_item_ibfk_2` FOREIGN KEY (`itemName`) REFERENCES `item` (`name`);

--
-- Constraints for table `issuebill`
--
ALTER TABLE `issuebill`
  ADD CONSTRAINT `issuebill_ibfk_1` FOREIGN KEY (`vehicalName`) REFERENCES `vehical` (`vehicalName`),
  ADD CONSTRAINT `issuebill_ibfk_2` FOREIGN KEY (`billNo`) REFERENCES `bill` (`billNo`),
  ADD CONSTRAINT `issuebill_ibfk_3` FOREIGN KEY (`shopName`) REFERENCES `shop` (`name`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`billNo`) REFERENCES `issuebill` (`billNo`);

--
-- Constraints for table `payment_invoice`
--
ALTER TABLE `payment_invoice`
  ADD CONSTRAINT `payment_invoice_ibfk_1` FOREIGN KEY (`invoiceId`) REFERENCES `invoice` (`invoiceNo`),
  ADD CONSTRAINT `payment_invoice_ibfk_2` FOREIGN KEY (`paymentId`) REFERENCES `payment` (`paymentId`);

--
-- Constraints for table `vehicalinventory`
--
ALTER TABLE `vehicalinventory`
  ADD CONSTRAINT `vehicalinventory_ibfk_2` FOREIGN KEY (`itemName`) REFERENCES `item` (`name`),
  ADD CONSTRAINT `vehicalinventory_ibfk_1` FOREIGN KEY (`vehicalName`) REFERENCES `vehical` (`vehicalName`);

--
-- Constraints for table `vehical_item`
--
ALTER TABLE `vehical_item`
  ADD CONSTRAINT `vehical_item_ibfk_1` FOREIGN KEY (`vehicalName`) REFERENCES `vehical` (`vehicalName`),
  ADD CONSTRAINT `vehical_item_ibfk_2` FOREIGN KEY (`itemName`) REFERENCES `item` (`name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
