package org.fundatec.supercevaJa;

import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.Pedido;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.model.enuns.FormaPagamento;
import org.fundatec.supercevaJa.model.enuns.StatusPedido;
import org.fundatec.supercevaJa.model.enuns.TipoCerveja;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SuperCevaJaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperCevaJaApplication.class, args);
    }
}
