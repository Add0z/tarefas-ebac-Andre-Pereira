package br.ebac.andre.CategoriaMeme.controllers;


import br.ebac.andre.CategoriaMeme.entities.Categoria;
import br.ebac.andre.CategoriaMeme.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> buscaCategorias() {
        return categoriaService.listaTodasCategorias();
    }

    @GetMapping("/categoria/id={id}")
    public Categoria buscaCategoria(@PathVariable Long id){
        return categoriaService.buscaCategoriaId(id);
    }

    @GetMapping("/categoria/nome={nome}")
    public Categoria buscaCategoria(@PathVariable String nome){
        return categoriaService.buscaCategoriaNome(nome);
    }



    @PostMapping("/NovaCategoria")
    public Categoria novoCategoria(@RequestBody Categoria categoria){
        return categoriaService.novoCategoria(categoria);
    }

    @DeleteMapping("/categoria/del/id={id}")
    public void deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
    }
}
