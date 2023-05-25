package Produto.Dao;

import Generic.IGenericDAO;
import Produto.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, Long> {
    void alterar(Produto entity, Produto entityCadastrado);
}
