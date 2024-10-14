package com.fatec.Leilao.model.informatica;

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
}


