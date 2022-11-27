package com.example.demo.modelo;
import jakarta.persistence.*;

@Entity
@Table(name="Docente", uniqueConstraints = @UniqueConstraint(columnNames = {"email","codigo"}))
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;
}
