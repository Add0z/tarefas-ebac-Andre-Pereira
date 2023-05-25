package Produto.Dao;

import Generic.GenericDAO;
import Produto.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

    public ProdutoDAO(){
        super();
    }
    @Override
    public Class<Produto> getClassType() {

        return Produto.class;
    }

    @Override
    public void alterar(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());


    }
}
