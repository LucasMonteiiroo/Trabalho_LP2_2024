package com.lp2.leilao.model.dto.produtoInformatica; import java.math.BigDecimal;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.informatica.DispositivoInformatica;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;

public record ExibicaoProdutoInformaticaDTO(
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
        Long leilaoId
) {
    public ExibicaoProdutoInformaticaDTO(DispositivoInformatica dispositivoInformatica) {
        this(dispositivoInformatica.getId(),
                dispositivoInformatica.getTipoProduto(),
                dispositivoInformatica.getMarca(),
                dispositivoInformatica.getModelo(),
                dispositivoInformatica.getDescricao(),
                dispositivoInformatica.getAnoFabricacao(),
                dispositivoInformatica.getCondicao(),
                dispositivoInformatica.getNumeroSerie(),
                dispositivoInformatica.getCor(),
                dispositivoInformatica.getPrecoInicial(),
                dispositivoInformatica.getLeilao().getId());
    }



}
