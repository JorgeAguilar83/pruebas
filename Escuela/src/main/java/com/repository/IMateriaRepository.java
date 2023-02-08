package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.entity.Materia;

public interface IMateriaRepository extends CrudRepository<Materia, Long>{
	Optional<Materia> findById(Long id);
}
