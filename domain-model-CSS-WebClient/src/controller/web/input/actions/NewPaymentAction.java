package controller.web.input.actions;


import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.handlers.ProcessSaleHandlerRemote;
import ui.web.helpers.AddProductHelper;
import ui.web.helpers.PaymentHelper;
import ui.web.helpers.ProcessSaleHelper;

@Stateless
public class NewPaymentAction extends Action {

	@EJB private ProcessSaleHandlerRemote ProcessSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		PaymentHelper ph = new PaymentHelper();
		
		ph.setProcessSaleHandler(ProcessSaleHandler);
		request.setAttribute("helper", ph);
		request.getRequestDispatcher("/criarVenda/pagamento.jsp").forward(request, response);
	}

}
