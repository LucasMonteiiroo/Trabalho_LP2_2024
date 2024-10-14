package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.Monitor;
import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;


public record ExibicaoDispositivoInformaticaMonitorDTO(
        Long id,
        TipoDispositivoInformatica tipoDispositivo,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Double PrecoInicial,
        String tamanhoTela,
        Long leilaoId
) {
    public ExibicaoDispositivoInformaticaMonitorDTO(Monitor DispositivoInformatica) {
        this(DispositivoInformatica.getId(),
                DispositivoInformatica.getTipoDispositivo(),
                DispositivoInformatica.getMarca(),
                DispositivoInformatica.getModelo(),
                DispositivoInformatica.getDescricao(),
                DispositivoInformatica.getAnoFabricacao(),
                DispositivoInformatica.getPrecoInicial(),
                DispositivoInformatica.getTamanhoTela(),
                DispositivoInformatica.getLeilao().getIdLeilao());
    }



}
