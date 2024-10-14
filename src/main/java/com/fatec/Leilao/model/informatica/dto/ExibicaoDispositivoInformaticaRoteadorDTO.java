package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.Roteador;
import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;


public record ExibicaoDispositivoInformaticaRoteadorDTO(
        Long id,
        TipoDispositivoInformatica tipoDispositivo,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Double PrecoInicial,
        Integer quantidadePortas,
        Long leilaoId
) {
    public ExibicaoDispositivoInformaticaRoteadorDTO(Roteador DispositivoInformatica) {
        this(DispositivoInformatica.getId(),
                DispositivoInformatica.getTipoDispositivo(),
                DispositivoInformatica.getMarca(),
                DispositivoInformatica.getModelo(),
                DispositivoInformatica.getDescricao(),
                DispositivoInformatica.getAnoFabricacao(),
                DispositivoInformatica.getPrecoInicial(),
                DispositivoInformatica.getQuantidadePortas(),
                DispositivoInformatica.getLeilao().getIdLeilao());
    }



}
