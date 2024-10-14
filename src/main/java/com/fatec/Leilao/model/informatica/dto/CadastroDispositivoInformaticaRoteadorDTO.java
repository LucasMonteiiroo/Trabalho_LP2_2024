package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;
import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroDispositivoInformaticaRoteadorDTO(
        @Schema(defaultValue = "ROTEADOR", description = "Tipo do Dispositivo") TipoDispositivoInformatica tipoDispositivo,
        @Schema(defaultValue = "TP-Link", description = "Marca do roteador") String marca,
        @Schema(defaultValue = "Modelo R1234", description = "Modelo do roteador") String modelo,
        @Schema(defaultValue = "Roteador sem fio de alta velocidade", description = "Descrição do roteador") String descricao,
        @Schema(defaultValue = "2023", description = "Ano de fabricação do roteador") String anoFabricacao,
        @Schema(defaultValue = "149.99", description = "Preço inicial do roteador") Double precoInicial,
        @Schema(defaultValue = "4", description = "Quantidade de portas do roteador") Integer quantidadePortas
) {
}
