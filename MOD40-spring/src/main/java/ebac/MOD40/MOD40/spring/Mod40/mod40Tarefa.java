package ebac.MOD40.MOD40.spring.Mod40;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class mod40Tarefa {

    @GetMapping
    private ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("Hello World");
    }
}