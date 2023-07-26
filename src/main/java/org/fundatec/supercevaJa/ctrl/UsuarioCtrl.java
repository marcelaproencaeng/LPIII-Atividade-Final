package org.fundatec.supercevaJa.ctrl;

import org.fundatec.supercevaJa.dto.UsuarioDTO;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioCtrl {
    private UsuarioService usuarioService;

    public UsuarioCtrl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuarioDTO) {
        System.out.println("Inserindo o usuário:" + usuarioDTO.getUserName());
        Usuario usuario = usuarioService.adicionarUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.ok((List<Usuario>) this.usuarioService.buscarTodos());
    }

    @DeleteMapping("/{userName}")
    public void deletarUsuarioPorUserName(@PathVariable("userName") String userName) {
        this.usuarioService.deletar(userName);
    }

    @PutMapping("/{idUsuario}/{sobrenome}")
    public ResponseEntity<Usuario> atualizarSobrenomeDeUsuarioPorId(@PathVariable("idUsuario") Long idUsuario,
                                                                    @PathVariable("sobrenome") String sobrenome) {
        usuarioService.atualizarSobrenomeDeUsuarioPorId(sobrenome, idUsuario);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
