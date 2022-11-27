 package com.example.demo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.DocenteDTO;
import com.example.demo.modelo.Docente;
import com.example.demo.servicio.DocenteServicio;

@Controller
@RequestMapping("/registro")  
public class DocenteControlador {
	
	private DocenteServicio docenteServicio;

	public DocenteControlador(DocenteServicio docenteServicio) {
		super();
		this.docenteServicio = docenteServicio;
	}

	@ModelAttribute
	public DocenteDTO retornarNuevoDocenteDTO() {
		
		return new DocenteDTO();
	}
	
	@GetMapping
	public String formularioDeRegistro(){
		return "";
	}
	
	@PostMapping
	public String registrarDocente(@ModelAttribute("docente") DocenteDTO registroDTO){
		this.docenteServicio.guardar(registroDTO);
		return "redirect:/registro?exito";
	}
}
