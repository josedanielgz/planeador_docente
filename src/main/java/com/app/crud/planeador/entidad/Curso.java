package com.app.crud.planeador.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "nroCreditos")
	private Integer nroCreditos;
	@Column(name = "horasIndependientes")
	private Integer horasIndependientes;
	@Column(name = "horasDirectas")
	private Integer horasDirectas;
	@Column(name = "programa")
	private String programa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroCreditos() {
		return nroCreditos;
	}

	public void setNroCreditos(Integer nroCreditos) {
		this.nroCreditos = nroCreditos;
	}

	public Integer getHorasIndependientes() {
		return horasIndependientes;
	}

	public void setHorasIndependientes(Integer horasIndependientes) {
		this.horasIndependientes = horasIndependientes;
	}

	public Integer getHorasDirectas() {
		return horasDirectas;
	}

	public void setHorasDirectas(Integer horasDirectas) {
		this.horasDirectas = horasDirectas;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public Curso(String nombre, Integer nroCreditos, Integer horasIndependientes, Integer horasDirectas,
			String programa) {
		super();
		this.nombre = nombre;
		this.nroCreditos = nroCreditos;
		this.horasIndependientes = horasIndependientes;
		this.horasDirectas = horasDirectas;
		this.programa = programa;
	}

	public Curso() {
		super();
	}

}
