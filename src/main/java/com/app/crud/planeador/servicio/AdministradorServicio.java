package com.app.crud.planeador.servicio;

import java.util.List;

import com.app.crud.planeador.entidad.Administrador;

public interface AdministradorServicio {

	public List<Administrador> listarAdministradores();

	public Administrador guardarAdministrador(Administrador Administrador);

	public Administrador buscarAdministradorPorDocumento(Long id);

	public Administrador actualizarAdministrador(Administrador Administrador);

	public void eliminarAdministrador(Long id);

}
