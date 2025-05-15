package com.lulocas.GerenciadorEscolar.repository;

import com.lulocas.GerenciadorEscolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}
