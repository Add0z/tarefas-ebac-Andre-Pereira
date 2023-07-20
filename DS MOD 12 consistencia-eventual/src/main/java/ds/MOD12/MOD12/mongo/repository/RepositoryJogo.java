package ds.MOD12.MOD12.mongo.repository;


import ds.MOD12.MOD12.mongo.modelo.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryJogo extends MongoRepository<Jogo, String> {

    long count();
}
