package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.entity.ItemPedido;
import com.trabalho1.trabalhoDeWeb.service.ItemPedidoService;
import com.trabalho1.trabalhoDeWeb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/itemPedido")
public class ItemPedidoController {
    @Autowired
    private ItemPedidoService itemPedidoService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos(@RequestHeader("login") String login, @RequestHeader("senha") String senha) throws Exception {
        loginService.autenticacao(login,senha);

        return new ResponseEntity(itemPedidoService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login,senha);

        return new ResponseEntity(itemPedidoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@RequestBody ItemPedido body) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(itemPedidoService.salvar(body), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login,senha);
        itemPedidoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,@PathVariable("id") Long id,
                                     @RequestBody ItemPedido body) throws Exception {
        loginService.autenticacao(login,senha);
        return new ResponseEntity(itemPedidoService.alterar(body), HttpStatus.ACCEPTED);
    }
}
