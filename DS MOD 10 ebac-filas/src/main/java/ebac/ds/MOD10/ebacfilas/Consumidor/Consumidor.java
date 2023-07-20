package ebac.ds.MOD10.ebacfilas.Consumidor;


import ebac.ds.MOD10.ebacfilas.config.ConfigRabbitMq;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = ConfigRabbitMq.NOME_FILA)
public class Consumidor {
    @RabbitHandler
    public void consumeMensagem(String mensagem) {
        System.out.println("====== Recebendo mensagem: " + mensagem);
    }
}
