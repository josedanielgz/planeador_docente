package com.app.crud.planeador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.crud.planeador.entidad.Administrador;
import com.app.crud.planeador.entidad.Curso;
import com.app.crud.planeador.entidad.Docente;
import com.app.crud.planeador.repositorio.AdministradorRepositorio;
import com.app.crud.planeador.repositorio.CursoRepositorio;
import com.app.crud.planeador.repositorio.DocenteRepositorio;

@SpringBootApplication
public class PlaneadorApplication implements CommandLineRunner {
	
	
	@Autowired
	private DocenteRepositorio repositorio;
	@Autowired
	private CursoRepositorio cursos;
	@Autowired
	private AdministradorRepositorio admins;

	@Override
	public void run(String... args) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Docente docente1 = new Docente((long) 1093456711, "Antion", "Puerto", "1234524", "testing@ufps.edu.co", passwordEncoder.encode("123456789"));
		Docente docente2 = new Docente((long) 1013242311, "Aquiles", "Baesa", "5169229", "otrocorrep@ufps.edu.co", passwordEncoder.encode("superclave456"));
		Administrador a = new Administrador(docente1.getDocumento());
		Curso nuevoCurso = new Curso("Ingeniería de Software", 4, 24, 12, "Ingeniería de Sistemas");
		repositorio.save(docente1);
		repositorio.save(docente2);
		admins.save(a);
		cursos.save(nuevoCurso);
	}

	public static void main(String[] args) {
		SpringApplication.run(PlaneadorApplication.class, args);
	}

}
