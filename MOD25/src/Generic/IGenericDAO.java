package Generic;
import Domain.Persists;


import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persists, E extends Serializable> {

     boolean cadastrar(T entity);

    T consultar(E chave);

    boolean alterar(T entity);

    boolean excluir(E chave);
}
