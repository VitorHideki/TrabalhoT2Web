package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.service.LoginService;
import com.trabalho1.trabalhoDeWeb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos(@RequestHeader("login") String login, @RequestHeader("senha") String senha) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(usuarioService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(usuarioService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login,senha);
        usuarioService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@RequestBody Usuario usuariobody) throws Exception {
        if (usuarioService.buscarTodos().isEmpty()){
            return new ResponseEntity(usuarioService.salvar(usuariobody), HttpStatus.CREATED);
        }else {
            loginService.autenticacao(login,senha);
            return new ResponseEntity(usuarioService.salvar(usuariobody), HttpStatus.CREATED);
        }
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id,
                                     @RequestBody Usuario body) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(usuarioService.alterar(body), HttpStatus.ACCEPTED);
    }
}
