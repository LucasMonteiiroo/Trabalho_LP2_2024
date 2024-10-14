package com.fatec.Leilao.service;

import com.fatec.Leilao.model.instituicaoFinanceira.InstituicaoFinanceira;
import com.fatec.Leilao.model.leilao.Leilao;
import com.fatec.Leilao.model.leilao.dto.CriacaoLeilaoDTO;
import com.fatec.Leilao.model.leilao.dto.ExibicaoLeilaoDTO;
import com.fatec.Leilao.repository.InstituicaoFinanceiraRepository;
import com.fatec.Leilao.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

    public ExibicaoLeilaoDTO criarLeilao(CriacaoLeilaoDTO criacaoLeilaoDTO) {
        InstituicaoFinanceira instituicaoFinanceira = instituicaoFinanceiraRepository.findById(criacaoLeilaoDTO.instituicaoFinanceira())
                .orElseThrow(() -> new RuntimeException("Instituição financeira não encontrada!"));
        Leilao leilao = new Leilao(criacaoLeilaoDTO, instituicaoFinanceira);
        leilaoRepository.save(leilao);
        return new ExibicaoLeilaoDTO(leilao);
    }

    public List<ExibicaoLeilaoDTO> listarLeiloes() {
        return leilaoRepository.findAll().stream().map(ExibicaoLeilaoDTO::new).toList();
    }

    public ResponseEntity<String> deletarLeilaoPorId(Long id) {
        if (leilaoRepository.findById(id).isPresent()) {
            leilaoRepository.deleteById(id);
        } else {
            return ResponseEntity.ok().body("Leilão inexistente!");
        }
        if (leilaoRepository.findById(id).isEmpty()) {
            return ResponseEntity.ok().body("Leilão deletado com sucesso!");
        } else {
            return ResponseEntity.ok().body("Erro ao deletar leilão!");
        }
    }
}