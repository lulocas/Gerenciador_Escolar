package com.lulocas.GerenciadorEscolar.service;

import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Long gerarMatricula() {
        return System.currentTimeMillis();
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno adicionarAluno(Aluno aluno) {
        aluno.setMatricula(gerarMatricula());
        return alunoRepository.save(aluno);
    }

    public void deletar(UUID id) {
        alunoRepository.deleteById(id);
    }

    public Aluno atualizar(UUID id, Aluno alunoAtualizado) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setDataNascimento(alunoAtualizado.getDataNascimento());
        aluno.setAno(alunoAtualizado.getAno());

        return alunoRepository.save(aluno);
    }
}
