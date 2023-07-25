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
    private long idPedido;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private List<Cerveja> cervejas;
    @Column
    private LocalDate dataPedido;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    public Pedido() {

    }

    public Pedido(long idPedido, Usuario usuario,
                  List<Cerveja> cervejas, LocalDate dataPedido,
                  StatusPedido status, FormaPagamento formaPagamento) {
        this.idPedido = idPedido;
        this.usuario = usuario;
        this.cervejas = cervejas;
        this.dataPedido = dataPedido;
        this.status = status;
        this.formaPagamento = formaPagamento;
    }
    public BigDecimal calcularValorTotal() {
        // Percorrer a Lista de Cervejas e somar todos os valores
        // A soma desses valores deve ser retornada, representando o valor total do Pedido
        BigDecimal valorTotalPedido = BigDecimal.ZERO;
        for (Cerveja cerveja : cervejas) {
            // BigDecimal big1 = new BigDecimal("1078");
            // BigDecimal big2 = new BigDecimal("1928");
            // BigDecimal bigResult = big1.add(big2);
            System.out.println(cerveja.getNome());
            // Somar todas as cervejas
            valorTotalPedido = valorTotalPedido.add(cerveja.getValor());
        }
        return valorTotalPedido;
    }
}
