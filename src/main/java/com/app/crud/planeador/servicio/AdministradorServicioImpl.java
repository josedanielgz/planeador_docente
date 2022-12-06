package com.app.crud.planeador.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.crud.planeador.entidad.Administrador;
import com.app.crud.planeador.repositorio.AdministradorRepositorio;
@Service
public class AdministradorServicioImpl implements AdministradorServicio {

	@Autowired
	private AdministradorRepositorio repositorio;

	public List<Administrador> listarAdministradores() {
		return repositorio.findAll();
	}

	@Override
	public Administrador guardarAdministrador(Administrador Administrador) {
		return repositorio.save(Administrador);
	}

	@Override
	public Administrador buscarAdministradorPorDocumento(Long id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Administrador actualizarAdministrador(Administrador Administrador) {
		// TODO Auto-generated method stub
		return repositorio.save(Administrador);
	}

	@Override
	public void eliminarAdministrador(Long id) {
		repositorio.deleteById(id);
	};

//	@Override
//	public Administrador buscarDocentePorEmail(String email) {
//		return null;
//	};
}
