package com.fatec.Leilao.model.leilao.dto;

import com.fatec.Leilao.model.leilao.endereco.dto.LocalizacaoDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record CriacaoLeilaoDTO (
        @Schema(defaultValue = "1")
        Long instituicaoFinanceira,

        @Schema(defaultValue = "Leilão Dispositivos de Informatica e Veiculos")
        String nome,

        @Schema(defaultValue = "Leilão de alta tecnologia: dispositivos e veículos de ponta em competição emocionante.")
        String descricao,

        @Schema(defaultValue = "25/12/2023 14:30:00")
        LocalDateTime dataInicio,

        @Schema(defaultValue = "01/01/2024 14:30:00")
        LocalDateTime dataFechamento,

        LocalizacaoDTO localizacao
){

}
