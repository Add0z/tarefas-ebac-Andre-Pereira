package ds.MOD13.DS.MOD3.estrangulado.service;


import ds.MOD13.DS.MOD3.estrangulado.entidades.Jogo;
import ds.MOD13.DS.MOD3.estrangulado.repositorios.RepoJogo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceJogo {

    @Autowired
    public final RepoJogo repoJogo;

    public ServiceJogo(RepoJogo repoJogo) {
        this.repoJogo = repoJogo;
    }

    public Iterable<Jogo> encontrarTodos(){
        return repoJogo.findAll();
    }


}
