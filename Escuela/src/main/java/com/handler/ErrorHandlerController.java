package com.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ErrorHandlerController {

	Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);
	
	@ExceptionHandler(Exception.class)
	public String aritmeticaError(Exception e, RedirectAttributes redirectAttributes) {
		e.printStackTrace();
		logger.error(e.getMessage());
		redirectAttributes.addFlashAttribute("error", "Ocurrio un error contacte al administrador");
	    return "redirect:/principal";
	}
}
