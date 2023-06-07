package DaoJpa;

import DomainJpa.ProdutoJpa;
import genericJpa.GenericDaoJpa;

public class ProdutoDaoJpa extends GenericDaoJpa<ProdutoJpa, Long> implements IProdutoDaoJpa {
    public ProdutoDaoJpa(){
        super(ProdutoJpa.class);
    }
}
