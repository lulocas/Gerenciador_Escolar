package com.lulocas.GerenciadorEscolar.repository;

import com.lulocas.GerenciadorEscolar.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TurmaRepository extends JpaRepository<Turma, UUID> {
}
