package com.fatec.Leilao.model.instituicaoFinanceira;

import com.fatec.Leilao.model.instituicaoFinanceira.enums.TipoInstituicao;

public record CriacaoInstituicaoDTO(
        String nomeInstituicao,
        TipoInstituicao tipo,
        String cnpj
) {
}
