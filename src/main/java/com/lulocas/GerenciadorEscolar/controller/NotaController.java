package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.model.Nota;
import com.lulocas.GerenciadorEscolar.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @GetMapping("/{alunoId}")
    public ResponseEntity<List<Nota>> listarNotas(@PathVariable UUID alunoId) {
        return ResponseEntity.ok(notaService.listarNotasPorAluno(alunoId));
    }

    @PostMapping
    public ResponseEntity<Nota> adicionarNota(@RequestBody Nota nota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.salvarNota(nota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> atualizarNota(@PathVariable UUID id, @RequestBody Nota notaAtualizada) {
        return ResponseEntity.ok(notaService.atualizarNota(id, notaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNota(@PathVariable UUID id) {
        notaService.deletarNota(id);
        return ResponseEntity.noContent().build();
    }
}
