package org.fundatec.supercevaJa.dto;

import lombok.Data;
import org.fundatec.supercevaJa.model.enuns.TipoCerveja;

import java.math.BigDecimal;

@Data
public class CervejaDTO {

    private long idCerveja;
    private String nome;
    private double teorAlcoolico;
    private int volume;
    private TipoCerveja tipo;
    private BigDecimal valor;
    private int quantidade;
}
