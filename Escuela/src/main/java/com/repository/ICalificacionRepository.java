package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.entity.Alumno;
import com.entity.CalificacionAluMat;

public interface ICalificacionRepository extends CrudRepository<CalificacionAluMat, Long>{
	List<CalificacionAluMat> findByAlumno(Alumno alumno);
	Optional<CalificacionAluMat> findById(Long id);
}
