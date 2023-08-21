package br.ebac.andre.UsuarioMeme.controllers;


import br.ebac.andre.UsuarioMeme.entities.Usuario;
import br.ebac.andre.UsuarioMeme.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> buscaUsuarios() {
        return usuarioService.listaTodosUsuarios();
    }

    @GetMapping("/usuarios/id={id}")
    public Usuario buscaUsuario(@PathVariable Long id) {
        return usuarioService.buscaUsuario(id);
    }

    @PostMapping("/novoUsuario")
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return usuarioService.novoUsuario(usuario);
    }

    @DeleteMapping("/usuarios/del/id={id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
    }


}
