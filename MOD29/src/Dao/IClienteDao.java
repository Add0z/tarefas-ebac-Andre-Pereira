package Dao;

import Domain.Cliente;

import java.util.List;

public interface IClienteDao {

    public Integer cadastrar(Cliente cliente) throws Exception;
    public Integer atualizar(Cliente cliente) throws Exception;
    public Cliente buscar(String codigo) throws Exception;
    public Integer excluir(Cliente cliente) throws Exception;
    public List<Cliente> buscarTodos() throws Exception;
}
