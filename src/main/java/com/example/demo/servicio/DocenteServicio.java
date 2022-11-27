package com.example.demo.servicio;

import com.example.demo.dto.DocenteDTO;
import com.example.demo.modelo.Docente;

public interface DocenteServicio {

	public Docente guardar (DocenteDTO registroDTO);
}
