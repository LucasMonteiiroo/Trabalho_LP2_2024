package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.informatica.DispositivoInformatica;
import com.lp2.leilao.model.veiculo.DispositivoVeiculo;

public record InformacaoBasicaProdutoDTO(
        Long produtoId,
        String tipoProduto,
        String descricao
) {


    public InformacaoBasicaProdutoDTO(DispositivoInformatica dispositivoInformatica) {
        this(dispositivoInformatica.getId(),
                dispositivoInformatica.getTipoProduto().toString(),
                dispositivoInformatica.getDescricao());
    }

    public InformacaoBasicaProdutoDTO(DispositivoVeiculo dispositivoVeiculo) {
        this(dispositivoVeiculo.getId(),
                dispositivoVeiculo.getTipoProduto().toString(),
                dispositivoVeiculo.getDescricao());
    }
}
