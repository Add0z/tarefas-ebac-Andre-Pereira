import Produto.Dao.IProdutoDAO;
import Produto.Dao.ProdutoDAO;
import Produto.Produto;

import java.math.BigDecimal;

public class ProdutoDaoMock {

    public IProdutoDAO dao;

            ProdutoDaoMock(){
                dao = new ProdutoDAO();
                dao.cadastrar(new Produto(1l,"telefone","iphone", new BigDecimal("5000")));
            }

    /*Produto produto = new Produto(1l,"telefone","iphone", new BigDecimal("5000"));
    @Override
    public boolean cadastrar(Produto entity) {

        return true;
    }

    @Override
    public Produto consultar(Long chave) {
        return produto;
    }



    @Override
    public void excluir(Long chave) {

    }*/
}

