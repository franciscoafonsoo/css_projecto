package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.handlers.ProcessSaleHandlerRemote;
import ui.web.helpers.PaymentHelper;
import ui.web.helpers.ProcessSaleHelper;
@Stateless
public class CreatePaymentAction extends Action{


@EJB ProcessSaleHandlerRemote processSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PaymentHelper ph = createHelper(request);
		request.setAttribute("helper", ph);
		
		if (validInput(ph)){
			try{
				processSaleHandler.createInvoice(intValue(ph.getSaleId()));
				processSaleHandler.closeSale(intValue(ph.getSaleId()));
				ph.clearValues();
				ph.addMessage("Sale successfully closed.");
			}
			 catch (business.ApplicationException e) {
				 ph.addMessage("Error creating new sale: " + e.getMessage());
			}
		}
		else{
			ph.addMessage("Error validating data");
		}
		request.getRequestDispatcher("/criarVenda/pagamento.jsp").forward(request, response);
	}
	
	private boolean validInput(PaymentHelper ph) {
		boolean result = isFilled(ph, ph.getSaleId(), "VAT number must be filled")
	 			&& isInt(ph, ph.getSaleId(), "VAT number with invalid characters");
		
		return result;
	}
	
	
	private PaymentHelper createHelper(HttpServletRequest request){
		PaymentHelper ph = new PaymentHelper();
		ph.setProcessSaleHandler(processSaleHandler);
		ph.setSaleId(request.getParameter("venda"));
		return ph;
	}
}
