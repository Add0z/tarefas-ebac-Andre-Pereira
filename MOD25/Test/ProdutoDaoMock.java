import Annotation.TipochaveExcep;
import Produto.Dao.IProdutoDAO;
import Produto.Dao.ProdutoDAO;
import Produto.Produto;

import java.math.BigDecimal;

public class ProdutoDaoMock implements IProdutoDAO {


    @Override
    public Boolean cadastrar(Produto entity) throws TipochaveExcep {
        return true;
    }

    @Override
    public Produto consultar(String valor) {
        Produto produto = new Produto();
        produto.setCodigo(valor);
        return produto;
    }

    @Override
    public void excluir(String chave) {

    }

    @Override
    public void alterar(Produto entity) throws TipochaveExcep {

    }
}

