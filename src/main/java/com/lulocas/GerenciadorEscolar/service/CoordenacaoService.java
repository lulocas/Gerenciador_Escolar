package com.lulocas.GerenciadorEscolar.service;

import com.lulocas.GerenciadorEscolar.model.Aluno;
import com.lulocas.GerenciadorEscolar.model.Coordenacao;
import com.lulocas.GerenciadorEscolar.repository.CoordenacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CoordenacaoService {
    @Autowired
    private CoordenacaoRepository coordenacaoRepository;

    public List<Coordenacao> listarTodos(){
        return coordenacaoRepository.findAll();
    }

    public Coordenacao adicionarCoordenacao(Coordenacao coordenacao){
        return coordenacaoRepository.save(coordenacao);
    }

    public void deletar(UUID id) {
        coordenacaoRepository.deleteById(id);
    }

    public Coordenacao atualizar(UUID id, Coordenacao coordenacaoAtualizado) {
        Coordenacao coordenacao = coordenacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordenacao não encontrado"));

        if (coordenacaoAtualizado.getNome() != null) {
            coordenacao.setNome(coordenacaoAtualizado.getNome());
        }
        if (coordenacaoAtualizado.getCpf() != null) {
            coordenacao.setCpf(coordenacaoAtualizado.getCpf());
        }
        if (coordenacaoAtualizado.getEmail() != null) {
            coordenacao.setEmail(coordenacaoAtualizado.getEmail());
        }
        if (coordenacaoAtualizado.getSenha() != null) {
            coordenacao.setSenha(coordenacaoAtualizado.getSenha());
        }
        if (coordenacaoAtualizado.getTelefone() != null) {
            coordenacao.setTelefone(coordenacaoAtualizado.getTelefone());
        }
        if (coordenacaoAtualizado.getFormacao() != null) {
            coordenacao.setFormacao(coordenacaoAtualizado.getFormacao());
        }

        return coordenacaoRepository.save(coordenacao);
    }


    public Coordenacao atualizarCredenciais(UUID id,  Coordenacao coordenacaoAtualizada) {
        Coordenacao coordenacao = coordenacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordenação não encontrada"));

        coordenacao.setEmail(coordenacaoAtualizada.getEmail());
        coordenacao.setSenha(coordenacaoAtualizada.getSenha());

        return coordenacaoRepository.save(coordenacao);
    }

    public Coordenacao buscarPorId(UUID id) {
        return coordenacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordenacao não encontrado com ID: " + id));
    }
}
