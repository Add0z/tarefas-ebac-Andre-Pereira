package Dao;

import Domain.Cliente;
import Domain.Produto;

import java.util.List;

public interface IProdutoDao {

    public Integer cadastrar(Produto produto) throws Exception;
    public Integer atualizar(Produto produto) throws Exception;
    public Produto buscar (String codigo) throws Exception;
    public Integer excluir(Produto produto) throws Exception;
    public List<Produto> buscarTodos() throws Exception;

}
