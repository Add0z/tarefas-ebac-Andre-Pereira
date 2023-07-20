package ds.MOD12.DS.MOD2.consistenciaeventual.jogoService;


import ds.MOD12.DS.MOD2.consistenciaeventual.repository.RepositoryJogo;
import ds.MOD12.DS.MOD2.consistenciaeventual.modelo.Jogo;
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
