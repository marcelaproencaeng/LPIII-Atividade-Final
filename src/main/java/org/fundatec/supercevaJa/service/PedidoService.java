package org.fundatec.supercevaJa.service;

import org.fundatec.supercevaJa.dto.CervejaDTO;
import org.fundatec.supercevaJa.dto.PedidoDTO;
import org.fundatec.supercevaJa.dto.UsuarioDTO;
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

    public BigDecimal adicionarPedido(UsuarioDTO usuarioDTO, PedidoDTO pedidoDTO,
                                      CervejaDTO cervejaDTO, long idUsuario) {


        Usuario usuario = usuarioRepository.pesquisar(idUsuario);
        if (usuario.isMaiorDeIdade() == false && usuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Pedido inválido" + usuario.getIdUsuario() +
                            "usuário menor de idade e/ou não cadastrado");
        }

        Pedido pedido = pedidoRepository.pesquisar(pedidoDTO.getIdPedido());
        if (pedido == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Pedido inexistente" + pedido.getIdPedido() + "Não há id do pedido");
        }

        Pedido pedido1 = new Pedido();
        pedido1.calcularValorTotal();
        pedido1.setUsuario(pedidoDTO.getUsuario());
        pedido1.setCervejas(pedidoDTO.getCervejas());
        pedidoRepository.save(pedido1);
        return pedido1.calcularValorTotal();


        Cerveja cerveja = new Cerveja();
        cerveja.setTipo(cervejaDTO.getTipo());
        cerveja.setQuantidade(cervejaDTO.getQuantidade());
        cerveja.setValor(cervejaDTO.getValor());
        cervejaRepository.save(cerveja);


        Usuario usuario1 = new Usuario();
        usuario1.setUserName(usuarioDTO.getUserName());
        usuarioRepository.save(usuario1);


        if (pedido1.getCervejas().size() <= 10) {

            Cerveja cerveja1 = new Cerveja();
            cerveja1.setTipo(cervejaDTO.getTipo());
            cerveja1.setQuantidade(cervejaDTO.getQuantidade());
            cerveja1.setValor(cervejaDTO.getValor());
            cervejaRepository.save(cerveja1);
            BigDecimal valorTotalDoPedido = pedido.calcularValorTotal();
            ResponseEntity.status(HttpStatus.OK).build();
            pedidoRepository.save(pedido1);
            return pedido.calcularValorTotal();

        }

        if (pedido1.getCervejas().size() >= 10) {

            pedido1.setCervejas(pedidoDTO.getCervejas());
            Usuario usuario2 = new Usuario();
            usuario2.setUserName(usuario.getUserName());
            usuarioRepository.save(usuario2);
            Cerveja cerveja3 = new Cerveja();
            cerveja3.setQuantidade(cervejaDTO.getQuantidade());
            cerveja3.setTipo(cervejaDTO.getTipo());
            cerveja3.setValor(cervejaDTO.getValor());
            cervejaRepository.save(cerveja3);
            BigDecimal valorTotalDoPedido = pedido.calcularValorTotal();
            BigDecimal valorTotalDoPedidoComDesconto = BigDecimal.ZERO;
            valorTotalDoPedidoComDesconto = valorTotalDoPedido
                    .subtract(valorTotalDoPedido.multiply(new BigDecimal(0.1)));
            pedidoRepository.save(pedido1);
            return pedido.calcularValorTotal();

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
        pedidoRepository.save(pedido);
        return pedido.calcularValorTotal();
//
//        }
//        if (pedido.getCervejas().size() <= 10 && temperatura > 22) {
//            long temperatura;
//            BigDecimal valorTotalDoPedido = pedido.calcularValorTotal();
//
//            ResponseEntity.status(HttpStatus.OK).build();
        pedidoRepository.save(pedido);
        return pedido.calcularValorTotal();

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
        pedidoRepository.save(pedido);
        return pedido.calcularValorTotal();
//
//        }
        return pedido.calcularValorTotal();
    }

}

