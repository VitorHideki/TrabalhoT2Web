package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.dto.PessoaDTO;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;

import com.trabalho1.trabalhoDeWeb.enums.Situacao;
import com.trabalho1.trabalhoDeWeb.enums.Tipo;
import com.trabalho1.trabalhoDeWeb.repository.PessoaRepository;
import com.trabalho1.trabalhoDeWeb.service.LoginService;
import com.trabalho1.trabalhoDeWeb.service.PessoaService;
import com.trabalho1.trabalhoDeWeb.service.UsuarioService;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/pessoa")

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PessoaRepository pessoaRepository;

//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<?> buscarTodos(@RequestHeader("login") String login, @RequestHeader("senha") String senha) throws Exception {
//        loginService.autenticacao(login, senha);
//        return new ResponseEntity(pessoaService.buscarTodos(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login, senha);
        return new ResponseEntity(pessoaService.buscarPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login, senha);
        pessoaService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @RequestBody PessoaDTO pessoaDto) throws Exception {
        if (!usuarioService.buscarTodos().isEmpty()) {
            loginService.autenticacao(login, senha);
        }
        if (pessoaService.calcularIdade(pessoaDto) < 18 && Tipo.FISICA.equals(pessoaDto.getTipo())) {
            return new ResponseEntity(pessoaService.salvarPessoaFisicaMenorDeIdade(pessoaDto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity(pessoaService.salvar(pessoaDto), HttpStatus.CREATED);
        }
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarStream(@RequestHeader("login") String login,
                                          @RequestHeader("senha") String senha,
                                          @RequestParam(value = "idResponsavel", required = false) Long idResponsavel,
                                          @RequestParam(value = "nomeResponsavel", required = false) String nomeResponsavel,
                                          @RequestParam(value = "tipo", required = false) Tipo tipo,
                                          @RequestParam(value = "situacao", required = false) Situacao situacao) throws Exception {
        loginService.autenticacao(login, senha);
        return new ResponseEntity(pessoaService.buscaStream(idResponsavel,nomeResponsavel,tipo,situacao),HttpStatus.OK);
    }


    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @PathVariable("id") Long id,
                                     @RequestBody Pessoa body) throws Exception {
        loginService.autenticacao(login, senha);
        return new ResponseEntity(pessoaService.alterar(body), HttpStatus.ACCEPTED);
    }


}
