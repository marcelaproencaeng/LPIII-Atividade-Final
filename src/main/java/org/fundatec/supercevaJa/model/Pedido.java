package org.fundatec.supercevaJa.model;

import jakarta.persistence.*;
import lombok.Data;
import org.fundatec.supercevaJa.model.enuns.FormaPagamento;
import org.fundatec.supercevaJa.model.enuns.StatusPedido;
import org.hibernate.engine.internal.Cascade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_pedido")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idPedido;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cerveja_id")
    private List<Cerveja> cervejas;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataPedido;
    @Column
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @Column
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    public Pedido() {

    }

    public Pedido(Long idPedido, Usuario usuario,
                  List<Cerveja> cervejas, LocalDate dataPedido,
                  StatusPedido status, FormaPagamento formaPagamento) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.cervejas = cervejas;
        this.dataPedido = dataPedido;
        this.status = status;
        this.formaPagamento = formaPagamento;
    }

}
