package ds.MOD10.ebac.Eventos.consumidor;


import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Component;

@Component
public class ConfigConsumidor {

    @RetryableTopic(attempts = "2")
    @KafkaListener(topics = "${kafka.ebac.nome.topic}",groupId = "ebacGrupo")
    public void consumirMensagem(String mensagem) {
        if (mensagem.contains("DLT")){
            throw new IllegalArgumentException("Teste de DLT");
        }
        System.out.println("======= Recebido: " + mensagem);

    }

    @DltHandler
    public void consumirMensagemDLT(String mensagem) {
        System.out.println("======= Recebido DLT: " + mensagem);
    }
}
