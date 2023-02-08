package com.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class BuscarDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String idAlumno;
	@NotBlank
	private String idMateria;
	@NotBlank
	private String  calificacion;
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	public String getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	

}
