/**
 * 
 */
package service;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.IProdutoDAO;
import domain.Produto;
import services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}
