package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.dto.LoginDTO;
import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class LoginService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    private Object Exception;

    public Usuario autenticacao(String login, String senha) throws Exception {
        Usuario usuario = usuarioRepository.getUsuario(login);
        if (senha.equals(usuario.getSenha())) {
            return usuario;
        } else {
            throw new Exception();
        }

    }
}