
USE `smartprice` ;
-- -----------------------------------------------------
-- Upgrade
-- -----------------------------------------------------

ALTER TABLE `usuario` CHANGE `password` `password` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;
ALTER TABLE `administradores` CHANGE `contraseña` `contraseña` TEXT CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL;

INSERT INTO `administradores` (`idadministradores`, `usuario`, `email`, `contraseña`) VALUES (NULL, 'AdminSmartPrice', 'admin@smartprice.com.ar', 'd8823b1768ee2be856aa82a10319540d8d902e1fb10a5e9530fd097061028bfcffaaf260cf88aeb46f71f41e5f5750a4157e479c07413cf12b507199b9bdf429');