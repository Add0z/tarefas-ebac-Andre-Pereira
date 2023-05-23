import Dao.IClienteDao;
import Service.ClienteService;
import Domain.Cliente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;


public class ClienteServiceTest {

    IClienteDao clienteDaoMock;
    ClienteService clienteService;

    Cliente cliente;

    public ClienteServiceTest(){
        clienteDaoMock = new ClienteDaoMock().dao;
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
    public void cadastrarCliente() {
//            throws TipoChave {
        boolean retorno = clienteService.cadastrar(new Cliente("Leozinho","55555231231",99999999L,"Hilário"));
        Assert.assertTrue(retorno);
    }



    @Test
    public void alterarCliente() {
        cliente.setNome("Andrés");
        clienteService.alterar(cliente);
        Cliente retorno = clienteService.consultar(cliente.getCpf());
        Assert.assertEquals("Andrés", retorno.getNome());
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void consultarCliente(){

        Cliente retorno = clienteService.consultar(cliente.getCpf());
        Assert.assertNotNull(retorno.getNome());
    }


}
