import DaoJpa.ClienteDaoJpa;
import DaoJpa.ClienteDaoJpa2;
import DaoJpa.ClienteDaoJpa3;
import DaoJpa.IClienteDaoJpa;
import DomainJpa.ClienteJpa;
import DomainJpa.ClienteJpa2;
import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class ClienteDaoJpaTest3 {

    private IClienteDaoJpa<ClienteJpa> clienteDaoJpa;
    private IClienteDaoJpa<ClienteJpa2> clienteDaoJpa3;


    private Random rd;

    public ClienteDaoJpaTest3(){
        this.clienteDaoJpa = new ClienteDaoJpa();
        this.clienteDaoJpa3 = new ClienteDaoJpa3();
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

        Collection<ClienteJpa2> clienteJpaCollection3 = clienteDaoJpa3.buscarTodos();
        clienteJpaCollection3.forEach(clienteJpa -> {
            try{
                clienteDaoJpa3.excluir(clienteJpa);
            } catch (DAOException e){
                e.printStackTrace();
            }
        });
    }

    @Test
    public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa2 clienteJpaNew3 = criarCliente2();
        clienteDaoJpa.cadastrar(clienteJpa);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(clienteJpa.getId());
        assertNotNull(clienteJpa1);

        clienteJpa.setId(null);
        clienteDaoJpa3.cadastrar(clienteJpaNew3);

        ClienteJpa2 clienteJpa3 = clienteDaoJpa3.consultar(clienteJpaNew3.getId());
        assertNotNull(clienteJpa3);

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
    private ClienteJpa2 criarCliente2() {
        ClienteJpa2 clienteJpa = new ClienteJpa2();
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
        ClienteJpa2 clienteJpaNew3 = criarCliente2();
        ClienteJpa2 retorno3 = clienteDaoJpa3.cadastrar(clienteJpaNew3);

        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);

        assertNotNull(retorno);
        assertNotNull(retorno3);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        ClienteJpa2 clienteJpa3 = clienteDaoJpa3.consultar(retorno3.getId());
        assertNotNull(clienteJpa3);

        clienteDaoJpa.excluir(clienteJpa);
        clienteDaoJpa3.excluir(clienteJpaNew3);


        ClienteJpa clienteJpa11 = clienteDaoJpa.consultar(retorno.getId());
        assertNull(clienteJpa11);

        ClienteJpa2 clienteJpa33 = clienteDaoJpa3.consultar(retorno3.getId());
        assertNull(clienteJpa33);
    }

    @Test
    public void excluirCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa2 clienteJpaNew3 = criarCliente2();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa2 retorno3 = clienteDaoJpa3.cadastrar(clienteJpaNew3);

        assertNotNull(retorno);
        assertNotNull(retorno3);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        ClienteJpa2 clienteJpa3 = clienteDaoJpa3.consultar(retorno3.getId());
        assertNotNull(clienteJpa3);

        clienteDaoJpa.excluir(clienteJpa);
        clienteDaoJpa3.excluir(clienteJpaNew3);


        clienteJpa1 = clienteDaoJpa.consultar(clienteJpa.getId());
        assertNull(clienteJpa1);

        clienteJpa3 = clienteDaoJpa3.consultar(clienteJpaNew3.getId());
        assertNull(clienteJpa3);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa2 clienteJpaNew3 = criarCliente2();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa2 retorno3 = clienteDaoJpa3.cadastrar(clienteJpaNew3);

        assertNotNull(retorno);
        assertNotNull(retorno3);

        ClienteJpa clienteJpa1 = clienteDaoJpa.consultar(retorno.getId());
        assertNotNull(clienteJpa1);

        ClienteJpa2 clienteJpa3 = clienteDaoJpa3.consultar(retorno3.getId());
        assertNotNull(clienteJpa3);

        clienteJpa1.setNome("ANDREO");
        clienteDaoJpa.alterar(clienteJpa1);
        clienteJpa3.setNome("ANDREO3");
        clienteDaoJpa3.alterar(clienteJpa3);

        ClienteJpa clienteJpaAlterado = clienteDaoJpa.consultar(clienteJpa1.getId());
        assertNotNull(clienteJpaAlterado);
        assertEquals("ANDREO", clienteJpaAlterado.getNome());

        ClienteJpa2 clienteJpaAlterado3 = clienteDaoJpa3.consultar(clienteJpa3.getId());
        assertNotNull(clienteJpaAlterado3);
        assertEquals("ANDREO3", clienteJpaAlterado3.getNome());

        clienteDaoJpa.excluir(clienteJpa);
        clienteJpa1 = clienteDaoJpa.consultar(clienteJpaAlterado.getId());
        assertNull(clienteJpa1);

        clienteDaoJpa3.excluir(clienteJpaNew3);
        clienteJpa3 = clienteDaoJpa3.consultar(clienteJpaAlterado3.getId());
        assertNull(clienteJpa3);
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ClienteJpa clienteJpa = criarCliente();
        ClienteJpa2 clienteJpaNew3 = criarCliente2();
        ClienteJpa retorno = clienteDaoJpa.cadastrar(clienteJpa);
        ClienteJpa2 retorno3 = clienteDaoJpa3.cadastrar(clienteJpaNew3);

        assertNotNull(retorno);
        assertNotNull(retorno3);


        ClienteJpa clienteJpa1 = criarCliente();
        ClienteJpa retorno1 = clienteDaoJpa.cadastrar(clienteJpa1);
        assertNotNull(retorno1);

        ClienteJpa2 clienteJpa13 = criarCliente2();
        ClienteJpa2 retorno13 = clienteDaoJpa3.cadastrar(clienteJpa13);
        assertNotNull(retorno13);

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

        Collection< ClienteJpa2> clienteJpaCollection3 = clienteDaoJpa3.buscarTodos();
        assertTrue(clienteJpaCollection3 != null);
        assertTrue(clienteJpaCollection3.size() == 2);

        clienteJpaCollection3.forEach(cli -> {
            try {
                clienteDaoJpa3.excluir(cli);
            }catch (DAOException e) {
                e.printStackTrace();
            }
        });

        Collection< ClienteJpa> clienteJpaCollection1 = clienteDaoJpa.buscarTodos();
        assertTrue(clienteJpaCollection1 != null);
        assertTrue(clienteJpaCollection1.size() == 0);

        Collection< ClienteJpa2> clienteJpaCollection13 = clienteDaoJpa3.buscarTodos();
        assertTrue(clienteJpaCollection13 != null);
        assertTrue(clienteJpaCollection13.size() == 0);
    }










}
