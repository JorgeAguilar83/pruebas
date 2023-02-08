package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.entity.Alumno;

public interface IAlumnoRepository extends CrudRepository<Alumno, Long>{
	Optional<Alumno> findById(Long id);
}
