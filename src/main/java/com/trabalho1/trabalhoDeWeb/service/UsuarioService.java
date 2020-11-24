package com.trabalho1.trabalhoDeWeb.service;


import com.trabalho1.trabalhoDeWeb.entity.Usuario;
import com.trabalho1.trabalhoDeWeb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Object buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario produto) {
        return usuarioRepository.save(produto);
    }

    public Usuario alterar(Usuario produto) {
        return usuarioRepository.save(produto);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
