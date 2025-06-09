package com.lulocas.GerenciadorEscolar.repository;

import com.lulocas.GerenciadorEscolar.model.Coordenacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoordenacaoRepository extends JpaRepository<Coordenacao, UUID> {
}
