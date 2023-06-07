package genericJpa;

import java.io.Serializable;

public abstract class GenericDaoJpa1 <T extends Persistente, E extends Serializable>
        extends GenericDaoJpa<T,E> {

    public GenericDaoJpa1(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre1");
    }
}
