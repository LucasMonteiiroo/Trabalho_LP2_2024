package com.lp2.leilao.model.informatica;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.produtoInformatica.CadastroProdutoInformaticaNotebookDTO;
import com.lp2.leilao.model.dto.produtoInformatica.ExibicaoProdutoInformaticaNotebookDTO;
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



    public Notebook(CadastroProdutoInformaticaNotebookDTO cadastroProdutoInformaticaNotebookDTO, Leilao leilao, String tamanhoTela) {
        super(cadastroProdutoInformaticaNotebookDTO,leilao);
        this.tamanhoTela = tamanhoTela;
    }

    public Notebook(CadastroProdutoInformaticaNotebookDTO cadastroProdutoInformaticaDTO, DispositivoInformatica produtoEncontrado, DispositivoInformatica dispositivoInformatica1) {
        super(produtoEncontrado,
                new DispositivoInformatica(cadastroProdutoInformaticaDTO, produtoEncontrado.getLeilao()));
        this.tamanhoTela = cadastroProdutoInformaticaDTO.tamanhoTela();
    }




    @Override
    public ExibicaoProdutoInformaticaNotebookDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaNotebookDTO(this);
    }


}


