package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;
import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroDispositivoInformaticaMonitorDTO(
        @Schema(defaultValue = "MONITOR", description = "Tipo do Dispositivo") TipoDispositivoInformatica tipoDispositivo,

        @Schema(defaultValue = "ACER")
        String marca,

        @Schema(defaultValue = "Modelo Teste 123")

        String modelo,
        @Schema(defaultValue = "Vívido, nítido, amplo, moderno, ajustável.")
        String descricao,

        @Schema(defaultValue = "2015")
        String anoFabricacao,

        @Schema(defaultValue = "1000")

        Double precoInicial,
        @Schema(defaultValue = "1350x1100")

        String tamanhoTela
) {
}
