package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.model.Turma;
import com.lulocas.GerenciadorEscolar.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/escola/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> listarTodos() {
        return turmaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Turma> adicionarTurma(@RequestBody Turma turma) {
        Turma novaTurma = turmaService.adicionarTurma(turma);
        return ResponseEntity.ok(novaTurma);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable UUID id) {
        turmaService.deletar(id);
        return "Turma deletada";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable UUID id, @RequestBody Turma turmaAtualizada) {
        Turma turma = turmaService.atualizar(id, turmaAtualizada);
        return ResponseEntity.ok(turma);
    }
}
