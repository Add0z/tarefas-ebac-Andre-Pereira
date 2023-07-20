package ebac.ds.MOD10.ebacfilas.Service;

import ebac.ds.MOD10.ebacfilas.config.ConfigRabbitMq;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ServiceRabbitMq {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(ConfigRabbitMq.NOME_EXCHANGE, "ebac.rota.mensagem", mensagem);
    }


}
