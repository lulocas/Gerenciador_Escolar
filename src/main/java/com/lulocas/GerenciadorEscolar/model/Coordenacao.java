package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name="coordenacao")
@Getter
@Setter
@ToString
public class Coordenacao {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="nome", length=100, nullable=false)
    private String nome;

    @Column(name="cpf", length=14, nullable=false)
    private String cpf;

    @Column(name="email", length=100)
    private String email;

    @Column(name="formacao", length=150)
    private String formacao;

    @Column(name="senha", length=20)
    private String senha;

    @Column(name="telefone", length=20)
    private String telefone;
}
