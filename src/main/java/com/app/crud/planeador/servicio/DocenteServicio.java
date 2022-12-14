package com.app.crud.planeador.servicio;

import java.util.List;

import com.app.crud.planeador.entidad.Docente;

public interface DocenteServicio {

	public List<Docente> listarTodosLosDocentes();

	public Docente guardarDocente(Docente docente);

	public Docente buscarDocentePorDocumento(Long id);

	public Docente actualizarDocente(Docente docente);

	public void eliminarDocente(Long id);
}
