package ds.MOD09.animalservice.repositorios;

import ds.MOD09.animalservice.entidades.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface CuidadorRepository extends JpaRepository<Cuidador, Integer> {
    Cuidador findByNome(String nome);

}