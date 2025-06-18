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
        return System.currentTimeMillis() % 1000000;
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

        if (alunoAtualizado.getNome() != null) {
            aluno.setNome(alunoAtualizado.getNome());
        }
        if (alunoAtualizado.getAno() != null) {
            aluno.setAno(alunoAtualizado.getAno());
        }
        if (alunoAtualizado.getCpf() != null) {
            aluno.setCpf(alunoAtualizado.getCpf());
        }
        if (alunoAtualizado.getEmail() != null) {
            aluno.setEmail(alunoAtualizado.getEmail());
        }
        if (alunoAtualizado.getSenha() != null) {
            aluno.setSenha(alunoAtualizado.getSenha());
        }
        if (alunoAtualizado.getTelefone() != null) {
            aluno.setTelefone(alunoAtualizado.getTelefone());
        }
        if(alunoAtualizado.getTurma() != null){
            aluno.setTurma(alunoAtualizado.getTurma());
        }
        if(alunoAtualizado.getNumFaltas() != null){
            aluno.setNumFaltas(alunoAtualizado.getNumFaltas());
        }

        return alunoRepository.save(aluno);
    }

    public Aluno atualizarCredenciais(UUID id, Aluno alunoAtualizada) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setEmail(alunoAtualizada.getEmail());
        aluno.setSenha(alunoAtualizada.getSenha());

        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(UUID id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + id));
    }


}
