import Dao.IClienteDao;
import Domain.Cliente;

import java.io.Serializable;
import java.util.Collection;

public class ClienteDaoMock implements IClienteDao {


    Cliente cliente = new Cliente("André", "1231231231", 99999999l,"Hilário");
    @Override
    public boolean cadastrar(Cliente entity) {
        return true;
    }

    @Override
    public void excluir(String chave) {

    }

    @Override
    public void alterar(Cliente entity) {
        cliente.setNome(entity.getNome());

    }

    @Override
    public Cliente consultar(String Cpf) {
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return IClienteDao.super.buscarTodos();
    }
}
