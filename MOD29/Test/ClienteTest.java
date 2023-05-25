import Dao.ClienteDao;
import Dao.IClienteDao;
import Domain.Cliente;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private IClienteDao clienteDao = new ClienteDao();

    @Test
    public void cadastrarTest() throws Exception{
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Andre");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDao.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception{
        clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Andre");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
		assertNotNull(clienteBD);
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());

		Integer countDel = clienteDao.excluir(clienteBD);
		assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Andre");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDao.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Andre");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clientes = new Cliente();
        clientes.setCodigo("20");
        clientes.setNome("Teste");
        Integer countCad2 = clienteDao.cadastrar(clientes);
        assertTrue(countCad2 == 1);

        List<Cliente> list = clienteDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Cliente cli : list) {
            clienteDao.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = clienteDao.buscarTodos();
        assertEquals(list.size(), 0);

    }
    @Test
    public void atualizarTest() throws Exception {
        clienteDao = new ClienteDao();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Andre");
        Integer countCad = clienteDao.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDao.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("Outro nome");
        Integer countUpdate = clienteDao.atualizar(clienteBD);
        assertTrue(countUpdate == 1);

        Cliente clienteBD1 = clienteDao.buscar("10");
        assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDao.buscar("20");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = clienteDao.buscarTodos();
        for (Cliente cli : list) {
            clienteDao.excluir(cli);
        }
    }
}