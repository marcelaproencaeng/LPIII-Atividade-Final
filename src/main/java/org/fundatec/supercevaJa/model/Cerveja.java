package org.fundatec.supercevaJa.model;

import jakarta.persistence.*;
import lombok.Data;
import org.fundatec.supercevaJa.model.enuns.TipoCerveja;
import java.math.BigDecimal;


@Entity
@Table(name = "tb_cerveja")
@Data
public class Cerveja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long idCerveja;
    @Column(length = 100, name = "Nome")
    private String nome;
    @Column
    private double teorAlcoolico;
    @Column
    private int volume;
    @Enumerated(EnumType.STRING)
    private TipoCerveja tipo;
    @Column
    private BigDecimal valor;
    @Column
    private int quantidade;

    public Cerveja() {

    }

    public Cerveja(long idCerveja, String nome,
                   double teorAlcoolico, int volume, TipoCerveja tipo,
                   BigDecimal valor, int quantidade) {
        this.idCerveja = idCerveja;
        this.nome = nome;
        this.teorAlcoolico = teorAlcoolico;
        this.volume = volume;
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
    }


}
