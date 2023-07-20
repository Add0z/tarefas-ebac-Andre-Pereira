package ds.MOD11.zookeeperclient.HWController;


import ds.MOD11.zookeeperclient.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWcontroller {

    @Autowired
    private Client client;


    @GetMapping("/helloClient")
    public String Hello() {
        return client.Hello();
    }
}
