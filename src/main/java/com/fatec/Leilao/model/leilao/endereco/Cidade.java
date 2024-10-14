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
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cidade")
    private Long idCidade;

    private String nomeCidade;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    @JsonBackReference
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    @JsonManagedReference
    private List<Bairro> bairros;

    public Cidade(LocalizacaoDTO localizacao) {
        this.nomeCidade = localizacao.cidade();
        this.estado = new Estado(localizacao);
    }
}
