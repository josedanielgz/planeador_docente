package com.example.demo.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.DocenteDTO;
import com.example.demo.modelo.Docente;

@Repository
public interface DocenteRepositorio extends JpaRepository<Docente, Long> {

	Docente save(DocenteDTO registroDTO);

}
