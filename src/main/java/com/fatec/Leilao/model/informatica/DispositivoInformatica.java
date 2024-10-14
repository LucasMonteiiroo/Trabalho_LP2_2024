package com.fatec.Leilao.model.informatica;

import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoDTO;
import com.fatec.Leilao.model.informatica.dto.CadastroDispositivoInformaticaSwitchDTO;
import com.fatec.Leilao.model.informatica.enums.TipoDispositivoInformatica;
import com.fatec.Leilao.model.leilao.Leilao;
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

    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    public DispositivoInformatica(CadastroDispositivoDTO cadastroDispositivoDTO, Leilao leilao) {
        this.tipoDispositivo = cadastroDispositivoDTO.tipoDispositivo();
        this.marca = cadastroDispositivoDTO.marca();
        this.descricao = cadastroDispositivoDTO.descricao();
        this.anoFabricacao = cadastroDispositivoDTO.anoFabricacao();
        this.precoInicial = cadastroDispositivoDTO.precoInicial();
        this.leilao = leilao;
    }

}
