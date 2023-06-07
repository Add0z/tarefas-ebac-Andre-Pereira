package DaoJpa;

import DomainJpa.ClienteJpa;
import DomainJpa.ClienteJpa2;
import genericJpa.GenericDaoJpa2;
import genericJpa.GenericDaoJpa3;

public class ClienteDaoJpa3 extends GenericDaoJpa3<ClienteJpa2, Long> implements IClienteDaoJpa<ClienteJpa2> {
    public ClienteDaoJpa3(){
        super(ClienteJpa2.class);
    }
}