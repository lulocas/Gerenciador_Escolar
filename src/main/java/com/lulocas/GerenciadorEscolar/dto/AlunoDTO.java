package com.lulocas.GerenciadorEscolar.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AlunoDTO {
    private String nome;
    private String cpf;
    private Integer ano;
    private String email;
    private String senha;
    private String telefone;
    private Integer numFaltas;
    private UUID turmaId;
}
