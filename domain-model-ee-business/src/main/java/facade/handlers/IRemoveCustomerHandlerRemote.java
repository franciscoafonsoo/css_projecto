package facade.handlers;

import facade.dto.CustomerDTO;
import facade.exceptions.ApplicationException;

import javax.ejb.Remote;

@Remote
public interface IRemoveCustomerHandlerRemote {

	public CustomerDTO getCustomer(int id) throws ApplicationException;

	public Iterable<CustomerDTO> getCustomers();

	public void deleteCustomer(int id) throws ApplicationException;
}
