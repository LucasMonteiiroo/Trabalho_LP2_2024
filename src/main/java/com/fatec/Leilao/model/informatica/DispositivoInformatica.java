package com.fatec.Leilao.model.informatica;

import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class DispositivoInformatica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoDispositivoInformatica tipoDispositivo;

    private String marca;

    private String modelo;

    private String descricao;

    private String anoFabricacao;

    private Double precoInicial;

}
