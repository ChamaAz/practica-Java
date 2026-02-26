-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2025 at 04:29 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tienda`
--

-- --------------------------------------------------------

--
-- Table structure for table `consolas`
--

CREATE TABLE `consolas` (
  `id_consola` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `potencia_cpu` varchar(60) NOT NULL,
  `potencia_gpu` varchar(60) NOT NULL,
  `compania` varchar(50) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  `unidades` int(3) NOT NULL,
  `generacion` enum('1','2') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `consolas`
--

INSERT INTO `consolas` (`id_consola`, `nombre`, `potencia_cpu`, `potencia_gpu`, `compania`, `precio`, `unidades`, `generacion`) VALUES
(1, 'Nintendo Switch', '4 nucleos a 1.02 GHz', '0.5 teraflops', 'Nintendo', 329, 250, '1'),
(2, 'Nintendo Switch Lite', '4 nucleos a 1.02 GHz', '0.5 teraflops', 'Nintendo', 219, 125, '1'),
(3, 'PS4', '8 nucleos a 1.6 GHz', '1.84 teraflops', 'Sony', 400, 220, '1'),
(4, 'PS5 con CD', '8 nucleos a 3.5 GHz', '10.28 teraflops', 'Sony', 500, 300, '2'),
(5, 'PS5 sin CD', '8 nucleos a 3.5 GHz', '10.28 teraflops', 'Sony', 400, 200, '2'),
(6, 'Xbox one', '8 nucleos a 1.75 GHz', '1.31 teraflops', 'Microsoft', 500, 150, '1'),
(7, 'Xbox S', '8 nucleos a 3.6 GHz', '4.006 teraflops', 'Microsoft', 349, 125, '2'),
(8, 'Xbox X', '8 nucleos a 3.8 GHz', '12.155 teraflops', 'Microsoft', 549, 200, '2');

-- --------------------------------------------------------

--
-- Table structure for table `juegos`
--

CREATE TABLE `juegos` (
  `id_juego` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `compania_desarrolladora` varchar(60) NOT NULL,
  `genero` varchar(60) NOT NULL,
  `puntuacion_metacritic` int(2) NOT NULL,
  `precio` int(11) DEFAULT NULL,
  `unidades_disponibles` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `juegos`
--

INSERT INTO `juegos` (`id_juego`, `nombre`, `compania_desarrolladora`, `genero`, `puntuacion_metacritic`, `precio`, `unidades_disponibles`) VALUES
(1, 'A Plague Tale: Requiem', 'Asobo Studio', 'Aventura', 85, 50, 100),
(2, 'Animal Crossing: New Horizons', 'Nintendo', 'Aventura', 90, 60, 60),
(3, 'Bloodborne', 'FromSoftware', 'Accion', 92, 20, 50),
(4, 'Crackdown 3', 'Sumo Digital', 'Accion', 71, 30, 65),
(5, 'Demonss Souls', 'Bluepoint Games', 'Accion', 92, 70, 100),
(6, 'Destruction AllStars', 'Lucid Games', 'Multijugador', 60, 20, 60),
(7, 'Final Fantasy VII Remake Intergrade', 'Square Enix', 'RPG', 89, 70, 90),
(8, 'Forza Horizon 4', 'Playground Games', 'Carreras', 92, 60, 60),
(9, 'Forza Horizon 5', 'Playground Games', 'Carreras', 92, 60, 90),
(10, 'Gears 5', 'The Coalition', 'Accion', 84, 60, 100),
(11, 'Ghost of Tsushima', 'Sucker Punch Productions', 'Accion', 83, 60, 95),
(12, 'Gran Turismo 7', 'Polyphony Digital', 'Carreras', 87, 70, 74),
(13, 'Gran Turismo Sport', 'Polyphony Digital', 'Carreras', 75, 30, 15),
(14, 'Halo 5: Guardians', '343 Industries', 'Ciencia ficcion', 84, 30, 50),
(15, 'Halo Infinite', '343 Industries', 'Ciencia ficcion', 87, 60, 100),
(16, 'Horizon Zero Dawn', 'Guerrilla Games', 'Accion', 83, 60, 95),
(17, 'Inside', 'Playdead', 'Plataformas', 91, 20, 60),
(18, 'Kenna: Bridge of Spirits', 'Ember Lab', 'Aventura', 82, 40, 60),
(19, 'Knack 2', 'SIE Japan Studio', 'Accion', 73, 20, 45),
(20, 'Luigis Mansion 3', 'Nintendo', 'Aventura', 86, 50, 110),
(21, 'Mario Kart 8 Deluxe', 'Nintendo', 'Carreras', 92, 50, 95),
(22, 'Mario Party Superstars', 'Nintendo', 'Multijugador', 80, 60, 50),
(23, 'Microsoft Flight Simulator', 'Asobo Studio', 'Simulacion', 93, 60, 90),
(24, 'Pokémon Scarlet and Violet', 'Game Freak', 'RPG', 72, 60, 75),
(25, 'Quantum Break', 'Remedy Entertainment', 'Accion', 80, 40, 62),
(26, 'Ratchet & Clank', 'Insomniac Games', 'Accion', 85, 40, 100),
(27, 'Ratchet & Clank: Rift Apart', 'Insomniac Games', 'Accion', 88, 65, 100),
(28, 'ReCore', 'Comcept', 'Aventura', 67, 20, 50),
(29, 'Resident Evil Village', 'Capcom', 'Terror', 84, 60, 64),
(30, 'Returnal', 'Housemarque', 'Accion', 82, 70, 92),
(31, 'Scorn', 'Ebb Software', 'Horror', 69, 40, 25),
(32, 'Sea of Thieves', 'Rare', 'Aventura', 70, 40, 90),
(33, 'Spider-Man', 'Insomniac Games', 'Accion', 87, 40, 100),
(34, 'Spider-Man: Miles Morales', 'Insomniac Games', 'Accion', 85, 70, 62),
(35, 'State of Decay 2', 'Undead Labs', 'Accion', 84, 60, 70),
(36, 'Sunset Overdrive', 'Insomniac Games', 'Accion', 81, 20, 59),
(37, 'Super Mario 3D World + Bowser’s Fury', 'Nintendo', 'Plataformas', 89, 50, 100),
(38, 'Super Mario Maker 2', 'Nintendo', 'Aventura', 88, 60, 58),
(39, 'Super Mario Odyssey', 'Nintendo', 'Plataformas', 97, 50, 100),
(40, 'Super Smash Bros. Ultimate', 'Nintendo', 'Multijugador', 93, 60, 95),
(41, 'Tetris Effect: Connected', 'Monstars Inc.', 'Musica', 90, 40, 90),
(42, 'The Ascent', 'Neon Giant', 'Accion', 75, 30, 60),
(43, 'The Last of Us Part II', 'Naughty Dog', 'Aventura', 93, 60, 68),
(44, 'The Legend of Zelda: Tears of the Kingdom', 'Nintendo', 'Aventura', 96, 70, 92),
(45, 'The Medium', 'Bloober Team', 'Terror', 74, 50, 92),
(46, 'The Order: 1886', 'Ready at Dawn', 'Accion', 60, 20, 25),
(47, 'The Pathless', 'Giant Squid Studios', 'Aventura', 80, 50, 65),
(48, 'Until Dawn', 'Supermassive Games', 'Horror', 79, 20, 65),
(49, 'Watch Dogs: Legion', 'Ubisoft', 'Accion', 79, 60, 45),
(50, 'Yakuza: Like a Dragon', 'SEGA', 'Aventura', 81, 50, 95);

-- --------------------------------------------------------

--
-- Table structure for table `juego_consola`
--

CREATE TABLE `juego_consola` (
  `id_juego` int(11) NOT NULL,
  `id_consola` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `juego_consola`
--

INSERT INTO `juego_consola` (`id_juego`, `id_consola`) VALUES
(1, 7),
(1, 8),
(2, 1),
(2, 2),
(3, 3),
(4, 6),
(5, 4),
(5, 5),
(6, 4),
(6, 5),
(7, 4),
(7, 5),
(8, 6),
(9, 7),
(9, 8),
(10, 6),
(11, 3),
(12, 4),
(12, 5),
(13, 3),
(14, 6),
(15, 7),
(15, 8),
(16, 3),
(17, 6),
(18, 4),
(18, 5),
(19, 3),
(20, 1),
(20, 2),
(21, 1),
(21, 2),
(22, 1),
(22, 2),
(23, 7),
(23, 8),
(24, 1),
(24, 2),
(25, 6),
(26, 3),
(27, 4),
(27, 5),
(28, 6),
(29, 7),
(29, 8),
(30, 4),
(30, 5),
(31, 7),
(31, 8),
(32, 6),
(33, 3),
(34, 4),
(34, 5),
(35, 6),
(36, 6),
(37, 1),
(37, 2),
(38, 1),
(38, 2),
(39, 1),
(39, 2),
(40, 1),
(40, 2),
(41, 7),
(41, 8),
(42, 7),
(42, 8),
(43, 3),
(44, 1),
(44, 2),
(45, 7),
(45, 8),
(46, 3),
(47, 4),
(47, 5),
(48, 3),
(49, 4),
(49, 5),
(50, 7),
(50, 8);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `nombreUser` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `esAdmin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`nombreUser`, `password`, `esAdmin`) VALUES
('admin', '1234', 1),
('user1', '1234', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consolas`
--
ALTER TABLE `consolas`
  ADD PRIMARY KEY (`id_consola`);

--
-- Indexes for table `juegos`
--
ALTER TABLE `juegos`
  ADD PRIMARY KEY (`id_juego`);

--
-- Indexes for table `juego_consola`
--
ALTER TABLE `juego_consola`
  ADD PRIMARY KEY (`id_juego`,`id_consola`),
  ADD KEY `id_consola` (`id_consola`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nombreUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consolas`
--
ALTER TABLE `consolas`
  MODIFY `id_consola` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `juegos`
--
ALTER TABLE `juegos`
  MODIFY `id_juego` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `juego_consola`
--
ALTER TABLE `juego_consola`
  ADD CONSTRAINT `juego_consola_ibfk_1` FOREIGN KEY (`id_juego`) REFERENCES `juegos` (`id_juego`) ON DELETE CASCADE,
  ADD CONSTRAINT `juego_consola_ibfk_2` FOREIGN KEY (`id_consola`) REFERENCES `consolas` (`id_consola`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
