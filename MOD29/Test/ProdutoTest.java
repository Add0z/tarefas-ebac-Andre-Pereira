import Dao.ClienteDao;
import Dao.IProdutoDao;
import Dao.ProdutoDao;
import Domain.Cliente;
import Domain.Produto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    private IProdutoDao produtoDao = new ProdutoDao();

    @Test
    public void cadastrarTest () throws Exception{
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("TELEFONE1");
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDao.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDao.excluir(produtoBD);
        assertTrue(countDel == 1);

    }

    @Test
    public void buscarTest() throws Exception{
        produtoDao = new ProdutoDao();
        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("TELEFONE2");
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDao.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDao.excluir(produtoBD);
        assertTrue(countDel == 1);

    }

    @Test
    public void excluirTest() throws Exception {
        produtoDao = new ProdutoDao();
        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("TELEFONE3");
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD= produtoDao.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDao.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("TELEFONE4");
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoS = new Produto();
        produtoS.setCodigo("20");
        produtoS.setNome("Teste");
        Integer countCad2 = produtoDao.cadastrar(produtoS);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto pro : list) {
            produtoDao.excluir(pro);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDao.buscarTodos();
        assertEquals(list.size(), 0);

    }
    @Test
    public void atualizarTest() throws Exception {
        produtoDao = new ProdutoDao();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("TELEFONE5");
        Integer countCad = produtoDao.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDao.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        produtoBD.setCodigo("20");
        produtoBD.setNome("Outro produto");
        Integer countUpdate = produtoDao.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoDao.buscar("10");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDao.buscar("20");
        assertNotNull(produtoBD2);
        assertEquals(produtoBD.getId(), produtoBD2.getId());
        assertEquals(produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoBD.getNome(), produtoBD2.getNome());

        List<Produto> list = produtoDao.buscarTodos();
        for (Produto pro : list) {
            produtoDao.excluir(pro);
        }
    }




























}
