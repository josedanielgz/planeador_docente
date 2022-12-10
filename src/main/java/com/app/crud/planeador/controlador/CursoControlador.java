package com.app.crud.planeador.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CursoControlador {

	@GetMapping("/curso")
	public String curso(Model model) {
		return "docentes";
	}

	@GetMapping("/curso/nuevo")
	public String principalMicrocurriculos(Model model) {
		return "crear_curso";
	}

	@PostMapping("/curso/nuevo")
	public String volverDocentes(Model model) {
		return "crear_curso";
	}
}
