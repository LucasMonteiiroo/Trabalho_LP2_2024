package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;
import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroDispositivoInformaticaHubDTO(
        @Schema(defaultValue = "HUB", description = "Tipo do Dispositivo") TipoDispositivoInformatica tipoDispositivo,

        @Schema(defaultValue = "Acer", description = "Marca do hub") String marca,
        @Schema(defaultValue = "Modelo X100", description = "Modelo do hub") String modelo,
        @Schema(defaultValue = "Hub de alta velocidade para conexões de rede", description = "Descrição do hub") String descricao,
        @Schema(defaultValue = "2023", description = "Ano de fabricação do hub") String anoFabricacao,
        @Schema(defaultValue = "1234567890", description = "Número de série do hub") Integer numeroSerie,
        @Schema(defaultValue = "Branco", description = "Cor do hub") String cor,
        @Schema(defaultValue = "89.99", description = "Preço inicial do hub") Double precoInicial,
        @Schema(defaultValue = "8", description = "Quantidade de portas do hub") Integer quantidadePortas
) {
}
