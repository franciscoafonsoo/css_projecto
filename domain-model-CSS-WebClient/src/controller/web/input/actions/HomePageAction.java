package controller.web.input.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.handlers.PayHandlerRemote;
import ui.web.helpers.PayHelper;

@Stateless
public class HomePageAction extends Action{

	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.getRequestDispatcher("/index.html").forward(request, response);
	
}
}
