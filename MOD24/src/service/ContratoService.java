package service;

import dao.IContratoDao;

public class ContratoService implements IContratoService {
    private IContratoDao contratoDao;

    public ContratoService(IContratoDao daoDao) {
        this.contratoDao = daoDao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso contrato salvar";
    }

    @Override
    public String buscar() {
        contratoDao.buscar();
        return "Sucesso contrato buscar";
    }

    @Override
    public String alterar() {
        contratoDao.alterar();
        return "Sucesso contrato alterar";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Sucesso contrato excluir";
    }
}
