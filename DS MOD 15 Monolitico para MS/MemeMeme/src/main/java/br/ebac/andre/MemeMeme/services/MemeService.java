package br.ebac.andre.MemeMeme.services;

import br.ebac.andre.MemeMeme.ApiWebFlux.ApiServiceCategoria;
import br.ebac.andre.MemeMeme.ApiWebFlux.ApiServiceUsuario;
import br.ebac.andre.MemeMeme.entities.Meme;
import br.ebac.andre.MemeMeme.exceptions.ApiResponseException;
import br.ebac.andre.MemeMeme.exceptions.ExceptionResponse;
import br.ebac.andre.MemeMeme.repositories.MemeRepo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;




@Component
public class MemeService {

    @Autowired
    private MemeRepo memeRepo;

    @Autowired
    private ApiServiceUsuario apiServiceUsuario;

    @Autowired
    private ApiServiceCategoria apiServiceCategoria;

    private Meme meme;


    public List<Meme> listaTodosMemes(){
        return memeRepo.findAll();
    }

    public Meme buscaMemeId(Long id){
        return memeRepo.findById(id).get();
    }



    // TODO: 2023/08/15 Criar sistema de logs
    // TODO: 2023/08/19 adicionar UNIQUE para o nome do usuario e categoria
    // TODO: 2023/08/19 tratar erro caso usuario ou categoria ja existir e o SQL recusar ( só inverter o sentido do erro da API, dando throw caso ja haja o usuario ou categoria)
    public Object novoMeme(Meme meme) throws ApiResponseException {
        StringBuilder errolog = new StringBuilder();

        boolean isCategoriaValid = isCategoriaInApiResponse(meme);
        boolean isUsuarioNameValid = isUsuarioNameInApiResponse(meme);

        if (!isCategoriaValid) {
            errolog.append("Categoria não encontrada: ").append(meme.getCategoria());
        }

        if (!isUsuarioNameValid) {
            if (errolog.length() > 0) {
                errolog.append(" " +
                        ";" + " ");
            }
            errolog.append("Usuário não encontrado: ").append(meme.getUsuario());
        }

        if (errolog.length() > 0) {
            throw new ApiResponseException(errolog.toString());
        }

        if (isCategoriaValid && isUsuarioNameValid) {

            return memeRepo.save(meme);
        }

        return errolog.toString();
    }

    // TODO: 2023/08/18 Criar Banco de Logs em um banco comum de H2 - como usar dois bancos de dados na mesma aplicação sendo que um aplicativo pode ter mais de um banco de dados



    public boolean isUsuarioNameInApiResponse(Meme meme) {
        String targetUsuarioName = meme.getUsuario();
        String apiResponses = apiServiceUsuario.fetchDataFromApi();

        JsonArray usuariosArray = new Gson().fromJson(apiResponses, JsonArray.class);

        for (JsonElement usuarioElement : usuariosArray) {
            JsonObject usuarioObject = usuarioElement.getAsJsonObject();
            String nome = usuarioObject.get("nome").getAsString();

            if (nome.equals(targetUsuarioName)) {
                System.out.println("Usuario encontrado");
                return true;
            }
        }

        System.out.println("Usuario não encontrado");
        return false;
    }





//    public boolean isCategoriaInApiResponse(Meme meme) {
//        String targetCategoria = meme.getCategoria();
//
//        List<String> apiResponses = apiServiceCategoria.fetchDataFromApi().flux().collectList().block();
//
//        if (apiResponses != null) {
//            for (String response : apiResponses) {
//                if (response.contains(targetCategoria)) {
//                    System.out.println("Categoria encontrada");
//                    return true;
//                }
//            }
//        }
//
//        System.out.println("Categoria não encontrada");
//        return false;
//    }

    public boolean isCategoriaInApiResponse(Meme meme) {
        String tergetCategoriaName = meme.getCategoria();
        String apiResponses = apiServiceCategoria.fetchDataFromApi();

        JsonArray categoriaArray = new Gson().fromJson(apiResponses, JsonArray.class);

        for (JsonElement categoriaElement : categoriaArray) {
            JsonObject categoriaObject = categoriaElement.getAsJsonObject();
            String categoria = categoriaObject.get("nome").getAsString();

            if (categoria.equals(tergetCategoriaName)) {
                System.out.println("Categoria encontrada");
                return true;
            }
        }

        System.out.println("Categoria não encontrada");
        return false;
    }



    public List<Meme> buscaMemesPorUsuario(String usuario){
        try {
            return memeRepo.buscaMemesPorUsuario(usuario);
        } catch (ApiResponseException e) {
            throw new ApiResponseException("Usuario não encontrado " + usuario);
        }
    }

    public void deletaMeme(Long id){
        memeRepo.deleteById(id);
    }

    public List<Meme> MemePorCategoria(String categoria){
        try {
            return memeRepo.MemePorCategoria(categoria);
        } catch (ApiResponseException e) {
            throw new ApiResponseException("Categoria não encontrada" + categoria);
        }
    }

}
