package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.handlers.PayHandlerRemote;
import business.handlers.ProcessSaleHandlerRemote;
import ui.web.helpers.PayHelper;
import ui.web.helpers.PaymentHelper;

@Stateless
public class NewPayAction extends Action{

	@EJB private PayHandlerRemote PayHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		PayHelper ph = new PayHelper();
		
		ph.setPayHandler(PayHandler);
		request.setAttribute("helper", ph);
		request.getRequestDispatcher("/criarPagamento/pagar.jsp").forward(request, response);
	
}
}
