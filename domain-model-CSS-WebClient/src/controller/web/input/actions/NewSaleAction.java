package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.web.helpers.NewCustomerHelper;
import ui.web.helpers.ProcessSaleHelper;
import business.handlers.AddCustomerHandlerRemote;
import business.handlers.ProcessSaleHandlerRemote;


/**
 * Handles the nova Venda event
 * 
 * @author Pedro
 *
 */
@Stateless
public class NewSaleAction extends Action {
	
	@EJB private ProcessSaleHandlerRemote ProcessSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		ProcessSaleHelper psh = new ProcessSaleHelper();
		psh.setProcessSaleHandler(ProcessSaleHandler);
		request.setAttribute("helper", psh);
		request.getRequestDispatcher("/criarVenda/novaVenda.jsp").forward(request, response);
	}

}