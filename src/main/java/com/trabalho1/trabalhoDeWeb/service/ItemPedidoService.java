package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.entity.ItemPedido;

import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.enums.Tipo;
import com.trabalho1.trabalhoDeWeb.repository.ItemPedidoRepository;
import com.trabalho1.trabalhoDeWeb.repository.PessoaRepository;
import com.trabalho1.trabalhoDeWeb.repository.ProdutoRepository;
import com.trabalho1.trabalhoDeWeb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PessoaRepository pessoaRepository;


    public List<ItemPedido> buscarTodos() {
        return itemPedidoRepository.findAll();
    }

    public Object buscarPorId(Long id) {
        return itemPedidoRepository.findById(id);
    }

    public ItemPedido salvar(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido alterar(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public void deletar(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public List<Produto> buscaStream(@RequestHeader("login") String login, @RequestHeader("senha") String senha, @RequestParam(name = "descricao", required = false) String descricao, @RequestParam
            (name = "precoMinimo", required = false) double precoMinimo, @RequestParam(name = "precoMaximo", required = false)
                                             double precoMaximo) throws Exception {
        loginService.autenticacao(login, senha);
        Usuario usu = usuarioRepository.getUsuario(login);
        Optional<Pessoa> pessoa2 = pessoaRepository.findById(usu.getId());
        Pessoa pessoa1 = pessoa2.get();
        List<Produto> busca;

        busca = produtoRepository.findAll().stream().
                filter(pessoa -> {
                    if (pessoa1.getTipo().equals(Tipo.FISICA)) {
                        produtoRepository.findAll().stream().filter(produto -> {
                            if (produto.getDescricao().contains(descricao)) {
                                return false;
                            } else {
                                return true;
                            }
                        }).filter(produto -> {

                            if (precoMinimo <= produto.getPrecoVendaFisica()) {
                                return false;
                            }else {
                                return true;
                            }
                        }).filter(produto -> {
                            if (precoMaximo >= produto.getPrecoVendaFisica()) {
                                return false;
                            } else {
                                return true;
                            }
                        }).collect(Collectors.toList());
                    } else {
                        produtoRepository.findAll().stream().filter(produto -> {
                            if (produto.getDescricao().contains(descricao)) {
                                return false;
                            } else{return true;}
                        }).filter(produto -> {
                            if (precoMinimo <= produto.getPrecoVendaJuridica()) {
                                return false;
                            }
                            return true;
                        }).filter(produto -> {
                            if (precoMaximo >= produto.getPrecoVendaJuridica()) {
                                return false;
                            } else {
                                return true;
                            }
                        }).collect(Collectors.toList());
                        return true;
                    }
                    return true;
                }).collect(Collectors.toList());
        return busca;
    }


}
