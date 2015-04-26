-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 26-04-2015 a las 20:54:27
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `SistemaEjemplo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `RUT` int(9) NOT NULL,
  `nombre` text COLLATE utf8_spanish_ci NOT NULL,
  `apellidoPaterno` text COLLATE utf8_spanish_ci NOT NULL,
  `apellidoMaterno` text COLLATE utf8_spanish_ci NOT NULL,
  `email` text COLLATE utf8_spanish_ci
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`RUT`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `email`) VALUES
(174580227, 'javier221212', 'andanad', 'quijada', 'dadasdada@xvideos.com'),
(111111111, 'roberto', 'abadilla', 'quijada', 'roberto@gmail.com'),
(222222222, 'claudio', 'gonzales', 'quezada', 'claudio@gmail.com'),
(333333333, 'alexiss', 'sanchez', 'sanchez', 'alexis@gmail.com'),
(555555555, 'arturo', 'vidal', 'pardo', 'arturo@gmail.com'),
(666666666, 'claudio', 'bravo', 'munoz', 'claudioB@gmail.com'),
(313, 'clemente', 'eqwe', 'eqwe', 'dasd'),
(777777777, 'carla', 'navarrete', 'benga', 'carla@gmail.com'),
(88888888, 'laura', 'se te ve ', 'la tanga', 'laura@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`RUT`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
