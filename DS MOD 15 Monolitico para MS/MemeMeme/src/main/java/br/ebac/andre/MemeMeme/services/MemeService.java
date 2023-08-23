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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;




@Component
public class MemeService {

    Logger logger = LogManager.getLogger(MemeService.class);

    @Autowired
    private MemeRepo memeRepo;

    @Autowired
    private ApiServiceUsuario apiServiceUsuario;

    @Autowired
    private ApiServiceCategoria apiServiceCategoria;

    private Meme meme;


    public List<Meme> listaTodosMemes(){
        logger.info("\u001B[34mBuscando lista de memes: " + memeRepo.count());
        return memeRepo.findAll();
    }

    public Meme buscaMemeId(Long id){
        logger.info("\u001B[34mBuscando meme id: " + id);
        return memeRepo.findById(id).get();
    }



    // TODO: 2023/08/19 adicionar UNIQUE para o nome do usuario e categoria
    public Object novoMeme(Meme meme) throws ApiResponseException {
        StringBuilder errolog = new StringBuilder();

        boolean isCategoriaValid = isCategoriaInApiResponse(meme);
        boolean isUsuarioNameValid = isUsuarioNameInApiResponse(meme);

        if (!isCategoriaValid) {
            logger.error("Categoria não encontrada: " + meme.getCategoria());
            errolog.append("Categoria não encontrada: ").append(meme.getCategoria());
        }

        if (!isUsuarioNameValid) {
            if (errolog.length() > 0) {
                errolog.append(" " +
                        ";" + " ");
            }
            logger.error("Usuário não encontrado: " + meme.getUsuario());
            errolog.append("Usuário não encontrado: ").append(meme.getUsuario());
        }

        if (errolog.length() > 0) {
            throw new ApiResponseException(errolog.toString());
        }

        if (isCategoriaValid && isUsuarioNameValid) {
            logger.info("\u001B[34mMeme inserido com sucesso! :" + meme.getNome());
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


    public boolean isCategoriaInApiResponse(Meme meme) {
        String tergetCategoriaName = meme.getCategoria();
        String apiResponses = apiServiceCategoria.fetchDataFromApi();

        JsonArray categoriaArray = new Gson().fromJson(apiResponses, JsonArray.class);

        for (JsonElement categoriaElement : categoriaArray) {
            JsonObject categoriaObject = categoriaElement.getAsJsonObject();
            String categoria = categoriaObject.get("nome").getAsString();

            if (categoria.equals(tergetCategoriaName)) {
                return true;
            }
        }

        return false;
    }



    public List<Meme> buscaMemesPorUsuario(String usuario){
        try {
            logger.info("\u001B[34mBuscando memes por usuario: " + usuario + "\u001B[0m");
            return memeRepo.buscaMemesPorUsuario(usuario);
        } catch (ApiResponseException e) {
            logger.error("Usuario não encontrado " + usuario);
            throw new ApiResponseException("Usuario não encontrado " + usuario);
        }
    }

    public void deletaMeme(Long id){
        logger.info("\u001B[34mDeletando meme: " + id);
        memeRepo.deleteById(id);
    }

    public List<Meme> MemePorCategoria(String categoria){
        try {
            logger.info("\u001B[34mBuscando memes por categoria: " + categoria + "\u001B[0m");
            return memeRepo.MemePorCategoria(categoria);
        } catch (ApiResponseException e) {
            logger.error("Categoria não encontrada" + categoria);
            throw new ApiResponseException("Categoria não encontrada" + categoria);
        }
    }

}
