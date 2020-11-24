package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.repository.LambdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

@Service
public class LambdaService {

    @Autowired
    private LambdaRepository lambdaRepository;
//
//    public List<Pessoa> findPessoa(String genero){
//        Mostrador mostrador = new Mostrador();
//       lambdaRepository.findAll().stream()
//       .filter(pessoa -> {
//           return pessoa.getNome().equals(genero);
//       })
//               .forEach(pessoa -> System.out.println(pessoa.getNome()));
//       return null;
//    }
//
//    class Mostrador implements Consumer<Pessoa> {
//        public void accept(Pessoa u){
//            System.out.println(u.getNome());
//        }
//    }

}
