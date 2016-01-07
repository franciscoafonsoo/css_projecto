package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.web.helpers.NewCustomerHelper;
import business.ApplicationException;
import business.handlers.AddCustomerHandlerRemote;

/**
 * Handles the criar cliente event.
 * If the request is valid, it dispatches it to the domain model (the application's business logic)
 * Notice as well the use of an helper class to assist in the jsp response. 
 * 
 * @author fmartins
 *
 */
@Stateless
public class CreateCustomerAction extends Action {
	
	@EJB AddCustomerHandlerRemote addCustomerHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


		NewCustomerHelper nch = createHelper(request);
		request.setAttribute("helper", nch);
		
		if (validInput(nch)) {
			try {
				addCustomerHandler.addCustomer(intValue(nch.getVATNumber()), 
						nch.getDesignation(), intValue(nch.getPhoneNumber()), intValue(nch.getDiscountType()));
				nch.clearFields();
				nch.addMessage("Customer successfully added.");
			} catch (ApplicationException e) {
				nch.addMessage("Error adding customer: " + e.getMessage());
			}
		} else
			nch.addMessage("Error validating customer data");
		
		request.getRequestDispatcher("/criarCliente/novoCliente.jsp").forward(request, response);
	}

	
	private boolean validInput(NewCustomerHelper nch) {
		boolean result = isFilled(nch, nch.getDesignation(), "Designation must be filled.");
		
		result &= isFilled(nch, nch.getVATNumber(), "VAT number must be filled")
				 			&& isInt(nch, nch.getVATNumber(), "VAT number with invalid characters");
		
		if (!nch.getPhoneNumber().equals(""))
			result &= isInt(nch, nch.getPhoneNumber(), "Phone number contains invalid characters");

		result &= isFilled(nch, nch.getDiscountType(), "Discount type must be filled") 
					&& isInt(nch, nch.getDiscountType(), "Discount type with invalid characters");

		return result;
	}


	private NewCustomerHelper createHelper(HttpServletRequest request) {
		NewCustomerHelper nch = new NewCustomerHelper();
		nch.setAddCustomerHandler(addCustomerHandler);

		nch.setDesignation(request.getParameter("designacao"));
		nch.setVATNumber(request.getParameter("npc"));
		nch.setPhoneNumber(request.getParameter("telefone"));
		nch.setDiscountType(request.getParameter("desconto"));
		
		return nch;
	}	
}
