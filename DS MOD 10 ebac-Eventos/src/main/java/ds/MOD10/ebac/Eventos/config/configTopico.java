package ds.MOD10.ebac.Eventos.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class configTopico {
    @Value("${kafka.ebac.nome.topic}")
    private String nomeTopic;


    @Bean
    public NewTopic configNewTopic() {
        return TopicBuilder.name(nomeTopic).partitions(1).replicas(1).build();

    }
}
