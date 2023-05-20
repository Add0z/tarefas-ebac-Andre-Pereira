import Dao.ClienteDao;
import Dao.IClienteDao;
import Domain.Cliente;
import Service.IClienteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteDaoTest {
    private Cliente cliente;
    private IClienteDao clienteDao;

    public ClienteDaoTest(){
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init(){
        cliente = new Cliente("André","1231231231L",99999999L,"Hilário");
        cliente.setCpf(1231231231L);
        cliente.setNome("André");
        cliente.setTel(99999999L);
        cliente.setEnd("Hilário");
        clienteDao.cadastrar(cliente);

    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertEquals(cliente.toString(), clienteConsultado.toString());
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(String.valueOf(cliente.getCpf()));
    }

    @Test
    public void salvarCliente(){
        Boolean retorno = clienteDao.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarCliente(){
        cliente.setNome("Andréas");
       clienteDao.alterar(cliente);

    }
}
