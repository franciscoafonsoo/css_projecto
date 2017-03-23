package facade.handlers;

import business.Discount;
import facade.dto.CustomerDTO;
import facade.exceptions.ApplicationException;

import javax.ejb.Remote;

@Remote
public interface IAddCustomerHandlerRemote {

	public CustomerDTO addCustomer (int vat, String denomination, 
			int phoneNumber, int discountType) 
			throws ApplicationException;
	
	public Iterable<Discount> getDiscounts() throws ApplicationException;
}
