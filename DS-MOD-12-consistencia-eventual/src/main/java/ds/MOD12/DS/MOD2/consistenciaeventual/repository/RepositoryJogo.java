package ds.MOD12.DS.MOD2.consistenciaeventual.repository;


import ds.MOD12.DS.MOD2.consistenciaeventual.modelo.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryJogo extends MongoRepository<Jogo, String> {

    long count();
}
