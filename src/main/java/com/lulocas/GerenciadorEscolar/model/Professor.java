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

    @Column(name="formacao", length=150, nullable=false)
    private String formacao;

    @Column(name="email", length=100, nullable=false)
    private String email;

    @Column(name="senha", length=20)
    private String senha;

    @Column(name="telefone", length=20)
    private String telefone;

    @OneToOne
    @JoinColumn(name="turma_id", nullable=false)
    private Turma turma;

}
