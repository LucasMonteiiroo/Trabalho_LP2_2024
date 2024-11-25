package com.lp2.leilao.model.veiculo;


import com.lp2.leilao.model.LanceDispositivoVeiculo;
import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.produtoVeiculo.*;
import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.enums.TipoProdutoVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class DispositivoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoProdutoVeiculo tipoProduto;

    private String marca;

    private String modelo;

    private String descricao;

    private String anoFabricacao;

    private Condicao condicao;

    private Integer numeroPlaca;

    private Double quilometragem;

    private Double motor;

    private String cor;

    private Double precoInicial;

    @OneToMany(mappedBy = "dispositivoVeiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LanceDispositivoVeiculo> lances;

    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;
    public DispositivoVeiculo(DispositivoVeiculo dispositivoVeiculoEncontrado, DispositivoVeiculo dispositivoVeiculo) {
        this.id = dispositivoVeiculoEncontrado.getId();
        this.tipoProduto = dispositivoVeiculo.tipoProduto != null ? dispositivoVeiculo.tipoProduto : dispositivoVeiculoEncontrado.getTipoProduto();
        this.marca = dispositivoVeiculo.marca != null ? dispositivoVeiculo.marca : dispositivoVeiculoEncontrado.getMarca();
        this.modelo = dispositivoVeiculo.modelo != null ? dispositivoVeiculo.modelo : dispositivoVeiculoEncontrado.getModelo();
        this.descricao = dispositivoVeiculo.descricao != null ? dispositivoVeiculo.descricao : dispositivoVeiculoEncontrado.getDescricao();
        this.anoFabricacao = dispositivoVeiculo.anoFabricacao != null ? dispositivoVeiculo.anoFabricacao : dispositivoVeiculoEncontrado.getAnoFabricacao();
        this.condicao = dispositivoVeiculo.condicao != null ? dispositivoVeiculo.condicao : dispositivoVeiculoEncontrado.getCondicao();
        this.numeroPlaca = dispositivoVeiculo.numeroPlaca != null ? dispositivoVeiculo.numeroPlaca : dispositivoVeiculoEncontrado.getNumeroPlaca();
        this.quilometragem = dispositivoVeiculo.quilometragem != null ? dispositivoVeiculo.quilometragem : dispositivoVeiculoEncontrado.getQuilometragem();
        this.motor = dispositivoVeiculo.motor != null ? dispositivoVeiculo.motor : dispositivoVeiculoEncontrado.getMotor();
        this.cor = dispositivoVeiculo.cor != null ? dispositivoVeiculo.cor : dispositivoVeiculoEncontrado.getCor();
        this.precoInicial = dispositivoVeiculo.precoInicial != null ? dispositivoVeiculo.precoInicial : dispositivoVeiculoEncontrado.getPrecoInicial();
        this.leilao = dispositivoVeiculo.leilao;
    }

    public DispositivoVeiculo(CadastroProdutoVeiculoDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoVeiculo.UTILITARIO;
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    public DispositivoVeiculo(CadastroProdutoVeiculoMotocicletaDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoVeiculo.MOTOCICLETA;
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    public DispositivoVeiculo(CadastroProdutoVeiculoCarroDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoVeiculo.CARRO;
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    public DispositivoVeiculo(CadastroProdutoVeiculoCaminhaoDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoVeiculo.CAMINHAO;
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;

    }

    public DispositivoVeiculo(CadastroProdutoVeiculoUtilitarioDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = TipoProdutoVeiculo.UTILITARIO;
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    public Object criacaoDTO() {
        return null;
    }


    @Override
    public String toString() {
        return "ProdutoVeiculo{" +
                "id=" + id +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", anoFabricacao='" + anoFabricacao + '\'' +
                ", condicao=" + condicao +
                ", numeroPlaca=" + numeroPlaca +
                ", quilometragem=" + quilometragem +
                ", motor=" + motor +
                ", cor='" + cor + '\'' +
                ", precoInicial=" + precoInicial +
                ", leilao=" + leilao +
                '}';
    }
}
