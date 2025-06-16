package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/escola/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Aluno> adicionar(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.adicionarAluno(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    @DeleteMapping("/{id}")
    public String deletarAluno(@PathVariable UUID id) {
        alunoService.deletar(id);
        return "Aluno deletado";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable UUID id, @RequestBody Aluno alunoAtualizado) {
        Aluno aluno = alunoService.atualizar(id, alunoAtualizado);
        return ResponseEntity.ok(aluno);
    }

    @PutMapping("/{id}/credenciais")
    public ResponseEntity<Aluno> atualizarCredenciais(@PathVariable UUID id, @RequestBody Aluno alunoAtualizada) {
        Aluno aluno = alunoService.atualizarCredenciais(id, alunoAtualizada);
        return ResponseEntity.ok(aluno);
    }

}
