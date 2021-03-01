-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2021 at 11:57 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rekrutacja`
--

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE `note` (
  `id_note` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `title` varchar(256) COLLATE utf8_polish_ci NOT NULL,
  `content` text COLLATE utf8_polish_ci NOT NULL,
  `added` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `note`
--

INSERT INTO `note` (`id_note`, `id_user`, `title`, `content`, `added`) VALUES
(1, 2, 'Lorem ipsum', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vehicula erat nec metus vehicula, ac maximus nulla ultrices. Aenean quis aliquam tortor. Etiam turpis turpis, ultrices mattis metus quis, semper pulvinar lacus. Maecenas consectetur consectetur mauris sit amet vestibulum. Ut vitae lacus at ante semper bibendum. Curabitur eleifend nec magna eget iaculis. Vestibulum imperdiet volutpat velit vel tristique. Quisque vestibulum luctus ligula, id interdum urna consectetur quis. Donec consectetur tortor ut nisi elementum, vitae tincidunt eros commodo. Vivamus mollis nibh vel pharetra viverra. Nulla eu suscipit ante. Pellentesque mollis dolor velit, eget egestas arcu sagittis in. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Nam congue id dolor non sagittis. ', '2021-02-02 22:28:22'),
(2, 2, 'Lorem ipsum 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vehicula erat nec metus vehicula, ac maximus nulla ultrices. Aenean quis aliquam tortor. Etiam turpis turpis, ultrices mattis metus quis, semper pulvinar lacus. Maecenas consectetur consectetur mauris sit amet vestibulum. Ut vitae lacus at ante semper bibendum. Curabitur eleifend nec magna eget iaculis. Vestibulum imperdiet volutpat velit vel tristique. Quisque vestibulum luctus ligula, id interdum urna consectetur quis. Donec consectetur tortor ut nisi elementum, vitae tincidunt eros commodo. Vivamus mollis nibh vel pharetra viverra. Nulla eu suscipit ante. Pellentesque mollis dolor velit, eget egestas arcu sagittis in. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Nam congue id dolor non sagittis. ', '2021-02-02 22:28:22'),
(3, 1, 'Lorem ipsum 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vehicula erat nec metus vehicula, ac maximus nulla ultrices. Aenean quis aliquam tortor. Etiam turpis turpis, ultrices mattis metus quis, semper pulvinar lacus. Maecenas consectetur consectetur mauris sit amet vestibulum. Ut vitae lacus at ante semper bibendum. Curabitur eleifend nec magna eget iaculis. Vestibulum imperdiet volutpat velit vel tristique. Quisque vestibulum luctus ligula, id interdum urna consectetur quis. Donec consectetur tortor ut nisi elementum, vitae tincidunt eros commodo. Vivamus mollis nibh vel pharetra viverra. Nulla eu suscipit ante. Pellentesque mollis dolor velit, eget egestas arcu sagittis in. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Nam congue id dolor non sagittis. ', '2021-02-02 22:28:48'),
(4, 2, 'Lorem ipsum 4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam vehicula erat nec metus vehicula, ac maximus nulla ultrices. Aenean quis aliquam tortor. Etiam turpis turpis, ultrices mattis metus quis, semper pulvinar lacus. Maecenas consectetur consectetur mauris sit amet vestibulum. Ut vitae lacus at ante semper bibendum. Curabitur eleifend nec magna eget iaculis. Vestibulum imperdiet volutpat velit vel tristique. Quisque vestibulum luctus ligula, id interdum urna consectetur quis. Donec consectetur tortor ut nisi elementum, vitae tincidunt eros commodo. Vivamus mollis nibh vel pharetra viverra. Nulla eu suscipit ante. Pellentesque mollis dolor velit, eget egestas arcu sagittis in. In hac habitasse platea dictumst. In hac habitasse platea dictumst. Nam congue id dolor non sagittis. ', '2021-02-02 22:28:48');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `login` varchar(128) COLLATE utf8_polish_ci NOT NULL,
  `password` varchar(128) COLLATE utf8_polish_ci NOT NULL,
  `is_blocked` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `login`, `password`, `is_blocked`) VALUES
(1, 'AdamTalarczyk', '1a64a010767f0725fb52111b0a9e9f84', 0),
(2, 'JanKowalski', '2c9341ca4cf3d87b9e4eb905d6a3ec45', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `id_details` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `name` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(64) COLLATE utf8_polish_ci NOT NULL,
  `birth_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id_details`, `id_user`, `name`, `surname`, `birth_date`) VALUES
(2, 2, 'Jan', 'Kowalski', '1997-12-06'),
(5, 1, 'Adam', 'Talarczyk', '1980-10-10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`id_note`),
  ADD KEY `FK` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`id_details`),
  ADD UNIQUE KEY `FK` (`id_user`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `note`
--
ALTER TABLE `note`
  MODIFY `id_note` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `id_details` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user_details`
--
ALTER TABLE `user_details`
  ADD CONSTRAINT `user_details_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
