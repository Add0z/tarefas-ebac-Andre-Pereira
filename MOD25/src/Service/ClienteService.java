package Service;

import Cliente.Cliente;
import Cliente.Dao.IClienteDao;
import Generic.IGenericDAO;

public class ClienteService extends GenericService<Cliente, Long>
        implements IClienteService{


    public ClienteService(IClienteDao clienteDAO) {
        super(clienteDAO);
        //this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente consultarCPF(Long cpf) {
        return this.dao.consultar(cpf);
    }


    }
