package br.ebac.andre.CategoriaMeme.repositories;

import br.ebac.andre.CategoriaMeme.entities.Categoria;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
