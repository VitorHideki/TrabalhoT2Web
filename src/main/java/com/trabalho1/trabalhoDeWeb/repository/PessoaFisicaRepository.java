package com.trabalho1.trabalhoDeWeb.repository;


import com.trabalho1.trabalhoDeWeb.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository  extends JpaRepository<PessoaFisica, Long> {
}
