package org.fundatec.supercevaJa.ctrl;

import jakarta.websocket.server.PathParam;
import org.fundatec.supercevaJa.dto.CervejaDTO;
import org.fundatec.supercevaJa.dto.CriarPedidoDTO;
import org.fundatec.supercevaJa.dto.PedidoDTO;
import org.fundatec.supercevaJa.dto.UsuarioDTO;
import org.fundatec.supercevaJa.model.Pedido;
import org.fundatec.supercevaJa.service.PedidoService;
import org.fundatec.supercevaJa.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/pedidos")
@CrossOrigin(origins = "*")
public class PedidoCtrl {
    private final PedidoService pedidoService;
    private final UsuarioService usuarioService;

    public PedidoCtrl(PedidoService pedidoService, UsuarioService usuarioService) {
        this.pedidoService = pedidoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CriarPedidoDTO criarPedidoDTO) {
        BigDecimal valorTotalPedido = pedidoService.adicionarPedido(criarPedidoDTO);
        return ResponseEntity.ok("Valor total do pedido: R$" + valorTotalPedido);
    }

}
