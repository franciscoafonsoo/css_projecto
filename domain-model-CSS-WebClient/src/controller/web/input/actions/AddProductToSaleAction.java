package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ApplicationException;
import business.handlers.AddCustomerHandlerRemote;
import business.handlers.ProcessSaleHandlerRemote;
import ui.web.helpers.AddProductHelper;
import ui.web.helpers.NewCustomerHelper;

@Stateless
public class AddProductToSaleAction extends Action{
	
	@EJB ProcessSaleHandlerRemote processSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


		AddProductHelper aph = createHelper(request);
		request.setAttribute("helper", aph);
		
		if (validInput(aph)) {
			try {
				processSaleHandler.addProductToSale(intValue(aph.getSaleId()) 
					, intValue(aph.getProdId()), intValue(aph.getQuant()));
				aph.clearValues();
				aph.addMessage("Customer successfully added.");
			} catch (ApplicationException e) {
				aph.addMessage("Error adding customer: " + e.getMessage());
			}
		} else
			aph.addMessage("Error validating Product or Sale data");
		
		request.getRequestDispatcher("/criarVenda/produtos.jsp").forward(request, response);
	}

	
	private boolean validInput(AddProductHelper aph) {
		boolean result = isFilled(aph, aph.getSaleId(), "Sale must be filled.") 
							&& isInt(aph, aph.getSaleId(), "Prod with invalid characters");
		
		result &= isFilled(aph, aph.getProdId(), "ProdId must be filled")
				 			&& isInt(aph, aph.getProdId(), "Prod with invalid characters");
		
		if (!aph.getQuant().equals(""))
			result &= isInt(aph, aph.getQuant(), "Quantity contains invalid characters");

		return result;
	}


	private AddProductHelper createHelper(HttpServletRequest request) {
		AddProductHelper aph = new AddProductHelper();
		aph.setProcessSaleHandler(processSaleHandler);
		aph.setSaleId(request.getParameter("venda"));
		aph.setProdId(request.getParameter("produto"));
		aph.setQuant(request.getParameter("quant"));
		return aph;
	}	
}
