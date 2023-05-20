package Service;

import Domain.Persists;
import Generic.IGenericDAO;

import java.io.Serializable;

public class GenericService<T extends Persists, E extends Serializable> implements IGenericService<T, E> {

    protected IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao){
        this.dao = dao;
    }

    public GenericService() {

    }


    @Override
    public boolean cadastrar(T entity) {
        return true;
    }

    public T buscarPorCpf(E key) {
        return dao.consultar(key);
    }

    public void excluir(E key) {
        dao.excluir(key);
    }

    @Override
    public void alterar(T entity) {

    }
}
