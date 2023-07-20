package ds.MOD11.ebaclogs.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/logs")
public class LogsController {


    private static  final Logger LOGGER = LoggerFactory.getLogger(LogsController.class);

    @Value("${servico2.url:}")
    private String urlServico2;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getLogs() {

        final double mensagem = Math.random();

        LOGGER.info("LogsController {}", mensagem);

        if (urlServico2!=null && urlServico2.length() > 0) {
            final String mensagemDeles = restTemplate.exchange(urlServico2, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();

            return "Enviado: " + mensagem + " E Devolveu: (" + mensagemDeles + ")";
        }

         return "e eu deveria parar por aqui";
    }
}
