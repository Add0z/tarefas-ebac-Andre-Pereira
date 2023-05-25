package Service;

import Cliente.Cliente;
import Generic.IGenericDAO;

public class ClienteService extends GenericService<Cliente, String>{
    public ClienteService(IGenericDAO<Cliente, String> dao){
        super(dao);
    }



//    @Override
//    public boolean cadastrar(Cliente entity) {
//        return false;
//    }
//
//    @Override
//    public Cliente buscarPorCpf(String key) {
//        return null;
//    }
//
//    @Override
//    public void excluir(String key) {
//
//    }
//
//    @Override
//    public void alterar(Cliente entity) {
//
//    }
}
