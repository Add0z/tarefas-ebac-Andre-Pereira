/**
 * 
 */
package dao;

import java.util.List;

import javax.persistence.TypedQuery;

import dao.generic.GenericDAO;
import domain.Produto;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		TypedQuery<Produto> tpQuery = 
				this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}

}
