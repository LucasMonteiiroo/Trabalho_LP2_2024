package com.lp2.leilao.repository;

import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.LanceDispositivoInformatica;
import com.lp2.leilao.model.informatica.DispositivoInformatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceDispositivoInformaticaRepository extends JpaRepository<LanceDispositivoInformatica, Long> {
    List<LanceDispositivoInformatica> findAllByCliente(Cliente cliente);

    @Query(value = "SELECT VALOR FROM LANCE_INFORMATICA WHERE dispositivo_informatica_id = ?1 ORDER BY VALOR DESC LIMIT 1",nativeQuery = true)
    Double findValorByDispositivoInformatica(Long id);

    List<LanceDispositivoInformatica> findByDispositivoInformatica(DispositivoInformatica dispositivoInformatica);
}
