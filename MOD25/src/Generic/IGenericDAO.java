package Generic;
import Cliente.Persists;


import java.io.Serializable;

public interface IGenericDAO <T extends Persists, E extends Serializable> {

     boolean cadastrar(T entity);

    T consultar(E chave);

    boolean alterar(T entity);

    boolean excluir(E chave);
}
