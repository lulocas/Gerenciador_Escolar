package com.lulocas.GerenciadorEscolar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="nota")
@Getter
@Setter
@ToString
public class Nota {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="materia_nome", length=100, nullable=false)
    private String materia;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private UUID aluno;

    @Column(name="nota1")
    private BigDecimal nota1;

    @Column(name="nota2")
    private BigDecimal nota2;

    @Column(name="nota3")
    private BigDecimal nota3;
}
