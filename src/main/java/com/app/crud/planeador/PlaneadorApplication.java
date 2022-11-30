package com.app.crud.planeador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.crud.planeador.entidad.Docente;
import com.app.crud.planeador.repositorio.DocenteRepositorio;

@SpringBootApplication
public class PlaneadorApplication implements CommandLineRunner {
	
	
	@Autowired
	private DocenteRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		Docente docente1 = new Docente((long) 1093456711, "Rosendo", "Meep", "6669999", "testing@yourlife.org", "superclave1234");
		Docente docente2 = new Docente((long) 1013242311, "Aquiles", "Baesa", "5169229", "weweee@yourlife.org", "superclave456");
		repositorio.save(docente1);
		repositorio.save(docente2);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(PlaneadorApplication.class, args);
	}

}
