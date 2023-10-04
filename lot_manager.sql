-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 04 Paź 2023, 15:22
-- Wersja serwera: 10.4.27-MariaDB
-- Wersja PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `lot_manager`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `airport`
--

CREATE TABLE `airport` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `coutry_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `countries`
--

CREATE TABLE `countries` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `birthDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `customer-flight`
--

CREATE TABLE `customer-flight` (
  `customer_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `flight`
--

CREATE TABLE `flight` (
  `id` int(11) NOT NULL,
  `plane_id` int(11) NOT NULL,
  `startAirport_id` int(11) NOT NULL,
  `finalAirport_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `plane`
--

CREATE TABLE `plane` (
  `id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `seatsAmount` int(11) NOT NULL,
  `startAirport_id` int(11) NOT NULL,
  `finalAirport_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `airport`
--
ALTER TABLE `airport`
  ADD PRIMARY KEY (`id`),
  ADD KEY `coutry_id` (`coutry_id`);

--
-- Indeksy dla tabeli `countries`
--
ALTER TABLE `countries`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `customer-flight`
--
ALTER TABLE `customer-flight`
  ADD PRIMARY KEY (`customer_id`,`flight_id`),
  ADD KEY `flight_id` (`flight_id`);

--
-- Indeksy dla tabeli `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`id`,`plane_id`,`startAirport_id`,`finalAirport_id`),
  ADD KEY `plane_id` (`plane_id`),
  ADD KEY `startAirport_id` (`startAirport_id`),
  ADD KEY `plane_id_2` (`plane_id`),
  ADD KEY `finalAirport_id` (`finalAirport_id`);

--
-- Indeksy dla tabeli `plane`
--
ALTER TABLE `plane`
  ADD PRIMARY KEY (`id`,`flight_id`),
  ADD UNIQUE KEY `id` (`id`,`startAirport_id`,`finalAirport_id`),
  ADD KEY `flight_id` (`flight_id`),
  ADD KEY `startAirport_id` (`startAirport_id`),
  ADD KEY `finalAirport_id` (`finalAirport_id`),
  ADD KEY `startAirport_id_2` (`startAirport_id`),
  ADD KEY `finalAirport_id_2` (`finalAirport_id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `airport`
--
ALTER TABLE `airport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `countries`
--
ALTER TABLE `countries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `flight`
--
ALTER TABLE `flight`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `plane`
--
ALTER TABLE `plane`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `airport`
--
ALTER TABLE `airport`
  ADD CONSTRAINT `airport_ibfk_1` FOREIGN KEY (`coutry_id`) REFERENCES `countries` (`id`);

--
-- Ograniczenia dla tabeli `customer-flight`
--
ALTER TABLE `customer-flight`
  ADD CONSTRAINT `customer-flight_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `customer-flight_ibfk_2` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`);

--
-- Ograniczenia dla tabeli `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `flight_ibfk_1` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  ADD CONSTRAINT `flight_ibfk_2` FOREIGN KEY (`startAirport_id`) REFERENCES `airport` (`id`),
  ADD CONSTRAINT `flight_ibfk_3` FOREIGN KEY (`finalAirport_id`) REFERENCES `airport` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
