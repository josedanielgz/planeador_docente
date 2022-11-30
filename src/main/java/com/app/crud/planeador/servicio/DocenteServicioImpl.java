package com.app.crud.planeador.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.planeador.entidad.Docente;
import com.app.crud.planeador.repositorio.DocenteRepositorio;

@Service
public class DocenteServicioImpl implements DocenteServicio{

	@Autowired
	private DocenteRepositorio repositorio;
	
	public List<Docente> listarTodosLosDocentes(){
		return repositorio.findAll();
	}

	@Override
	public Docente guardarDocente(Docente docente) {
		return repositorio.save(docente);
	}

	@Override
	public Docente buscarDocentePorDocumento(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Docente actualizarEstudiante(Docente docente) {
		// TODO Auto-generated method stub
		return repositorio.save(docente);
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repositorio.deleteById(id);
	};
}
