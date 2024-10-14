package com.fatec.Leilao.service;

import com.fatec.Leilao.model.instituicaoFinanceira.dto.CriacaoInstituicaoDTO;
import com.fatec.Leilao.model.instituicaoFinanceira.dto.ExibicaoInstituicaoFinanceiraDTO;
import com.fatec.Leilao.model.instituicaoFinanceira.InstituicaoFinanceira;
import com.fatec.Leilao.model.leilao.Leilao;
import com.fatec.Leilao.repository.InstituicaoFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<String> deletarinstituicaoPorId(Long id) {
        Optional<InstituicaoFinanceira> instituicaoFinanceira = instituicaoFinanceiraRepository.findById(id);
        if(instituicaoFinanceira.isPresent()){
            for(Leilao leilao: instituicaoFinanceira.get().getLeilao()){
                if(leilao.getInstituicaoFinanceira().size()==1){
                    throw new RuntimeException("O leilão com ID " + leilao.getInstituicaoFinanceira() + " está vinculado a apenas uma instituição financeira!");
                }
            }
            instituicaoFinanceiraRepository.deleteById(id);
        } else {
            throw new RuntimeException("Instituição inexistente!");
        }
        if (instituicaoFinanceiraRepository.findById(id).isEmpty()){
            return ResponseEntity.ok().body("Instituição financeira deletada com sucesso!");
        } else {
            throw new RuntimeException("Erro ao deletar instituição financeira!");
        }
    }
}
