package br.com.andrepereira.generic;

import br.com.andrepereira.Annotation.TipoChave;
import br.com.andrepereira.domain.Cliente;
import br.com.andrepereira.domain.Persists;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    public Boolean cadastrar(T entity) {
        Map<Long, T> mapIner = this.map.get(getClassType());
        Long chave = getChave(entity);
        if (mapIner.containsKey(chave)) {
            return false;
        }
        mapIner.put(chave, entity);
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
        Long chave = getChave(entity);
        T  objCadastrado = mapInter.get(chave);
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
