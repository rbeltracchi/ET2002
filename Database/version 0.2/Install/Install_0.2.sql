--
-- Database version 0.2
--

CREATE TABLE `administradores` (
  `idadministradores` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contraseña` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `administradores` (`idadministradores`, `usuario`, `email`, `contraseña`) VALUES
(1, 'AdminSmartPrice', 'admin@smartprice.com.ar', 'd8823b1768ee2be856aa82a10319540d8d902e1fb10a5e9530fd097061028bfcffaaf260cf88aeb46f71f41e5f5750a4157e479c07413cf12b507199b9bdf429');

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
  `precio` decimal(2,0) NOT NULL,
  `cantidad_minima` int(11) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `precio_regular` (
  `precio_regular` decimal(6,2) DEFAULT NULL,
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
  ADD UNIQUE KEY `usuario_UNIQUE` (`usuario`),
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
  ADD KEY `FK_idmarca_idx` (`idMarca`),
  ADD KEY `FK_idcategoria_idx` (`idCategoria`);

ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`id_oferente`,`nombre_sucursal`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

ALTER TABLE `administradores`
  MODIFY `idadministradores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `categoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `FK_oferta_producto_y_servicio` FOREIGN KEY (`id_producto`) REFERENCES `producto_y_servicio` (`idproductos_y_servicios`),
  ADD CONSTRAINT `fk_oferta_Oferente` FOREIGN KEY (`id_oferente`) REFERENCES `oferente` (`id_usuario_oferente`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `precio_regular`
  ADD CONSTRAINT `fk_oferente_precio` FOREIGN KEY (`id_oferente`) REFERENCES `oferente` (`id_usuario_oferente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_producto_precio` FOREIGN KEY (`id_producto`) REFERENCES `producto_y_servicio` (`idproductos_y_servicios`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `producto_y_servicio`
  ADD CONSTRAINT `FK_producto_y_servicio_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `FK_producto_y_servicio_idcategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  ADD CONSTRAINT `FK_producto_y_servicio_idmarca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`),
  ADD CONSTRAINT `FK_producto_y_servicio_marca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idMarca`);

ALTER TABLE `sucursales`
  ADD CONSTRAINT `fk_Sucursales_oferente` FOREIGN KEY (`id_oferente`) REFERENCES `oferente` (`id_usuario_oferente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;