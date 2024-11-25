package com.lp2.leilao.model.dto.lance;

import com.lp2.leilao.model.LanceDispositivoInformatica;
import com.lp2.leilao.model.LanceDispositivoVeiculo;
import com.lp2.leilao.util.FormatadorData;

public record LanceGanhadorDTO(
        Long id,
        Double valor,
        String data
) {
    public LanceGanhadorDTO(LanceDispositivoInformatica lanceDispositivoInformatica) {
        this(lanceDispositivoInformatica.getId(),
                lanceDispositivoInformatica.getValor(),
                FormatadorData.formatarData(lanceDispositivoInformatica.getData()));

    }
    public LanceGanhadorDTO(LanceDispositivoVeiculo lanceDispositivoVeiculo) {
        this(lanceDispositivoVeiculo.getId(),
                lanceDispositivoVeiculo.getValor(),
                FormatadorData.formatarData(lanceDispositivoVeiculo.getData()));
    }
}
