package com.fatec.Leilao.model.informatica;

import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoDTO;
import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoInformaticaRoteadorDTO;
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
public class Roteador extends DispositivoInformatica {
    private Integer quantidadePortas;

    public Roteador(CadastroDispositivoInformaticaRoteadorDTO cadastroDispositivoInformaticaRoteadorDTO, Leilao leilao, Integer quantidadePortas) {
        super(new CadastroDispositivoDTO(cadastroDispositivoInformaticaRoteadorDTO), leilao);
        this.quantidadePortas = quantidadePortas;
    }
}


