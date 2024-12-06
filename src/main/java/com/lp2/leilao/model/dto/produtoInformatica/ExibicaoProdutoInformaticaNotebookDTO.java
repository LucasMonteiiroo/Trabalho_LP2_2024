package com.lp2.leilao.model.dto.produtoInformatica; import java.math.BigDecimal;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.informatica.Notebook;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;

import java.math.BigDecimal;

public record ExibicaoProdutoInformaticaNotebookDTO(
        Long id,
        TipoProdutoInformatica tipoProduto,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Condicao condicao,
        BigDecimal numeroSerie,
        String cor,
        Double PrecoInicial,
        String tamanhoTela,
        Long leilaoId
) {
    public ExibicaoProdutoInformaticaNotebookDTO(Notebook produtoInformatica) {
        this(produtoInformatica.getId(),
                produtoInformatica.getTipoProduto(),
                produtoInformatica.getMarca(),
                produtoInformatica.getModelo(),
                produtoInformatica.getDescricao(),
                produtoInformatica.getAnoFabricacao(),
                produtoInformatica.getCondicao(),
                produtoInformatica.getNumeroSerie(),
                produtoInformatica.getCor(),
                produtoInformatica.getPrecoInicial(),
                produtoInformatica.getTamanhoTela(),
                produtoInformatica.getLeilao().getId());
    }



}
