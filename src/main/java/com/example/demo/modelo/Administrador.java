package com.example.demo.modelo;
import jakarta.persistence.*;

@Entity
@Table(name="Administrador")
public class Administrador {
    @Id
    @Column(name="docente",length=10)
    private String docente;
}
