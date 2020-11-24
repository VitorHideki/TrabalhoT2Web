package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.entity.Pedido;

import com.trabalho1.trabalhoDeWeb.service.LoginService;
import com.trabalho1.trabalhoDeWeb.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private LoginService loginService;
    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos(@RequestHeader("login") String login, @RequestHeader("senha") String senha) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(pedidoService.buscarTodos(login,senha), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(pedidoService.buscarPorId(login,senha,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login,senha);
        pedidoService.deletar(login,senha,id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@RequestBody Pedido pedido) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(pedidoService.salvar(login,senha,pedido), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id,
                                     @RequestBody Pedido body) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(pedidoService.alterar(login,senha,body), HttpStatus.ACCEPTED);
    }

}
