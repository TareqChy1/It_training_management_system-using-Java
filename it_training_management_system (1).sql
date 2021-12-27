-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2019 at 03:07 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it training management system`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `courseId` varchar(8) NOT NULL,
  `courseName` varchar(30) NOT NULL,
  `courseFee` double(8,2) NOT NULL,
  `duration` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseId`, `courseName`, `courseFee`, `duration`) VALUES
('c01', 'Graphic  ', 14000.00, '3 months'),
('c02', 'SEO', 12000.00, '5 months'),
('c03', 'CPA Marketing', 10000.00, '3 months'),
('c04', 'Apps Devlopment', 10000.00, '4 months'),
('c05', 'Web Design', 10000.00, '3 months'),
('c06', 'Java', 10000.00, '3 months'),
('c01', 'Graphic  ', 14000.00, '3 months'),
('c01', 'Graphic  ', 14000.00, '3 months');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `empId` varchar(8) NOT NULL,
  `name` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`empId`, `name`, `designation`, `salary`) VALUES
('e01', 'khairul alam', 'Manager', 50000.00),
('e02', 'Prokrity ', 'Trainer', 15000.00),
('e03', 'Roza Mia', 'Trainer', 15000.00),
('e04', 'Krisna Ahmed', 'Trainer', 12000.00),
('e05', 'Saron Ahmed', 'Clerk', 5000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('e01', 'e01', 0),
('e02', 'e02', 1),
('s01', 's02', 2),
('s02', 's02', 2),
('e03', 'e03', 1),
('81653', '14748104', 0),
('38927', '10511774', 2),
('58963', '10929276', 2),
('15734', '12206688', 2),
('10275', '15683803', 2),
('18833', '14259615', 2),
('103323', '12614036', 2),
('77616', '17440107', 2),
('28130', '13330081', 2),
('107280', '12822775', 2),
('54976', '10150482', 2),
('27989', '15418962', 2),
('74334', '15863473', 2),
('29753', '17424529', 2),
('49360', '12172930', 2),
('39698', '15719440', 2);

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `purchaseId` varchar(8) NOT NULL,
  `courseId` varchar(4) NOT NULL,
  `studentId` varchar(8) NOT NULL,
  `studentName` varchar(30) NOT NULL,
  `amount` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`purchaseId`, `courseId`, `studentId`, `studentName`, `amount`) VALUES
('p01', 'c03', 's01', 'Mitila Alam', 10000.00),
('p02', 'c02', 's02', 'Mahajabin Chowdhury', 10000.00),
('p03', 'c05', 's03', 'Jafia Hossain', 10000.00),
('p04', 'c03', 's04', 'Maria Ahmed', 10000.00),
('p05', 'c04', 's05', 'Lalin', 10000.00),
('p06', 'c02', '10275', 'rokib', 10000.00),
('p07', 'c02', '18833', 'promi', 10000.00),
('11099229', 'c02', '15734', 'borhan', 10000.00),
('16793092', 'c01', 's01', 'Manik', 12000.00),
('16053', 'c02', '29753', 'rimu', 12000.00),
('441733', 'c02', '49360', 'liam', 12000.00),
('15921491', 'c01', 's01', 'Manik', 14000.00),
('557257', 'c02', '39698', 'Fahim', 12000.00);

-- --------------------------------------------------------

--
-- Table structure for table `security`
--

CREATE TABLE `security` (
  `userId` varchar(30) NOT NULL,
  `answer` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `security`
--

INSERT INTO `security` (`userId`, `answer`) VALUES
('', ''),
('e01', 'Mim'),
('e02', 'Toi'),
('s01', 'mim'),
('s02', 'Rama'),
('e03', 'Bala'),
('81653', 'Bina'),
('38927', 'Chaity'),
('58963', 'Tilo'),
('15734', 'Milo'),
('10275', 'Kilo'),
('18833', 'Silo'),
('103323', 'Bilo'),
('77616', 'Nilo'),
('28130', 'Filo'),
('107280', 'Pilo'),
('54976', 'Rolo'),
('27989', 'SSS'),
('', 'leak'),
('74334', 'mimi'),
('29753', 'LImiK'),
('49360', 'petri'),
('39698', 'SSS');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentId` varchar(8) NOT NULL,
  `studentName` varchar(30) NOT NULL,
  `courseName` varchar(30) NOT NULL,
  `courseId` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentId`, `studentName`, `courseName`, `courseId`) VALUES
('s01', 'Manik', 'Graphic Design', 'c01'),
('s02', 'Borhan', 'CPA Marketing', 'c03'),
('s03', 'Monim', 'Web Design', 'c05'),
('s04', 'Robin', 'Apps Development', 'c04'),
('58963', 'shanto', 'SEO', 'c02'),
('15734', 'borhan', 'SEO', 'c02'),
('10275', 'rokib', 'SEO', 'c02'),
('18833', 'promi', 'SEO', 'c02'),
('103323', 'erin', 'SEO', 'c02'),
('77616', 'mon', 'SEO', 'c02'),
('28130', 'abdul', 'SEO', 'c02'),
('107280', 'taiya', 'SEO', 'c02'),
('54976', 'bhn', 'SEO', 'c02'),
('27989', 'azan', 'SEO', 'c02'),
('74334', 'roket', 'SEO', 'c02'),
('29753', 'rimu', 'SEO', 'c02'),
('49360', 'liam', 'SEO', 'c02'),
('39698', 'Fahim', 'SEO', 'c02');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
