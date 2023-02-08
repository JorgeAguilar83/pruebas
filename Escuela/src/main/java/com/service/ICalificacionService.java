package com.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.dto.CalificacionDto;
import com.entity.Alumno;
import com.entity.CalificacionAluMat;
import com.entity.Materia;

public interface ICalificacionService {
	CalificacionDto findByAlumno(Long id);
	Optional<CalificacionAluMat> findById(Long id);
	void save(Alumno alumno, Materia materia, BigDecimal calificacion);
	void update(CalificacionAluMat calificacionAluMat);
	void delete(Long id);
	Optional<Alumno> findByIdAlumno(Long id);
	Optional<Materia> findByIdMateria(Long id);
	default double calculateAverage(List<CalificacionAluMat> list) {
        return list.stream()
                .mapToDouble(a -> a.getCalificacion().doubleValue())
                .average().orElse(0);
    }
}
