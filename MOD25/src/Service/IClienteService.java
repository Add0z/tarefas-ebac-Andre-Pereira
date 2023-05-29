package Service;

import Annotation.TipochaveExcep;
import Cliente.Cliente;

public interface IClienteService {


    Boolean cadastrar(Cliente cliente) throws TipochaveExcep;

    Cliente consultarCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipochaveExcep ;
}
