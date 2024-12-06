package com.lp2.leilao.repository;

import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.LanceDispositivoVeiculo;
import com.lp2.leilao.model.veiculo.DispositivoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceDispositivoVeiculoRepository extends JpaRepository<LanceDispositivoVeiculo, Long> {

    List<LanceDispositivoVeiculo> findAllByCliente(Cliente cliente);

    @Query(value = "SELECT VALOR FROM LANCE_VEICULO WHERE dispositivo_veiculo_id = ?1 ORDER BY VALOR DESC LIMIT 1",nativeQuery = true)
    Double findValorByProdutoVeiculo(Long id);

    List<LanceDispositivoVeiculo> findByDispositivoVeiculo(DispositivoVeiculo dispositivoVeiculo);
}
