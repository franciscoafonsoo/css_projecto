package controller.web.inputController.actions;

import facade.handlers.IGetOrdersHandlerRemote;
import presentation.web.model.PendingOrderModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Stateless
public class PendingOrderAction extends Action {

    @EJB
    private IGetOrdersHandlerRemote getOrdersHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PendingOrderModel model = new PendingOrderModel();
        model.setGetOrdersHandler(getOrdersHandler);
        request.setAttribute("model", model);
        request.getRequestDispatcher("/pendingOrder/pendingOrder.jsp").forward(request, response);
    }
}