package ds.MOD10.ebac.Eventos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ServiceKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.ebac.nome.topic}")
    private String nomeTopic;


    public void enviarMensagem(String mensagem) {
        kafkaTemplate.send(nomeTopic, mensagem);

    }

}
