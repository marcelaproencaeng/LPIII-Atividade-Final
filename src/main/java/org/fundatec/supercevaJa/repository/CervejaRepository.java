package org.fundatec.supercevaJa.repository;

import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.enuns.TipoCerveja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CervejaRepository extends JpaRepository<Cerveja,Long> {
    Cerveja findByTipo(TipoCerveja tipo);

    Cerveja findByNome(String nome);
}
