import Produto.Dao.IProdutoDAO;
import Produto.Dao.ProdutoDAO;
import Produto.Produto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoDaoTest {
    IProdutoDAO produtoDAO;
    //Produto produto;


    public ProdutoDaoTest() {
        produtoDAO = new ProdutoDAO();
    }

        @Before
        public void aux(){
            //produto = new Produto(1L,"telefone", "iphone",new BigDecimal("5000"));
            produtoDAO.cadastrar(new Produto(1L,"telefone", "iphone",new BigDecimal("5000")));

        }

        @Test
        public void cadastroProdutoTest(){
            boolean retorno = produtoDAO.cadastrar(new Produto(2L,"telefone", "iphone",new BigDecimal("5000")));
            Assert.assertTrue(retorno);
        }

        @Test
        public void consultarTest(){
            Produto retorno = produtoDAO.consultar(1l);
            /*System.out.println(produtoDAO.consultar(produto.getCodigo()));
            System.out.println(produtoDAO.consultar(1L));*/
            Assert.assertEquals(retorno.getNome(), "telefone");
        }

        @Test
        public void atualizarTest(){
        var produto = produtoDAO.consultar(1l);
        produto.setDescricao("samsung");
        produtoDAO.alterar(produto);
        Produto retorno = produtoDAO.consultar(produto.getCodigo());
        Assert.assertEquals("samsung",retorno.getDescricao());
//        Assert.assertEquals("samsung", produto.getDescricao());
        }



        @Test
        public void excluirTest(){
        produtoDAO.excluir(1l);
        Produto retorno = produtoDAO.consultar(1l);
        Assert.assertNull(retorno);
        }


}
