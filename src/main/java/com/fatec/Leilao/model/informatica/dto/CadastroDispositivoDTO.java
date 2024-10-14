package com.fatec.Leilao.model.informatica.dto;

import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;

public record CadastroDispositivoDTO(
        TipoDispositivoInformatica tipoDispositivo,

        String marca,

        String modelo,

        String descricao,

        String anoFabricacao,

        Double precoInicial
) {
    public CadastroDispositivoDTO(CadastroDispositivoInformaticaNotebookDTO cadastroDispositivoInformaticaDTO) {
        this(
                cadastroDispositivoInformaticaDTO.tipoDispositivo(),
                cadastroDispositivoInformaticaDTO.marca(),
                cadastroDispositivoInformaticaDTO.modelo(),
                cadastroDispositivoInformaticaDTO.descricao(),
                cadastroDispositivoInformaticaDTO.anoFabricacao(),
                cadastroDispositivoInformaticaDTO.precoInicial()
        );
    }

    public CadastroDispositivoDTO(CadastroDispositivoInformaticaMonitorDTO cadastroDispositivoInformaticaMonitorDTO) {
        this(
                cadastroDispositivoInformaticaMonitorDTO.tipoDispositivo(),
                cadastroDispositivoInformaticaMonitorDTO.marca(),
                cadastroDispositivoInformaticaMonitorDTO.modelo(),
                cadastroDispositivoInformaticaMonitorDTO.descricao(),
                cadastroDispositivoInformaticaMonitorDTO.anoFabricacao(),
                cadastroDispositivoInformaticaMonitorDTO.precoInicial()
        );
    }

    public CadastroDispositivoDTO(CadastroDispositivoInformaticaHubDTO cadastroDispositivo) {
        this(
                cadastroDispositivo.tipoDispositivo(),
                cadastroDispositivo.marca(),
                cadastroDispositivo.modelo(),
                cadastroDispositivo.descricao(),
                cadastroDispositivo.anoFabricacao(),
                cadastroDispositivo.precoInicial()
        );
    }

    public CadastroDispositivoDTO(CadastroDispositivoInformaticaSwitchDTO cadastroDispositivo) {
        this(
                cadastroDispositivo.tipoDispositivo(),
                cadastroDispositivo.marca(),
                cadastroDispositivo.modelo(),
                cadastroDispositivo.descricao(),
                cadastroDispositivo.anoFabricacao(),
                cadastroDispositivo.precoInicial()
        );
    }

    public CadastroDispositivoDTO(CadastroDispositivoInformaticaRoteadorDTO cadastroDispositivo) {
        this(
                cadastroDispositivo.tipoDispositivo(),
                cadastroDispositivo.marca(),
                cadastroDispositivo.modelo(),
                cadastroDispositivo.descricao(),
                cadastroDispositivo.anoFabricacao(),
                cadastroDispositivo.precoInicial()
        );
    }
}
