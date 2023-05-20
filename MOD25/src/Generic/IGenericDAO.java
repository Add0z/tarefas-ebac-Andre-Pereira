package Generic;
import Domain.Persists;


import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persists, E extends Serializable> {

     boolean cadastrar(T entity);

     void excluir(E chave);

    void alterar(T entity);
     T consultar(E chave);

     default Collection<T> buscarTodos() {
        return null;
    }

}
