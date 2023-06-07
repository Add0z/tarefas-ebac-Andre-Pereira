package genericJpa;

import java.io.Serializable;

public abstract class GenericDaoJpa2 <T extends Persistente, E extends Serializable>
        extends GenericDaoJpa<T,E> {

    public GenericDaoJpa2(Class<T> persistenteClass) {
        super(persistenteClass, "Postgre2");
    }
}