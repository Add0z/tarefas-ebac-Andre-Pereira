package Service;

import Generic.GenericDAO;
import Generic.IGenericDAO;
import Produto.Produto;

public class ProdutoService extends GenericService<Produto, Long> {

    public ProdutoService(IGenericDAO<Produto, Long> dao){
        super(dao);
    }
}
