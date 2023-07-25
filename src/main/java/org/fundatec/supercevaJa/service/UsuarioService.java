package org.fundatec.supercevaJa.service;

import org.fundatec.supercevaJa.dto.UsuarioDTO;
import org.fundatec.supercevaJa.model.Usuario;
import org.fundatec.supercevaJa.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario adicionarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioASerAdicionado = new Usuario();
        usuarioASerAdicionado.setUserName(usuarioDTO.getUserName());
        usuarioASerAdicionado.setCpf(usuarioDTO.getCpf());
        usuarioASerAdicionado.setNome(usuarioDTO.getNome());
        usuarioASerAdicionado.setDataNascimento(usuarioDTO.getDataNascimento());
        usuarioASerAdicionado.setSobrenome(usuarioDTO.getSobrenome());
        usuarioASerAdicionado.setSenha(usuarioDTO.getSenha());

        Usuario usuario = findByUsername(usuarioASerAdicionado.getUserName());
        if (usuario != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Usuário" + usuario.getUserName() + "Já existe");
        }
        return usuarioRepository.save(usuarioASerAdicionado);
    }

    public Usuario findByUsername(String userName) {
        return usuarioRepository.findByUserName(userName);
    }
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
    public void deletar(String userName) {
        Usuario usuarioParaRemover = findByUsername(userName);
        if (usuarioParaRemover == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Não é possível remover usuário inexistente");
        }
        usuarioRepository.delete(usuarioParaRemover);
    }

    public Usuario atualizarSobrenomeDeUsuarioPorId(String novoSobrenome,Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        if(usuarioOptional.isPresent()){
            Usuario usuario=usuarioOptional.get();
            usuario.setSobrenome(novoSobrenome);
            return usuarioRepository.save(usuario);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Usuário não encontrado com o id"+idUsuario);
        }
    }
}
