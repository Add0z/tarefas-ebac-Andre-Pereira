import Produto.Dao.IProdutoDAO;
import Produto.Produto;
import Service.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoServiceTest {

    Produto produto;
    IProdutoDAO produtoDaoMock;

    ProdutoService produtoService;

    public ProdutoServiceTest(){
        produtoDaoMock = new ProdutoDaoMock().dao;
        produtoService = new ProdutoService(produtoDaoMock);
    }

    @Before
    public void aux(){
        produto = new Produto(1L,"telefone", "iphone",new BigDecimal("5000"));
    }

    @Test
    public void cadastrarTest(){
        boolean retorno = produtoService.cadastrar(new Produto(3L,"telefone", "iphone",new BigDecimal("5000")));
        Assert.assertTrue(retorno);
        Assert.assertFalse(produtoService.cadastrar(new Produto(3L,"telefone", "iphone",new BigDecimal("5000"))));
    }

    @Test
    public void consultarTest(){
        Produto retorno = produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(retorno.getDescricao());
    }

    @Test
    public void atualizatTest(){
//        produto.setDescricao("samsung");
//        produtoService.alterar(produto);
        produto.setDescricao("samsung");
        produtoService.alterar(produto);
        Produto retorno = produtoService.consultar(produto.getCodigo());
        Assert.assertEquals("samsung", retorno.getDescricao());
    }

    @Test
    public void excluriTest(){

        Assert.assertTrue(produtoService.excluir(produto.getCodigo()));
    }
}
