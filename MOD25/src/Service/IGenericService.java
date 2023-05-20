package Service;

import Domain.Cliente;
import Domain.Persists;

import java.io.Serializable;
//package Domain;

public interface IGenericService<T extends Persists, E extends Serializable> {
    boolean cadastrar(T entity) ;

    T buscarPorCpf(E key);

    void excluir(E key);

    void alterar(T entity) ;
}
