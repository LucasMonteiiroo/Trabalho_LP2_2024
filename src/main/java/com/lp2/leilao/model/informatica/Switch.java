package com.lp2.leilao.model.informatica;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.produtoInformatica.CadastroProdutoInformaticaSwitchDTO;
import com.lp2.leilao.model.dto.produtoInformatica.ExibicaoProdutoInformaticaSwitchDTO;
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

    public Switch(CadastroProdutoInformaticaSwitchDTO cadastroProdutoInformaticaSwitchDTO, Leilao leilao, Integer quantidadePortas) {
        super(cadastroProdutoInformaticaSwitchDTO,leilao);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public ExibicaoProdutoInformaticaSwitchDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaSwitchDTO(this);
    }
}


