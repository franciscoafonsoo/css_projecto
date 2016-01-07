package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.web.helpers.NewCustomerHelper;
import business.handlers.AddCustomerHandlerRemote;


/**
 * Handles the novo cliente event
 * 
 * @author fmartins
 *
 */
@Stateless
public class NewCustomerAction extends Action {
	
	@EJB private AddCustomerHandlerRemote addCustomerHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		NewCustomerHelper nch = new NewCustomerHelper();
		nch.setAddCustomerHandler(addCustomerHandler);
		request.setAttribute("helper", nch);
		request.getRequestDispatcher("/criarCliente/novoCliente.jsp").forward(request, response);
	}

}
