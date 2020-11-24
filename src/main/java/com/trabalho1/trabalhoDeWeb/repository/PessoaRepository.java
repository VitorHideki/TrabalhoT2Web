package com.trabalho1.trabalhoDeWeb.repository;

import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.trabalho1.trabalhoDeWeb.entity.Pessoa;

@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long> {

}

