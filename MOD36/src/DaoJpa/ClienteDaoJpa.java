package DaoJpa;

import DomainJpa.ClienteJpa;
import genericJpa.GenericDaoJpa;
import genericJpa.GenericDaoJpa1;

public class ClienteDaoJpa extends GenericDaoJpa1<ClienteJpa, Long> implements IClienteDaoJpa<ClienteJpa> {
    public ClienteDaoJpa(){
        super(ClienteJpa.class);
    }
}
