package com.trabalho1.trabalhoDeWeb.repository;

import com.trabalho1.trabalhoDeWeb.entity.Pessoa;
import com.trabalho1.trabalhoDeWeb.entity.Produto;
import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query( value = "SELECT UP.id, P.id FROM Usuario UP JOIN Pessoa P ON UP.id = UP.id WHERE UP.id  = P.id")

    Produto findProdutoById(@Param("id")Long id);
    Produto findByIdadePermitida(int idade);

}
