package com.fatec.Leilao.model.instituicaoFinanceira;

import com.fatec.Leilao.model.instituicaoFinanceira.dto.CriacaoInstituicaoDTO;
import com.fatec.Leilao.model.instituicaoFinanceira.enums.TipoInstituicao;
import com.fatec.Leilao.model.leilao.Leilao;
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
public class InstituicaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstituicaoFinanceira;

    private String nomeInstituicao;
    private TipoInstituicao tipoInstituicao;
    private String cnpj;

    @ManyToMany
    @JoinTable(
            name = "leilao_instituicao",
            joinColumns = @JoinColumn(name = "instituicao_id"),
            inverseJoinColumns = @JoinColumn(name = "leilao_id"))
    private List<Leilao> leilao;

    public InstituicaoFinanceira(CriacaoInstituicaoDTO criacaoInstituicaoDTO) {
        this.nomeInstituicao = criacaoInstituicaoDTO.nomeInstituicao();
        this.cnpj = criacaoInstituicaoDTO.cnpj();
        this.tipoInstituicao = criacaoInstituicaoDTO.tipo();
    }
}
