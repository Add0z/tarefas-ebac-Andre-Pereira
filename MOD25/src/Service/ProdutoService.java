package Service;

import Generic.GenericDAO;
import Generic.IGenericDAO;
import Produto.Dao.IProdutoDAO;
import Produto.Produto;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}

