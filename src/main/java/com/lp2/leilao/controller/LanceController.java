package com.lp2.leilao.controller;

import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.model.dto.lance.ExibicaoLanceProdutoDTO;
import com.lp2.leilao.service.LanceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "lance")
@Tag(name = "LANCE")

public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping("gerar-lance/{produtoId}/{clienteCpf}/{valor}/{categoriaProduto}")
    public ExibicaoLanceProdutoDTO gerarLanceProdutoInformatica (@PathVariable Long produtoId,
                                                                 @PathVariable String clienteCpf,
                                                                 @PathVariable Double valor,
                                                                 @PathVariable CategoriaProduto categoriaProduto){
        return lanceService.gerarLanceProduto(produtoId, clienteCpf, valor,categoriaProduto);
    }

    @PostMapping("historico/{produtoId}/{categoriaProduto}")
    public List<ExibicaoLanceProdutoDTO> gerarLanceProdutoInformatica (@PathVariable Long produtoId,
                                                                       @PathVariable CategoriaProduto categoriaProduto){
        return lanceService.historicoLance(produtoId, categoriaProduto);
    }
}
