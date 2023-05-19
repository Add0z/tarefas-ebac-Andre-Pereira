package dao;

public class ClienteDao
implements IClienteDao{

    public String salvar() {
        throw new UnsupportedOperationException("Não funciona sem conf de banco SALVAR");
//        return "Sucesso";
    }

    @Override
    public String buscar() {

        throw new UnsupportedOperationException("Não funciona sem conf de banco BUSCAR");
    }
}
