package com.fatec.Leilao.repository;

import com.fatec.Leilao.model.instituicaoFinanceira.InstituicaoFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoFinanceiraRepository extends JpaRepository<InstituicaoFinanceira, Long> {
}
