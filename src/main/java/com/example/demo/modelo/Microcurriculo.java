package com.example.demo.modelo;
import jakarta.persistence.*;

@Entity
@Table(name="Microcurriculo")
public class Microcurriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    private Materia materia;
}
