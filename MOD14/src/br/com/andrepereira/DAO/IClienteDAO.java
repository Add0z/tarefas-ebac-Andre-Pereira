package br.com.andrepereira.DAO;

import br.com.andrepereira.domain.Cliente;

import java.util.Collection;

import java.util.Collections;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar(Long cpf);

    public default Collection<Cliente> buscarTodos() {
        return null;
    }
}
