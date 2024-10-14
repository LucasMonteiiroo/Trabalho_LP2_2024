package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.DispositivoInformatica;
import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;

public record ExibicaoDispositivoInformaticaDTO(
        Long id,
        TipoDispositivoInformatica tipoDispositivo,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Double precoInicial,
        Long leilaoId
) {
    public ExibicaoDispositivoInformaticaDTO(DispositivoInformatica DispositivoInformatica) {
        this(DispositivoInformatica.getId(),
                DispositivoInformatica.getTipoDispositivo(),
                DispositivoInformatica.getMarca(),
                DispositivoInformatica.getModelo(),
                DispositivoInformatica.getDescricao(),
                DispositivoInformatica.getAnoFabricacao(),
                DispositivoInformatica.getPrecoInicial(),
                DispositivoInformatica.getLeilao().getIdLeilao());
    }



}
