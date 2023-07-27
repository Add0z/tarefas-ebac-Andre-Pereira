package ds.MOD13.DS.MOD3.estrangulado.feign;


import ds.MOD13.DS.MOD3.estrangulado.vo.NovoUsuarioVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@FeignClient(value = "cliente-novo-usuario", url = "http://localhost:8084")
public interface ClienteFeingNovoUsuario {

    @RequestMapping(method = RequestMethod.POST, path = "/usuarios")
    NovoUsuarioVO novoUsuario(@RequestBody NovoUsuarioVO novoUsuarioVO);


    @RequestMapping(method = RequestMethod.GET, path = "/usuarios")
    List<NovoUsuarioVO> encontrarTodos();

}
