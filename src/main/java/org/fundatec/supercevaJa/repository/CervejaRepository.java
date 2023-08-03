package org.fundatec.supercevaJa.repository;

import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.model.enuns.TipoCerveja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CervejaRepository extends JpaRepository<Cerveja,Long> {
    Cerveja findByTipo(TipoCerveja tipo);

    List<Cerveja> findAll();

    Cerveja findByNome(String nome);
}
