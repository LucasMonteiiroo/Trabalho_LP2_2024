package com.fatec.Leilao.model.leilao.endereco;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    private String nomePais;

    @OneToMany(mappedBy = "pais")
    @JsonManagedReference
    private List<Estado> estados;

    public Pais(String brasil) {
        this.nomePais = brasil;
    }
}
