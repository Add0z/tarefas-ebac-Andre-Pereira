import dao.ClienteDao;
import dao.mock.ClienteDaoMock;
import dao.IClienteDao;
import service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {

    @Test
    public void salvarTest () {
        IClienteDao DaoDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(DaoDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso cliente salvar", retorno);
    }
    @Test
    public void buscarTest(){
        IClienteDao DaoDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(DaoDao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso cliente buscar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarTest(){
        IClienteDao DaoDao = new ClienteDao();
        ClienteService service = new ClienteService(DaoDao);
        String retorno = service.buscar();
        Assert.assertEquals("Sucesso cliente buscar", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest () {
        IClienteDao DaoDao = new ClienteDao();
        ClienteService service = new ClienteService(DaoDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso cliente salvar", retorno);
    }
}
