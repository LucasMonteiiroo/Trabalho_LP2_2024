package com.lp2.leilao.model.informatica;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.produtoInformatica.CadastroProdutoInformaticaHubDTO;
import com.lp2.leilao.model.dto.produtoInformatica.ExibicaoProdutoInformaticaHubDTO;
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

    public Hub(CadastroProdutoInformaticaHubDTO cadastroProdutoInformaticaHubDTO, Leilao leilao, Integer quantidadePortas) {
        super(cadastroProdutoInformaticaHubDTO,leilao);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public ExibicaoProdutoInformaticaHubDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaHubDTO(this);
    }
}


