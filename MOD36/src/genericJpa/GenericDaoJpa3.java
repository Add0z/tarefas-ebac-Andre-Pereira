package genericJpa;

import java.io.Serializable;

public abstract class GenericDaoJpa3 <T extends Persistente, E extends Serializable>
        extends GenericDaoJpa<T,E> {

    public GenericDaoJpa3(Class<T> persistenteClass) {
        super(persistenteClass, "Mysql1");
    }
}