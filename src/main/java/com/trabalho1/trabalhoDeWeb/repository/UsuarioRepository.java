package com.trabalho1.trabalhoDeWeb.repository;

import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    @Query("select distinct u from Usuario as u where u.login like :login")
    Usuario getUsuario(@Param("login") String login);

}
