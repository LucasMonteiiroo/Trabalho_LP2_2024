package com.fatec.Leilao.model.instituicaoFinanceira.dto;

import com.fatec.Leilao.model.instituicaoFinanceira.enums.TipoInstituicao;
import io.swagger.v3.oas.annotations.media.Schema;

public record CriacaoInstituicaoDTO(
        @Schema(defaultValue = "Bradesco", description = "Nome da Instituição") String nomeInstituicao,
        @Schema(defaultValue = "BANCO", description = "Tipo da Instituição") TipoInstituicao tipo,
        @Schema(defaultValue = "66.460.942/0001-60", description = "CNPJ da Instituiçaõ") String cnpj
) {
}
