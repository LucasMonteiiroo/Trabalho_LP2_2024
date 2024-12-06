package com.lp2.leilao.model.dto.produtoVeiculo;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.veiculo.DispositivoVeiculo;
import com.lp2.leilao.model.enums.TipoProdutoVeiculo;

public record ExibicaoProdutoVeiculoDTO(
        Long id,
        TipoProdutoVeiculo tipoProduto,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Condicao condicao,
        Integer numeroPlaca,
        Double quilometragem,
        Double motor,
        String cor,
        Double precoInicial,
        Long leilaoId
) {


    public ExibicaoProdutoVeiculoDTO(DispositivoVeiculo dispositivoVeiculo) {
        this(dispositivoVeiculo.getId(),
                dispositivoVeiculo.getTipoProduto(),
                dispositivoVeiculo.getMarca(),
                dispositivoVeiculo.getModelo(),
                dispositivoVeiculo.getDescricao(),
                dispositivoVeiculo.getAnoFabricacao(),
                dispositivoVeiculo.getCondicao(),
                dispositivoVeiculo.getNumeroPlaca(),
                dispositivoVeiculo.getQuilometragem(),
                dispositivoVeiculo.getMotor(),
                dispositivoVeiculo.getCor(),
                dispositivoVeiculo.getPrecoInicial(),
                dispositivoVeiculo.getLeilao().getId());
    }

}
