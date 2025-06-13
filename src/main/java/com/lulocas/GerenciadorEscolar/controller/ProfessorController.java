package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.model.Coordenacao;
import com.lulocas.GerenciadorEscolar.model.Professor;
import com.lulocas.GerenciadorEscolar.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/escola/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listarTodos(){
        return professorService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Professor> adicionarProfessor(@RequestBody Professor professor){
        Professor novoProfessor = professorService.adicionarProfessor(professor);
        return ResponseEntity.ok(novoProfessor);
    }

    @DeleteMapping("/{id}")
    public String deletarProfessor(@PathVariable UUID id){
        professorService.deletar(id);
        return "Professor deletado";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable UUID id, @RequestBody Professor professorAtualizado){
        Professor professor = professorService.atualizar(id, professorAtualizado);
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/{id}/credenciais")
    public ResponseEntity<Professor> atualizarCredenciais(@PathVariable UUID id,
                                                            @RequestBody Professor professorAtualizada) {
        Professor professor = professorService.atualizarCredenciais(id,  professorAtualizada);
        return ResponseEntity.ok(professorAtualizada);
    }
}
