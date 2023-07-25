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


        Usuario usuario = new Usuario(
                1,
                "Maria",
                "Medeiros",
                "98838310542",
                LocalDate.of(1988, 10, 12),
                "maria.medeiros",
                "12345");
        Usuario usuario1 = new Usuario(
                2,
                "Bruno",
                "Dias",
                "89738942217",
                LocalDate.of(1999, 8, 12),
                "bruno.dias",
                "23456");
        Usuario usuario2 = new Usuario(
                3,
                "Lorena",
                "Stein",
                "89088812012",
                LocalDate.of(2000, 6, 3),
                "lorena.stein",
                "23455");
        Usuario usuario3 = new Usuario(
                4,
                "Marta",
                "Balis",
                "59085612332",
                LocalDate.of(2004, 9, 15),
                "marta.balis",
                "26755");
        Usuario usuario4 = new Usuario(
                5,
                "Renato",
                "Castro",
                "87685992387",
                LocalDate.of(2006, 5, 12),
                "renato.castro",
                "26754");
        Usuario usuario5 = new Usuario(
                6,
                "Melissa",
                "Cardoso",
                "98765992300",
                LocalDate.of(2007, 4, 10),
                "melissa.cardoso",
                "33754");
        Cerveja cerveja = new Cerveja(
                1,
                "ALBANOS IRISH DRY STOUT",
                4.0,
                600,
                TipoCerveja.STOUT,
                new BigDecimal(20),
                6);
        Cerveja cerveja1 = new Cerveja(
                4,
                "JAPAS WASABIRU APA",
                6.0,
                310,
                TipoCerveja.APA,
                new BigDecimal(26),
                5);
        Cerveja cerveja2 = new Cerveja(
                5,
                "BOCK BIERBAUM",
                7.0,
                600,
                TipoCerveja.BOCK,
                new BigDecimal(19),
                4);

        Cerveja cerveja3 = new Cerveja(
                7,
                "AMSTEL",
                5.0,
                350,
                TipoCerveja.LAGER,
                new BigDecimal(15),
                3);
//        VALUES (1,'OPA BIER PILSEN', 5.00, 1,'PILSEN',10.00,1);
        Cerveja cerveja4 = new Cerveja(
                1,
                "BIER PILSEN",
                5.0,
                1,
                TipoCerveja.PILSEN,
                new BigDecimal(10),
                1);

//                (2,'OPA BIER WEIZEN', 6.00, 250,'WEISS',12.00,2);
        Cerveja cerveja5 = new Cerveja(
                2,
                "OPA BIER WEIZEN",
                6.0,
                250,
                TipoCerveja.WEISS,
                new BigDecimal(12),
                2);
//        VALUES (6,'ALBANOS AMERICAN IPA',6.00 ,250,'IPA',12.00,5);
        Cerveja cerveja6 = new Cerveja(
                6,
                "ALBANOS AMERICAN IPA",
                6.0,
                250,
                TipoCerveja.IPA,
                new BigDecimal(12),
                5);
        Pedido pedido1 = new Pedido(
                1,
                usuario,
                Arrays.asList(cerveja, cerveja1),
                LocalDate.of(2023, 7, 7),
                StatusPedido.ACEITO,
                FormaPagamento.CARTAO);
        Pedido pedido2 = new Pedido(
                2,
                usuario1,
                Arrays.asList(cerveja, cerveja1),
                LocalDate.of(2023, 7, 10),
                StatusPedido.CRIADO,
                FormaPagamento.PIX);
        Pedido pedido3 = new Pedido(
                3,
                usuario2,
                Arrays.asList(cerveja, cerveja1),
                LocalDate.of(2023, 7, 20),
                StatusPedido.A_CAMINHO,
                FormaPagamento.DINHEIRO);
        Pedido pedido4 = new Pedido(
                3,
                usuario3,
                Arrays.asList(cerveja, cerveja1),
                LocalDate.of(2023, 7, 23),
                StatusPedido.DISPONIVEL_PARA_RETIRADA,
                FormaPagamento.PIX);
        Pedido pedido5 = new Pedido(
                3,
                usuario4,
                Arrays.asList(cerveja, cerveja1),
                LocalDate.of(2023, 7, 24),
                StatusPedido.ENTREGUE,
                FormaPagamento.CARTAO);
        Pedido pedido6 = new Pedido(
                3,
                usuario5,
                Arrays.asList(cerveja, cerveja3),
                LocalDate.of(2023, 7, 25),
                StatusPedido.EM_PREPARO,
                FormaPagamento.CARTAO);

        pedido1.calcularValorTotal();
        pedido1.getCervejas();
        pedido1.getUsuario();

        pedido2.calcularValorTotal();
        pedido2.getCervejas();
        pedido2.getUsuario();

        pedido3.calcularValorTotal();
        pedido3.getUsuario();
        pedido3.getCervejas();

        pedido4.getCervejas();
        pedido4.getUsuario();
        pedido4.calcularValorTotal();

        pedido5.getUsuario();
        pedido5.getCervejas();
        pedido5.calcularValorTotal();

        pedido6.getUsuario();
        pedido6.getUsuario();
        pedido6.calcularValorTotal();
    }
}
