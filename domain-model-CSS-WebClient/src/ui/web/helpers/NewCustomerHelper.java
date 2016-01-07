package ui.web.helpers;

import java.util.LinkedList;

import business.handlers.AddCustomerHandlerRemote;
import business.ApplicationException;
import business.DiscountDTO;

/**
 * Helper class to assist in the response of novo cliente.
 * This class is the response information expert.
 * 
 * @author fmartins
 *
 */ 
public class NewCustomerHelper extends Helper {

	private String designation;
	private String vatNumber;
	private String phoneNumber;
	private String discountType;
	private AddCustomerHandlerRemote addCustomerHandler;
		
	public void setAddCustomerHandler(AddCustomerHandlerRemote addCustomerHandler) {
		this.addCustomerHandler = addCustomerHandler;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;	
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public String getVATNumber() {
		return vatNumber;
	}
	
	public void setVATNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDiscountType() {
		return discountType;
	}
	
	public void clearFields() {
		designation = vatNumber = phoneNumber = "";
		discountType = "1";
	}
	
	public Iterable<DiscountDTO> getDiscounts () {
		try {
			return addCustomerHandler.getDiscounts();
		} catch (ApplicationException e) {
			return new LinkedList<DiscountDTO> ();		
		}
	}	
}
