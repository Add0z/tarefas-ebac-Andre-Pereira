package DaoJpa;

import DomainJpa.ClienteJpa;
import DomainJpa.ProdutoJpa;
import DomainJpa.VendaJpa;
import exception.DAOException;
import exception.TipoChaveNaoEncontradaException;
import genericJpa.GenericDaoJpa;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.Type;

public class VendaDaoJpa extends GenericDaoJpa<VendaJpa, Long> implements IVendaDaoJpa {

    public VendaDaoJpa(){
        super(VendaJpa.class);
    }

    @Override
    public void finalizarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(vendaJpa);

    }

    @Override
    public void cancelarVenda(VendaJpa vendaJpa) throws TipoChaveNaoEncontradaException, DAOException {
        super.alterar(vendaJpa);
    }

    @Override
    public void excluir(VendaJpa entity) throws DAOException{
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    @Override
    public VendaJpa cadastrar(VendaJpa entity) throws TipoChaveNaoEncontradaException, DAOException {
        try{
            openConnection();
            entity.getProdutos().forEach(prod -> {
                ProdutoJpa produtoJpa = entityManager.merge(prod.getProduto());
                prod.setProduto(produtoJpa);
            });
            ClienteJpa clienteJpa = entityManager.merge(entity.getCliente());
            entity.setCliente(clienteJpa);
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e){
            throw new DAOException("ERRO SALVANDO VENDA", e);
        }
    }


    @Override
    public VendaJpa consultarCollection(Long id) {
        openConnection();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery< VendaJpa> query = builder.createQuery(VendaJpa.class);
        Root<VendaJpa> root = query.from(VendaJpa.class);
        root.fetch("cliente");
        root.fetch("produtos");
        query.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery< VendaJpa> tpQuery = entityManager.createQuery(query);
        VendaJpa vendaJpa = tpQuery.getSingleResult();
        closeConnection();
        return vendaJpa;
    }
}
