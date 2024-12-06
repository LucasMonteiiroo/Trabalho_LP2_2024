package com.lp2.leilao.model.dto.leilao;

import com.lp2.leilao.model.LanceDispositivoInformatica;
import com.lp2.leilao.model.dto.cliente.ExibicaoClienteDTO;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;

public record ExibicaoVencedorLeilao(
        Long id,
        TipoProdutoInformatica tipoProduto,

        ExibicaoClienteDTO vencedor


) {


    public ExibicaoVencedorLeilao(LanceDispositivoInformatica lanceGanhador) {
        this(lanceGanhador.getDispositivoInformatica().getId(),
                lanceGanhador.getDispositivoInformatica().getTipoProduto(),
                new ExibicaoClienteDTO(lanceGanhador.getCliente()));
    }
}
