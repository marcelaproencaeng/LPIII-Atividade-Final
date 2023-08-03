package org.fundatec.supercevaJa.dto;

import lombok.Builder;
import lombok.Data;
import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.model.enuns.FormaPagamento;
import org.fundatec.supercevaJa.model.enuns.StatusPedido;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CriarPedidoDTO {

    private String userName;
    private List<CriarCervejaDTO> cervejas;
}
