package Venda.dao;

import Annotation.TipochaveExcep;
import Generic.IGenericDAO;
import Venda.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipochaveExcep;
}
