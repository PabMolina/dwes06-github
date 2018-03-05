-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-01-2018 a las 19:58:09
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresa`
--
CREATE DATABASE IF NOT EXISTS `empresa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `empresa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `COD_CLIENTE` int(11) NOT NULL,
  `NOMBRE` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LOCALIDAD` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL,
  `LIMITE_CREDITO` int(11) NOT NULL,
  PRIMARY KEY (`COD_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`COD_CLIENTE`, `NOMBRE`, `LOCALIDAD`, `LIMITE_CREDITO`) VALUES
(101, 'DISTRIBUCIONES GOMEZ', 'MADRID', 50000),
(102, 'LOGITRONICA S.L', 'BARCELONA', 50000),
(103, 'INDUSTRIAS LACTEAS S.A.', 'LAS ROZAS', 100000),
(104, 'TALLERES ESTESO S.A.', 'SEVILLA', 50000),
(105, 'EDICIONES SANZ', 'BARCELONA', 50000),
(106, 'SIGNOLOGIC S.A.', 'MADRID', 50000),
(107, 'MARTIN Y ASOCIADOS S.L.', 'ARAVACA', 100000),
(108, 'MANUFACTURAS ALI S.A.', 'SEVILLA', 50000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE IF NOT EXISTS `pedidos` (
  `cod_PEDIDO` int(11) NOT NULL,
  `COD_PRODUCTO` int(11) DEFAULT NULL,
  `COD_CLIENTE` int(11) DEFAULT NULL,
  `UNIDADES` int(11) NOT NULL,
  `FECHA_PEDIDO` date NOT NULL,
  PRIMARY KEY (`cod_PEDIDO`),
  KEY `FK_PEDIDOS_CLIENTES` (`COD_CLIENTE`),
  KEY `FK_PEDIDOS_PRODUCTOS` (`COD_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`cod_PEDIDO`, `COD_PRODUCTO`, `COD_CLIENTE`, `UNIDADES`, `FECHA_PEDIDO`) VALUES
(1000, 20, 103, 3, '2017-09-06'),
(1001, 50, 106, 2, '2017-10-06'),
(1002, 10, 101, 4, '2017-10-07'),
(1003, 20, 105, 4, '2017-10-16'),
(1004, 20, 101, 5, '2017-11-06'),
(1005, 20, 102, 3, '2017-11-06'),
(1006, 20, 103, 2, '2017-11-07'),
(1007, 20, 104, 1, '2017-11-16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `COD_PRODUCTO` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PRECIO_ACTUAL` int(11) DEFAULT NULL,
  `STOCK_DISPONIBLE` int(11) NOT NULL,
  `IMAGEN` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`COD_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`COD_PRODUCTO`, `DESCRIPCION`, `PRECIO_ACTUAL`, `STOCK_DISPONIBLE`, `IMAGEN`) VALUES
(10, 'MESA DESPACHO MOD. GAVIOTA', 550, 50, 'mesa_despacho'),
(20, 'SILLA DIRECTOR MOD. BUFALO', 670, 25, 'silla_director'),
(30, 'ARMARIO NOGAL DOS PUERTAS', 460, 20, 'armario_nogal'),
(40, 'MESA MODELO UNIN', 340, 15, 'mesa'),
(50, 'ARCHIVADOR CEREZO', 250, 20, 'archivador'),
(60, 'CAJA SEGURIDAD MOD B222', 280, 15, 'caja'),
(70, 'DESTRUCTORA DE PAPEL A3', 450, 25, 'destructora'),
(80, 'MESA ORDENADOR MOD. ERGOS', 550, 25, 'mesa_ordenador');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `FK_PEDIDOS_CLIENTES` FOREIGN KEY (`COD_CLIENTE`) REFERENCES `clientes` (`COD_CLIENTE`),
  ADD CONSTRAINT `FK_PEDIDOS_PRODUCTOS` FOREIGN KEY (`COD_PRODUCTO`) REFERENCES `productos` (`COD_PRODUCTO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
