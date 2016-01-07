package business.handlers;

import javax.ejb.Remote;

import business.ApplicationException;
import business.DiscountDTO;


@Remote
public interface AddCustomerHandlerRemote {

	void addCustomer(int vat, String domination, int phoneNumber, int discountType) throws ApplicationException;
	

	Iterable<DiscountDTO> getDiscounts() throws ApplicationException;
	
}
