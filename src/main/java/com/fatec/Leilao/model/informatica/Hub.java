package com.fatec.Leilao.model.informatica;

import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoDTO;
import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoInformaticaHubDTO;
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
public class Hub extends DispositivoInformatica {
    private Integer quantidadePortas;

    public Hub(CadastroDispositivoInformaticaHubDTO cadastroDispositivoInformaticaHubDTO, Leilao leilao, Integer quantidadePortas) {
        super(new CadastroDispositivoDTO(cadastroDispositivoInformaticaHubDTO),leilao);
        this.quantidadePortas = quantidadePortas;
    }

}


