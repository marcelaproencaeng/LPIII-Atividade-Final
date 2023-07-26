package org.fundatec.supercevaJa.service;

import org.fundatec.supercevaJa.dto.*;
import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.Pedido;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.repository.CervejaRepository;
import org.fundatec.supercevaJa.repository.PedidoRepository;
import org.fundatec.supercevaJa.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final CervejaRepository cervejaRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         CervejaRepository cervejaRepository,
                         UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.cervejaRepository = cervejaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public BigDecimal adicionarPedido(CriarPedidoDTO criarPedidoDTO) {
        Usuario usuario = usuarioRepository.findByUserName(criarPedidoDTO.getUserName());
        if (usuario.isMaiorDeIdade() == false && usuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Pedido inválido" + usuario.getIdUsuario() +
                            "usuário menor de idade e/ou não cadastrado");
        }

//        Pedido pedido = pedidoRepository.findById(pedidoDTO.getIdPedido());
//        if (pedido == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    "Pedido inexistente" + pedido.getIdPedido() + "Não há id do pedido");
//        }

        Pedido novoPedido = new Pedido();
        novoPedido.setUsuario(usuario);

        List<Cerveja> cervejasDoPedido = new ArrayList<Cerveja>();
        List<CriarCervejaDTO> listaCervejasDTO = criarPedidoDTO.getCervejas();
        for (CriarCervejaDTO criarCervejaDTO : listaCervejasDTO) {
            Cerveja cerveja = new Cerveja();
            cerveja.setQuantidade(criarCervejaDTO.getQuantidade());
            cerveja.setValor(criarCervejaDTO.getValor());
            cervejasDoPedido.add(cerveja);
            cervejaRepository.save(cerveja);
        }
        novoPedido.setCervejas(cervejasDoPedido);

        pedidoRepository.save(novoPedido);

        if (novoPedido.getCervejas().size() <= 10) {
            BigDecimal valorTotalDoPedido = calcularValorTotal(novoPedido);
            pedidoRepository.save(novoPedido);
            return valorTotalDoPedido;
        }

        if (novoPedido.getCervejas().size() >= 10) {
            BigDecimal valorTotalDoPedido = calcularValorTotal(novoPedido);
            BigDecimal valorTotalDoPedidoComDesconto = BigDecimal.ZERO;
            valorTotalDoPedidoComDesconto = valorTotalDoPedido
                    .subtract(valorTotalDoPedido.multiply(new BigDecimal(0.1)));
            pedidoRepository.save(novoPedido);
            return valorTotalDoPedido;
        }

//        if (pedido.getCervejas().size() >= 10 && temperatura <= 22) {
//            long temperatura;
//            BigDecimal valorTotalDoPedido = pedido.calcularValorTotal();
//            BigDecimal valorTotalDoPedidoComDesconto = BigDecimal.ZERO;
//            BigDecimal descontoComTemperatura = valorTotalDoPedidoComDesconto
//                    .subtract(valorTotalDoPedidoComDesconto.multiply(new BigDecimal(0.15)));
//            valorTotalDoPedidoComDesconto = valorTotalDoPedido
//                    .subtract(valorTotalDoPedido.multiply(new BigDecimal(0.1)));
//            ResponseEntity.status(HttpStatus.OK).build();
//        pedidoRepository.save(pedido);
//        return pedido.calcularValorTotal();
//
//        }
//        if (pedido.getCervejas().size() <= 10 && temperatura > 22) {
//            long temperatura;
//            BigDecimal valorTotalDoPedido = pedido.calcularValorTotal();
//
//            ResponseEntity.status(HttpStatus.OK).build();
//        pedidoRepository.save(pedido);
//        return pedido.calcularValorTotal();

//        }
//        if (pedido.getCervejas().size() <= 10 && temperatura <= 22) {
//            long temperatura;
//            Cerveja cerveja = new Cerveja();
//            cerveja.setQuantidade(cervejaDTO.getQuantidade());
//            cerveja.setValor(cervejaDTO.getValor());
//            BigDecimal valorTotalDoPedido = pedido.calcularValorTotal();
//            BigDecimal descontoComTemperatura = valorTotalDoPedido.subtract(valorTotalDoPedido
//                    .multiply(new BigDecimal(0.15)));
//            ResponseEntity.status(HttpStatus.OK).build();
//        pedidoRepository.save(pedido);
//        return pedido.calcularValorTotal();
//
//        }
//        return pedido.calcularValorTotal();

        return null;

    }
    private BigDecimal calcularValorTotal(Pedido pedido) {
        // Percorrer a Lista de Cervejas e somar todos os valores
        // A soma desses valores deve ser retornada, representando o valor total do Pedido
        BigDecimal valorTotalPedido = BigDecimal.ZERO;
        for (Cerveja cerveja : pedido.getCervejas()) {
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

