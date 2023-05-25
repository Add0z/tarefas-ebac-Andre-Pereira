import Cliente.Dao.ClienteDao;
import Cliente.Dao.IClienteDao;
import Cliente.Cliente;

public class ClienteDaoMock {
    public IClienteDao dao;

    ClienteDaoMock(){
        dao = new ClienteDao();
        dao.cadastrar(new Cliente("André", "1231231231", 99999999l,"Hilário"));
    }


    /*@Override
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
    }*/

}
