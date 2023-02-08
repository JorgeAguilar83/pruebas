package com.dto;

import java.io.Serializable;
import java.util.List;

import com.entity.CalificacionAluMat;

public class CalificacionDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private double promedio;
	private List<CalificacionAluMat> listCalificacionAluMat;
	
	public CalificacionDto(double promedio, List<CalificacionAluMat> listCalificacionAluMat) {
		this.promedio = promedio;
		this.listCalificacionAluMat = listCalificacionAluMat;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public List<CalificacionAluMat> getListCalificacionAluMat() {
		return listCalificacionAluMat;
	}

	public void setListCalificacionAluMat(List<CalificacionAluMat> listCalificacionAluMat) {
		this.listCalificacionAluMat = listCalificacionAluMat;
	}
	
}
