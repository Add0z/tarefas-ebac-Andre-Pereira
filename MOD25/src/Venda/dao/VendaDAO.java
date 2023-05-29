package Venda.dao;

import Annotation.TipochaveExcep;
import Generic.GenericDAO;
import Venda.Venda;

public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {


    @Override
    public Class<Venda> getClassType() {
        return null;
    }

    @Override
    public void excluir(String valor) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }


    @Override
    public void atualizarDados(Venda entity, Venda entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setStatus(entity.getStatus());
    }
    @Override
    public void finalizarVenda(Venda venda) throws TipochaveExcep {
        venda.setStatus(Venda.Status.CONCLUIDA);
        super.alterar(venda);
    }
}
