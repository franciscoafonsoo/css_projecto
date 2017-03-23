package controller.web.inputController.actions;

import facade.handlers.IReceiveOrderHandlerRemote;
import presentation.web.model.ReceiveOrderModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Stateless
public class ReceiveOrderAction extends Action {

    @EJB
    private IReceiveOrderHandlerRemote receiveOrderHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReceiveOrderModel model = new ReceiveOrderModel();
        model.setReceiveOrderHandler(receiveOrderHandler);
        request.setAttribute("model", model);
        request.getRequestDispatcher("/receiveOrder/receiveOrder.jsp").forward(request, response);
    }
}
