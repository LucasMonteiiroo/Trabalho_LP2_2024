package com.lp2.leilao.model.dto.lance;

import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.model.LanceDispositivoInformatica;
import com.lp2.leilao.model.LanceDispositivoVeiculo;

import java.time.LocalDateTime;

public record ExibicaoLanceProdutoDTO(
        Long id,
        Double valor,
        LocalDateTime data,
        Long idProduto,
        String cpfCliente,
        CategoriaProduto categoriaProduto
) {
    public ExibicaoLanceProdutoDTO(LanceDispositivoInformatica lanceDispositivoInformatica) {
        this(lanceDispositivoInformatica.getId(),
                lanceDispositivoInformatica.getValor(),
                lanceDispositivoInformatica.getData(),
                lanceDispositivoInformatica.getDispositivoInformatica().getId(),
                lanceDispositivoInformatica.getCliente().getCpf(),
                CategoriaProduto.INFORMATICA);

    }
    public ExibicaoLanceProdutoDTO(LanceDispositivoVeiculo lanceDispositivoVeiculo) {
        this(lanceDispositivoVeiculo.getId(),
                lanceDispositivoVeiculo.getValor(),
                lanceDispositivoVeiculo.getData(),
                lanceDispositivoVeiculo.getDispositivoVeiculo().getId(),
                lanceDispositivoVeiculo.getCliente().getCpf(),
                CategoriaProduto.VEICULO);
    }
}
