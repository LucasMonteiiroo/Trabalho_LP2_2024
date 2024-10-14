package com.fatec.Leilao.model.leilao.dto;


import com.fatec.Leilao.model.leilao.Leilao;
import com.fatec.Leilao.model.leilao.enums.StatusLeilao;

import java.time.LocalDateTime;

public record ExibicaoLeilaoDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataAbertura,
        StatusLeilao status
) {
    public ExibicaoLeilaoDTO(Leilao leilao) {
        this(leilao.getIdLeilao(),
                leilao.getNome(),
                leilao.getDescricao(),
                leilao.getDataAbertura(),
                leilao.getStatus());
    }
}
