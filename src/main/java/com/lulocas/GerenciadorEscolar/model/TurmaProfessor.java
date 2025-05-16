package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;

@Entity
public class TurmaProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @Column(name = "materia", length = 100, nullable = false)
    private String materia;
}
