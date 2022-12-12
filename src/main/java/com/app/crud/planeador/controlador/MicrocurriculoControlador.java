package com.app.crud.planeador.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MicrocurriculoControlador {

	@GetMapping("/planeadores")
	public String principalMicrocurriculos(Model model) {
		return "planeadores";
	}
}
