package com.app.crud.planeador.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.crud.planeador.entidad.Curso;
import com.app.crud.planeador.servicio.CursoServicio;

@Controller
public class CursoControlador {

	@Autowired
	private CursoServicio servicio;

	@GetMapping("/cursos")
	public String curso(Model model) {
		model.addAttribute("cursos", servicio.listarTodosLosCursos());
		return "cursos";
	}

	@GetMapping("/cursos/nuevo")
	public String principalMicrocurriculos(Model model) {
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		return "crear_curso";
	}
	
	@PostMapping("/cursos")
	public String guardarCurso(@ModelAttribute("curso") Curso curso) {
		servicio.guardarCurso(curso);
		return "redirect:/cursos";
	}
	
	@PostMapping("/cursos/{id}")
	public String editarCurso(@PathVariable Long id, @ModelAttribute("curso") Curso curso,
			Model modelo) {
		Curso cursoExistente = servicio.buscarCursoPorId(id);
		cursoExistente.setId(curso.getId());
		cursoExistente.setNombre(curso.getNombre());
		cursoExistente.setNroCreditos(curso.getNroCreditos());
		cursoExistente.setHorasIndependientes(curso.getHorasIndependientes());
		cursoExistente.setHorasDirectas(curso.getHorasDirectas());
		cursoExistente.setPrograma(curso.getPrograma());
		servicio.guardarCurso(cursoExistente);
		return "redirect:/cursos";
	}

	@GetMapping("/cursos/{id}")
	public String eliminarDocente(@PathVariable Long id) {
		servicio.eliminarCurso(id);
		return "redirect:/cursos";
	}

	
	@GetMapping("/cursos/editar/{id}")
	public String editarCursoFormulario(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("curso", servicio.buscarCursoPorId(id));
		return "editar_curso";
	}
}
