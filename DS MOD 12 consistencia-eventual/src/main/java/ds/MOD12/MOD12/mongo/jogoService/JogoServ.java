package ds.MOD12.MOD12.mongo.jogoService;


import ds.MOD12.MOD12.mongo.modelo.Jogo;
import ds.MOD12.MOD12.mongo.repository.RepositoryJogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableMongoRepositories(basePackageClasses = RepositoryJogo.class)
public class JogoServ {

    @Autowired
    private RepositoryJogo repositoryJogo;

    public Jogo salvar(Jogo jogo) {
        return repositoryJogo.insert(jogo);
    }

    public long count() {
        return repositoryJogo.count();
    }
}
