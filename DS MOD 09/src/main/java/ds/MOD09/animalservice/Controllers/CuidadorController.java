package ds.MOD09.animalservice.Controllers;
import ds.MOD09.animalservice.entidades.Cuidador;
import ds.MOD09.animalservice.repositorios.CuidadorRepository;
import ds.MOD09.animalservice.repositorios.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuidador")
public class CuidadorController {

    private AnimalRepository animalRepository;
    private final CuidadorRepository cuidadorRepository;

    public CuidadorController(AnimalRepository animalRepository,
                              CuidadorRepository cuidadorRepository) {
        this.animalRepository = animalRepository;
        this.cuidadorRepository = cuidadorRepository;
    }
    @GetMapping
    private List<Cuidador> findAll() {
        return cuidadorRepository.findAll();
    }

    @PostMapping
    private Cuidador create(@RequestBody Cuidador cuidador) {
        return cuidadorRepository.save(cuidador);
    }


}


