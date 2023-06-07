import DaoJpa.IVendaDaoJpa;
import DomainJpa.VendaJpa;
import exception.DAOException;
import exception.TipoChaveNaoEncontradaException;
import genericJpa.GenericDaoJpa;

public class VendaExclusaoDaoJpaTest extends GenericDaoJpa<VendaJpa, Long> implements IVendaDaoJpa {

    public VendaExclusaoDaoJpaTest(){
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException {

    }

    @Override
    public void cancelarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException {

    }

    @Override
    public VendaJpa consultarCollection(Long id) {
        return null;
    }
}
