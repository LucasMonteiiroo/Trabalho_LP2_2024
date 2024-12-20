package com.lp2.leilao.model.dto.leilao;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.enums.StatusLeilao;
import com.lp2.leilao.util.ConfenciaStatusLeilao;

import java.time.LocalDateTime;

public record ExibicaoLeilaoDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataAbertura,
        LocalDateTime dataInicio,
        LocalDateTime dataFechamento,
        StatusLeilao status
) {
    public ExibicaoLeilaoDTO(Leilao leilao) {
        this(leilao.getId(),
                leilao.getNome(),
                leilao.getDescricao(),
                leilao.getDataAbertura(),
                leilao.getDataInicio(),
                leilao.getDataFechamento(),
                ConfenciaStatusLeilao.conferirStatus(leilao));
    }

}
