package org.fundatec.supercevaJa.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;


@Entity
@Table(name = "tb_usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idUsuario;
    @Column(length = 100, name = "Nome")
    private String nome;
    @Column(length = 100, name = "Sobrenome")
    private String sobrenome;
    @Column(length = 11, name = "cpf", unique = true)
    private String cpf;
    @Column
    private LocalDate dataNascimento;
    @Column
    private String userName;
    @Column
    private String senha;

    public Usuario() {

    }

    public Usuario(long idUsuario, String nome, String sobrenome,
                   String cpf, LocalDate dataNascimento, String userName, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.userName = userName;
        this.senha = senha;
    }

    public boolean isMaiorDeIdade() {
        int anoNascimento = dataNascimento.getYear();
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual - anoNascimento;
        if (idade <= 18){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Menores de  18 anos não podem realizar pedido");
        }
        return true;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Usuario usuario = (Usuario) o;
//        return idUsuario.equals(usuario.idUsuario);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idUsuario);
//    }
//
//    @Override
//    public String toString() {
//        return "Usuario{" +
//                "idUsuario=" + idUsuario +
//                ", nome='" + nome + '\'' +
//                ", sobrenome='" + sobrenome + '\'' +
//                ", cpf='" + cpf + '\'' +
//                ", dataNascimento=" + dataNascimento +
//                ", userName='" + userName + '\'' +
//                ", senha='" + senha + '\'' +
//                '}';
//    }
}
