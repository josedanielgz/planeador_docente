package com.example.demo.servicio;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DocenteDTO;
import com.example.demo.modelo.Docente;
import com.example.demo.repositorio.DocenteRepositorio;

@Service
public class DocenteServicioImpl implements DocenteServicio {

	private DocenteRepositorio docenteRepositorio;

	public DocenteServicioImpl(DocenteRepositorio docenteRepositorio) {
		super();
		this.docenteRepositorio = docenteRepositorio;
	}

	@Override
	public Docente guardar(DocenteDTO registroDTO) {
		Docente docente = new Docente(registroDTO.getDocumento(), registroDTO.getPrimerNombre(),
				registroDTO.getPrimerApellido(), registroDTO.getCodigo(), registroDTO.getEmail(),
				registroDTO.getClave());
		return this.docenteRepositorio.save(registroDTO);
	}

}
