package br.com.andrepereira.generic;

import br.com.andrepereira.domain.Persists;
import br.com.andrepereira.domain.Produto;

import java.util.Collection;

public interface IGenericDAO <T extends Persists> {

    public Boolean cadastrar(T entity);

    public void excluir(Long valor);
    public void alterar(T entity);
    public T consultar(Long valor);

    public default Collection<T> buscarTodos() {
        return null;
    }


}
