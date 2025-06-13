package com.lulocas.GerenciadorEscolar.repository;

import com.lulocas.GerenciadorEscolar.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotaRepository extends JpaRepository<Nota, UUID> {
    List<Nota> findByAlunoId(UUID alunoId);
}
