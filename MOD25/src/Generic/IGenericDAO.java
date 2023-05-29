package Generic;
import Annotation.TipochaveExcep;
import Cliente.Persists;


import java.io.Serializable;

public interface IGenericDAO <T extends Persists, E extends Serializable> {

    public Boolean cadastrar(T entity) throws TipochaveExcep;

    public T consultar(E valor);

    public void alterar(T entity) throws TipochaveExcep;

    public void excluir(E chave);
}
