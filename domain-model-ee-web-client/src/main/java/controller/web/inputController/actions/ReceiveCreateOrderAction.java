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
public class ReceiveCreateOrderAction extends Action {

    @EJB private IReceiveOrderHandlerRemote receiveOrdersHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReceiveOrderModel model = createModel(request);
        request.setAttribute("model", model);
        model.clearMessage();
        if (validInput(model)) {
            try {
                Iterable<OrdersDTO> orders= receiveOrdersHandler.getOrdersBySupplier(intValue(model.getvat()));
                model.clearFields();
                model.addMessage("supplier");
                model.addMessage(ordersToString(orders));
            } catch (ApplicationException e) {
                model.addMessage("Error registering delivery: " + e.getMessage());
            }
        } else
            model.addMessage("Error validating order data");

        request.getRequestDispatcher("/receiveOrder/receiveOrder.jsp").forward(request, response);
    }

    private String ordersToString(Iterable<OrdersDTO> orders){
        String ans= "";
        for (OrdersDTO o: orders
                ) {
            ans += "Order id: " + o.id + " <br> Product: "+ o.prodcode + " <br> Quantity: "+o.qty + " <br> Order Date: " + o.orderDate + "<br> Delivery Date: "+o.deliveryDate + "<br> Previous Order: " + o.oldOlder+"<br><br>";
        }
        return ans;
    }

    private boolean validInput(ReceiveOrderModel model) {
        // check if VATNumber is filled and a valid number
        boolean resposta= isFilled(model, model.getvat(), "vat must be filled")
                && isInt(model, model.getvat(), "vat with invalid characters");
        return resposta;
    }

    private ReceiveOrderModel createModel(HttpServletRequest request) {
        // Create the object model
        ReceiveOrderModel model = new ReceiveOrderModel();
        model.setReceiveOrderHandler(receiveOrdersHandler);

        // fill it with data from the request
        model.setvat(request.getParameter("vat"));
        return model;
    }


}
