package com.fatec.Leilao.model.instituicaoFinanceira.dto;

import com.fatec.Leilao.model.instituicaoFinanceira.InstituicaoFinanceira;
import com.fatec.Leilao.model.instituicaoFinanceira.enums.TipoInstituicao;

public record ExibicaoInstituicaoFinanceiraDTO(
        Long id,
    String nomeInstituicao,
    TipoInstituicao tipo,
    String cnpj
) {
    public ExibicaoInstituicaoFinanceiraDTO(InstituicaoFinanceira instituicaoFinanceira) {
        this(instituicaoFinanceira.getIdInstituicaoFinanceira(),
                instituicaoFinanceira.getNomeInstituicao(),
                instituicaoFinanceira.getTipoInstituicao(),
                instituicaoFinanceira.getCnpj());
    }
}
