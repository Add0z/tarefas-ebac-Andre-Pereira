package ds.MOD13.DS.MOD3.estrangulado.controller;


import ds.MOD13.DS.MOD3.estrangulado.entidades.Usuario;
import ds.MOD13.DS.MOD3.estrangulado.service.ServiceUsuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    private final ServiceUsuario serviceUsuario;

    public ControllerUsuario(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping
    public Iterable<Usuario> encontrarTodos(){
        return serviceUsuario.encontrarTodos();
    }
}
