package com.lulocas.GerenciadorEscolar.service;

import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.model.Nota;
import com.lulocas.GerenciadorEscolar.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotaService {
    @Autowired
    private NotaRepository notaRepository;
    @Autowired
    private AlunoService alunoService;

    public List<Nota> listarNotasPorAluno(UUID alunoId) {
        return notaRepository.findByAlunoId(alunoId);
    }

    public Nota salvarNota(Nota nota) {
        if (nota.getAluno() == null || nota.getAluno().getId() == null) {
            throw new RuntimeException("Aluno deve ser especificado para salvar a nota.");
        }

        Aluno aluno = alunoService.buscarPorId(nota.getAluno().getId());
        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado com ID: " + nota.getAluno().getId());
        }

        nota.setAluno(aluno); // Garante que a nota está vinculada a um aluno existente
        return notaRepository.save(nota);
    }

    public Nota atualizarNota(UUID id, Nota notaAtualizada) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));

        // Validação do aluno antes de atualizar a nota
        if (notaAtualizada.getAluno() == null || notaAtualizada.getAluno().getId() == null) {
            throw new RuntimeException("Aluno deve ser especificado para atualizar a nota.");
        }

        Aluno aluno = alunoService.buscarPorId(notaAtualizada.getAluno().getId());
        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado com ID: " + notaAtualizada.getAluno().getId());
        }

        nota.setAluno(aluno);
        if (notaAtualizada.getMateria() != null) {
            nota.setMateria(notaAtualizada.getMateria());
        }
        if (notaAtualizada.getNota1() != null) {
            nota.setNota1(notaAtualizada.getNota1());
        }
        if (notaAtualizada.getNota2() != null) {
            nota.setNota2(notaAtualizada.getNota2());
        }
        if (notaAtualizada.getNota3() != null) {
            nota.setNota3(notaAtualizada.getNota3());
        }

        return notaRepository.save(nota);
    }

    public void deletarNota(UUID id) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));
        notaRepository.delete(nota);
    }

    public Nota buscarPorId(UUID id) {
        return notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada com ID: " + id));
    }
}
