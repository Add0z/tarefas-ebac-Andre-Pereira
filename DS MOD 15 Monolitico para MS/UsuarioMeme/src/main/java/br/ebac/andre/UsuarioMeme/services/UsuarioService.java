package br.ebac.andre.UsuarioMeme.services;


import br.ebac.andre.UsuarioMeme.entities.Usuario;
import br.ebac.andre.UsuarioMeme.repositories.UsuarioRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioService {

    Logger logger = LogManager.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepo usuarioRepo;

    public Usuario novoUsuario(Usuario usuario) {
        logger.info("\u001B[34mNovo usuario: " + usuario.getNome() + "\u001B[0m");
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        logger.info("\u001B[34mBuscando lista de usuarios: " + usuarioRepo.count() + "\u001B[0m");
        return usuarioRepo.findAll();
    }


    public void deletarUsuario(Long id) {
        logger.info("\u001B[34mDeletando usuario: " + id + "\u001B[0m");
        usuarioRepo.deleteById(id);}

    public Usuario buscaUsuario(Long id) {
        logger.info("\u001B[34mBuscando usuario id: " + id + "\u001B[0m");
        return usuarioRepo.findById(id).get();
    }
}
