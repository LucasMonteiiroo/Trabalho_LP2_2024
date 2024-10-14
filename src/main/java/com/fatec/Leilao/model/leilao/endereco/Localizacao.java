package com.fatec.Leilao.model.leilao.endereco;

import com.fatec.Leilao.model.leilao.endereco.dto.LocalizacaoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(PkLocalizacao.class)
public class Localizacao {
    @Id
    private Long numero;
    @Id
    private String cep;


    private String cidade;

    private String estado;

    private String rua;

    private String bairro;

    public Localizacao(LocalizacaoDTO localizacao) {
        this.numero = localizacao.numero();
        this.cep = localizacao.cep();
        this.cidade = localizacao.cidade();
        this.estado = localizacao.siglaEstado();
        this.bairro = localizacao.bairro();
    }
}
