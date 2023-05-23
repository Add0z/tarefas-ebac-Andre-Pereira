import Dao.ClienteDao;
import Dao.IClienteDao;
import Domain.Cliente;
import Service.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDaoTest {
    IClienteDao clienteDao;
    Cliente cliente;


    public ClienteDaoTest(){

        this.clienteDao = new ClienteDao();
    }

    @Before
    public void init(){
        cliente = new Cliente("André","1222221231",99999999L,"Hilário");
        clienteDao.cadastrar(cliente);
//        cliente.setCpf("1231231231");
//        cliente.setNome("André");
//        cliente.setTel(99999999L);
//        cliente.setEnd("Hilário");
//        clienteDao.cadastrar(cliente);

    }

    @Test
    public void cadastrarCliente(){
        boolean retorno = clienteDao.cadastrar(new Cliente("André","1444441231",99999999L,"Hilário"));
        Assert.assertTrue(retorno);
    }

    @Test
    public void pesquisarCliente(){
        Cliente retorno = clienteDao.consultar(cliente.getCpf());
        Assert.assertEquals(cliente.toString(), retorno.toString());
    }
    @Test
    public void alterarCliente(){
//        cliente.setNome("Andréas");
//        clienteDao.alterar(cliente);
        cliente.setNome("Andréas");
        clienteDao.alterar(cliente);
        Cliente retorno = clienteDao.consultar(cliente.getCpf());
        Assert.assertEquals("Andréas", retorno.getNome());

    }

    @Test
    public void excluirCliente(){
//        clienteDao.excluir(String.valueOf(cliente.getCpf()));
        Assert.assertTrue(clienteDao.excluir(cliente.getCpf()));
        Cliente retorno = clienteDao.consultar(cliente.getCpf());
        Assert.assertNull(retorno);
    }
}
