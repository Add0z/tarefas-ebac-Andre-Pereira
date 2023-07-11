package ds.MOD10.ebac.Eventos.produtor;


import ds.MOD10.ebac.Eventos.service.ServiceKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class ProdutorController {

    @Autowired
   private ServiceKafka serviceKafka;


    @PostMapping
    public void enviarMensagem(@RequestBody String mensagem) {

        System.out.println("======= Enviado: " + mensagem);
        serviceKafka.enviarMensagem(mensagem);

    }
}
