package org.fundatec.supercevaJa.ctrl;

import jakarta.websocket.server.PathParam;
import org.fundatec.supercevaJa.dto.CervejaDTO;
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

    @PostMapping("/{idUsuario}")
    public ResponseEntity<Pedido> create(@RequestBody PedidoDTO pedidoDTO,
                                         @PathVariable("usuarioDTO") UsuarioDTO usuarioDTO,
                                         @PathParam("cervejaDTO") CervejaDTO cervejaDTO,
                                         @PathVariable("idUsuario") long idUsuario) {
        BigDecimal pedido = pedidoService.adicionarPedido(usuarioDTO,pedidoDTO,cervejaDTO,idUsuario);
        return ResponseEntity.status(HttpStatus.OK).build();
//          return ResponseEntity.status(HttpStatus.FOUND).body(tarifaService.calcularTarifa(idVeiculo,
//                tarifa.getSaida()));
//         @PostMapping
//    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuarioDTO) {
//        System.out.println("Inserindo o usuário:" + usuarioDTO.getUserName());
//        Usuario usuario = usuarioService.adicionarUsuario(usuarioDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
