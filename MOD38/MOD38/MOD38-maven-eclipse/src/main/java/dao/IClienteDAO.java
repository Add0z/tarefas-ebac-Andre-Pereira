/**
 * 
 */
package dao;

import java.util.List;

import dao.generic.IGenericDAO;
import domain.Cliente;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

	List<Cliente> filtrarClientes(String query);

}
