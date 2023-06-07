package genericJpa;

import exception.DAOException;
import exception.MaisDeUmRegistroException;
import exception.TableException;
import exception.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericJpaDao <T extends Persistente, E extends Serializable> {

    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public void excluir(T entity) throws DAOException;
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException;
    public Collection<T> buscarTodos() throws DAOException;
}
