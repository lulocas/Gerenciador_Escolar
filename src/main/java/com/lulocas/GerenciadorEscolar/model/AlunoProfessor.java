package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;

@Entity
public class AlunoProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @Column(name = "materia", length = 100, nullable = false)
    private String materia;
}
