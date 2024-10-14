package com.fatec.Leilao.model.leilao.endereco;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Estado {

    @Id
    private String siglaEstado;

    private String nomeEstado;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    @JsonBackReference
    private Pais pais;

    @OneToMany(mappedBy = "estado")
    @JsonManagedReference
    private List<Cidade> cidades;

    public Estado(LocalizacaoDTO localizacao) {
        this.siglaEstado = localizacao.siglaEstado();
        this.nomeEstado = localizacao.estado();
        this.pais = new Pais("Brasil");
    }
}
