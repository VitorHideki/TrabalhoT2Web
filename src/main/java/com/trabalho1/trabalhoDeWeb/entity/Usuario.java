package com.trabalho1.trabalhoDeWeb.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Entity
@Table(name = "TB_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Usuario {

        private static final long serialVersionUID = 1L;
        @Id
        @JoinColumn(name = "PES_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "USU_ISADMIN", nullable = false)
        private boolean isAdmin;

        @Column(unique = true, name = "USU_LOGIN")
        private String login;


        @Column(name = "USU_SENHA")
        private String senha;

    public Usuario(Long id){
            this.id = id;
        }

        public Usuario() {

        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
