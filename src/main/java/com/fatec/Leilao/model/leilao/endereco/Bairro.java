package com.fatec.Leilao.model.leilao.endereco;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fatec.Leilao.model.leilao.endereco.dto.LocalizacaoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBairro;

    private String nomeBairro;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    @JsonBackReference
    private Cidade cidade;

    public Bairro(LocalizacaoDTO localizacao) {
        this.nomeBairro = localizacao.bairro();
        this.cidade = new Cidade(localizacao);
    }
}
