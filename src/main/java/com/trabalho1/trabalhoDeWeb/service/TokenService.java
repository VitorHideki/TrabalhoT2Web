package com.trabalho1.trabalhoDeWeb.service;

import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class TokenService {


    private String key = "String aleatoria";

    private static final long expiritationTime = 18000000;
    public String  generateToken(Usuario usuario){
        return Jwts.builder().setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject("Teste JWP")
                .setExpiration(new Date(System.currentTimeMillis()+ expiritationTime))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
