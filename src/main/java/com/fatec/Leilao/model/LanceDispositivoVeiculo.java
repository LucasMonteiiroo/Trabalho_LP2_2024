package com.lp2.leilao.model;


import com.lp2.leilao.model.veiculo.DispositivoVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "LANCE_VEICULO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LanceDispositivoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDateTime data = LocalDateTime.now(ZoneId.systemDefault()).minusHours(3);

    @ManyToOne
    @JoinColumn(name = "dispositivo_veiculo_id")
    private DispositivoVeiculo dispositivoVeiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;


    public LanceDispositivoVeiculo(DispositivoVeiculo dispositivoVeiculo, Cliente cliente, Double valor) {
        this.valor = valor;
        this.dispositivoVeiculo = dispositivoVeiculo;
        this.cliente = cliente;
    }
}
