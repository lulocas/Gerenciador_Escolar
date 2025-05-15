package com.lulocas.GerenciadorEscolar.repository;

import com.lulocas.GerenciadorEscolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
}
