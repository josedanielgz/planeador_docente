package com.app.crud.planeador.entidad;

import jakarta.persistence.*;

//https://www.baeldung.com/jpa-one-to-one
@Entity
@Table(name = "Administrador")
public class Administrador {
	@Id
	@Column(name = "docente")
	private Long docente;

	public Long getDocente() {
		return docente;
	}

	public void setDocente(Long docente) {
		this.docente = docente;
	}

	public Administrador(Long docente) {
		super();
		this.docente = docente;
	}

	public Administrador() {
		super();
	}
	
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "documento")
//	private Docente padre;
	
	
}
