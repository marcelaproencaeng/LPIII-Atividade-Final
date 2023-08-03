package org.fundatec.supercevaJa.ctrl;

import org.fundatec.supercevaJa.dto.CervejaDTO;
import org.fundatec.supercevaJa.model.Cerveja;
import org.fundatec.supercevaJa.model.enuns.TipoCerveja;
import org.fundatec.supercevaJa.service.CervejaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1/cervejas/tipos")
@CrossOrigin(origins = "*")
public class CervejaCtrl {
    private final CervejaService cervejaService;

    public CervejaCtrl(CervejaService cervejaService) {
        this.cervejaService = cervejaService;
    }

    @GetMapping
    public ResponseEntity<List<Cerveja>> buscarTodas() {
        List<Cerveja> cerveja = cervejaService.buscarTodas();
//        ResponseEntity.ok(this.cervejaService.buscarTodas());
//        return ResponseEntity.status(HttpStatus.OK).build();
        return ResponseEntity.ok((List<Cerveja>) this.cervejaService.buscarTodas());

    }
//     public ResponseEntity<List<Usuario>> buscarTodos() {
//        return ResponseEntity.ok((List<Usuario>) this.usuarioService.buscarTodos());

    // @PostMapping("/{tipos}")
    @PostMapping
    public ResponseEntity<Cerveja> create(@RequestBody CervejaDTO cervejaDTO) {
        System.out.println("inserindo a cerveja" + cervejaDTO.getIdCerveja());
        Cerveja cerveja = cervejaService.adicionarCerveja(cervejaDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/{nome}")
    public void deletarTipoCervejaPorNome(@PathVariable("nome") String nome) {
        this.cervejaService.deletar(nome);
    }
//    @PutMapping

    @PutMapping("/{tipo}/{valor}")
    public ResponseEntity<Cerveja> AtualizarValorDeCervejaPorTipo(@PathVariable("valor") BigDecimal valor,
                                                                  @PathVariable("tipo") TipoCerveja tipo) {
        this.cervejaService.atualizarValorDeCervejaPorTipo(valor,tipo);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
