package com.lulocas.GerenciadorEscolar.repository;

import com.lulocas.GerenciadorEscolar.model.Nota;
import com.lulocas.GerenciadorEscolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
}
