package com.app.crud.planeador.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

//	@GetMapping({"/","/perfil"})
//	public String paginaPrincipal(){
//		return "perfil";
//	}

	@GetMapping({ "/", "/inicio" })
	public String paginaPrincipal(Model model) {
//		https://stackoverflow.com/a/30992510
//		https://www.thymeleaf.org/doc/articles/springmvcaccessdata.html
		model.addAttribute("el_docente", new Docente());
		return "login";
	}

	@GetMapping({ "/login" })
	public String regresarInicio(Model model) {
		model.addAttribute("el_docente", new Docente());
		return "login";
	}

	
	@PostMapping("/login")
	public String iniciarSesion(@ModelAttribute("el_docente") Docente docente, Model model) {
//		https://stackoverflow.com/questions/54597495/how-to-compare-a-password-text-with-the-bcrypt-hashes
		try {
			Administrador elAdmin = adminServicio.buscarAdministradorPorDocumento(docente.getDocumento());
			if (elAdmin != null) {
				Docente guardado = servicio.buscarDocentePorDocumento(elAdmin.getDocente());
				if (passwordEncoder.matches(docente.getClave(), guardado.getClave())) {
					model.addAttribute("el_docente", guardado);
					return "perfil";
				}
			}
			return "redirect:/login?error";
		} catch (Exception e) {
			return "redirect:/login?error";
		}
	}

//CONTROLADORES PARA EL MENU DE DOCENTES
	
	@GetMapping({ "/docentes" })
	public String listarDocentes(Model modelo) {
		modelo.addAttribute("docentes", servicio.listarTodosLosDocentes());
		return "docentes";
	}

	@GetMapping({ "/docentes/nuevo" })
	public String crearDocentesFormulario(Model modelo) {
		Docente docente = new Docente();
		modelo.addAttribute("docente", docente);
		return "crear_docente";
	}

	@PostMapping("/docentes")
	public String guardarEstudiante(@ModelAttribute("docente") Docente docente) {
		servicio.guardarDocente(docente);
		return "redirect:/docentes";
	}

	@GetMapping("/docentes/editar/{documento}")
	public String editarDocenteFormulario(@PathVariable Long documento, Model modelo) {
		modelo.addAttribute("docente", servicio.buscarDocentePorDocumento(documento));
		return "editar_docente";
	}

	@PostMapping("/docentes/{documento}")
	public String actualizarEstudiante(@PathVariable Long documento, @ModelAttribute("docente") Docente docente,
			Model modelo) {

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
	}
	
//	CONTROLADORES PARA EDITAR EL PERFIL
	@GetMapping({ "/perfil" })
	public String elPerfil() {
		return "perfil";
	}

	@GetMapping("/perfil/editar/{documento}")
	public String editarPerfil(@PathVariable Long documento, Model modelo) {
		modelo.addAttribute("el_docente", servicio.buscarDocentePorDocumento(documento));
		return "editar_perfil";
	}

	@PostMapping("/perfil/{documento}")
	public String actualizarPerfil(@PathVariable Long documento, @ModelAttribute("el_docente") Docente docente,
			Model modelo) {

		Docente docenteExistente = servicio.buscarDocentePorDocumento(documento);
		docenteExistente.setDocumento(docente.getDocumento());
		docenteExistente.setPrimerNombre(docente.getPrimerNombre());
		docenteExistente.setPrimerApellido(docente.getPrimerApellido());
		docenteExistente.setCodigo(docente.getCodigo());
		docenteExistente.setEmail(docente.getEmail());
		servicio.guardarDocente(docenteExistente);
		modelo.addAttribute("el_docente", docenteExistente);
		return "redirect:/docentes";
	}

//	https://github.com/daisy-world/ExcelToDB/blob/master/src/main/java/com/salesxl/ExcelReadService.java
}
