package com.fatec.Leilao.model.informatica.dto;


import com.fatec.Leilao.model.informatica.Notebook;
import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;

public record ExibicaoDispositivoInformaticaNotebookDTO(
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
    public ExibicaoDispositivoInformaticaNotebookDTO(Notebook DispositivoInformatica) {
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
