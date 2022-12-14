package com.app.crud.planeador.servicio;

import java.util.List;

import com.app.crud.planeador.entidad.Curso;

public interface CursoServicio {

	public List<Curso> listarTodosLosCursos();

	public Curso guardarCurso(Curso curso);

	public Curso buscarCursoPorId(Long id);

	public Curso actualizarCurso(Curso curso);

	public void eliminarCurso(Long id);
}
