import Dao.IClienteDao;
import Service.ClienteService;
import Service.IClienteService;
import Domain.Cliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ClienteServiceTest {

    IClienteDao clienteDaoMock;
    ClienteService clienteService;

    Cliente cliente;

    public ClienteServiceTest(){
        clienteDaoMock = new ClienteDaoMock();
        clienteService = new ClienteService(clienteDaoMock);
    }
    @Before
    public void init(){
        cliente = new Cliente("André","1231231231",99999999L,"Hilário");
//        cliente.setCpf(1231231231L);
//        cliente.setNome("André");
//        cliente.setTel(99999999L);
//        cliente.setEnd("Hilário");


    }

    @Test
    public void pesquisarCliente(){

        Cliente clienteConsultado = clienteService.buscarPorCpf(String.valueOf(cliente.getCpf()));
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() {
//            throws TipoChave {
        boolean retorno = clienteService.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(String.valueOf(cliente.getCpf()));
    }

    @Test
    public void alterarCliente() {
        cliente.setNome("Andrés");
        clienteService.alterar(cliente);
        Assert.assertEquals("Andrés", cliente.getNome());
    }
}
