package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="turma")
@Getter
@Setter
@ToString
public class Turma {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="nome_turma", length=100, nullable=false)
    private String nomeTurma;

    @Column(name="serie", nullable=false)
    private int serie;

    @OneToOne(mappedBy="turma")
    private Professor professor;

    @OneToMany(mappedBy="turma")
    private List<Aluno> alunos;
}
