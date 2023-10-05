-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 05 Paź 2023, 13:29
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
  `city_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `airport`
--

INSERT INTO `airport` (`id`, `name`, `city_id`) VALUES
(1, 'Lotnisko Chopina w Warszawie', 1),
(2, 'Port Lorniczy Bydgoszcz', 2),
(3, 'Port Lotniczy Keflavik', 3),
(4, 'Port lotniczy Amsterdam-Schiphol', 4),
(5, 'Port lotniczy Akita', 5),
(6, 'Port lotniczy Innsbruck', 6);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `country_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `city`
--

INSERT INTO `city` (`id`, `name`, `country_id`) VALUES
(1, 'Warszawa', 1),
(2, 'Bydgoszcz', 1),
(3, 'Keflavik', 2),
(4, 'Schiphol', 3),
(5, 'Akita', 4),
(6, 'Innsbruck', 5);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `countries`
--

CREATE TABLE `countries` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `countries`
--

INSERT INTO `countries` (`id`, `name`) VALUES
(1, 'Polska'),
(2, 'Islandia'),
(3, 'Holandia'),
(4, 'Japonia'),
(5, 'Austria');

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

--
-- Zrzut danych tabeli `customer`
--

INSERT INTO `customer` (`id`, `name`, `surname`, `email`, `phoneNumber`, `birthDate`) VALUES
(1, 'Adam', 'Kowalski', 'adamkowalski@gmail.com', '642973564', '2003-10-15');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `customer-flight`
--

CREATE TABLE `customer-flight` (
  `customer_id` int(11) NOT NULL,
  `flight_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `customer-flight`
--

INSERT INTO `customer-flight` (`customer_id`, `flight_id`) VALUES
(1, 1);

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

--
-- Zrzut danych tabeli `flight`
--

INSERT INTO `flight` (`id`, `plane_id`, `startAirport_id`, `finalAirport_id`) VALUES
(1, 1, 1, 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `plane`
--

CREATE TABLE `plane` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `seatsAmount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Zrzut danych tabeli `plane`
--

INSERT INTO `plane` (`id`, `name`, `seatsAmount`) VALUES
(1, 'boeing 737', 50);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `airport`
--
ALTER TABLE `airport`
  ADD PRIMARY KEY (`id`),
  ADD KEY `city_id` (`city_id`);

--
-- Indeksy dla tabeli `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD KEY `country_id` (`country_id`);

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
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `airport`
--
ALTER TABLE `airport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT dla tabeli `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT dla tabeli `countries`
--
ALTER TABLE `countries`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `flight`
--
ALTER TABLE `flight`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `plane`
--
ALTER TABLE `plane`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `airport`
--
ALTER TABLE `airport`
  ADD CONSTRAINT `airport_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`);

--
-- Ograniczenia dla tabeli `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `city_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

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
  ADD CONSTRAINT `flight_ibfk_2` FOREIGN KEY (`startAirport_id`) REFERENCES `airport` (`id`),
  ADD CONSTRAINT `flight_ibfk_3` FOREIGN KEY (`finalAirport_id`) REFERENCES `airport` (`id`),
  ADD CONSTRAINT `flight_ibfk_4` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
