package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.handlers.PayHandlerRemote;
import ui.web.helpers.PayHelper;
import ui.web.helpers.PaymentHelper;

@Stateless
public class CreatePayAction extends Action{

	@EJB PayHandlerRemote PayHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PayHelper ph = createHelper(request);
		request.setAttribute("helper", ph);
		
		if (validInput(ph)){
			try{
				PayHandler.pay(intValue(ph.getPayId()));
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
		request.getRequestDispatcher("/criarPagamento/pagar.jsp").forward(request, response);
	}
	
	private boolean validInput(PayHelper ph) {
		boolean result = isFilled(ph, ph.getPayId(), "VAT number must be filled")
	 			&& isInt(ph, ph.getPayId(), "VAT number with invalid characters");
		
		return result;
	}
	
	
	private PayHelper createHelper(HttpServletRequest request){
		PayHelper ph = new PayHelper();
		ph.setPayHandler(PayHandler);
		ph.setPayId(request.getParameter("pagamento"));
		return ph;
	}
}
