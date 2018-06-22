CREATE SCHEMA IF NOT EXISTS `smartprice` DEFAULT CHARACTER SET utf8 ;
USE `smartprice` ;
-- -----------------------------------------------------
-- Table `smartprice`.`administradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`administradores` (
  `idadministradores` INT(11) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idadministradores`),
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `smartprice`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`categoria` (
  `idCategoria` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `categoria_padre` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategoria`),
  INDEX `FK_categoria_padre_idx` (`categoria_padre` ASC),
  CONSTRAINT `FK_categoria_categoria`
    FOREIGN KEY (`categoria_padre`)
    REFERENCES `smartprice`.`categoria` (`idCategoria`),
  CONSTRAINT `FK_categoria_categoria_padre`
    FOREIGN KEY (`categoria_padre`)
    REFERENCES `smartprice`.`categoria` (`idCategoria`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `smartprice`.`marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`marca` (
  `idMarca` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  `logotipo` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`idMarca`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `smartprice`.`producto_y_servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`producto_y_servicio` (
  `idproductos_y_servicios` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL,
  `idMarca` INT(11) NULL DEFAULT NULL,
  `idCategoria` INT(11) NULL DEFAULT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `foto` BLOB NULL DEFAULT NULL,
  PRIMARY KEY (`idproductos_y_servicios`),
  INDEX `FK_idmarca_idx` (`idMarca` ASC),
  INDEX `FK_idcategoria_idx` (`idCategoria` ASC),
  CONSTRAINT `FK_producto_y_servicio_categoria`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `smartprice`.`categoria` (`idCategoria`),
  CONSTRAINT `FK_producto_y_servicio_idcategoria`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `smartprice`.`categoria` (`idCategoria`),
  CONSTRAINT `FK_producto_y_servicio_idmarca`
    FOREIGN KEY (`idMarca`)
    REFERENCES `smartprice`.`marca` (`idMarca`),
  CONSTRAINT `FK_producto_y_servicio_marca`
    FOREIGN KEY (`idMarca`)
    REFERENCES `smartprice`.`marca` (`idMarca`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`categoria_de_denuncia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`categoria_de_denuncia` (
  `idcategoria_de_denuncia` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcategoria_de_denuncia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(200) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(200) NULL DEFAULT NULL,
  `activo` TINYINT(1) NULL DEFAULT '1',
  `DTYPE` VARCHAR(45) NULL DEFAULT 'Usuario',
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`oferente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`oferente` (
  `id_usuario_oferente` INT(11) NOT NULL,
  `cuit` INT(11) NOT NULL,
  `razon_social` VARCHAR(200) NULL DEFAULT NULL,
  `direccion` VARCHAR(200) NULL DEFAULT NULL,
  `telefono` BIGINT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_usuario_oferente`),
  UNIQUE INDEX `cuit_UNIQUE` (`cuit` ASC),
  INDEX `fk_oferente_login_idx` (`id_usuario_oferente` ASC),
  CONSTRAINT `fk_oferente_login`
    FOREIGN KEY (`id_usuario_oferente`)
    REFERENCES `smartprice`.`usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`calificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`calificacion` (
  `idproducto` INT(11) NOT NULL,
  `idoferente` INT(11) NOT NULL,
  `idcategoria_denuncia` INT(11) NULL DEFAULT NULL,
  `puntaje` INT(11) NOT NULL,
  `idusuario_denunciante` INT(11) NOT NULL,
  INDEX `FK_calificacion_producto_y_servicio_idx` (`idproducto` ASC),
  INDEX `FK_calificaion_categoria_de_denuncia_idx` (`idcategoria_denuncia` ASC),
  INDEX `fk_calificacion_oferente_idx` (`idoferente` ASC),
  INDEX `fk_calificacion_denunciante_idx` (`idusuario_denunciante` ASC),
  CONSTRAINT `FK_calificacion_producto_y_servicio`
    FOREIGN KEY (`idproducto`)
    REFERENCES `smartprice`.`producto_y_servicio` (`idproductos_y_servicios`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_calificaion_categoria_de_denuncia`
    FOREIGN KEY (`idcategoria_denuncia`)
    REFERENCES `smartprice`.`categoria_de_denuncia` (`idcategoria_de_denuncia`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_calificacion_denunciante`
    FOREIGN KEY (`idusuario_denunciante`)
    REFERENCES `smartprice`.`usuario` (`id_usuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_calificacion_oferente`
    FOREIGN KEY (`idoferente`)
    REFERENCES `smartprice`.`oferente` (`id_usuario_oferente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`detalle_combo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`detalle_combo` (
  `id_combo` INT(11) NOT NULL,
  `producto_incluido` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`id_combo`, `producto_incluido`),
  INDEX `producto_incluido_idx` (`producto_incluido` ASC),
  CONSTRAINT `fk_detalle_combo_1`
    FOREIGN KEY (`id_combo`)
    REFERENCES `smartprice`.`producto_y_servicio` (`idproductos_y_servicios`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `producto_incluido`
    FOREIGN KEY (`producto_incluido`)
    REFERENCES `smartprice`.`producto_y_servicio` (`idproductos_y_servicios`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`oferta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`oferta` (
  `id_oferta` INT(11) NOT NULL AUTO_INCREMENT,
  `id_oferente` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_finalizacion` DATE NULL DEFAULT NULL,
  `precio` DECIMAL(2,0) NOT NULL,
  `cantidad_minima` INT(11) NULL DEFAULT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id_oferta`),
  INDEX `FK_idproducto_idx` (`id_producto` ASC),
  INDEX `fk_oferta_Oferente_idx` (`id_oferente` ASC),
  CONSTRAINT `FK_oferta_producto_y_servicio`
    FOREIGN KEY (`id_producto`)
    REFERENCES `smartprice`.`producto_y_servicio` (`idproductos_y_servicios`),
  CONSTRAINT `fk_oferta_Oferente`
    FOREIGN KEY (`id_oferente`)
    REFERENCES `smartprice`.`oferente` (`id_usuario_oferente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`precio_regular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`precio_regular` (
  `precio_regular` DECIMAL(6,2) NULL DEFAULT NULL,
  `id_oferente` INT(11) NOT NULL,
  `id_producto` INT(11) NOT NULL,
  PRIMARY KEY (`id_oferente`, `id_producto`),
  INDEX `fk_producto_precio_idx` (`id_producto` ASC),
  CONSTRAINT `fk_oferente_precio`
    FOREIGN KEY (`id_oferente`)
    REFERENCES `smartprice`.`oferente` (`id_usuario_oferente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_producto_precio`
    FOREIGN KEY (`id_producto`)
    REFERENCES `smartprice`.`producto_y_servicio` (`idproductos_y_servicios`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`sequence` (
  `SEQ_NAME` VARCHAR(50) NOT NULL,
  `SEQ_COUNT` DECIMAL(38,0) NULL DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -----------------------------------------------------
-- Table `smartprice`.`sucursales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `smartprice`.`sucursales` (
  `id_oferente` INT(11) NOT NULL,
  `nombre_sucursal` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_oferente`, `nombre_sucursal`),
  CONSTRAINT `fk_Sucursales_oferente`
    FOREIGN KEY (`id_oferente`)
    REFERENCES `smartprice`.`oferente` (`id_usuario_oferente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;