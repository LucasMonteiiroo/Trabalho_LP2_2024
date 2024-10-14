package com.fatec.Leilao.repository;

import com.fatec.Leilao.model.informatica.DispositivoInformatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoInformatica, Long> {
}
