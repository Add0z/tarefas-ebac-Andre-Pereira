package Service;

import Domain.Cliente;

public interface IClienteService {


    Boolean salvar(Cliente cliente) ;

    Long buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) ;
}
