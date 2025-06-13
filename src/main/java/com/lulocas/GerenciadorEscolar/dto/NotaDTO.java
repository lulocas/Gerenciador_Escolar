package com.lulocas.GerenciadorEscolar.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class NotaDTO {
    private UUID alunoId;
    private String materia;
    private BigDecimal nota1;
    private BigDecimal nota2;
    private BigDecimal nota3;

}

