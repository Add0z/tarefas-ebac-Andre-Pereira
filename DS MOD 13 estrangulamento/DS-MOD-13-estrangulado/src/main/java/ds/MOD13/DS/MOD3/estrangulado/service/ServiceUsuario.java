package ds.MOD13.DS.MOD3.estrangulado.service;


import ds.MOD13.DS.MOD3.estrangulado.entidades.Usuario;
import org.springframework.stereotype.Component;
import ds.MOD13.DS.MOD3.estrangulado.repositorios.RepoUsuario;

@Component
public class ServiceUsuario {

    private final RepoUsuario repoUsuario;

    public ServiceUsuario(RepoUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    public Iterable<Usuario> encontrarTodos(){
        return repoUsuario.findAll();
    }
}
