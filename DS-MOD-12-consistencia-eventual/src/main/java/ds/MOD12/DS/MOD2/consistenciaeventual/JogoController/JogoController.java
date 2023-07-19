package ds.MOD12.DS.MOD2.consistenciaeventual.JogoController;


import ds.MOD12.DS.MOD2.consistenciaeventual.jogoService.JogoServ;
import ds.MOD12.DS.MOD2.consistenciaeventual.modelo.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/jogos")
public class JogoController {

    @Autowired
    private JogoServ jogoServ;

    @PostMapping
    public Jogo salvar(@RequestBody Jogo jogo) {
        return jogoServ.salvar(jogo);
    }

    @GetMapping("/count")
    public long count() {
        return jogoServ.count();
    }
}
