package com.lulocas.GerenciadorEscolar.service;

import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.model.Professor;
import com.lulocas.GerenciadorEscolar.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarTodos(){
        return professorRepository.findAll();
    }

    public Professor adicionarProfessor(Professor professor){
        return professorRepository.save(professor);
    }

    public void deletar(UUID id) {
        professorRepository.deleteById(id);
    }

    public Professor atualizar(UUID id, Professor professorAtualizado) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        if (professorAtualizado.getNome() != null) {
            professor.setNome(professorAtualizado.getNome());
        }
        if (professorAtualizado.getCpf() != null) {
            professor.setCpf(professorAtualizado.getCpf());
        }
        if (professorAtualizado.getFormacao() != null) {
            professor.setFormacao(professorAtualizado.getFormacao());
        }
        if(professorAtualizado.getTurma() != null){
            professor.setTurma(professorAtualizado.getTurma());
        }
        if(professorAtualizado.getEmail() != null){
            professor.setEmail(professorAtualizado.getEmail());
        }
        if(professorAtualizado.getSenha() != null){
            professor.setSenha(professorAtualizado.getSenha());
        }
        if(professorAtualizado.getTelefone() != null){
            professor.setTelefone(professorAtualizado.getTelefone());
        }

        return professorRepository.save(professor);
    }

    public Professor atualizarCredenciais(UUID id, Professor professorAtualizada) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setEmail(professorAtualizada.getEmail());
        professor.setSenha(professorAtualizada.getSenha());

        return professorRepository.save(professor);
    }

    public Professor buscarPorId(UUID id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com ID: " + id));
    }


}
