package br.ebac.andre.UsuarioMeme.repositories;

import br.ebac.andre.UsuarioMeme.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
}
