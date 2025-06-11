package com.lulocas.GerenciadorEscolar.service;

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

    public Coordenacao atualizar(UUID id, Coordenacao coordenacaoAtualizado){
        Coordenacao coordenacao = coordenacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordenacao não encontrado"));
        coordenacao.setNome(coordenacaoAtualizado.getNome());
        coordenacao.setCpf(coordenacaoAtualizado.getCpf());
        coordenacao.setEmail(coordenacaoAtualizado.getEmail());
        coordenacao.setSenha(coordenacaoAtualizado.getSenha());
        coordenacao.setTelefone(coordenacaoAtualizado.getTelefone());

        return coordenacaoRepository.save(coordenacao);
    }

    public Coordenacao atualizarCredenciais(UUID id,  Coordenacao coordenacaoAtualizada) {
        Coordenacao coordenacao = coordenacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordenação não encontrada"));

        coordenacao.setEmail(coordenacaoAtualizada.getEmail());
        coordenacao.setSenha(coordenacaoAtualizada.getSenha());

        return coordenacaoRepository.save(coordenacao);
    }
}
