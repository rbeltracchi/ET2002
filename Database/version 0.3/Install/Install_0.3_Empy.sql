SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `administradores` (
  `idadministradores` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  `nombre` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `administradores` (`idadministradores`, `activo`, `nombre`, `email`, `password`) VALUES
(1, 1, 'Martin Andres Farias', 'martin', 'adc285cb2e8ac3d014a2494ee6c1971c3607ac7802f6c53d6b48bf277fb3b2f09357a94b9302a6aab7572855990c4cda1c566c950eef41a63b33a075b8092415'),
(2, 1, 'Juan Veron', 'juan', '0d6694a0cc6c1b50a86fb85d238ade77ca5a9e81ef089b9fedd30eef6d1acbd2da15dd73b5420d8b486d8fc9c3e5d00ebce7d5a434c7c3c3ac4998838fdbc9bb'),
(3, 1, 'Agustin Gonzales', 'agustin', '7b79adabe195629f82b189dc229472202e0253092d2e26039f39ffcc76a826b7cd37f3264f3b1cd9997835f749731369c7d23d69d5ae84504ae022e6b4d6d1f2'),
(4, 1, 'lucho', 'lucho', '8d93983e90221e9c2295acd50dd34e439c38289769ea2f87707fec1ce07714742fb0ee6004ab299e928a28eb23a94635328b45f5ea87ed96ed5611223ab9c5a9'),
(5, 1, 'Diego', 'diego', 'a5dec58304420504e9c733ee78499bca287a9345d0c3b42ba98a55d397548a9a50ab1d6bfe1a39766215f43467e3096d9696bc474f7f6b33e1a1b79c217e30e2'),
(6, 1, 'Administrador', 'admin@smartprice.com.ar', '3a2df4b8fa6c9e9e610105b6180eb8c2b263fc88056c642fd66ca4e8d3e3c8e8aea96163f2fe964b2f41202fed2ae53b962ec37baebe7851c9ecdb5970f30946');

CREATE TABLE `calificacion` (
  `idproducto` int(11) NOT NULL,
  `idoferente` int(11) NOT NULL,
  `idcategoria_denuncia` int(11) DEFAULT NULL,
  `puntaje` int(11) NOT NULL,
  `idusuario_denunciante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `categoria_padre` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `categoria` (`idCategoria`, `nombre`, `categoria_padre`) VALUES
(1, 'Mercado', NULL),
(2, 'Carnes', 1),
(3, 'Frutas y Verduras', 1),
(4, 'Panadería y Dulces', 1),
(5, 'Lacteos y Huevos', 1),
(6, 'Almacen', 1),
(7, 'Conservas y comida preparada', 1),
(8, 'Bebidas y jugos', 1),
(9, 'Snacks', 1),
(10, 'Cuidado personal', 1),
(11, 'Fiambres', 1),
(12, 'Tecnologia', NULL),
(13, 'Celulares y accesorios', 12),
(14, 'Computacion', 12),
(15, 'Camaras y accesorios', 12),
(16, 'Audio y Video', 12),
(17, 'Consolas', 12),
(18, 'Acc Vehiculos', NULL),
(19, 'Neumaticos', 18),
(20, 'Repuestos Automotor', 18),
(21, 'Audio vehiculos', 18),
(22, 'Acc Motos', 18),
(23, 'Acc Auto', 18),
(24, 'Tunning', 18),
(25, 'Juguetes y Bebes', NULL),
(26, 'Bebe', 25),
(27, 'Disfraces y cotillon', 25),
(28, 'Juguetes', 25),
(29, 'Juegos', 25),
(30, 'Vehiculos para niños', 25),
(31, 'Muñecos', 25),
(32, 'Hogar y Electrodomesticos', NULL),
(33, 'Electrodomesticos', 32),
(34, 'Climatizacion', 32),
(35, 'Jardineria y exteriores', 32),
(36, 'Bazar', 32),
(37, 'Decoracion', 32),
(38, 'Living', 32),
(39, 'Dormitorio', 32),
(40, 'Herramientas y Oficinas', NULL),
(41, 'Herramientas', 40),
(42, 'Electricidad', 40),
(43, 'Construccion', 40),
(44, 'Industrias y Oficinas', 40),
(45, 'Libreria', NULL),
(46, 'Utiles escolares', 45),
(47, 'Novelas y Cuentos', 45),
(48, 'Comics e Historietas', 45),
(49, 'Revistas', 45),
(50, 'Manuales', 45),
(51, 'Ciencias', 45),
(52, 'Moda', NULL),
(53, 'Mujer', 52),
(54, 'Hombre', 52),
(55, 'Niños', 52),
(56, 'Servicios', NULL),
(57, 'Alquileres', 56),
(58, 'Cafeteria', 56),
(59, 'Heladeria', 56),
(60, 'Delivery', 56),
(61, 'Plomero-Gasista', 56),
(62, 'Electricista', 56),
(63, 'Serv. Tecnico PC', 56);

CREATE TABLE `categoria_de_denuncia` (
  `idcategoria_de_denuncia` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `detalle_combo` (
  `id_combo` int(11) NOT NULL,
  `producto_incluido` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `logotipo` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferente` (
  `id_usuario_oferente` int(11) NOT NULL,
  `cuit` int(11) NOT NULL,
  `razon_social` varchar(200) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `telefono` bigint(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `oferta` (
  `id_oferta` int(11) NOT NULL,
  `id_oferente` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizacion` date DEFAULT NULL,
  `precio` float(10,2) NOT NULL,
  `cantidad_minima` int(11) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `precio_regular` (
  `precio` float(10,2) DEFAULT NULL,
  `id_oferente` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `producto_y_servicio` (
  `idproductos_y_servicios` int(11) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `idMarca` int(11) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `foto` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

CREATE TABLE `sucursales` (
  `id_oferente` int(11) NOT NULL,
  `nombre_sucursal` varchar(45) NOT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` text NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  `DTYPE` varchar(45) DEFAULT 'Usuario'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `administradores`
  ADD PRIMARY KEY (`idadministradores`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

ALTER TABLE `calificacion`
  ADD KEY `FK_calificacion_producto_y_servicio_idx` (`idproducto`),
  ADD KEY `FK_calificaion_categoria_de_denuncia_idx` (`idcategoria_denuncia`),
  ADD KEY `fk_calificacion_oferente_idx` (`idoferente`),
  ADD KEY `fk_calificacion_denunciante_idx` (`idusuario_denunciante`);

ALTER TABLE `categoria`
  ADD PRIMARY KEY (`idCategoria`),
  ADD KEY `FK_categoria_padre_idx` (`categoria_padre`);

ALTER TABLE `categoria_de_denuncia`
  ADD PRIMARY KEY (`idcategoria_de_denuncia`);

ALTER TABLE `detalle_combo`
  ADD PRIMARY KEY (`id_combo`,`producto_incluido`),
  ADD KEY `producto_incluido_idx` (`producto_incluido`);

ALTER TABLE `marca`
  ADD PRIMARY KEY (`idMarca`);

ALTER TABLE `oferente`
  ADD PRIMARY KEY (`id_usuario_oferente`),
  ADD UNIQUE KEY `cuit_UNIQUE` (`cuit`),
  ADD KEY `fk_oferente_login_idx` (`id_usuario_oferente`);

ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id_oferta`),
  ADD KEY `FK_idproducto_idx` (`id_producto`),
  ADD KEY `fk_oferta_Oferente_idx` (`id_oferente`);

ALTER TABLE `precio_regular`
  ADD PRIMARY KEY (`id_oferente`,`id_producto`),
  ADD KEY `fk_producto_precio_idx` (`id_producto`);

ALTER TABLE `producto_y_servicio`
  ADD PRIMARY KEY (`idproductos_y_servicios`),
  ADD KEY `FK_producto_y_servicio_categoria` (`idCategoria`),
  ADD KEY `FK_producto_y_servicio_idmarca` (`idMarca`);

ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`id_oferente`,`nombre_sucursal`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);


ALTER TABLE `administradores`
  MODIFY `idadministradores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

ALTER TABLE `marca`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `oferta`
  MODIFY `id_oferta` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `producto_y_servicio`
  MODIFY `idproductos_y_servicios` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `calificacion`
  ADD CONSTRAINT `FK_calificacion_producto_y_servicio` FOREIGN KEY (`idproducto`) REFERENCES `producto_y_servicio` (`idproductos_y_servicios`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_calificaion_categoria_de_denuncia` FOREIGN KEY (`idcategoria_denuncia`) REFERENCES `categoria_de_denuncia` (`idcategoria_de_denuncia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_calificacion_denunciante` FOREIGN KEY (`idusuario_denunciante`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_calificacion_oferente` FOREIGN KEY (`idoferente`) REFERENCES `oferente` (`id_usuario_oferente`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `categoria`
  ADD CONSTRAINT `FK_categoria_categoria` FOREIGN KEY (`categoria_padre`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `FK_categoria_categoria_padre` FOREIGN KEY (`categoria_padre`) REFERENCES `categoria` (`idCategoria`);

ALTER TABLE `detalle_combo`
  ADD CONSTRAINT `fk_detalle_combo_1` FOREIGN KEY (`id_combo`) REFERENCES `producto_y_servicio` (`idproductos_y_servicios`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `producto_incluido` FOREIGN KEY (`producto_incluido`) REFERENCES `producto_y_servicio` (`idproductos_y_servicios`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `oferente`
  ADD CONSTRAINT `fk_oferente_login` FOREIGN KEY (`id_usuario_oferente`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `oferta`
  ADD CONSTRAINT `FK_oferta_producto_y_servicio` FOREIGN KEY (`id_producto`) REFERENCES `producto_y_servicio` (`idproductos_y_servicios`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_oferta_Oferente` FOREIGN KEY (`id_oferente`) REFERENCES `oferente` (`id_usuario_oferente`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `precio_regular`
  ADD CONSTRAINT `fk_oferente_precio` FOREIGN KEY (`id_oferente`) REFERENCES `oferente` (`id_usuario_oferente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_producto_precio` FOREIGN KEY (`id_producto`) REFERENCES `producto_y_servicio` (`idproductos_y_servicios`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `producto_y_servicio`
  ADD CONSTRAINT `FK_producto_y_servicio_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_producto_y_servicio_idmarca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `sucursales`
  ADD CONSTRAINT `fk_Sucursales_oferente` FOREIGN KEY (`id_oferente`) REFERENCES `oferente` (`id_usuario_oferente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;