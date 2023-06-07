package DaoJpa;

import DomainJpa.ProdutoJpa;
import genericJpa.GenericDaoJpa;
import genericJpa.GenericDaoJpa1;

public class ProdutoDaoJpa extends GenericDaoJpa1<ProdutoJpa, Long> implements IProdutoDaoJpa {
    public ProdutoDaoJpa(){
        super(ProdutoJpa.class);
    }
}
