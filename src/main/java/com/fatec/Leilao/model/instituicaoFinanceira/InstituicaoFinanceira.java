package com.fatec.Leilao.model.instituicaoFinanceira;

import com.fatec.Leilao.model.instituicaoFinanceira.enums.TipoInstituicao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public InstituicaoFinanceira(CriacaoInstituicaoDTO criacaoInstituicaoDTO) {
        this.nomeInstituicao = criacaoInstituicaoDTO.nomeInstituicao();
        this.cnpj = criacaoInstituicaoDTO.cnpj();
        this.tipoInstituicao = criacaoInstituicaoDTO.tipo();
    }
}
