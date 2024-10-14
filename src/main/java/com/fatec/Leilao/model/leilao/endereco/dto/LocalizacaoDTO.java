package com.fatec.Leilao.model.leilao.endereco.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LocalizacaoDTO(
        @Schema(defaultValue = "49092618")
        String cep,
        @Schema(defaultValue = "80")
        Long numero,
        @Schema(defaultValue = "Rua Oito")
        String rua,

        @Schema(defaultValue = "Aracaju")
        String bairro,

        @Schema(defaultValue = "SE")
        String cidade,

        @Schema(defaultValue = "SE")
        String siglaEstado
) {
}
