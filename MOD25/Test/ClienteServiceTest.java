import Annotation.TipochaveExcep;
import Cliente.Dao.IClienteDao;
import Service.ClienteService;
import Cliente.Cliente;
import Service.IClienteService;
import Service.IGenericService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDao dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }
    @Before
    public void init(){
        cliente = new Cliente("André",1231231231l,99999999L,"Hilário");
    }
    @Test
    public void cadastrarCliente() throws TipochaveExcep {
//            throws TipoChave {
        boolean retorno = clienteService.cadastrar(new Cliente("Leozinho",55555231231l,99999999L,"Hilário"));
        Assert.assertTrue(retorno);
    }



    @Test
    public void alterarCliente() throws TipochaveExcep {
        cliente.setNome("Andrés");
        clienteService.alterar(cliente);
        Assert.assertEquals("Andrés", cliente.getNome());
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(Long.valueOf(cliente.getCpf()));
    }

    @Test
    public void consultarCliente(){

        Cliente clienteConsultado = clienteService.consultarCPF(Long.valueOf(cliente.getCpf()));
        Assert.assertNotNull(clienteConsultado);
    }


}
