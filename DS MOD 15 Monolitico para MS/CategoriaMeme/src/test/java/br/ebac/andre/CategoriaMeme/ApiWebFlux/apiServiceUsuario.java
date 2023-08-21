package br.ebac.andre.CategoriaMeme.ApiWebFlux;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class apiServiceUsuario {

    private final WebClient webClient;

    public apiServiceUsuario(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/memelandia").build();
    }

    public String fetchDataFromApi(){
        return webClient.get().uri("/usuarios").retrieve().bodyToMono(String.class).block();

    }


}
