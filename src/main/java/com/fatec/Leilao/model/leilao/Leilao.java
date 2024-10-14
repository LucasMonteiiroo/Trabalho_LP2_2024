package com.fatec.Leilao.model.leilao;

import com.fatec.Leilao.model.instituicaoFinanceira.InstituicaoFinanceira;
import com.fatec.Leilao.model.leilao.dto.CriacaoLeilaoDTO;
import com.fatec.Leilao.model.leilao.endereco.Localizacao;
import com.fatec.Leilao.model.leilao.enums.StatusLeilao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLeilao;
    private String nome;
    private String descricao;
    private LocalDateTime dataAbertura = LocalDateTime.now(ZoneId.systemDefault());
    private LocalDateTime dataInicio;
    private LocalDateTime dataFechamento;
    private StatusLeilao status;

    @ManyToOne
    @JoinColumn(name = "cep", referencedColumnName = "cep")
    public Localizacao localizacao;

    @ManyToMany
    @JoinTable(
            name = "leilao_instituicao",
            joinColumns = @JoinColumn(name = "leilao_id"),
            inverseJoinColumns = @JoinColumn(name = "instituicao_id"))
    private List<InstituicaoFinanceira> instituicaoFinanceira;

    public Leilao(CriacaoLeilaoDTO criacaoLeilaoDTO, InstituicaoFinanceira instituicaoFinanceira) {
        this.nome = criacaoLeilaoDTO.nome();
        this.descricao = criacaoLeilaoDTO.descricao();
        this.dataInicio = criacaoLeilaoDTO.dataInicio();
        this.dataFechamento = criacaoLeilaoDTO.dataFechamento();
        this.instituicaoFinanceira = Collections.singletonList(instituicaoFinanceira);
        this.status = StatusLeilao.EM_ABERTO;
    }
}
