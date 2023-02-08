INSERT INTO `escuela`.`t_alumnos` (`activo`, `ap_materno`, `ap_paterno`, `nombre`) VALUES (1, 'Down', 'Dow', 'Jhon');

INSERT INTO `escuela`.`t_materias` (`activo`, `nombre`) VALUES (1, 'matematicas');
INSERT INTO `escuela`.`t_materias` (`activo`, `nombre`) VALUES (1, 'programacion');
INSERT INTO `escuela`.`t_materias` (`activo`, `nombre`) VALUES (1, 'ingenieria de software');

INSERT INTO `escuela`.`t_calificaciones` (`calificacion`, `fecha_registro`, `alumno_id`, `materia_id`) VALUES (9.8, CURDATE(), 1, 1);





