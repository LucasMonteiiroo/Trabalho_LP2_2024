package com.fatec.Leilao.model.leilao.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PkLocalizacao implements Serializable {
    private String cep;
    private Integer numero;
}
