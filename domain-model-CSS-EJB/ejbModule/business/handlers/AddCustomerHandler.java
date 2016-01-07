package business.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import business.ApplicationException;
import business.CustomerCatalog;
import business.Discount;
import business.DiscountCatalog;
import business.DiscountDTO;

/**
 * Handles the add customer use case. This represents a very 
 * simplified use case with just one operation: addCustomer.
 * 
 * @author fmartins
 * @version 1.1 (17/04/2015)
 *
 */

@Stateless
public class AddCustomerHandler implements AddCustomerHandlerRemote {
	
	/**
	 * The customer's catalog
	 */
	@EJB private CustomerCatalog customerCatalog;
	
	/**
	 * The discount's catalog 
	 */
	@EJB private DiscountCatalog discountCatalog;
	
	/**
	 * Creates a handler for the add customer use case given
	 * the customer and the discount catalogs.
	 *  
	 * @param customerCatalog A customer's catalog
	 * @param discountCatalog A discount's catalog
	*/

	/**
	 * Adds a new customer with a valid Number. It checks that there is no other 
	 * customer in the database with the same VAT.
	 * 
	 * @param vat The VAT of the customer
	 * @param denomination The customer's name
	 * @param phoneNumber The customer's phone 
	 * @param discountType The type of discount applicable to the customer
	 * @throws ApplicationException When the VAT number is invalid (we check it according 
	 * to the Portuguese legislation).
	 */
	public void addCustomer (int vat, String denomination, 
			int phoneNumber, int discountType) 
			throws ApplicationException {
		Discount discount = discountCatalog.getDiscount(discountType);
		customerCatalog.addCustomer(vat, denomination, phoneNumber, discount);
	}	
	
	public Iterable<DiscountDTO> getDiscounts() throws ApplicationException {
		List<DiscountDTO> l = new ArrayList<DiscountDTO>();
		for (Discount d : discountCatalog.getDiscounts()) {
			DiscountDTO discount = new DiscountDTO(d.getId(), d.getDescription());
			l.add(discount);
		}
		return l;
	}

}
