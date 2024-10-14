package com.fatec.Leilao.model.informatica;

import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoDTO;
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
public class Notebook extends DispositivoInformatica {
    private String tamanhoTela;

    public Notebook(CadastroDispositivoInformaticaNotebookDTO cadastroDispositivoInformaticaDTO, Leilao leilao, String s) {
        super(new CadastroDispositivoDTO(cadastroDispositivoInformaticaDTO),leilao);
        this.tamanhoTela = s;
    }
}


