package com.app.crud.planeador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.crud.planeador.entidad.Docente;

@Repository
public interface DocenteRepositorio extends JpaRepository<Docente, Long> {
	
}                                             