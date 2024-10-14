package com.fatec.Leilao.model.informatica;

import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoDTO;
import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoInformaticaSwitchDTO;
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
public class Switch extends DispositivoInformatica {
    private Integer quantidadePortas;

    public Switch(CadastroDispositivoInformaticaSwitchDTO cadastroDispositivoInformaticaSwitchDTO, Leilao leilao, Integer quantidadePortas) {
        super(new CadastroDispositivoDTO(cadastroDispositivoInformaticaSwitchDTO), leilao);
        this.quantidadePortas = quantidadePortas;
    }
}


