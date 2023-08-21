package br.ebac.andre.MemeMeme.ApiWebFlux;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceUsuario {

    private final WebClient webClient;

    public ApiServiceUsuario(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/memelandia").build();
    }

    public String fetchDataFromApi(){
        return webClient.get().uri("/usuarios").retrieve().bodyToMono(String.class).block();


    }




}
