package br.com.andrepereira.DAO;

import br.com.andrepereira.domain.Cliente;
import br.com.andrepereira.generic.GenericDAO;
import br.com.andrepereira.generic.IGenericDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteMapDAO extends GenericDAO<Cliente> implements IClienteDAO {

    public ClienteMapDAO () {
        super();
        Map<Long, Cliente>mapIner = this.map.get(getClassType());
        if (mapIner ==  null){
            mapIner = new HashMap<>();
            this.map.put(getClassType(), mapIner);
        }

    }

    public Class<Cliente> getClassType() {
        return Cliente.class;
    }

    @Override
    public void atualizar(Cliente cliente, Cliente entityCadastrado) {
        entityCadastrado.setNome(cliente.getNome());
        entityCadastrado.setTel(cliente.getTel());
        entityCadastrado.setNumero(cliente.getNumero());
        entityCadastrado.setEnd(cliente.getEnd());
        entityCadastrado.setCidade(cliente.getCidade());
        entityCadastrado.setEstado(cliente.getEstado());

    }


//    private Map<Long, Cliente> map;
//
//    public ClienteMapDAO () {
//        this.map = new HashMap<>();
//    }
//
//    @Override
//    public Boolean cadastrar(Cliente cliente) {
//        if (this.map.containsKey(cliente.getCpf())) {
//            return false;
//        }
//        this.map.put(cliente.getCpf(), cliente);
//        return true;
//    }
//
//    @Override
//    public void excluir(Long cpf) {
//        Cliente clienteCadastrado = this.map.get(cpf);
//
//        if (clienteCadastrado != null) {
//            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
//        }
//
//    }
//
//    @Override
//    public void alterar(Cliente cliente) {
//        Cliente clienteCadastrado = this.map.get(cliente.getCpf());
//        if (clienteCadastrado != null) {
//            clienteCadastrado.setNome(cliente.getNome());
//            clienteCadastrado.setTel(cliente.getTel());
//            clienteCadastrado.setNumero(cliente.getNumero());
//            clienteCadastrado.setEnd(cliente.getEnd());
//            clienteCadastrado.setCidade(cliente.getCidade());
//            clienteCadastrado.setEstado(cliente.getEstado());
//
//        }
//
//    }
//
//    @Override
//    public Cliente consultar(Long cpf) {
//        return this.map.get(cpf);
//    }
//
//    @Override
//    public Collection<Cliente> buscarTodos() {
//        return this.map.values();
//    }
}
