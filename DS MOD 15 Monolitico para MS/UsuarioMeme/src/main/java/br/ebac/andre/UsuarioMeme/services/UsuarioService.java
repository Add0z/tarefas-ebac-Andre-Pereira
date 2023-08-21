package br.ebac.andre.UsuarioMeme.services;


import br.ebac.andre.UsuarioMeme.entities.Usuario;
import br.ebac.andre.UsuarioMeme.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public Usuario novoUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return usuarioRepo.findAll();
    }


    public void deletarUsuario(Long id) {usuarioRepo.deleteById(id);}

    public Usuario buscaUsuario(Long id) {
        return usuarioRepo.findById(id).get();
    }
}
