package ds.MOD13.DS.MOD3.estrangulado.utils;

import ds.MOD13.DS.MOD3.estrangulado.entidades.Usuario;
import ds.MOD13.DS.MOD3.estrangulado.vo.NovoUsuarioVO;
import ds.MOD13.DS.MOD3.estrangulado.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UsuarioUtils {

    private UsuarioUtils() {}

    public static Usuario fromUsuarioVO(UsuarioVO usuarioVO) {
        return new Usuario(usuarioVO.getId(), usuarioVO.getNome(), usuarioVO.getLogin(), usuarioVO.getIdade());
    }

    public static UsuarioVO toUsuarioVO(Usuario usuario) {
        return new UsuarioVO(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getIdade());
    }

    public static Iterable<UsuarioVO> toUsuarioVOs(Iterable<Usuario> usuarios) {

        List<UsuarioVO> usuarioVOList = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            usuarioVOList.add(new UsuarioVO(usuario.getId(), usuario.getNome(), usuario.getLogin(), usuario.getIdade()));
        }
        return usuarioVOList;
    }

    public static UsuarioVO fromNovoUsuarioVO(NovoUsuarioVO novoUsuarioVO) {
        UsuarioVO usuarioVO = new UsuarioVO(null,novoUsuarioVO.getNome(), novoUsuarioVO.getLogin(), novoUsuarioVO.getIdade());;
        usuarioVO.setIdNovoUsuario(novoUsuarioVO.getId());
        usuarioVO.setAlturaCm(novoUsuarioVO.getAlturaCm());

        return usuarioVO;
    }

    public static NovoUsuarioVO toNovoUsuarioVO(UsuarioVO usuarioVO) {
        NovoUsuarioVO novoUsuarioVO = new NovoUsuarioVO(null, usuarioVO.getNome(), usuarioVO.getLogin(), usuarioVO.getIdade());
        novoUsuarioVO.setAlturaCm(usuarioVO.getAlturaCm());

        return novoUsuarioVO;
    }
}
