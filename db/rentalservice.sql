-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 17, 2022 at 05:17 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rentalservice`
--

-- --------------------------------------------------------

--
-- Table structure for table `asset`
--

CREATE TABLE `asset` (
  `asset_id` bigint(20) NOT NULL,
  `asset_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `price_per_hour` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `asset`
--

INSERT INTO `asset` (`asset_id`, `asset_name`, `location`, `price_per_hour`, `status`, `type`, `user_id`) VALUES
(1, 'house', 'johar', 400, 'inreview', 'house', 1);

-- --------------------------------------------------------

--
-- Table structure for table `asset_booking`
--

CREATE TABLE `asset_booking` (
  `booking_id` bigint(20) NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `assets_asset_id` bigint(20) DEFAULT NULL,
  `users_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `asset_review`
--

CREATE TABLE `asset_review` (
  `id` bigint(20) NOT NULL,
  `rating` double DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `asset_asset_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `request_of_service`
--

CREATE TABLE `request_of_service` (
  `request_id` bigint(20) NOT NULL,
  `details` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `account_number` bigint(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `cinic` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `account_number`, `address`, `cinic`, `email`, `gender`, `name`, `number`, `type`) VALUES
(1, 832473924797, 'gulshan', 838373924797, 'shahmir@gmail,com', 'male', 'shahmir', 8262343353, 'renter');

-- --------------------------------------------------------

--
-- Table structure for table `user_rating_and_review`
--

CREATE TABLE `user_rating_and_review` (
  `id` bigint(20) NOT NULL,
  `rating` double DEFAULT NULL,
  `review` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `provider_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asset`
--
ALTER TABLE `asset`
  ADD PRIMARY KEY (`asset_id`),
  ADD KEY `FKi2t8rfq8blfbh1rpvbxqrmgvd` (`user_id`);

--
-- Indexes for table `asset_booking`
--
ALTER TABLE `asset_booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `FKhnxqlmal0d6liuhlhwxqq95nx` (`assets_asset_id`),
  ADD KEY `FK8drnfxwbsjukxudlaylkb80p8` (`users_id`);

--
-- Indexes for table `asset_review`
--
ALTER TABLE `asset_review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK22n5tn6p1pvo11bfnt9v7u9x8` (`asset_asset_id`),
  ADD KEY `FKdgoog6uus3muehl9l8iibgsh0` (`user_id`);

--
-- Indexes for table `request_of_service`
--
ALTER TABLE `request_of_service`
  ADD PRIMARY KEY (`request_id`),
  ADD KEY `FKby5y4f72w395qcbxqsot32qgw` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_rating_and_review`
--
ALTER TABLE `user_rating_and_review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdurpyc14lefvylp4v380lke1f` (`provider_id`),
  ADD KEY `FKagbmcjdw5w2puw8li6roykjjg` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asset`
--
ALTER TABLE `asset`
  MODIFY `asset_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `asset_booking`
--
ALTER TABLE `asset_booking`
  MODIFY `booking_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `asset_review`
--
ALTER TABLE `asset_review`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `request_of_service`
--
ALTER TABLE `request_of_service`
  MODIFY `request_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user_rating_and_review`
--
ALTER TABLE `user_rating_and_review`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `asset`
--
ALTER TABLE `asset`
  ADD CONSTRAINT `FKi2t8rfq8blfbh1rpvbxqrmgvd` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `asset_booking`
--
ALTER TABLE `asset_booking`
  ADD CONSTRAINT `FK8drnfxwbsjukxudlaylkb80p8` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKhnxqlmal0d6liuhlhwxqq95nx` FOREIGN KEY (`assets_asset_id`) REFERENCES `asset` (`asset_id`);

--
-- Constraints for table `asset_review`
--
ALTER TABLE `asset_review`
  ADD CONSTRAINT `FK22n5tn6p1pvo11bfnt9v7u9x8` FOREIGN KEY (`asset_asset_id`) REFERENCES `asset` (`asset_id`),
  ADD CONSTRAINT `FKdgoog6uus3muehl9l8iibgsh0` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `request_of_service`
--
ALTER TABLE `request_of_service`
  ADD CONSTRAINT `FKby5y4f72w395qcbxqsot32qgw` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_rating_and_review`
--
ALTER TABLE `user_rating_and_review`
  ADD CONSTRAINT `FKagbmcjdw5w2puw8li6roykjjg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKdurpyc14lefvylp4v380lke1f` FOREIGN KEY (`provider_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
