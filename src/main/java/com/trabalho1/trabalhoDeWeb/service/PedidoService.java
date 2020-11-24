package com.trabalho1.trabalhoDeWeb.service;


import com.trabalho1.trabalhoDeWeb.entity.Pedido;
import com.trabalho1.trabalhoDeWeb.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private LoginService loginService;


    public Pedido buscar(@RequestHeader("login") String login, @RequestHeader("senha") String senha, Long id) throws Exception {
        loginService.autenticacao(login,senha);

        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        return pedidoOptional.orElse(null);
    }


    public List<Pedido> buscarTodos(@RequestHeader("login") String login, @RequestHeader("senha") String senha) throws Exception {
        loginService.autenticacao(login,senha);
        return pedidoRepository.findAll();
    }


    public Object buscarPorId(@RequestHeader("login") String login, @RequestHeader("senha") String senha,Long id) throws Exception {
        loginService.autenticacao(login,senha);

        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }


    public Pedido salvar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,Pedido pedido) throws Exception {
        loginService.autenticacao(login,senha);
        return pedidoRepository.save(pedido);
    }


    public Pedido alterar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,Pedido pedido) throws Exception {
        loginService.autenticacao(login,senha);
        return pedidoRepository.save(pedido);
    }
    public void deletar(@RequestHeader("login") String login, @RequestHeader("senha") String senha,Long id) throws Exception {
        loginService.autenticacao(login,senha);
        pedidoRepository.deleteById(id);
    }
}
