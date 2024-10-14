package com.fatec.Leilao.model.leilao.endereco;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fatec.Leilao.model.leilao.endereco.dto.LocalizacaoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Localizacao {
    @Id
    private String cep;

    private Integer numero;

    private String nomeRua;

    @ManyToOne
    @JoinColumn(name = "id_bairro")
    @JsonBackReference
    private Bairro bairro;

    public Localizacao(LocalizacaoDTO localizacao) {
        this.cep = localizacao.cep();
        this.numero = localizacao.numero();
        this.nomeRua = localizacao.rua();
        this.bairro = new Bairro(localizacao);
    }
}
