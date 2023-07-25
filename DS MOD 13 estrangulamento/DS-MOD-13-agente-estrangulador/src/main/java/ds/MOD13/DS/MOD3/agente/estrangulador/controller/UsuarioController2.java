package ds.MOD13.DS.MOD3.agente.estrangulador.controller;


import ds.MOD13.DS.MOD3.agente.estrangulador.entidades.Usuario2;
import ds.MOD13.DS.MOD3.agente.estrangulador.service.ServiceUsu2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario2")
public class UsuarioController2 {

    private final ServiceUsu2 usuarioService;

    public UsuarioController2(ServiceUsu2 usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public Iterable<Usuario2> encontrarUsuarios(){
        return usuarioService.encontrarUsuarios();
    }

}
