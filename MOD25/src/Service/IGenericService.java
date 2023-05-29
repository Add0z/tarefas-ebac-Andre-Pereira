package Service;

import Annotation.TipochaveExcep;
import Cliente.Persists;

import java.io.Serializable;

public interface IGenericService<T extends Persists, E extends Serializable> {
    public Boolean cadastrar(T entity) throws TipochaveExcep ;

    public T consultar(E key);

   public void excluir(E key);

    public void alterar(T entity)  throws TipochaveExcep;
}
