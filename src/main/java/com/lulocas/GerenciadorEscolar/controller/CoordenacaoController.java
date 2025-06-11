package com.lulocas.GerenciadorEscolar.controller;

import com.lulocas.GerenciadorEscolar.model.Coordenacao;
import com.lulocas.GerenciadorEscolar.service.CoordenacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/escola/coordenacao")
public class CoordenacaoController {
    @Autowired
    private CoordenacaoService coordenacaoService;

    @GetMapping
    public List<Coordenacao> listarTodos() {
        return coordenacaoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Coordenacao> adicionarCoordenacao(@RequestBody Coordenacao coordenacao) {
        Coordenacao novaCoordenacao = coordenacaoService.adicionarCoordenacao(coordenacao);
        return ResponseEntity.ok(novaCoordenacao);
    }

    @DeleteMapping("/{id}")
    public String deletarCoordenacao(@PathVariable UUID id) {
        coordenacaoService.deletar(id);
        return "Coordenacao deletada";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordenacao> atualizarCoordenacao(@PathVariable UUID id, @RequestBody Coordenacao coordenacaoAtualizada) {
        Coordenacao coordenacao = coordenacaoService.atualizar(id, coordenacaoAtualizada);
        return ResponseEntity.ok(coordenacao);
    }

    @PutMapping("/{id}/credenciais")
    public ResponseEntity<Coordenacao> atualizarCredenciais(@PathVariable UUID id,
                                                            @RequestBody Coordenacao coordenacaoAtualizada) {
        Coordenacao coordenacao = coordenacaoService.atualizarCredenciais(id,  coordenacaoAtualizada);
        return ResponseEntity.ok(coordenacaoAtualizada);
    }
}
