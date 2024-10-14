package com.fatec.Leilao.model.informatica;

import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoDTO;
import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoInformaticaMonitorDTO;
import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoInformaticaNotebookDTO;
import com.fatec.Leilao.model.leilao.Leilao;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Monitor extends DispositivoInformatica {
    private String tamanhoTela;

    public Monitor(CadastroDispositivoInformaticaMonitorDTO cadastroDispositivoInformaticaMonitorDTO, Leilao leilao, String s) {
        super(new CadastroDispositivoDTO(cadastroDispositivoInformaticaMonitorDTO),leilao);
        this.tamanhoTela = s;
    }
}


