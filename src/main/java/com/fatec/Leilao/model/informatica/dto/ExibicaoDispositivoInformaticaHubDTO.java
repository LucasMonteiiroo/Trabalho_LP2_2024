package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.Hub;
import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;


public record ExibicaoDispositivoInformaticaHubDTO(
        Long id,
        TipoDispositivoInformatica tipoDispositivo,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Double precoInicial,
        Integer quantidadePortas,
        Long leilaoId
) {
    public ExibicaoDispositivoInformaticaHubDTO(Hub DispositivoInformatica) {
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
