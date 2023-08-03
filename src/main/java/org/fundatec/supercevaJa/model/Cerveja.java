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
    private Long idCerveja;
    @Column(length = 100, name = "Nome")
    private String nome;
    @Column
    private Double teorAlcoolico;
    @Column
    private Integer volume;
    @Column
    @Enumerated(EnumType.STRING)
    private TipoCerveja tipo;
    @Column
    private BigDecimal valor;
    @Column
    private Integer quantidade;

    public Cerveja() {

    }

    public Cerveja(Long idCerveja, String nome,
                   Double teorAlcoolico, Integer volume, TipoCerveja tipo,
                   BigDecimal valor, Integer quantidade) {
        this.idCerveja = idCerveja;
        this.nome = nome;
        this.teorAlcoolico = teorAlcoolico;
        this.volume = volume;
        this.tipo = tipo;
        this.valor = valor;
        this.quantidade = quantidade;
    }


}
