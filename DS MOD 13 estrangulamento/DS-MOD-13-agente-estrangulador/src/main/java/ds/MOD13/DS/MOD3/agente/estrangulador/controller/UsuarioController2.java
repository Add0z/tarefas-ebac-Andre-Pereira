package ds.MOD13.DS.MOD3.agente.estrangulador.controller;


import ds.MOD13.DS.MOD3.agente.estrangulador.entidades.Usuario2;
import ds.MOD13.DS.MOD3.agente.estrangulador.service.ServiceUsu2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController2 {

    private final ServiceUsu2 usuarioService;

    public UsuarioController2(ServiceUsu2 usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public Iterable<Usuario2> encontrarUsuarios(){
        return usuarioService.encontrarUsuarios();
    }

    @PostMapping
    public Usuario2 criarUsuario(@RequestBody Usuario2 usuario){
        return usuarioService.criarUsuario(usuario);
    }

}
