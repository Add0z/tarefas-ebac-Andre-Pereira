package ds.MOD13.DS.MOD3.estrangulado.controller;


import ds.MOD13.DS.MOD3.estrangulado.entidades.Usuario;
import ds.MOD13.DS.MOD3.estrangulado.service.ServiceUsuario;
import ds.MOD13.DS.MOD3.estrangulado.service.ServicoNovoUsuario;
import ds.MOD13.DS.MOD3.estrangulado.vo.UsuarioVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {


    private final ServicoNovoUsuario servicoNovoUsuario;

    public ControllerUsuario( ServicoNovoUsuario servicoNovoUsuario) {

        this.servicoNovoUsuario = servicoNovoUsuario;
    }

    @GetMapping
    public Iterable<UsuarioVO> encontrarTodos(){
        return servicoNovoUsuario.encontrarTodos();
    }

    @PostMapping
    public UsuarioVO criarUsuario(@RequestBody UsuarioVO usuario){


        return servicoNovoUsuario.criarNovoUsuario(usuario);
    }


}
