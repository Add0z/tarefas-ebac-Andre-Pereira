package DaoJpa;

import DomainJpa.ClienteJpa;
import genericJpa.GenericDaoJpa;

public class ClienteDaoJpa extends GenericDaoJpa<ClienteJpa, Long> implements IClienteDaoJpa {
    public ClienteDaoJpa(){
        super(ClienteJpa.class);
    }
}
