package Service;

import Domain.Persists;

import java.io.Serializable;

public interface IGenericService<T extends Persists, E extends Serializable> {
    boolean cadastrar(T entity) ;

    T consultar(E key);

    boolean excluir(E key);

    boolean alterar(T entity) ;
}
