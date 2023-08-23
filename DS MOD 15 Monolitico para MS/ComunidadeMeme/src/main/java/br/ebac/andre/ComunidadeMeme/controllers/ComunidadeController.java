package br.ebac.andre.ComunidadeMeme.controllers;


import br.ebac.andre.ComunidadeMeme.services.ComunidadeService;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memelandia")
public class ComunidadeController {

    @Autowired
    private ComunidadeService comunidadeService;


        @GetMapping("/memeDoDia")
        public String MemeDoDia(){
            return comunidadeService.MemeDoDia();
        }
}
