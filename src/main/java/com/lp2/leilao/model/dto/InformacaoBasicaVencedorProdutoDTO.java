package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.informatica.DispositivoInformatica;
import com.lp2.leilao.model.veiculo.DispositivoVeiculo;
import com.lp2.leilao.model.dto.leilao.GanhadorLeilaoDTO;

public record InformacaoBasicaVencedorProdutoDTO(
        Long produtoId,
        String tipoProduto,
        String descricao,

        GanhadorLeilaoDTO ganhador

) {


    public InformacaoBasicaVencedorProdutoDTO(DispositivoInformatica dispositivoInformatica, GanhadorLeilaoDTO ganhador) {
        this(dispositivoInformatica.getId(),
                dispositivoInformatica.getTipoProduto().toString(),
                dispositivoInformatica.getDescricao(),
                ganhador);
    }

    public InformacaoBasicaVencedorProdutoDTO(DispositivoVeiculo dispositivoVeiculo, GanhadorLeilaoDTO ganhador) {
        this(dispositivoVeiculo.getId(),
                dispositivoVeiculo.getTipoProduto().toString(),
                dispositivoVeiculo.getDescricao(),
                ganhador);
    }
}
