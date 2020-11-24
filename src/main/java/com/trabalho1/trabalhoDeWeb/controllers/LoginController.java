package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<Usuario> autenticar(@RequestBody String login,String senha) throws Exception {
        Usuario usuario = loginService.autenticacao(login, senha);
        return new ResponseEntity<Usuario>(HttpStatus.OK);
    }
}
