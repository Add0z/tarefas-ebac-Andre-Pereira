package ds.MOD13.DS.MOD3.agente.estrangulador.service;


import ds.MOD13.DS.MOD3.agente.estrangulador.entidades.Usuario2;
import ds.MOD13.DS.MOD3.agente.estrangulador.repo.RepoUsu2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceUsu2 {

    private final RepoUsu2 repoUsu2;

    public ServiceUsu2(RepoUsu2 repoUsu2){
        this.repoUsu2 = repoUsu2;
    }

    public Iterable<Usuario2> encontrarUsuarios(){
        return repoUsu2.findAll();
    }

    public Usuario2 criarUsuario(Usuario2 usuario){
        return repoUsu2.save(usuario);
    }
}
