package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_calificaciones")
public class CalificacionAluMat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "calificacion", precision = 10, scale = 2)
	private BigDecimal calificacion;
	
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fechaRegistro;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="alumno_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Alumno alumno;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="materia_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Materia materia;

	public CalificacionAluMat(){}
	
	public CalificacionAluMat(BigDecimal calificacion, Date fechaRegistro, Alumno alumno, Materia materia){
		this.calificacion = calificacion;
		this.fechaRegistro = fechaRegistro;
		this.alumno = alumno;
		this.materia = materia;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(BigDecimal calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}
