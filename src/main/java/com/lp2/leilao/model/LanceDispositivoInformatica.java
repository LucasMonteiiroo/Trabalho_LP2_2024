package com.lp2.leilao.model;


import com.lp2.leilao.model.informatica.DispositivoInformatica;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "lance_informatica")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LanceDispositivoInformatica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDateTime data = LocalDateTime.now(ZoneId.systemDefault()).minusHours(3);

    @ManyToOne
    @JoinColumn(name = "dispositivo_informatica_id")
    private DispositivoInformatica dispositivoInformatica;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;


    public LanceDispositivoInformatica(DispositivoInformatica dispositivoInformatica, Cliente cliente, Double valor) {
        this.valor = valor;
        this.dispositivoInformatica = dispositivoInformatica;
        this.cliente = cliente;
    }
}
