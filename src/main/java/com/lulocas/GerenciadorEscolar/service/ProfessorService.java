package com.lulocas.GerenciadorEscolar.service;

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

    public Professor atualizar(UUID id, Professor professorAtualizado){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        professor.setNome(professorAtualizado.getNome());
        professor.setCpf(professorAtualizado.getCpf());
        professor.setFormacao(professorAtualizado.getFormacao());
        professor.setMateria(professorAtualizado.getMateria());
        professor.setDataNascimento(professorAtualizado.getDataNascimento());

        return professorRepository.save(professor);
    }
}
