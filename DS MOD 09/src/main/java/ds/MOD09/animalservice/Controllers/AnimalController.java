package ds.MOD09.animalservice.Controllers;
import ds.MOD09.animalservice.entidades.Animal;
import ds.MOD09.animalservice.repositorios.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    @GetMapping
    private List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> FindNotAdoptedAnimals() {
        return animalRepository.FindNotAdoptedAnimals();
    }

    @GetMapping("/adopted")
    private List<Animal> FindAdoptedAnimals() {
        return animalRepository.FindAdoptedAnimals();
    }

    @GetMapping("/not-adopted-dog")
    private List<Animal> FindNotAdoptedDog() {
        return animalRepository.FindNotAdoptedDog();
    }

    @GetMapping("/adopted-dog")
    private List<Animal> FindAdoptedDog() {
        return animalRepository.FindAdoptedDog();
    }

    @GetMapping("/not-adopted-cat")
    private List<Animal> FindNotAdoptedCat() {
        return animalRepository.FindNotAdoptedCat();
    }

    @GetMapping("/adopted-cat")
    private List<Animal> FindAdoptedCat() {
        return animalRepository.FindAdoptedCat();
    }

    @GetMapping("/employees")
    private List<String> FindEmployees() {
        Date startDate = Date.valueOf("2023-02-05");
        Date endDate =  Date.valueOf("2023-07-05");
        return animalRepository.FindEmployees(startDate, endDate);
    }

    @GetMapping("/month")
    private List<Animal> FindMonthAnimals() {
        Date startDate = Date.valueOf("2023-02-05");
        Date endDate =  Date.valueOf("2023-07-05");
        return animalRepository.FindMonthAnimals(startDate, endDate);
    }
}


