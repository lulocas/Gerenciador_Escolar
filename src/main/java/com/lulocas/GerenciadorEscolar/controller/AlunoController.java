package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.dto.AlunoDTO;
import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.model.Coordenacao;
import com.lulocas.GerenciadorEscolar.model.Turma;
import com.lulocas.GerenciadorEscolar.service.AlunoService;
import com.lulocas.GerenciadorEscolar.service.TurmaService;
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
    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setCpf(alunoDTO.getCpf());
        aluno.setAno(alunoDTO.getAno());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setSenha(alunoDTO.getSenha());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setNumFaltas(alunoDTO.getNumFaltas());

        if (alunoDTO.getTurmaId() != null) { // Se o aluno tiver uma turma, ela deve existir
            Turma turma = turmaService.buscarPorId(alunoDTO.getTurmaId());
            aluno.setTurma(turma);
        }

        return ResponseEntity.ok(alunoService.adicionarAluno(aluno));
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
