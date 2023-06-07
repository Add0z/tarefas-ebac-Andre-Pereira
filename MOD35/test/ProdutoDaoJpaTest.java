import DaoJpa.IProdutoDaoJpa;
import DaoJpa.ProdutoDaoJpa;
import DomainJpa.ProdutoJpa;
import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.*;

public class ProdutoDaoJpaTest {

    private IProdutoDaoJpa produtoDaoJpa;

    public ProdutoDaoJpaTest(){
        this.produtoDaoJpa = new ProdutoDaoJpa();
    }

    @After
    public void end() throws DAOException{
        Collection<ProdutoJpa> produtoJpaCollection = produtoDaoJpa.buscarTodos();
        produtoJpaCollection.forEach(cli -> {
            try {
                produtoDaoJpa.excluir(cli);
            } catch (DAOException e ){
                e.printStackTrace();
            }
        });

    }

    @Test
    public void pesquisar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produtoJpa = criaProduto("A1");
        assertNotNull(produtoJpa);
        ProdutoJpa produtoDB = this.produtoDaoJpa.consultar(produtoJpa.getId());
        assertNotNull(produtoDB);
        
    }

    private ProdutoJpa criaProduto(String a1) throws DAOException, TipoChaveNaoEncontradaException {
        ProdutoJpa produtoJpa = new ProdutoJpa();
        produtoJpa.setCodigo(a1);
        produtoJpa.setDescricao("Produto 1");
        produtoJpa.setNome("Produto 1");
        produtoJpa.setValor(BigDecimal.TEN);
        produtoJpa.setPacote("S");
        produtoJpa.setEstoque(10);
        produtoDaoJpa.cadastrar(produtoJpa);
        return produtoJpa;
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produtoJpa = criaProduto("A2");
        assertNotNull(produtoJpa);
    }

    @Test
    public void excluir() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produtoJpa = criaProduto("A3");
        assertNotNull(produtoJpa);
        this.produtoDaoJpa.excluir(produtoJpa);
        ProdutoJpa produtoJpaDB = this.produtoDaoJpa.consultar(produtoJpa.getId());
        assertNull(produtoJpaDB);
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        ProdutoJpa produtoJpa = criaProduto("A4");
        produtoJpa.setNome("Produto Alterado");
        produtoDaoJpa.alterar(produtoJpa);
        ProdutoJpa produtoJpaDB = this.produtoDaoJpa.consultar(produtoJpa.getId());
        assertNotNull(produtoJpaDB);
        assertEquals("Produto Alterado", produtoJpaDB.getNome());
    }

    @Test
    public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        criaProduto("A5");
        criaProduto("A6");
        Collection< ProdutoJpa> list = produtoDaoJpa.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 2);

        for (ProdutoJpa produtoJpa : list){
            this.produtoDaoJpa.excluir(produtoJpa);
        }

        list = produtoDaoJpa.buscarTodos();
        assertTrue(list != null);
        assertTrue(list.size() == 0);
    }














}
