package com.fatec.Leilao.repository;

import com.fatec.Leilao.model.leilao.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
}
