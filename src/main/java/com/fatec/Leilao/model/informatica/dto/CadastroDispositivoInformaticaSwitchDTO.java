package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;
import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroDispositivoInformaticaSwitchDTO(
        @Schema(defaultValue = "SWITCH", description = "Tipo do Dispositivo") TipoDispositivoInformatica tipoDispositivo,
        @Schema(defaultValue = "MarcaX", description = "Marca do switch de rede") String marca,
        @Schema(defaultValue = "Modelo Rede 2000", description = "Modelo do switch de rede") String modelo,
        @Schema(defaultValue = "Switch para conexão de cabos de internet", description = "Descrição do switch de rede") String descricao,
        @Schema(defaultValue = "2022", description = "Ano de fabricação do switch de rede") String anoFabricacao,
        @Schema(defaultValue = "99.99", description = "Preço inicial do switch de rede") Double precoInicial,
        @Schema(defaultValue = "8", description = "Quantidade de portas do switch de rede") Integer quantidadePortas
) {
}
