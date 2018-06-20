-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-06-2018 a las 18:42:10
-- Versión del servidor: 10.1.33-MariaDB
-- Versión de PHP: 7.2.6

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
  `creado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modificado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `eliminado_el` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `linea_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `familia`
--

INSERT INTO `familia` (`id`, `nombre`, `creado_el`, `modificado_el`, `eliminado_el`, `linea_id`) VALUES
(4, 'Mani', '2018-05-31 12:59:14', '2018-05-31 12:59:14', '2018-05-31 12:59:14', 1),
(5, 'Duro', '2018-05-31 13:00:36', '2018-05-31 13:00:36', '2018-05-31 13:00:36', 2),
(6, 'Pampita', '2018-06-03 18:45:41', '2018-06-03 18:45:41', '2018-06-03 18:45:41', 2),
(9, 'Genjibre', '2018-06-03 22:00:08', '2018-06-03 22:00:08', '2018-06-03 22:00:08', 1),
(12, 'Coche', '2018-06-03 23:48:29', '2018-06-03 23:48:29', '2018-06-03 23:48:29', 10),
(13, 'Cruzeiro', '2018-06-03 23:50:51', '2018-06-03 23:50:51', '2018-06-03 23:50:51', 11),
(14, 'Motorola', '2018-06-04 14:01:26', '2018-06-04 14:01:26', '2018-06-04 14:01:26', 11);

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
(1, 'Salados', '2018-05-31 12:48:54', '2018-05-31 12:48:54', '2018-05-31 12:48:54'),
(2, 'Pan', '2018-05-31 12:59:53', '2018-05-31 12:59:53', '2018-05-31 12:59:53'),
(3, 'Lacteos', '2018-05-31 13:05:46', '2018-05-31 13:05:46', '2018-05-31 13:05:46'),
(10, 'Grasa', '2018-05-31 13:40:32', '2018-05-31 13:40:32', '2018-05-31 13:40:32'),
(11, 'Cafe', '2018-06-03 23:50:18', '2018-06-03 23:50:18', '2018-06-03 23:50:18'),
(12, 'Cereales', '2018-06-04 16:12:00', '2018-06-04 16:12:00', '2018-06-04 16:12:00');

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
-- Estructura de tabla para la tabla `produccion`
--

CREATE TABLE `produccion` (
  `id` int(255) NOT NULL,
  `unidad_medida_id` int(255) NOT NULL,
  `produccion_cantidad` int(255) NOT NULL,
  `producto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `produccion`
--

INSERT INTO `produccion` (`id`, `unidad_medida_id`, `produccion_cantidad`, `producto_id`) VALUES
(1, 1, 30, 6),
(2, 1, 40, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `formato` varchar(255) NOT NULL,
  `creado_el` datetime NOT NULL,
  `modificado_el` datetime NOT NULL,
  `eliminado_el` datetime NOT NULL,
  `familia_id` int(11) NOT NULL,
  `unidad_medida_id` int(11) NOT NULL,
  `linea_id` int(11) NOT NULL,
  `codigo_barra` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `marca`, `formato`, `creado_el`, `modificado_el`, `eliminado_el`, `familia_id`, `unidad_medida_id`, `linea_id`, `codigo_barra`) VALUES
(2, 'Paltak', 'Peruana', 'Malla', '2018-06-18 16:31:56', '2018-06-18 16:31:56', '2018-06-18 16:31:56', 4, 1, 1, 10002),
(3, 'Queso', 'Colun', 'Laminado', '2018-06-04 14:45:33', '2018-06-04 14:45:33', '2018-06-04 14:45:33', 12, 1, 3, 10005),
(4, 'Centolla', 'Mariscol', 'Malla', '2018-06-04 14:56:01', '2018-06-04 14:56:01', '2018-06-04 14:56:01', 14, 2, 10, 102211),
(5, 'Pate', 'San Jorge', 'Bolsas', '2018-06-04 16:40:09', '2018-06-04 16:40:09', '2018-06-04 16:40:09', 14, 2, 1, 32165131),
(6, 'Mayonesa', 'Hellmans', 'Embase', '2018-06-05 10:37:03', '2018-06-05 10:37:03', '2018-06-05 10:37:03', 12, 1, 10, 10),
(9, 'Sandia', 'Franuel', 'Bolsa', '2018-06-18 16:35:40', '2018-06-18 16:35:40', '2018-06-18 16:35:40', 6, 1, 3, 10004);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `id` int(11) NOT NULL,
  `producto_id` int(11) NOT NULL,
  `estado` varchar(255) NOT NULL,
  `insumos` varchar(255) NOT NULL,
  `cantidad` int(255) NOT NULL,
  `unidad_medidad_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`id`, `producto_id`, `estado`, `insumos`, `cantidad`, `unidad_medidad_id`) VALUES
(1, 2, 'Activo', 'Azucar', 20, 1),
(2, 5, 'Desactivado', 'Azucar', 20, 2),
(3, 4, 'Activo', 'Grasa', 50, 2);

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
(1, 'kg', 'kilos', '2018-05-30 17:51:12', '2018-05-30 17:51:12', '2018-05-30 17:51:12'),
(2, 'MT', 'METROS', '2018-05-30 17:54:27', '2018-05-30 17:54:27', '2018-05-30 17:54:27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `pass`, `correo`, `tipo`) VALUES
(1, 'Matias', '123456', 'matias@gmail.com', 'Gerente'),
(2, 'Andys', '123456', 'andy@gmail.com', 'Administrador'),
(3, 'Jorge', 'pastrana', 'jorge@gmail.com', 'Administrador'),
(4, 'Roberto', '666', 'roberto@gmail.com', 'Administrador'),
(5, 'Prueba', '123', 'prueba@pepe', 'Administrador'),
(6, 'Brandon', '666', 'brandon@gmail.dios', 'Administrador'),
(7, 'Ricardo', '123456789', 'ricardo@gmail.dios', 'Administrador'),
(8, 'Roberto V', '123', 'tito@gmail.com', 'Gerente'),
(9, 'Fabian', '123', 'fabitox@gmail.com', 'Administrador'),
(10, 'Rodolfo', '123', 'rodo@gmail.com', 'Gerente'),
(11, 'pepito', 'pepe', 'pepe', 'Administrador');

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
-- Indices de la tabla `produccion`
--
ALTER TABLE `produccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_produccion_unidad_idx` (`unidad_medida_id`),
  ADD KEY `fk_producto_idx` (`producto_id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_producto_familia1_idx` (`familia_id`),
  ADD KEY `fk_producto_unidad_medida1_idx` (`unidad_medida_id`),
  ADD KEY `fk_producto_linea_idx` (`linea_id`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_receta_producto1_idx` (`producto_id`),
  ADD KEY `fk_reseta_unidad_medida` (`unidad_medidad_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `linea`
--
ALTER TABLE `linea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `precio_venta`
--
ALTER TABLE `precio_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `produccion`
--
ALTER TABLE `produccion`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `unidad_medida`
--
ALTER TABLE `unidad_medida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

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
-- Filtros para la tabla `produccion`
--
ALTER TABLE `produccion`
  ADD CONSTRAINT `fk_produccion_unidad_idx` FOREIGN KEY (`unidad_medida_id`) REFERENCES `unidad_medida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_idx` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_familia1` FOREIGN KEY (`familia_id`) REFERENCES `familia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_linea_idx` FOREIGN KEY (`linea_id`) REFERENCES `linea` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_producto_unidad_medida1` FOREIGN KEY (`unidad_medida_id`) REFERENCES `unidad_medida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `fk_receta_producto1` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_reseta_unidad_medida` FOREIGN KEY (`unidad_medidad_id`) REFERENCES `unidad_medida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
