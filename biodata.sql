-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 29, 2023 at 02:41 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biodata`
--

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `id` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `no_telepon` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`id`, `nama`, `no_telepon`, `jenis_kelamin`, `alamat`) VALUES
('04ecca22-67c3-485a-93b6-8e37ee258fd8', 'Deandra Adhitya', '07518264912', 'Laki-Laki', 'Cimahi'),
('0623a546-9ab6-467f-9def-e72056f506be', 'Fowaz Amran Alfarez', '07487124912', 'Laki-Laki', 'Cimahi'),
('1d638cd1-4660-46d2-adac-faf4bd501c02', 'Fauzi Ilyas Nuryadi', '05129518925', 'Laki-Laki', 'Pangandaran'),
('66616c53-463a-4cfe-a2d6-c051695a8f48', 'Gilman Arief F', '085797983833', 'Laki-Laki', 'Komp.Manglayang Regency Blok B.10 No.26'),
('f160ccb8-74d2-45d1-b141-2e4638db5d74', 'Lutfi Amin Ghifarullah', '08672744141', 'Laki-Laki', 'Sarijadi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
