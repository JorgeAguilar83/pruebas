package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_materias")
public class Materia extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nombre", length = 80)
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
