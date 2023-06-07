package DaoJpa;

import DomainJpa.ClienteJpa;
import genericJpa.IGenericJpaDao;
import genericJpa.Persistente;

public interface IClienteDaoJpa<T extends Persistente> extends IGenericJpaDao<T, Long> {
}
