package Dao;

import Domain.Cliente;
import Generic.GenericDAO;

import java.io.Serializable;

public class ClienteDao extends GenericDAO<Cliente, String> implements IClienteDao {

    public ClienteDao(){
        super();
    }

    @Override
    public Class<Cliente> getClassType() {
        return Cliente.class;
    }

    @Override
    public void atualizar(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setCpf(Long.valueOf(entity.getCpf()));
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setEnd(entity.getEnd());
        entityCadastrado.setTel(entityCadastrado.getTel());
    }
}
