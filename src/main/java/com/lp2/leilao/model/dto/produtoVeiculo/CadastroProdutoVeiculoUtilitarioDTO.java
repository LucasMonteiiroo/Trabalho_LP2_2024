package com.lp2.leilao.model.dto.produtoVeiculo;

import com.lp2.leilao.model.enums.Condicao;

public record CadastroProdutoVeiculoUtilitarioDTO(


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

        Integer capacidadePessoa
) {




}
