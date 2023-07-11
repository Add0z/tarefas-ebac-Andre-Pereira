package ebac.ds.MOD10.ebacfilas.Produtor;


import ebac.ds.MOD10.ebacfilas.Service.ServiceRabbitMq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/mensagem")
public class Produtor {
    @Autowired
    private ServiceRabbitMq serviceRabbitMq;

    @PostMapping
    public void enviarMensagem(@RequestBody String mensagem) {
        System.out.println("============== Enviando mensangem: " + mensagem);

        serviceRabbitMq.enviarMensagem(mensagem);

    }
}
