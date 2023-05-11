package br.com.andrepereira.DAO;

import br.com.andrepereira.domain.Cliente;
import br.com.andrepereira.domain.Produto;
import br.com.andrepereira.generic.GenericDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO{

    public ProdutoDAO () {
        super();
        Map<Long, Produto> mapIner = this.map.get(getClassType());
        if (mapIner ==  null){
            mapIner = new HashMap<>();
            this.map.put(getClassType(), mapIner);
        }
    }

    @Override
    public Class<Produto> getClassType() {
        return Produto.class;
    }

    @Override
    public void atualizar(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setName(entity.getName());
        entityCadastrado.setCode(entity.getCode());


    }
}
