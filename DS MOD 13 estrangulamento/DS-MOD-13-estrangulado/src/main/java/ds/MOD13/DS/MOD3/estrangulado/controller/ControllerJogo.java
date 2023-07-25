package ds.MOD13.DS.MOD3.estrangulado.controller;


import ds.MOD13.DS.MOD3.estrangulado.entidades.Jogo;
import ds.MOD13.DS.MOD3.estrangulado.service.ServiceJogo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jogos")
public class ControllerJogo {

    private final ServiceJogo serviceJogo;

    public ControllerJogo(ServiceJogo serviceJogo) {
        this.serviceJogo = serviceJogo;
    }

    @GetMapping
    public Iterable<Jogo> encontrarTodos(){
        return serviceJogo.encontrarTodos();
    }

}
