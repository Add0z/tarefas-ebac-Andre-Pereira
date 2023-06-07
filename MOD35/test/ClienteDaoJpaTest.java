import DaoJpa.ClienteDaoJpa;
import DaoJpa.IClienteDaoJpa;
import DomainJpa.ClienteJpa;
import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteDaoJpaTest {

    private IClienteDaoJpa clienteDaoJpa;

    private Random rd;

    public ClienteDaoJpaTest(){
        this.clienteDaoJpa = new ClienteDaoJpa();
        rd = new Random();
    }

    @After
    public void end() throws DAOException{
        Collection<ClienteJpa> clienteJpaCollection = clienteDaoJpa.buscarTodos();
        clienteJpaCollection.forEach(clienteJpa -> {
            try{
                clienteDaoJpa.excluir(clienteJpa);
            } catch (DAOException e){
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(clienteJpa.getId());
        assertNotNull(clienteJpa1);
    }

    private ClienteJpa criarCliente() {
        ClienteJpa clienteJpa = new ClienteJpa();
        clienteJpa.setCpf(rd.nextLong());
        clienteJpa.setNome("Andre");
        clienteJpa.setCidade("Santa Catarina");
        clienteJpa.setEnd("End");
        clienteJpa.setEstado("SC");
        clienteJpa.setNumero(102);
        clienteJpa.setTel(33333333333L);
        //	TAREFA MOD30 -------------------------------------------
        clienteJpa.setSexo("M");
        return clienteJpa;
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        assertNotNull(retorno);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        clienteDaoJpa.excluir(clienteJpa);

        ClienteJpa clienteJpa2 = clienteDaoJpa.consultar(retorno.getId());
        assertNull(clienteJpa2);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        assertNotNull(retorno);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(clienteJpa.getId());
        assertNotNull(clienteJpa1);

        clienteDaoJpa.excluir(clienteJpa);

         clienteJpa1 = clienteDaoJpa.consultar(clienteJpa.getId());
        assertNull(clienteJpa1);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        assertNotNull(retorno);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        clienteJpa1.setNome("ANDREO");
        clienteDaoJpa.alterar(clienteJpa1);

        ClienteJpa clienteJpaAlterado = clienteDaoJpa.consultar(clienteJpa1.getId());
        assertNotNull(clienteJpaAlterado);
        assertEquals("ANDREO", clienteJpaAlterado.getNome());

        clienteDaoJpa.excluir(clienteJpa);
        clienteJpa1 = clienteDaoJpa.consultar(clienteJpaAlterado.getId());
        assertNull(clienteJpa1);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        assertNotNull(retorno);

        ClienteJpa clienteJpa1 = criarCliente();
        ClienteJpa retorno1 = clienteDaoJpa.cadastrar(clienteJpa1);
        assertNotNull(retorno1);

        Collection< ClienteJpa> clienteJpaCollection = clienteDaoJpa.buscarTodos();
        assertTrue(clienteJpaCollection != null);
        assertTrue(clienteJpaCollection.size() == 2);

        clienteJpaCollection.forEach(cli -> {
            try {
                clienteDaoJpa.excluir(cli);
            }catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection< ClienteJpa> clienteJpaCollection1 = clienteDaoJpa.buscarTodos();
        assertTrue(clienteJpaCollection1 != null);
        assertTrue(clienteJpaCollection1.size() == 0);
    }










}
