package com.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.CalificacionDto;
import com.entity.*;
import com.repository.IAlumnoRepository;
import com.repository.ICalificacionRepository;
import com.repository.IMateriaRepository;

@Service
public class CalificacionImpl implements ICalificacionService  {

	@Autowired
	private ICalificacionRepository calificacionRepository;
	@Autowired
	private IAlumnoRepository alumnoRepository;
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	public CalificacionDto findByAlumno(Long id) {	
		List<CalificacionAluMat> list = calificacionRepository.findByAlumno(new Alumno(id));
		return new CalificacionDto(calculateAverage(list),list);
	}

	@Override
	public void save(Alumno alumno, Materia materia, BigDecimal calificacion){
		calificacionRepository.save(new CalificacionAluMat(calificacion, new Date(), alumno, materia));		
	}
	
	@Override
	public void update(CalificacionAluMat calificacionAluMat) {
		calificacionRepository.save(calificacionAluMat);
	}

	@Override
	public void delete(Long id) {
		CalificacionAluMat calificacionAluMat = new CalificacionAluMat();
		calificacionAluMat.setId(id);
		calificacionRepository.delete(calificacionAluMat);
	}

	@Override
	public Optional<Alumno> findByIdAlumno(Long id) {
		return alumnoRepository.findById(id);
	}

	@Override
	public Optional<Materia> findByIdMateria(Long id) {
		return materiaRepository.findById(id);
	}

	@Override
	public Optional<CalificacionAluMat> findById(Long id) {
		return calificacionRepository.findById(id);
	}

}
