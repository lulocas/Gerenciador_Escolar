package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="aluno")
@Getter
@Setter
@ToString
public class Aluno {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="matricula", length=100, nullable=false, unique=true)
    private Long matricula;

    @Column(name="nome", length=100, nullable=false)
    private String nome;

    @Column(name="cpf", length=14, nullable=false)
    private String cpf;

    @Column(name="ano_escola", nullable=false)
    private int ano;

    @Column(name="data_nascimento", nullable=false)
    private LocalDate dataNascimento;

    @Column(name="email", length=100, nullable=false)
    private String email;

    @ManyToOne
    @JoinColumn(name="turma_id", nullable=false)
    private Turma turma;


    @Deprecated
    public Aluno(){}
}
