package com.lp2.leilao.model.informatica;


import com.lp2.leilao.model.LanceDispositivoInformatica;
import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.produtoInformatica.*;
import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

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

    private TipoProdutoInformatica tipoProduto;

    private String marca;

    private String modelo;

    private String descricao;

    private String anoFabricacao;

    private Condicao condicao;

    private BigDecimal numeroSerie;

    private String cor;

    private Double precoInicial;

    @OneToMany(mappedBy = "dispositivoInformatica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LanceDispositivoInformatica> lances;

    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    public DispositivoInformatica(DispositivoInformatica dispositivoInformaticaEncontrado, DispositivoInformatica dispositivoInformatica){
        this.id = dispositivoInformaticaEncontrado.getId();

        this.tipoProduto = dispositivoInformatica.tipoProduto != null ? dispositivoInformatica.tipoProduto : dispositivoInformaticaEncontrado.getTipoProduto();
        this.marca = dispositivoInformatica.marca != null ? dispositivoInformatica.marca : dispositivoInformaticaEncontrado.getMarca();
        this.modelo = dispositivoInformatica.modelo != null ? dispositivoInformatica.modelo : dispositivoInformaticaEncontrado.getModelo();
        this.descricao = dispositivoInformatica.descricao != null ? dispositivoInformatica.descricao : dispositivoInformaticaEncontrado.getDescricao() ;
        this.anoFabricacao = dispositivoInformatica.anoFabricacao != null ? dispositivoInformatica.anoFabricacao : dispositivoInformaticaEncontrado.getAnoFabricacao();
        this.condicao = dispositivoInformatica.condicao != null ? dispositivoInformatica.condicao : dispositivoInformaticaEncontrado.getCondicao();
        this.numeroSerie = dispositivoInformatica.numeroSerie != null ? dispositivoInformatica.numeroSerie : dispositivoInformaticaEncontrado.getNumeroSerie();
        this.cor = dispositivoInformatica.cor != null ? dispositivoInformatica.cor : dispositivoInformaticaEncontrado.getCor();
        this.precoInicial = dispositivoInformatica.precoInicial != null ? dispositivoInformatica.precoInicial : dispositivoInformaticaEncontrado.getPrecoInicial();
        this.leilao = dispositivoInformatica.leilao;
    }

    public DispositivoInformatica(CadastroProdutoInformaticaDTO cadastroProdutoInformaticaDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoInformatica.SWITCH;
        this.marca = cadastroProdutoInformaticaDTO.marca();
        this.modelo = cadastroProdutoInformaticaDTO.modelo();
        this.descricao = cadastroProdutoInformaticaDTO.descricao();
        this.anoFabricacao = cadastroProdutoInformaticaDTO.anoFabricacao();
        this.condicao = cadastroProdutoInformaticaDTO.condicao();
        this.numeroSerie = cadastroProdutoInformaticaDTO.numeroSerie();
        this.cor = cadastroProdutoInformaticaDTO.cor();
        this.precoInicial = cadastroProdutoInformaticaDTO.PrecoInicial();
        this.leilao = leilao;
    }

    public DispositivoInformatica(CadastroProdutoInformaticaNotebookDTO cadastroProdutoInformaticaDTO, Leilao leilao) {
        this.tipoProduto = cadastroProdutoInformaticaDTO.tipoProduto();
        this.marca = cadastroProdutoInformaticaDTO.marca();
        this.modelo = cadastroProdutoInformaticaDTO.modelo();
        this.descricao = cadastroProdutoInformaticaDTO.descricao();
        this.anoFabricacao = cadastroProdutoInformaticaDTO.anoFabricacao();
        this.condicao = cadastroProdutoInformaticaDTO.condicao();
        this.numeroSerie = cadastroProdutoInformaticaDTO.numeroSerie();
        this.cor = cadastroProdutoInformaticaDTO.cor();
        this.precoInicial = cadastroProdutoInformaticaDTO.PrecoInicial();
        this.leilao = leilao;
    }

    public DispositivoInformatica(CadastroProdutoInformaticaMonitorDTO cadastroProdutoInformaticaDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoInformatica.MONITOR;
        this.marca = cadastroProdutoInformaticaDTO.marca();
        this.modelo = cadastroProdutoInformaticaDTO.modelo();
        this.descricao = cadastroProdutoInformaticaDTO.descricao();
        this.anoFabricacao = cadastroProdutoInformaticaDTO.anoFabricacao();
        this.condicao = cadastroProdutoInformaticaDTO.condicao();
        this.numeroSerie = cadastroProdutoInformaticaDTO.numeroSerie();
        this.cor = cadastroProdutoInformaticaDTO.cor();
        this.precoInicial = cadastroProdutoInformaticaDTO.PrecoInicial();
        this.leilao = leilao;
    }

    public DispositivoInformatica(CadastroProdutoInformaticaHubDTO cadastroProdutoInformaticaDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoInformatica.HUB;
        this.marca = cadastroProdutoInformaticaDTO.marca();
        this.modelo = cadastroProdutoInformaticaDTO.modelo();
        this.descricao = cadastroProdutoInformaticaDTO.descricao();
        this.anoFabricacao = cadastroProdutoInformaticaDTO.anoFabricacao();
        this.condicao = cadastroProdutoInformaticaDTO.condicao();
        this.numeroSerie = cadastroProdutoInformaticaDTO.numeroSerie();
        this.cor = cadastroProdutoInformaticaDTO.cor();
        this.precoInicial = cadastroProdutoInformaticaDTO.precoInicial();
        this.leilao = leilao;
    }

    public DispositivoInformatica(CadastroProdutoInformaticaSwitchDTO cadastroProdutoInformaticaDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoInformatica.SWITCH;
        this.marca = cadastroProdutoInformaticaDTO.marca();
        this.modelo = cadastroProdutoInformaticaDTO.modelo();
        this.descricao = cadastroProdutoInformaticaDTO.descricao();
        this.anoFabricacao = cadastroProdutoInformaticaDTO.anoFabricacao();
        this.condicao = cadastroProdutoInformaticaDTO.condicao();
        this.numeroSerie = cadastroProdutoInformaticaDTO.numeroSerie();
        this.cor = cadastroProdutoInformaticaDTO.cor();
        this.precoInicial = cadastroProdutoInformaticaDTO.precoInicial();
        this.leilao = leilao;
    }

    public DispositivoInformatica(CadastroProdutoInformaticaRoteadorDTO cadastroProdutoInformaticaDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoInformatica.ROTEADOR;
        this.marca = cadastroProdutoInformaticaDTO.marca();
        this.modelo = cadastroProdutoInformaticaDTO.modelo();
        this.descricao = cadastroProdutoInformaticaDTO.descricao();
        this.anoFabricacao = cadastroProdutoInformaticaDTO.anoFabricacao();
        this.condicao = cadastroProdutoInformaticaDTO.condicao();
        this.numeroSerie = cadastroProdutoInformaticaDTO.numeroSerie();
        this.cor = cadastroProdutoInformaticaDTO.cor();
        this.precoInicial = cadastroProdutoInformaticaDTO.precoInicial();
        this.leilao = leilao;
    }

    public Object criacaoDTO() {
        // Implementação padrão ou vazia na classe base
        return null;
    }

}
