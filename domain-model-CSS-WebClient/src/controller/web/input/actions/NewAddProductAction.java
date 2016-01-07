package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.handlers.AddCustomerHandlerRemote;
import business.handlers.ProcessSaleHandlerRemote;
import ui.web.helpers.AddProductHelper;
import ui.web.helpers.NewCustomerHelper;
import ui.web.helpers.ProcessSaleHelper;

@Stateless
public class NewAddProductAction extends Action{

@EJB private ProcessSaleHandlerRemote ProcessSaleHandler;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		AddProductHelper aph = new AddProductHelper();
		aph.setProcessSaleHandler(ProcessSaleHandler);
		request.setAttribute("helper", aph);
		request.getRequestDispatcher("/criarVenda/produtos.jsp").forward(request, response);
	}
}
