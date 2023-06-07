import DaoJpa.ClienteDaoJpa;
import DaoJpa.ClienteDaoJpa2;
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

public class ClienteDaoJpaTest2 {

    private IClienteDaoJpa<ClienteJpa> clienteDaoJpa;
    private IClienteDaoJpa<ClienteJpa> clienteDaoJpa2;


    private Random rd;

    public ClienteDaoJpaTest2(){
        this.clienteDaoJpa = new ClienteDaoJpa();
        this.clienteDaoJpa2 = new ClienteDaoJpa2();
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

        Collection<ClienteJpa> clienteJpaCollection2 = clienteDaoJpa2.buscarTodos();
        clienteJpaCollection2.forEach(clienteJpa -> {
            try{
                clienteDaoJpa2.excluir(clienteJpa);
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

        clienteJpa.setId(null);
        clienteDaoJpa2.cadastrar(clienteJpa);

        ClienteJpa clienteJpa2 = clienteDaoJpa2.consultar(clienteJpa.getId());
        assertNotNull(clienteJpa2);

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
        ClienteJpa clienteJpaNew2 = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa retorno2 = clienteDaoJpa2.cadastrar(clienteJpaNew2);

        assertNotNull(retorno);
        assertNotNull(retorno2);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        ClienteJpa clienteJpa2 = clienteDaoJpa2.consultar(retorno2.getId());
        assertNotNull(clienteJpa2);

        clienteDaoJpa.excluir(clienteJpa);
        clienteDaoJpa2.excluir(clienteJpaNew2);


        ClienteJpa clienteJpa11 = clienteDaoJpa.consultar(retorno.getId());
        assertNull(clienteJpa11);

        ClienteJpa clienteJpa22 = clienteDaoJpa2.consultar(retorno2.getId());
        assertNull(clienteJpa22);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa clienteJpaNew2 = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa retorno2 = clienteDaoJpa2.cadastrar(clienteJpaNew2);

        assertNotNull(retorno);
        assertNotNull(retorno2);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        ClienteJpa clienteJpa2 = clienteDaoJpa2.consultar(retorno2.getId());
        assertNotNull(clienteJpa2);

        clienteDaoJpa.excluir(clienteJpa);
        clienteDaoJpa2.excluir(clienteJpaNew2);


        clienteJpa1 = clienteDaoJpa.consultar(clienteJpa.getId());
        assertNull(clienteJpa1);

        clienteJpa2 = clienteDaoJpa2.consultar(clienteJpaNew2.getId());
        assertNull(clienteJpa2);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa clienteJpaNew2 = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa retorno2 = clienteDaoJpa2.cadastrar(clienteJpaNew2);

        assertNotNull(retorno);
        assertNotNull(retorno2);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        ClienteJpa clienteJpa2 = clienteDaoJpa2.consultar(retorno2.getId());
        assertNotNull(clienteJpa2);

        clienteJpa1.setNome("ANDREO");
        clienteDaoJpa.alterar(clienteJpa1);
        clienteJpa2.setNome("ANDREO2");
        clienteDaoJpa2.alterar(clienteJpa2);

        ClienteJpa clienteJpaAlterado = clienteDaoJpa.consultar(clienteJpa1.getId());
        assertNotNull(clienteJpaAlterado);
        assertEquals("ANDREO", clienteJpaAlterado.getNome());

        ClienteJpa clienteJpaAlterado2 = clienteDaoJpa2.consultar(clienteJpa2.getId());
        assertNotNull(clienteJpaAlterado2);
        assertEquals("ANDREO2", clienteJpaAlterado2.getNome());

        clienteDaoJpa.excluir(clienteJpa);
        clienteJpa1 = clienteDaoJpa.consultar(clienteJpaAlterado.getId());
        assertNull(clienteJpa1);

        clienteDaoJpa2.excluir(clienteJpaNew2);
        clienteJpa2 = clienteDaoJpa2.consultar(clienteJpaAlterado2.getId());
        assertNull(clienteJpa2);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa clienteJpaNew2 = criarCliente();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa retorno2 = clienteDaoJpa2.cadastrar(clienteJpaNew2);

        assertNotNull(retorno);
        assertNotNull(retorno2);


        ClienteJpa clienteJpa1 = criarCliente();
        ClienteJpa retorno1 = clienteDaoJpa.cadastrar(clienteJpa1);
        assertNotNull(retorno1);

        ClienteJpa clienteJpa12 = criarCliente();
        ClienteJpa retorno12 = clienteDaoJpa2.cadastrar(clienteJpa12);
        assertNotNull(retorno12);

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

        Collection< ClienteJpa> clienteJpaCollection2 = clienteDaoJpa2.buscarTodos();
        assertTrue(clienteJpaCollection2 != null);
        assertTrue(clienteJpaCollection2.size() == 2);

        clienteJpaCollection2.forEach(cli -> {
            try {
                clienteDaoJpa2.excluir(cli);
            }catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection< ClienteJpa> clienteJpaCollection1 = clienteDaoJpa.buscarTodos();
        assertTrue(clienteJpaCollection1 != null);
        assertTrue(clienteJpaCollection1.size() == 0);

        Collection< ClienteJpa> clienteJpaCollection12 = clienteDaoJpa2.buscarTodos();
        assertTrue(clienteJpaCollection12 != null);
        assertTrue(clienteJpaCollection12.size() == 0);
    }










}
