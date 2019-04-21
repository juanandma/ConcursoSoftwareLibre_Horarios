
-- -----------------------------------------------------
-- Table `horarios`.`Asignatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horarios`.`Asignatura` (
  `id_asignatura` INT,
  `nombre` VARCHAR(45) NOT NULL,
  `Cuatrimestre` INT NOT NULL,
  `Curso` INT NOT NULL,
  PRIMARY KEY (`id_asignatura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `horarios`.`Hora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `horarios`.`Hora` (
  `idHora` char(3),
  `Dia` INT NOT NULL,
  `HoraInicio` TIME(0) NOT NULL,
  `HoraFin` TIME(0) NOT NULL,
  `Tipo` INT NOT NULL,
  `Asignatura_id_asignatura` INT NOT NULL,
  PRIMARY KEY (`idHora`, `Asignatura_id_asignatura`),
  CONSTRAINT `fk_Hora_Asignatura`
    FOREIGN KEY (`Asignatura_id_asignatura`)
    REFERENCES `horarios`.`Asignatura` (`id_asignatura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- asignaturas
-- -----------------------------------------------------

INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('1', 'Economia', '1', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('2', 'Matematicas1', '1', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('3', 'Fisica', '1', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('4', 'fundamentosDeProgramacion', '1', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('5', 'fundamentosDeComputadores', '1', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('6', 'algoritmos1', '2', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('7', 'estructurasDeDatos1', '2', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('8', 'Matematicas2', '2', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('9', 'Matematicas3', '2', '1');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('10', 'tecnologiaDeComputadores', '2', '1');

INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('11', 'fundamentosDeRedes', '1', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('12', 'deso', '1', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('13', 'basesDeDatos', '1', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('14', 'estructuraDeComputadores', '1', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('15', 'metodologiaDeLaProgramacion', '1', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('16', 'inteligenciaArtificial', '2', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('17', 'arquitecturaDeComputadores', '2', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('18', 'estructurasDeDatos2', '2', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('19', 'principiosYFundamentosDelSoftware', '2', '2');
INSERT INTO `asignatura` (`id_asignatura`, `nombre`, `Cuatrimestre`, `Curso`) VALUES ('20', 'apso', '2', '2');




-- -----------------------------------------------------
-- horas de teoria de las asignaturas
-- -----------------------------------------------------

-- curso 1º

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h1', '1', '10:00', '11:00', '0', '1');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h2', '2', '10:00', '11:00', '0', '1');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h3', '2', '10:00', '11:00', '0', '2');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h4', '2', '11:00', '12:00', '0', '2');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h5', '2', '11:00', '12:00', '0', '3');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h6', '3', '10:00', '11:00', '0', '3');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h7', '3', '10:00', '11:00', '0', '4');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h8', '3', '11:00', '12:00', '0', '4');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h9', '3', '11:00', '12:00', '0', '5');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h10', '4', '10:00', '11:00', '0', '5');


INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h11', '1', '10:00', '11:00', '0', '6');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h12', '2', '10:00', '11:00', '0', '6');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h13', '2', '10:00', '11:00', '0', '7');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h14', '2', '11:00', '12:00', '0', '7');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h15', '2', '11:00', '12:00', '0', '8');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h16', '3', '10:00', '11:00', '0', '8');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h17', '3', '10:00', '11:00', '0', '9');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h18', '3', '11:00', '12:00', '0', '9');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h19', '3', '11:00', '12:00', '0', '10');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h20', '4', '10:00', '11:00', '0', '10');


-- curso 2º

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h21', '1', '10:00', '11:00', '0', '11');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h22', '1', '11:00', '12:00', '0', '11');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h23', '1', '11:00', '12:00', '0', '12');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h24', '2', '10:00', '11:00', '0', '12');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h25', '2', '10:00', '11:00', '0', '13');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h26', '3', '10:00', '11:00', '0', '13');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h27', '3', '10:00', '11:00', '0', '14');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h28', '4', '10:00', '11:00', '0', '14');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h29', '4', '10:00', '11:00', '0', '15');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h30', '4', '11:00', '12:00', '0', '15');


INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h31', '1', '10:00', '11:00', '0', '16');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h32', '1', '11:00', '12:00', '0', '16');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h33', '1', '11:00', '12:00', '0', '17');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h34', '2', '10:00', '11:00', '0', '17');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h35', '2', '10:00', '11:00', '0', '18');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h36', '3', '10:00', '11:00', '0', '18');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h37', '3', '10:00', '11:00', '0', '19');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h38', '4', '10:00', '11:00', '0', '19');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h39', '4', '10:00', '11:00', '0', '20');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h40', '4', '11:00', '12:00', '0', '20');




-- -----------------------------------------------------
-- horas de practicas de las asignaturas
-- -----------------------------------------------------

-- curso 1º

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h41', '1', '10:00', '11:00', '1', '1');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h42', '2', '10:00', '11:00', '1', '1');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h43', '2', '10:00', '11:00', '1', '2');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h44', '2', '11:00', '12:00', '1', '2');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h45', '2', '11:00', '12:00', '1', '3');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h46', '3', '10:00', '11:00', '1', '3');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h47', '3', '10:00', '11:00', '1', '4');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h48', '3', '11:00', '12:00', '1', '4');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h49', '3', '11:00', '12:00', '1', '5');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h50', '4', '10:00', '11:00', '1', '5');


INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h51', '1', '10:00', '11:00', '1', '6');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h52', '2', '10:00', '11:00', '1', '6');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h53', '2', '10:00', '11:00', '1', '7');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h54', '2', '11:00', '12:00', '1', '7');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h55', '2', '11:00', '12:00', '1', '8');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h56', '3', '10:00', '11:00', '1', '8');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h57', '3', '10:00', '11:00', '1', '9');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h58', '3', '11:00', '12:00', '1', '9');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h59', '3', '11:00', '12:00', '1', '10');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h60', '4', '10:00', '11:00', '1', '10');


-- curso 2º

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h61', '1', '10:00', '11:00', '1', '11');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h62', '1', '11:00', '12:00', '1', '11');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h63', '1', '11:00', '12:00', '1', '12');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h64', '2', '10:00', '11:00', '1', '12');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h65', '2', '10:00', '11:00', '1', '13');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h66', '3', '10:00', '11:00', '1', '13');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h67', '3', '10:00', '11:00', '1', '14');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h68', '4', '10:00', '11:00', '1', '14');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h69', '4', '10:00', '11:00', '1', '15');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h70', '4', '11:00', '12:00', '1', '15');


INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h71', '1', '10:00', '11:00', '1', '16');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h72', '1', '11:00', '12:00', '1', '16');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h73', '1', '11:00', '12:00', '1', '17');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h74', '2', '10:00', '11:00', '1', '17');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h75', '2', '10:00', '11:00', '1', '18');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h76', '3', '10:00', '11:00', '1', '18');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h77', '3', '10:00', '11:00', '1', '19');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h78', '4', '10:00', '11:00', '1', '19');

INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h79', '4', '10:00', '11:00', '1', '20');
INSERT INTO `hora` (`idHora`, `Dia`, `HoraInicio`, `HoraFin`, `Tipo`, `Asignatura_id_asignatura`) VALUES ('h80', '4', '11:00', '12:00', '1', '20');
