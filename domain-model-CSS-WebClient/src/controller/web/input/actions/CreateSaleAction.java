package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.ApplicationException;

import business.handlers.AddCustomerHandlerRemote;
import business.handlers.ProcessSaleHandlerRemote;
import ui.web.helpers.NewCustomerHelper;
import ui.web.helpers.ProcessSaleHelper;


@Stateless
public class CreateSaleAction extends Action {

@EJB ProcessSaleHandlerRemote processSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ProcessSaleHelper psh = createHelper(request);
		request.setAttribute("helper", psh);
		
		if (validInput(psh)){
			try{
				processSaleHandler.newSale(intValue(psh.getCustomerVat()));
				psh.clearValues();
				psh.addMessage("Customer successfully added.");
			}
			 catch (business.ApplicationException e) {
				 psh.addMessage("Error creating new sale: " + e.getMessage());
			}
		}
		else{
			psh.addMessage("Error validating data");
		}
		request.getRequestDispatcher("/criarVenda/novaVenda.jsp").forward(request, response);
	}
	
	private boolean validInput(ProcessSaleHelper psh) {
		boolean result = isFilled(psh, psh.getCustomerVat(), "VAT number must be filled")
	 			&& isInt(psh, psh.getCustomerVat(), "VAT number with invalid characters");
		
		return result;
	}
	
	
	private ProcessSaleHelper createHelper(HttpServletRequest request){
		ProcessSaleHelper psh = new ProcessSaleHelper();
		psh.setProcessSaleHandler(processSaleHandler);
		psh.setCustomerVat(request.getParameter("npc"));
		return psh;
	}
}
