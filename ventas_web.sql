-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-04-2023 a las 02:09:09
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ventas_web`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) NOT NULL,
  `Cedula` varchar(10) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Telefono` varchar(10) NOT NULL,
  `Estado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Cedula`, `Nombres`, `Apellidos`, `Direccion`, `Telefono`, `Estado`) VALUES
(1, '1025478954', 'Juan Pablo', 'Montoya Florez', 'Calle 22 Nro 88 - 12', '2197700', '1'),
(2, '1035799510', 'Rosa Maribel', 'Herrera Arango', 'Calle 22 NRO 44 - 11', '3225801450', '1'),
(3, '1025498736', 'Raquel Maritza', 'Olarte Ocampo', 'Av 4 Nro 33 - 88', '3225104322', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `IdDetalle` int(11) NOT NULL,
  `IdVenta` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `detalle_venta`
--

INSERT INTO `detalle_venta` (`IdDetalle`, `IdVenta`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(1, 1, 1, 3, 5500),
(2, 1, 1, 3, 45000),
(8, 6, 3, 2, 8000),
(9, 6, 1, 3, 5500),
(10, 7, 3, 3, 8000),
(11, 8, 3, 3, 8000),
(12, 8, 1, 5, 5500),
(13, 8, 6, 6, 20000),
(14, 9, 6, 5, 20000),
(15, 9, 5, 1, 10000),
(16, 10, 6, 1, 20000),
(17, 10, 3, 2, 8000),
(18, 11, 3, 1, 8000),
(19, 11, 5, 3, 10000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(11) NOT NULL,
  `Cedula` varchar(10) NOT NULL,
  `Nombres` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Telefono` varchar(10) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Estado` varchar(1) NOT NULL,
  `Usuario` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Cedula`, `Nombres`, `Apellidos`, `Telefono`, `Correo`, `Estado`, `Usuario`) VALUES
(1, '123456', 'Edgar', 'Montoya Florez', '3215227700', 'edgar@gmail.com', '1', 'admin'),
(2, '1035799510', 'Manuel Alberto', 'Quintero Arango', '5876655', 'manuel@gmail.com', '1', 'manuel1'),
(3, '1025789410', 'Ricardo', 'Gonzalez Medina', '2303030', 'rchar@gmail.com', '1', 'richar12'),
(4, '1028590120', 'Juan Gonzalo', 'Murillo Rodriguez', '202020', 'chalo@hotmail.com', '1', 'hhhhh'),
(5, '1035210470', 'Sofia', 'Rincon Bustamante', '3125897412', 'sofia@gmail.com', '1', 'sofi123'),
(6, '1058974123', 'Rafael', 'Aristizabal', '5876655', 'rafael2hotmail.com', '1', 'rafael5'),
(7, '1027255877', 'Jorge Luis', 'Ríos Restrepo', '3225801450', 'jorge@hotmail.com', '1', 'jorge123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) NOT NULL,
  `Codigo` varchar(30) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Precio` double NOT NULL,
  `Stock` int(11) NOT NULL,
  `Estado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Codigo`, `Descripcion`, `Precio`, `Stock`, `Estado`) VALUES
(1, 'CRT34HT', 'Bacterias AAA', 5500, 185, '1'),
(2, 'SSTR4H', 'Arroba de arroz Ideal', 45000, 45, '1'),
(3, '23LF-s7', 'Salsa de tomate x 1000 gramos', 8000, 47, '1'),
(4, 'AB32H-8KS', 'Caja de Jabón de lavar x 25 unidades', 113000, 75, '1'),
(5, '222G11', 'Bolsa de jabón fab x 500 mg', 10000, 37, '1'),
(6, '44HJD21', 'Tarro de chocolisto x 1000 mg', 20000, 49, '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVenta` int(11) NOT NULL,
  `NumeroFactura` varchar(12) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdEmpleado` int(11) NOT NULL,
  `Total` double NOT NULL,
  `Estado` varchar(1) NOT NULL,
  `FechaRegistro` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVenta`, `NumeroFactura`, `IdCliente`, `IdEmpleado`, `Total`, `Estado`, `FechaRegistro`) VALUES
(1, '00000001', 1, 1, 151500, '1', '2022-03-28'),
(6, '00000006', 3, 5, 32500, '1', '2022-04-17'),
(7, '00000007', 1, 6, 24000, '1', '2022-04-17'),
(8, '00000008', 1, 4, 171500, '1', '2022-04-17'),
(9, '00000009', 2, 7, 110000, '1', '2022-04-17'),
(10, '00000010', 3, 1, 36000, '1', '2022-04-18'),
(11, '00000011', 2, 1, 38000, '1', '2022-06-03');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD PRIMARY KEY (`IdDetalle`),
  ADD KEY `Fk_IdProducto` (`IdProducto`),
  ADD KEY `Fk_IdVenta` (`IdVenta`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVenta`),
  ADD KEY `Fk_IdCliente` (`IdCliente`),
  ADD KEY `Fk_empleado` (`IdEmpleado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  MODIFY `IdDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_venta`
--
ALTER TABLE `detalle_venta`
  ADD CONSTRAINT `Fk_IdProducto` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_IdVenta` FOREIGN KEY (`IdVenta`) REFERENCES `ventas` (`IdVenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `Fk_IdCliente` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Fk_empleado` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
