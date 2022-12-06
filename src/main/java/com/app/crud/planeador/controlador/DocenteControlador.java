package com.app.crud.planeador.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.crud.planeador.entidad.Administrador;
import com.app.crud.planeador.entidad.Docente;
import com.app.crud.planeador.servicio.AdministradorServicio;
import com.app.crud.planeador.servicio.DocenteServicio;

@Controller
public class DocenteControlador {
	
	@Autowired
	private DocenteServicio servicio;
	@Autowired
	private AdministradorServicio adminServicio;
	
//	@GetMapping({"/","/perfil"})
//	public String paginaPrincipal(){
//		return "perfil";
//	}
	
	@GetMapping({"/","/inicio"})
	public String paginaPrincipal(Model model){
//		https://stackoverflow.com/a/30992510
//		https://www.thymeleaf.org/doc/articles/springmvcaccessdata.html
		model.addAttribute("docente", new Docente());
		return "login";
	}
	
	@PostMapping("/login")
	public String iniciarSesion(@ModelAttribute("docente") Docente docente, Model model){
		Administrador actual = adminServicio.buscarAdministradorPorDocumento(docente.getDocumento());
		if (actual == null) {
			return "redirect:/login?error";
		}
		return "perfil";
	}
	
//	@GetMapping({"/perfil"})
//	public String redirigirPerfil(){
//		
//		return "perfil";
//	}
	
//	@GetMapping({"/docentes","/"})
	@GetMapping({"/docentes"})
	public String listarDocentes(Model modelo) {
		modelo.addAttribute("docentes", servicio.listarTodosLosDocentes());
		return "docentes";
	}
	
	@GetMapping({"/docentes/nuevo"})
	public String crearDocentesFormulario(Model modelo) {
		Docente docente = new Docente();
		modelo.addAttribute("docente", docente);
		return "crear_docente";
	}
	
	@PostMapping("/docentes")
	public String guardarEstudiante(@ModelAttribute("docente") Docente docente){
		servicio.guardarDocente(docente);
		return "redirect:/docentes";
	}
	
	@GetMapping("/docentes/editar/{documento}")
	public String editarDocenteFormulario(@PathVariable Long documento, Model modelo) {
		modelo.addAttribute("docente", servicio.buscarDocentePorDocumento(documento));
		return "editar_docente";
	}
	
	@PostMapping("/docentes/{documento}")
	public String actualizarEstudiante(@PathVariable Long documento, @ModelAttribute("docente") Docente docente, Model modelo){
		 
		Docente docenteExistente = servicio.buscarDocentePorDocumento(documento);
		docenteExistente.setDocumento(docente.getDocumento());
		docenteExistente.setPrimerNombre(docente.getPrimerNombre());
		docenteExistente.setPrimerApellido(docente.getPrimerApellido());
		docenteExistente.setCodigo(docente.getCodigo());
		docenteExistente.setEmail(docente.getEmail());
		servicio.guardarDocente(docente);
		return "redirect:/docentes";
	}
	
	@GetMapping("/docentes/{documento}")
	public String eliminarDocente(@PathVariable Long documento) {
		servicio.eliminarDocente(documento);
		return "redirect:/docentes";
	};
}
