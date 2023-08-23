package br.ebac.andre.CategoriaMeme.services;


import br.ebac.andre.CategoriaMeme.ApiWebFlux.apiServiceUsuario;
import br.ebac.andre.CategoriaMeme.entities.Categoria;
import br.ebac.andre.CategoriaMeme.repositories.CategoriaRepo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaService {

    Logger logger = LogManager.getLogger(CategoriaService.class);


    @Autowired
    private CategoriaRepo categoriarepositorio;


    private Categoria categoria;

    @Autowired
    private final apiServiceUsuario apiServiceUsuario;

    public CategoriaService( apiServiceUsuario apiServiceUsuario){

        this.apiServiceUsuario = apiServiceUsuario;
    }

    public boolean isUsuarioNameInApiResponse(Categoria categoria) {
        String targetUsuarioName = categoria.getUsuarioName();
        String apiResponses = apiServiceUsuario.fetchDataFromApi();

        JsonArray usuariosArray = new Gson().fromJson(apiResponses, JsonArray.class);

        for (JsonElement usuarioElement : usuariosArray) {
            JsonObject usuarioObject = usuarioElement.getAsJsonObject();
            String nome = usuarioObject.get("nome").getAsString();

            if (nome.equals(targetUsuarioName)) {
                return true;
            }
        }

        return false;
    }


    private boolean isCategoriaUnica(Categoria categoria) {
        return categoriarepositorio.findByNome(categoria.getNome()) == null;
    }



    public Categoria novoCategoria(Categoria categoria) {
        if (isCategoriaUnica(categoria)) {
            if (isUsuarioNameInApiResponse(categoria) == true) {
                logger.info("\u001B[34mCategoria inserida com sucesso! :" + categoria.getNome());
                return categoriarepositorio.save(categoria);
            }
        }
        logger.error("\u001B[34mCategoria não inserida! :" + categoria);
        return null;
    }




    public List<Categoria> listaTodasCategorias(){
        logger.info("\u001B[34mBuscando todas as categorias:" + categoriarepositorio.count());
        return categoriarepositorio.findAll();
    }

    public void deletarCategoria(Long id) {
        logger.info("\u001B[34mDeletando categoria: " + id + " - " + categoriarepositorio.findById(id).get().getNome());
        categoriarepositorio.deleteById(id);
    }

    public Categoria buscaCategoriaId(Long id) {
        logger.info("\u001B[34mBuscando categoria: " + id + " - " + categoriarepositorio.findById(id).get().getNome());
        return categoriarepositorio.findById(id).get();
    }

    public Categoria buscaCategoriaNome(String nome) {
        logger.info("\u001B[34mBuscando categoria: " + nome);
        return categoriarepositorio.findByNome(nome);
    }
}
