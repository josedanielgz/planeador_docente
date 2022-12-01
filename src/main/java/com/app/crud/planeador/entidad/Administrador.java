package com.app.crud.planeador.entidad;

import jakarta.persistence.*;

//https://www.baeldung.com/jpa-one-to-one
@Entity
@Table(name = "Administrador")
public class Administrador {
	@Id
	@Column(name = "docente")
	private Long docente;
	
    @OneToOne
    @MapsId
    @JoinColumn(name = "documento")
	private Docente padre;
}
