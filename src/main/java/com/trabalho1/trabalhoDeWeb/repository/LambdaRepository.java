package com.trabalho1.trabalhoDeWeb.repository;

import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.enums.Situacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LambdaRepository {

    @Autowired
    private LambdaRepository lambdaRepository;

    private List<Pessoa> pessoaList;
    private List<Produto> produtoList;

//    public LambdaRepository(){
//        this.pessoaList = Arrays.asList(
//                Pessoa.builder().id(1L).idResponsavel(0L).apelido("José").situacao(Situacao.ATIVO).nome("Jose Faria Lima")
//        );
//    }
//
//    public List<Pessoa> findAll(){
//        return pessoaList;
//    }

}
