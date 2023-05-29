import Annotation.TipochaveExcep;
import Produto.Dao.IProdutoDAO;
import Produto.Produto;
import Service.IProdutoService;
import Service.ProdutoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDaoMock();
        produtoService = new ProdutoService(dao);
    }
    @Before
    public void aux(){
        produto = new Produto("1","telefone", "iphone",new BigDecimal("5000"));
    }

    @Test
    public void cadastrarTest() throws TipochaveExcep {
        Boolean retorno = produtoService.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void consultarTest(){
        Produto produtor = this.produtoService.consultar(produto.getCodigo());
        Assert.assertNotNull(produtor);
    }

    @Test
    public void atualizatTest() throws TipochaveExcep{
        produto.setNome("andre pereira");
        produtoService.alterar(produto);

        Assert.assertEquals("andre pereira", produto.getNome());
    }

    @Test
    public void excluriTest() {
        produtoService.excluir(String.valueOf(produto.getCodigo()));
    }
}
