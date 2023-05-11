package br.com.andrepereira.generic;

import br.com.andrepereira.domain.Cliente;
import br.com.andrepereira.domain.Persists;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persists> implements IGenericDAO <T> {
    protected Map<Class, Map<Long, T>> map;

    public abstract Class<T> getClassType();

    public abstract void atualizar(T entity, T entityCadastrado);

    public GenericDAO() {
        if (this.map == null) {
            this.map = new HashMap<>();

        }
    }

    @Override
    public Boolean cadastrar(T entity) {
        Map<Long, T> mapIner = this.map.get(getClassType());
        if (mapIner.containsKey(entity.codeCatch())) {
            return false;
        }
        mapIner.put(entity.codeCatch(), entity);
        return true;
    }

    @Override
    public void excluir(Long valor) {
        Map<Long, T> mapInter = this.map.get(getClassType());
        T objCadastrado = mapInter.get(valor);
        if (objCadastrado != null) {
            this.map.remove(valor, objCadastrado);
        }

    }

    @Override
    public void alterar(T entity) {
        Map<Long, T> mapInter = this.map.get(getClassType());
        T  objCadastrado = mapInter.get(entity.codeCatch());
        if (objCadastrado != null) {
            atualizar(entity, objCadastrado);

        }
    }

    @Override
    public T consultar(Long valor) {
        Map<Long, T> mapInter = this.map.get(getClassType());
        return mapInter.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T> mapInter = this.map.get(getClassType());

        return mapInter.values();
    }
}
