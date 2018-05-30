-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-05-2018 a las 23:52:02
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `negocio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costo`
--

CREATE TABLE `costo` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `valor` int(11) NOT NULL,
  `es_actual` int(11) NOT NULL,
  `creado_el` datetime NOT NULL,
  `modificado_el` datetime NOT NULL,
  `eliminado_el` datetime NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_receta`
--

CREATE TABLE `detalle_receta` (
  `cantidad` float NOT NULL,
  `receta_id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familia`
--

CREATE TABLE `familia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `creado_el` datetime NOT NULL,
  `modificado_el` datetime NOT NULL,
  `eliminado_el` datetime NOT NULL,
  `linea_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea`
--

CREATE TABLE `linea` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `creado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modificado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `eliminado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `linea`
--

INSERT INTO `linea` (`id`, `nombre`, `creado_el`, `modificado_el`, `eliminado_el`) VALUES
(1, 'PAN', '2018-05-30 17:45:28', '2018-05-30 17:45:28', '2018-05-30 17:45:28'),
(2, 'PATE', '2018-05-30 17:48:20', '2018-05-30 17:48:20', '2018-05-30 17:48:20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precio_venta`
--

CREATE TABLE `precio_venta` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `valor` int(11) NOT NULL,
  `es_actual` int(11) NOT NULL,
  `creado_el` datetime NOT NULL,
  `modificado_el` datetime NOT NULL,
  `eliminado_el` datetime NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `formato` int(11) NOT NULL,
  `creado_el` datetime NOT NULL,
  `modificado_el` datetime NOT NULL,
  `eliminado_el` datetime NOT NULL,
  `familia_id` int(11) NOT NULL,
  `unidad_medida_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidad_medida`
--

CREATE TABLE `unidad_medida` (
  `id` int(11) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `creado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modificado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `eliminado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `unidad_medida`
--

INSERT INTO `unidad_medida` (`id`, `codigo`, `descripcion`, `creado_el`, `modificado_el`, `eliminado_el`) VALUES
(1, 'kg', 'kilos', '2018-05-30 17:51:12', '2018-05-30 17:51:12', '2018-05-30 17:51:12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `pass`, `correo`) VALUES
(1, 'Matias', '123456', 'matias@gmail.com'),
(2, 'Andys', '123456', 'andy@gmail.com'),
(3, 'Jorge', 'pastrana', 'jorge@gmail.com'),
(4, 'Roberto', '666', 'roberto@gmail.com'),
(5, 'Prueba', '123', 'prueba@pepe'),
(6, 'Brandon', '666', 'brandon@gmail.dios');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `costo`
--
ALTER TABLE `costo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_costo_producto1_idx` (`producto_id`);

--
-- Indices de la tabla `detalle_receta`
--
ALTER TABLE `detalle_receta`
  ADD PRIMARY KEY (`cantidad`,`receta_id`,`producto_id`),
  ADD KEY `fk_detalle_receta_receta1_idx` (`receta_id`),
  ADD KEY `fk_detalle_receta_producto1_idx` (`producto_id`);

--
-- Indices de la tabla `familia`
--
ALTER TABLE `familia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_familia_linea_idx` (`linea_id`);

--
-- Indices de la tabla `linea`
--
ALTER TABLE `linea`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `precio_venta`
--
ALTER TABLE `precio_venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_precio_venta_producto1_idx` (`producto_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_producto_familia1_idx` (`familia_id`),
  ADD KEY `fk_producto_unidad_medida1_idx` (`unidad_medida_id`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_receta_producto1_idx` (`producto_id`);

--
-- Indices de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `costo`
--
ALTER TABLE `costo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `familia`
--
ALTER TABLE `familia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `linea`
--
ALTER TABLE `linea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `precio_venta`
--
ALTER TABLE `precio_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `costo`
--
ALTER TABLE `costo`
  ADD CONSTRAINT `fk_costo_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_receta`
--
ALTER TABLE `detalle_receta`
  ADD CONSTRAINT `fk_detalle_receta_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_receta_receta1` FOREIGN KEY (`receta_id`) REFERENCES `receta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `familia`
--
ALTER TABLE `familia`
  ADD CONSTRAINT `fk_familia_linea` FOREIGN KEY (`linea_id`) REFERENCES `linea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `precio_venta`
--
ALTER TABLE `precio_venta`
  ADD CONSTRAINT `fk_precio_venta_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_familia1` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_unidad_medida1` FOREIGN KEY (`unidad_medida_id`) REFERENCES `unidad_medida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `fk_receta_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
