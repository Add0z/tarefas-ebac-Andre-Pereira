package DaoJpa;

import DomainJpa.ClienteJpa;
import genericJpa.GenericDaoJpa1;
import genericJpa.GenericDaoJpa2;

public class ClienteDaoJpa2 extends GenericDaoJpa2<ClienteJpa, Long> implements IClienteDaoJpa<ClienteJpa> {
    public ClienteDaoJpa2(){
        super(ClienteJpa.class);
    }
}