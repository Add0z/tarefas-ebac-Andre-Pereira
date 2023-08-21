package br.ebac.andre.MemeMeme.controllers;


import br.ebac.andre.MemeMeme.entities.Meme;
import br.ebac.andre.MemeMeme.exceptions.ExceptionResponse;
import br.ebac.andre.MemeMeme.services.MemeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/memelandia")
@Slf4j
public class MemeController {

    @Autowired
    private MemeService memeService;


    @GetMapping("/memes")
    public List<Meme> buscaMemes(){
        return memeService.listaTodosMemes();
    }

    @PostMapping("/NovoMeme")
    public Object novoMeme(@RequestBody Meme meme) throws ExceptionResponse {
        return memeService.novoMeme(meme);
    }

    @GetMapping("/memes/id={id}")
    public Meme buscaMemeId(@PathVariable Long id){
        return memeService.buscaMemeId(id);
    }

    @GetMapping("/memes/usuario={usuario}")
    public List<Meme> buscaMemesPorUsuario(@PathVariable String usuario){
        return memeService.buscaMemesPorUsuario(usuario);
    }

    @DeleteMapping("/memes/del/id={id}")
    public void deletaMeme(@PathVariable Long id){
        memeService.deletaMeme(id);
    }

    @GetMapping("/memes/categoria={categoria}")
    public List<Meme> MemePorCategoria(@PathVariable String categoria){
        return memeService.MemePorCategoria(categoria);
    }



}
