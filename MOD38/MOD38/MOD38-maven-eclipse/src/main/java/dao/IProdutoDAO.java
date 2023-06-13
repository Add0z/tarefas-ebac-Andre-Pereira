/**
 * 
 */
package dao;

import java.util.List;

import dao.generic.IGenericDAO;
import domain.Produto;

/**
 * @author rodrigo.pires
 *
 */
public interface IProdutoDAO extends IGenericDAO<Produto, String>{

	List<Produto> filtrarProdutos(String query);

}
