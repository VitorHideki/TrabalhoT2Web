package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.dto.PessoaDTO;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.enums.Tipo;
import com.trabalho1.trabalhoDeWeb.repository.PessoaRepository;
import com.trabalho1.trabalhoDeWeb.repository.ProdutoRepository;
import com.trabalho1.trabalhoDeWeb.repository.UsuarioRepository;
import com.trabalho1.trabalhoDeWeb.service.LoginService;
import com.trabalho1.trabalhoDeWeb.service.PessoaService;
import com.trabalho1.trabalhoDeWeb.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    PessoaService pessoaService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> buscarTodos(@RequestHeader("login") String login, @RequestHeader("senha") String senha) throws Exception {
        loginService.autenticacao(login, senha);
        Usuario usu = usuarioRepository.getUsuario(login);
//        List<Produto> produtos =  produtoService.buscarTodos();
//        Long idUsuario = usu.getId();

        Optional<Pessoa> pessoa = pessoaRepository.findById(usu.getId());
        Pessoa pessoa1 = pessoa.get();
        LocalDate dataHoje = LocalDate.now();
//        LocalDate ano = pessoa1.getDataDeNascimento();


        LocalDate pessoaDataDeNascimento = LocalDate.of(pessoa1.getDataDeNascimento().getYear(), pessoa1.getDataDeNascimento().getMonth(), pessoa1.getDataDeNascimento().getDayOfMonth());
        LocalDate idadePermitidaData = LocalDate.of(dataHoje.getYear(), dataHoje.getMonth(), dataHoje.getDayOfMonth());
        int idade = Period.between(pessoaDataDeNascimento, idadePermitidaData).getYears();
        produtoRepository.findAll().stream().filter(produtoFiltro -> {
            return (produtoFiltro.getIdadePermitida() <= idade);
        }).filter(produto -> {
            if (pessoa1.getTipo().equals(Tipo.FISICA)) {
                System.out.println(produto.getPrecoVendaFisica());

            } else {
                System.out.println(produto.getPrecoVendaJuridica()); }

            return false;
        }).collect(Collectors.toList())

                .forEach(produto1 -> System.out.println(produto1.getId()));

        return new ResponseEntity(produtoService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarPorId(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login, senha);
        Usuario usu = usuarioRepository.getUsuario(login);
//        List<Produto> produtos =  produtoService.buscarTodos();
//        Long idUsuario = usu.getId();

        Optional<Pessoa> pessoa = pessoaRepository.findById(usu.getId());
        Pessoa pessoa1 = pessoa.get();
        LocalDate dataHoje = LocalDate.now();
//        LocalDate ano = pessoa1.getDataDeNascimento();


        LocalDate pessoaDataDeNascimento = LocalDate.of(pessoa1.getDataDeNascimento().getYear(), pessoa1.getDataDeNascimento().getMonth(), pessoa1.getDataDeNascimento().getDayOfMonth());
        LocalDate idadePermitidaData = LocalDate.of(dataHoje.getYear(), dataHoje.getMonth(), dataHoje.getDayOfMonth());
        int idade = Period.between(pessoaDataDeNascimento, idadePermitidaData).getYears();
        produtoRepository.findAll().stream().filter(produtoFiltro -> {
            return (produtoFiltro.getIdadePermitida() <= idade);
        }).filter(produto -> {
            if (pessoa1.getTipo().equals(Tipo.FISICA)) {
                System.out.println(produto.getPrecoVendaFisica());

            } else {
                System.out.println(produto.getPrecoVendaJuridica()); }

            return false;
        }).collect(Collectors.toList());
        return new ResponseEntity(produtoService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> salvar(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @RequestBody Produto body) throws Exception {
        loginService.autenticacao(login, senha);

        return new ResponseEntity(produtoService.salvar(body), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> deletar(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @PathVariable("id") Long id) throws Exception {
        loginService.autenticacao(login, senha);

        produtoService.deletar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity<?> alterar(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @PathVariable("id") Long id,
                                     @RequestBody Produto body) throws Exception {
        loginService.autenticacao(login, senha);

        return new ResponseEntity(produtoService.alterar(body), HttpStatus.ACCEPTED);
    }
}
