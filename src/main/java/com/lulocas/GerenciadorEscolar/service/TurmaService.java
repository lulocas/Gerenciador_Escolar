package com.lulocas.GerenciadorEscolar.service;

import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.model.Turma;
import com.lulocas.GerenciadorEscolar.repository.AlunoRepository;
import com.lulocas.GerenciadorEscolar.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> listarTodos() {
        return turmaRepository.findAll();
    }

    public Turma adicionarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deletar(UUID id) {
        turmaRepository.deleteById(id);
    }

    public Turma atualizar(UUID id, Turma turmaAtualizado) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        turma.setNomeTurma(turmaAtualizado.getNomeTurma());
        turma.setSerie(turmaAtualizado.getSerie());

        return turmaRepository.save(turma);
    }
}
