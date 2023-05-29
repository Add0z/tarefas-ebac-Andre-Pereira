import Annotation.TipochaveExcep;
import Cliente.Dao.ClienteDao;
import Cliente.Dao.IClienteDao;
import Cliente.Cliente;

public class ClienteDaoMock implements IClienteDao {


    @Override
    public Boolean cadastrar(Cliente entity) throws TipochaveExcep {
        return true;
    }

    @Override
    public Cliente consultar(Long chave) {
        Cliente cliente = new Cliente();
        cliente.setCpf(chave);
        return cliente;
    }

    @Override
    public void excluir(Long chave) {
    }

    @Override
    public void alterar(Cliente entity) throws TipochaveExcep {
    }
}
