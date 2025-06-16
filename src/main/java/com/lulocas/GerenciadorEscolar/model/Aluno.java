package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private Integer ano;

    @Column(name="email", length=100)
    private String email;

    @Column(name="senha", length=20)
    private String senha;

    @Column(name="telefone", length=20)
    private String telefone;

    @Column(name="num_faltas")
    private Integer numFaltas;

    @Column(name="turma")
    private String turma;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nota> notas;

    @Deprecated
    public Aluno(){}
}
