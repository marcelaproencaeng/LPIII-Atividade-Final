package org.fundatec.supercevaJa.dto;

import lombok.Builder;
import lombok.Data;
import org.fundatec.supercevaJa.model.enuns.FormaPagamento;
import org.fundatec.supercevaJa.model.enuns.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class CriarCervejaDTO {

    private String nome;
    private int quantidade;
    private BigDecimal valor;
}
