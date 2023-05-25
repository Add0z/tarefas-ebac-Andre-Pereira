package Cliente.Dao;

import Cliente.Cliente;
import Generic.IGenericDAO;

public interface IClienteDao extends IGenericDAO<Cliente, String> {

    void alterar(Cliente entity, Cliente entityCadastrado);
}
