package controller.web.inputController.actions;

import facade.dto.OrdersDTO;
import facade.dto.ProductDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IReceiveOrderHandlerRemote;
import presentation.web.model.ReceiveOrderModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Stateless
public class RegisterCreateOrderAction extends Action {

    @EJB private IReceiveOrderHandlerRemote receiveOrdersHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReceiveOrderModel model = createModel(request);
        request.setAttribute("model", model);
        model.clearMessage();
        if (validInput(model)) {
            try {
                receiveOrdersHandler.receiveOrder(Integer.parseInt(model.getid()), Double.parseDouble(model.getqty()));
                model.clearFields();
                model.addMessage("Delivery registered with success");
            } catch (ApplicationException e) {
                model.addMessage("Error registering delivery: " + e.getMessage());
            }
        } else
            model.addMessage("Error validating order data");

        request.getRequestDispatcher("/receiveOrder/receiveOrder.jsp").forward(request, response);
    }


    private boolean validInput(ReceiveOrderModel model) {
        // check if VATNumber is filled and a valid number
        boolean resposta= isFilled(model, model.getid(), "id must be filled")
                && isInt(model, model.getid(), "id with invalid characters");
        // check if qty is filled and a valid number
        resposta &= isFilled(model, model.getqty(), "qty must be filled")
                && isInt(model, model.getqty(), "qty with invalid characters");
        return resposta;
    }

    private ReceiveOrderModel createModel(HttpServletRequest request) {
        // Create the object model
        ReceiveOrderModel model = new ReceiveOrderModel();
        model.setReceiveOrderHandler(receiveOrdersHandler);

        // fill it with data from the request
        model.setid(request.getParameter("id"));
        model.setqty(request.getParameter("qty"));

        return model;
    }


}
