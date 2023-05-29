package Service;

import Annotation.TipochaveExcep;
import Cliente.Persists;
import Generic.IGenericDAO;

import java.io.Serializable;


public abstract class GenericService<T extends Persists, E extends Serializable>
        implements IGenericService<T, E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao){this.dao = dao;}
    @Override
    public Boolean cadastrar(T entity) throws TipochaveExcep {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(E valor) {
        this.dao.excluir(valor);
    }
    @Override

    public void alterar(T entity)  throws TipochaveExcep  {
         this.dao.alterar(entity);

    }
    @Override
    public T consultar(E valor) {
        return this.dao.consultar(valor);
    }



}
