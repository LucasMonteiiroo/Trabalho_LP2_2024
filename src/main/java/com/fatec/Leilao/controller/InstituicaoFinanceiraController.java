package com.fatec.Leilao.controller;

import com.fatec.Leilao.model.instituicaoFinanceira.dto.CriacaoInstituicaoDTO;
import com.fatec.Leilao.model.instituicaoFinanceira.dto.ExibicaoInstituicaoFinanceiraDTO;
import com.fatec.Leilao.service.InstituicaoFinanceiraService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instituicao-financeira")
@Tag(name = "INSTITUICAO-FINANCEIRA")
public class InstituicaoFinanceiraController {

    @Autowired
    private InstituicaoFinanceiraService instituicaoFinanceiraService;


    @PostMapping("criar")
    public ExibicaoInstituicaoFinanceiraDTO criarInstituicaoFinanceira(@RequestBody CriacaoInstituicaoDTO criacaoInstituicaoDTO){
        return instituicaoFinanceiraService.criarInstituicaoFinanceira(criacaoInstituicaoDTO);
    }

    @GetMapping("listar")
    public List<ExibicaoInstituicaoFinanceiraDTO> listarInstituicoesFinanceiras(){
        return instituicaoFinanceiraService.listarInstituicoesFinanceiras();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarinstituicaoPorId(@PathVariable Long id){
        return instituicaoFinanceiraService.deletarinstituicaoPorId(id);
    }
}
