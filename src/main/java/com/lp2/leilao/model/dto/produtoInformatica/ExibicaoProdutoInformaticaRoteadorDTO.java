package com.lp2.leilao.model.dto.produtoInformatica; import java.math.BigDecimal;

import com.lp2.leilao.model.informatica.Roteador;
import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;

public record ExibicaoProdutoInformaticaRoteadorDTO(
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
        Integer quantidadePortas,
        Long leilaoId
) {
    public ExibicaoProdutoInformaticaRoteadorDTO(Roteador produtoInformatica) {
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
                produtoInformatica.getQuantidadePortas(),
                produtoInformatica.getLeilao().getId());
    }



}
