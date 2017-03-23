package business;

import facade.dto.CustomerDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IRemoveCustomerHandlerRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

/**
 * Handles the remove customer use case. This represents a very 
 * simplified use case that gets customers and deletes one of the
 * customers given its id. It illustrates the use of data transfer
 * objects to carry information about customers.
 * 
 * @author fmartins
 * @version 1.1 (17/04/2015)
 *
 */
@Stateless
public class RemoveCustomerHandler implements IRemoveCustomerHandlerRemote {
	
	/**
	 * The customer's catalog
	 */
	@EJB
	private CustomerCatalog customerCatalog;

	@Override
	public CustomerDTO getCustomer(int id) throws ApplicationException {
		Customer c = customerCatalog.getCustomerById(id);
		return new CustomerDTO(c.getVATNumber(), c.getDesignation(), c.getId());
	}

	@Override
	public Iterable<CustomerDTO> getCustomers() {
		List<CustomerDTO> customers = new LinkedList<>();
		for (Customer c : customerCatalog.getCustomers())
			customers.add(new CustomerDTO(c.getVATNumber(), c.getDesignation(), c.getId()));
		return customers;
	}

	@Override
	public void deleteCustomer(int id) throws ApplicationException {
		customerCatalog.deleteCustomer(id);
	}
	
}
