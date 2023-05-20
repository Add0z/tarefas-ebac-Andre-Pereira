package Generic;


import Annotation.TipoChave;
import Domain.Persists;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends Persists, E extends Serializable> implements IGenericDAO<T, E> {
    protected Map<Class, Map<Long, T>> map;

    public abstract Class<T> getClassType();

    public abstract void atualizar(T entity, T entityCadastrado);

    public GenericDAO() {
        if (this.map == null) {
            this.map = new HashMap<>();
        }
    }

    public Long getChave(T entity){
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field: fields){
            if (field.isAnnotationPresent(TipoChave.class)){
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMethod = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMethod);
                    Long valeu = (Long) method.invoke(entity);
                    return valeu;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }

        }
        return null;
    }

    @Override
    public boolean cadastrar(T entity) {
        Map<Long, T> mapIner = this.map.get(getClassType());
        Long chave = getChave(entity);
        if (mapIner.containsKey(chave)) {
            return false;
        }
        mapIner.put(chave, entity);
        return true;
    }

    @Override
    public void excluir(Serializable chave) {
        Map<Long, T> mapInter = this.map.get(getClassType());
        T objCadastrado = mapInter.get(chave);
        if (objCadastrado != null) {
            this.map.remove(chave, objCadastrado);
        }

    }

    @Override
    public void alterar(T entity) {
        Map<Long, T> mapInter = this.map.get(getClassType());
        Long chave = getChave(entity);
        T  objCadastrado = mapInter.get(chave);
        if (objCadastrado != null) {
            atualizar(entity, objCadastrado);

        }
    }

    @Override
    public T consultar(E chave) {
        Map<Long, T> mapInter = this.map.get(getClassType());
        return mapInter.get(chave);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T> mapInter = this.map.get(getClassType());

        return mapInter.values();
    }
}
