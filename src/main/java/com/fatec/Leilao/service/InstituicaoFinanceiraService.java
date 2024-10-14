package com.fatec.Leilao.service;

import com.fatec.Leilao.model.instituicaoFinanceira.CriacaoInstituicaoDTO;
import com.fatec.Leilao.model.instituicaoFinanceira.ExibicaoInstituicaoFinanceiraDTO;
import com.fatec.Leilao.model.instituicaoFinanceira.InstituicaoFinanceira;
import com.fatec.Leilao.repository.InstituicaoFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituicaoFinanceiraService {

    @Autowired
    private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

    public ExibicaoInstituicaoFinanceiraDTO criarInstituicaoFinanceira(CriacaoInstituicaoDTO criacaoInstituicaoDTO) {
        InstituicaoFinanceira instituicaoFinanceira = instituicaoFinanceiraRepository.save(new InstituicaoFinanceira(criacaoInstituicaoDTO));
        return new ExibicaoInstituicaoFinanceiraDTO(instituicaoFinanceira);
    }

    public List<ExibicaoInstituicaoFinanceiraDTO> listarInstituicoesFinanceiras() {
        return instituicaoFinanceiraRepository.findAll().stream().map(instituicaoFinanceira -> new ExibicaoInstituicaoFinanceiraDTO(instituicaoFinanceira)).toList();
    }
}
