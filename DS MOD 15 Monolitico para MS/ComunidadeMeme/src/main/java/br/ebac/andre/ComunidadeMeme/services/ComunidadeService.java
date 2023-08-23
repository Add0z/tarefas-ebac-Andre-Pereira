package br.ebac.andre.ComunidadeMeme.services;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.ebac.andre.ComunidadeMeme.apiWebFlux.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.random;

@Component
public class ComunidadeService {

    Logger logger = LogManager.getLogger(ComunidadeService.class);

    @Autowired
    private ApiServiceMeme apiServiceMeme;


//    public JsonElement MemeDoDia(){
//        ArrayList memes = apiServiceMeme.fetchDataFromApi("/memes");
//        System.out.println(" memes direto da API:"   + memes);
//        Integer min = 0;
//        Random random = new Random();
//        Integer randomMeme = random.nextInt(memes.size()- min + 1) + min;
//        String memeString = (String) memes.get(randomMeme);
//        Object memeStringS = new Gson().fromJson(memeString, Object.class);
//        return (JsonElement) memeStringS;
//
//
//
//
//    }

    public String MemeDoDia() {
        List<Map<String, Object>> memes = apiServiceMeme.fetchDataFromApi("/memes");

        if (memes == null || memes.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int min = 0;
        int randomMemeIndex = random.nextInt(memes.size() - min) + min;
        Map<String, Object> meme = memes.get(randomMemeIndex);

        Gson gson = new Gson();
        String jsonMeme = gson.toJson(meme);
        return jsonMeme;
    }

    // TODO: 2023/08/23 Um melhor jeito de fazer isso é criar um GET em MemeRepo @Query(SELECT * FROM Meme ORDER BY RAND() LIMIT 1;)
        // porem nessa forma feita eu posso pegar qualquer item aleátorio de qualquer umas das tres tabelas, tanto que seja de Meme, Usuario ou Categoria;
}
