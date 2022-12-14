package com.app.crud.planeador.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.planeador.entidad.Curso;
import com.app.crud.planeador.repositorio.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio {
	
	@Autowired
	public CursoRepositorio repositorio;

	@Override
	public List<Curso> listarTodosLosCursos() {
		return repositorio.findAll();
	}

	@Override
	public Curso guardarCurso(Curso curso) {
		return repositorio.save(curso);
	}

	@Override
	public Curso buscarCursoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Curso actualizarCurso(Curso curso) {
		return repositorio.save(curso);
	}

	@Override
	public void eliminarCurso(Long id) {
		repositorio.deleteById(id);
	}

}
