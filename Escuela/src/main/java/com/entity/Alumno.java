package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_alumnos")
public class Alumno extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nombre", length = 80)
	private String nombre;
	
	@Column(name = "ap_paterno" , length = 80)
	private String apPaterno;
	
	@Column(name = "ap_materno" , length = 80)
	private String apMaterno;

	public Alumno() {}
	
	public Alumno(Long id) {
		super.setId(id);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

}
