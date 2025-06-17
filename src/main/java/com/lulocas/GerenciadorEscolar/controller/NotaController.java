package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.model.Nota;
import com.lulocas.GerenciadorEscolar.repository.NotaRepository;
import com.lulocas.GerenciadorEscolar.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/escola/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;
    @Autowired
    private NotaRepository notaRepository;

    @GetMapping
    public List<Nota> listarTodos() {
        return notaService.listarTodos();
    }

    @GetMapping("/{alunoId}")
    public List<Nota> getNotasPorAluno(@PathVariable String alunoId) {
        return notaRepository.findByAlunoId(alunoId);
    }

    @PostMapping
    public ResponseEntity<Nota> adicionar(@RequestBody Nota nota) {
        Nota novaNota = notaService.salvarNota(nota);
        return ResponseEntity.ok(novaNota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> atualizar(@PathVariable UUID id, @RequestBody Nota notaAtualizada) {
        Nota nota = notaService.atualizarNota(id, notaAtualizada);
        return ResponseEntity.ok(nota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNota(@PathVariable UUID id) {
        notaService.deletarNota(id);
        return ResponseEntity.noContent().build();
    }
}
