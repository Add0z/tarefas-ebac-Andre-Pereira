package DaoJpa;

import DomainJpa.VendaJpa;
import exception.DAOException;
import exception.TipoChaveNaoEncontradaException;
import genericJpa.IGenericJpaDao;

public interface IVendaDaoJpa extends IGenericJpaDao<VendaJpa, Long> {
    public void finalizarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException;
    public void cancelarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException;
    public VendaJpa  consultarCollection(Long id);
}
