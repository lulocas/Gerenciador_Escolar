package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="professor")
@Getter
@Setter
@ToString
public class Professor {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="nome", length=100, nullable=false)
    private String nome;

    @Column(name="cpf", length=14, nullable=false)
    private String cpf;

    @Column(name="materia", length=100, nullable=false)
    private String materia;

    @Column(name="data_nascimento", nullable=false)
    private LocalDate dataNascimento;

    @Column(name="formacao", length=150, nullable=false)
    private String formacao;

    @Column(name="experiencia", nullable=true)
    private int anosExperiencia;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;

}
