package controller.web.inputController.actions;

import facade.handlers.IAddOrderHandlerRemote;
import presentation.web.model.NewOrderModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Handles the novo cliente event
 *
 * @author fmartins
 *
 */
@Stateless
public class NewOrderAction extends Action {

    @EJB private IAddOrderHandlerRemote addOrderHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NewOrderModel model = new NewOrderModel();
        model.setAddOrderHandler(addOrderHandler);
        request.setAttribute("model", model);
        request.getRequestDispatcher("/addOrder/newOrder.jsp").forward(request, response);
    }

}
