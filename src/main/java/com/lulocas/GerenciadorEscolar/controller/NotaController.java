package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.dto.NotaDTO;
import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.model.Nota;
import com.lulocas.GerenciadorEscolar.service.AlunoService;
import com.lulocas.GerenciadorEscolar.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private AlunoService alunoService;  // Precisamos buscar o aluno antes de atualizar

    @GetMapping("/{alunoId}")
    public ResponseEntity<List<Nota>> listarNotas(@PathVariable UUID alunoId) {
        return ResponseEntity.ok(notaService.listarNotasPorAluno(alunoId));
    }

    @PostMapping
    public ResponseEntity<Nota> adicionarNota(@RequestBody NotaDTO notaDTO) {
        Aluno aluno = alunoService.buscarPorId(notaDTO.getAlunoId());
        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado com ID: " + notaDTO.getAlunoId());
        }

        Nota nota = new Nota();
        nota.setAluno(aluno);
        nota.setMateria(notaDTO.getMateria());
        nota.setNota1(notaDTO.getNota1());
        nota.setNota2(notaDTO.getNota2());
        nota.setNota3(notaDTO.getNota3());

        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.salvarNota(nota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> atualizarNota(@PathVariable UUID id, @RequestBody NotaDTO notaDTO) {
        Nota notaExistente = notaService.buscarPorId(id);
        if (notaExistente == null) {
            throw new RuntimeException("Nota não encontrada com ID: " + id);
        }

        Aluno aluno = alunoService.buscarPorId(notaDTO.getAlunoId());
        if (aluno == null) {
            throw new RuntimeException("Aluno não encontrado com ID: " + notaDTO.getAlunoId());
        }

        notaExistente.setAluno(aluno);
        notaExistente.setMateria(notaDTO.getMateria());
        notaExistente.setNota1(notaDTO.getNota1());
        notaExistente.setNota2(notaDTO.getNota2());
        notaExistente.setNota3(notaDTO.getNota3());

        return ResponseEntity.ok(notaService.atualizarNota(id, notaExistente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNota(@PathVariable UUID id) {
        notaService.deletarNota(id);
        return ResponseEntity.noContent().build();
    }
}
