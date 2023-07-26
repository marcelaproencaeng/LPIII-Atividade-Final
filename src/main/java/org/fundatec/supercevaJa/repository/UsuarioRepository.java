package org.fundatec.supercevaJa.repository;

import org.fundatec.supercevaJa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUserName(String userName);
    List<Usuario> findAll();

    Usuario findById(long idUsuario);
}
