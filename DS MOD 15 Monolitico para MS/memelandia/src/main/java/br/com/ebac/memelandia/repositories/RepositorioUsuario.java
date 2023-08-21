package br.com.ebac.memelandia.repositories;

import br.com.ebac.memelandia.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
