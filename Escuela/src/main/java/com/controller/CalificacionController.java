package com.controller;

import java.math.BigDecimal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;
import com.dto.BuscarDTO;
import com.entity.Alumno;
import com.entity.CalificacionAluMat;
import com.entity.Materia;
import com.service.ICalificacionService;

@Controller
@SessionAttributes("calificaciones")
public class CalificacionController {

	@Autowired
	private ICalificacionService service;
	
	@RequestMapping(value = {"/principal", "/"}, method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "LA ESCUELA DE CURSOS ALTERNATIVOS");
		model.addAttribute("calificaciones",service.findByAlumno(1L));
		model.addAttribute("buscarDTO",new BuscarDTO());
		model.addAttribute("nombreBoton", "Alta Calificación");
		return Vistas.VISTA_LISTA_CALIFICACION;
	}

	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
    public String save(@Valid BuscarDTO buscarDTO, BindingResult result, Model model, RedirectAttributes mensaje) throws Exception{   	
		
		if (result.hasErrors()) {
			mensaje.addFlashAttribute("error", Utilerias.mensajeError(result));
			return Vistas.REDIRECT + Vistas.VISTA_PRINCIPAL;
		}
		
		Optional<Alumno> alumno = service.findByIdAlumno(Long.parseLong(buscarDTO.getIdAlumno()));
		Optional<Materia> materia = service.findByIdMateria(Long.parseLong(buscarDTO.getIdMateria()));
		
		if(alumno.isPresent() && materia.isPresent()) {
			service.save(alumno.get(), materia.get(), BigDecimal.valueOf(Double.parseDouble(buscarDTO.getCalificacion())));
			mensaje.addFlashAttribute("success","Calificación registrada");
		}else {
			mensaje.addFlashAttribute("error","No se encontró el alumno, o materia");
		}
		
		return Vistas.REDIRECT + Vistas.VISTA_PRINCIPAL;
    }
	
	@RequestMapping(value = "/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Long id, Model model,RedirectAttributes mensaje) {
		Optional<CalificacionAluMat> calificacion = service.findById(id);
		model.addAttribute("titulo", "ACTUALIZAR CALIFICACION");

		if(calificacion.isPresent()) {
			model.addAttribute("calificacionActualizar",calificacion.get());
			return Vistas.VISTA_ACTUALIZAR;
		}
		mensaje.addFlashAttribute("error","No se encontró la calificación");
		return Vistas.REDIRECT + Vistas.VISTA_PRINCIPAL;
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    public String update(@Valid CalificacionAluMat calificacionAluMat, BindingResult result, Model model, RedirectAttributes mensaje) throws Exception{  
		service.update(calificacionAluMat);
		mensaje.addFlashAttribute("success","Calificación actualizada");
		model.addAttribute("nombreBoton", "Actualizar");
		return Vistas.REDIRECT + Vistas.VISTA_PRINCIPAL; 
    }
	
	@RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes mensaje) {
		service.delete(id);
		mensaje.addFlashAttribute("success","Calificación eliminada");
		return Vistas.REDIRECT + Vistas.VISTA_PRINCIPAL;
	}
	
}
