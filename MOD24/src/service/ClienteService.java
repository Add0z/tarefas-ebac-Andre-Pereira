package service;

import dao.IClienteDao;

public class ClienteService implements IClienteService{
    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }

    @Override
    public String salvar() {
        clienteDao.salvar();
        return "Sucesso cliente salvar";
    }

    @Override
    public String buscar() {
        clienteDao.buscar();
        return "Sucesso cliente buscar";
    }

}
