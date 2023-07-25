package org.fundatec.supercevaJa.dto;

import lombok.Data;
import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.model.enuns.FormaPagamento;
import org.fundatec.supercevaJa.model.enuns.StatusPedido;

import java.time.LocalDate;
import java.util.List;

@Data
public class PedidoDTO {

    private long idPedido;
    private Usuario usuario;
    private List<Cerveja> cervejas;
    private LocalDate dataPedido;
    private StatusPedido status;
    private FormaPagamento formaPagamento;
}
