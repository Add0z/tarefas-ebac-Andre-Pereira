package ds.MOD13.DS.MOD3.estrangulado.service;


import ds.MOD13.DS.MOD3.estrangulado.entidades.Usuario;
import ds.MOD13.DS.MOD3.estrangulado.utils.UsuarioUtils;
import ds.MOD13.DS.MOD3.estrangulado.vo.UsuarioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ds.MOD13.DS.MOD3.estrangulado.repositorios.RepoUsuario;

@Component
public class ServiceUsuario {

    @Autowired
    private final RepoUsuario repoUsuario;

    public ServiceUsuario(RepoUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }

    public Iterable<UsuarioVO> encontrarTodos(){
       final Iterable<Usuario> usuarioIterable = repoUsuario.findAll();

       return UsuarioUtils.toUsuarioVOs(usuarioIterable);
    }

    public UsuarioVO criarUsuario(UsuarioVO usuarioVO){
        Usuario usuarioCriado = UsuarioUtils.fromUsuarioVO(usuarioVO);
        usuarioCriado = repoUsuario.save(usuarioCriado);

        return UsuarioUtils.toUsuarioVO(usuarioCriado);
    }


}
