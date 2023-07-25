package org.fundatec.supercevaJa.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UsuarioDTO {

    private long idUsuario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private LocalDate dataNascimento;
    private String userName;
    private String senha;

//    public UsuarioDTO(){
//
//    }
//
//    public UsuarioDTO(long idUsuario, String nome,
//                      String sobrenome, String cpf,
//                      LocalDate dataNascimento,
//                      String userName, String senha) {
//        this.idUsuario = idUsuario;
//        this.nome = nome;
//        this.sobrenome = sobrenome;
//        this.cpf = cpf;
//        this.dataNascimento = dataNascimento;
//        this.userName = userName;
//        this.senha = senha;
//    }

}
