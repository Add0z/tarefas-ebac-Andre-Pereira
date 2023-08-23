package br.ebac.andre.UsuarioMeme.repositories;

import br.ebac.andre.UsuarioMeme.entities.Usuario;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
}
