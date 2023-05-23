package Service;

import Domain.Persists;
import Generic.IGenericDAO;

import java.io.Serializable;


public class GenericService<T extends Persists, E extends Serializable> implements IGenericService<T, E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao){

        this.dao = dao;
    }


    @Override
    public boolean cadastrar(T entity) {
        return dao.cadastrar(entity);
    }

    public T consultar(E key) {
        return dao.consultar(key);
    }
    @Override
    public boolean alterar(T entity) {
       return dao.alterar(entity);

    }
    public boolean excluir(E key) {
        return dao.excluir(key);
    }


}
