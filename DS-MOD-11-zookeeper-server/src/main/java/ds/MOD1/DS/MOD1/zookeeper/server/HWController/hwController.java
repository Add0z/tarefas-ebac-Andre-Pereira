package ds.MOD1.DS.MOD1.zookeeper.server.HWController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hwController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
