package ds.MOD13.DS.MOD3.estrangulado.service;


import ds.MOD13.DS.MOD3.estrangulado.feign.ClienteFeingNovoUsuario;
import ds.MOD13.DS.MOD3.estrangulado.utils.UsuarioUtils;
import ds.MOD13.DS.MOD3.estrangulado.vo.NovoUsuarioVO;
import ds.MOD13.DS.MOD3.estrangulado.vo.UsuarioVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServicoNovoUsuario {

    private final ClienteFeingNovoUsuario clienteFeingNovoUsuario;

    public ServicoNovoUsuario(ClienteFeingNovoUsuario clienteFeingNovoUsuario) {
        this.clienteFeingNovoUsuario = clienteFeingNovoUsuario;
    }

    public UsuarioVO criarNovoUsuario(UsuarioVO usuarioVO) {
        NovoUsuarioVO novoUsuarioVO = UsuarioUtils.toNovoUsuarioVO(usuarioVO);
        novoUsuarioVO = clienteFeingNovoUsuario.novoUsuario(novoUsuarioVO);

        return UsuarioUtils.fromNovoUsuarioVO(novoUsuarioVO);
    }

    public Iterable<UsuarioVO> encontrarTodos(){
        List<NovoUsuarioVO> usuarioVOList = clienteFeingNovoUsuario.encontrarTodos();
        List<UsuarioVO> usuarioVOs = new ArrayList<>();

        for (NovoUsuarioVO novoUsuarioVO : usuarioVOList) {
            usuarioVOs.add(UsuarioUtils.fromNovoUsuarioVO(novoUsuarioVO));
        }

        return usuarioVOs;
    }
}
