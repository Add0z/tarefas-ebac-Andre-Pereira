package br.ebac.andre.ComunidadeMeme.apiWebFlux;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApiServiceMeme {

    private final WebClient webClient;

    public ApiServiceMeme(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083/memelandia").build();
    }

//    public ArrayList fetchDataFromApi(String baseUrl){
//        return webClient.get().uri(baseUrl).retrieve().bodyToMono(ArrayList.class).block();
//
//
//    }

    public List<Map<String, Object>> fetchDataFromApi(String baseUrl) {
        Mono<List> responseMono = webClient
                .get()
                .uri(baseUrl)
                .retrieve()
                .bodyToMono(List.class);

        return responseMono.block();
    }
}
