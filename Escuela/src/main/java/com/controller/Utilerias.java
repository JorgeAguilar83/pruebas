package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;

public class Utilerias {
	
	public static String mensajeError(BindingResult result) {
		Map<String, String> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {errores.put(err.getField(), "Error: "+err.getField() +" "+ err.getDefaultMessage());});
		return errores.toString(); 
	}
	
}
