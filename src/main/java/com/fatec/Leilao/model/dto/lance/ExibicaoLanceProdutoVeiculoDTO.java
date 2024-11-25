package com.lp2.leilao.model.dto.lance;

import com.lp2.leilao.model.LanceDispositivoVeiculo;

import java.time.LocalDateTime;

public record ExibicaoLanceProdutoVeiculoDTO(
        Long id,
        Double valor,
        LocalDateTime data,
        Long idProduto,
        String cpfCliente
) {
    public ExibicaoLanceProdutoVeiculoDTO(LanceDispositivoVeiculo lanceDispositivoVeiculo) {
        this(lanceDispositivoVeiculo.getId(),
                lanceDispositivoVeiculo.getValor(),
                lanceDispositivoVeiculo.getData(),
                lanceDispositivoVeiculo.getDispositivoVeiculo().getId(),
                lanceDispositivoVeiculo.getCliente().getCpf());
    }
}
