package org.fundatec.supercevaJa.repository;

import org.fundatec.supercevaJa.dto.UsuarioDTO;
import org.fundatec.supercevaJa.model.Pedido;
import org.fundatec.supercevaJa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    Pedido calcularPedido(Pedido pedido);


    Pedido pesquisar(long idPedido);
}
