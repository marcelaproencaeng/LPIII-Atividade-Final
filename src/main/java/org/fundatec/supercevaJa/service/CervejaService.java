package org.fundatec.supercevaJa.service;

import org.fundatec.supercevaJa.dto.CervejaDTO;
import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.model.enuns.TipoCerveja;
import org.fundatec.supercevaJa.repository.CervejaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CervejaService {
    private final CervejaRepository cervejaRepository;

    public CervejaService(CervejaRepository cervejaRepository) {
        this.cervejaRepository = cervejaRepository;
    }

    public List<Cerveja> buscarTodas() {
        return cervejaRepository.findAll();
    }

    public Cerveja adicionarCerveja(CervejaDTO cervejaDTO) {
        Cerveja cervejaASerAdicionada = new Cerveja();
        cervejaASerAdicionada.setIdCerveja(cervejaDTO.getIdCerveja());
        cervejaASerAdicionada.setNome(cervejaDTO.getNome());
        cervejaASerAdicionada.setValor(cervejaDTO.getValor());
        cervejaASerAdicionada.setTipo(cervejaDTO.getTipo());
        cervejaASerAdicionada.setVolume(cervejaDTO.getVolume());
        cervejaASerAdicionada.setQuantidade(cervejaDTO.getQuantidade());
        Cerveja cerveja = findByTipo(cervejaASerAdicionada.getTipo());
        if (cerveja != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cerveja" + cerveja.getTipo() + "já existe!");
        }
        cervejaRepository.save(cervejaASerAdicionada);
        return cervejaASerAdicionada;
    }

    private Cerveja findByTipo(TipoCerveja tipo) {
        return cervejaRepository.findByTipo(tipo);
    }

    public void deletar(String nome) {
        Cerveja tipoCervejaParaRemover = findByNome(nome);
        if (tipoCervejaParaRemover == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover um tipo de cerveja por nome inexistente");
        }
        cervejaRepository.delete(tipoCervejaParaRemover);
    }

    private Cerveja findByNome(String nome) {
        return cervejaRepository.findByNome(nome);
    }

    public Cerveja atualizarValorDeCervejaPorTipo(BigDecimal novoValor, TipoCerveja tipo) {
        Optional<Cerveja> cervejaOptional = Optional.ofNullable(cervejaRepository.findByTipo(tipo));
        if (cervejaOptional.isPresent()) {
            Cerveja cerveja = cervejaOptional.get();
            cerveja.setValor(novoValor);
            return cervejaRepository.save(cerveja);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Cerveja não encontrada por tipo" + tipo);
        }
    }


}
