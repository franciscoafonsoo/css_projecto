package controller.web.inputController.actions;

import facade.dto.OrdersDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IAddCustomerHandlerRemote;
import facade.handlers.IAddOrderHandlerRemote;
import facade.handlers.IGetOrdersHandlerRemote;
import presentation.web.model.PendingOrderModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Stateless
public class PendingCreateAction extends Action {

    @EJB private IGetOrdersHandlerRemote getOrdersHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PendingOrderModel model = createModel(request);
        request.setAttribute("model", model);
        model.clearMessage();
        if (validInput(model)) {
            try {
                Iterable<OrdersDTO> order = getOrdersHandler.getOrdersByProduct(intValue(model.getprodcode()));
                model.clearFields();
                model.addMessage("order");
                model.addMessage(orderToString(order));
            } catch (ApplicationException e) {
                model.addMessage("Error getting order: " + e.getMessage());
            }
        } else
            model.addMessage("Error validating order data");

        request.getRequestDispatcher("/pendingOrder/pendingOrder.jsp").forward(request, response);
    }

    private String orderToString(Iterable<OrdersDTO> orders){
        String ans= "";
        for (OrdersDTO o: orders
             ) {
            ans += "Order id: " + o.id + " <br> Product: "+ o.prodcode + " <br> Quantity: "+o.qty + " <br> Order Date: " + o.orderDate + "<br> Delivery Date: "+o.deliveryDate + "<br> Previous Order: " + o.oldOlder+"<br><br>";
        }
        return ans;
    }


    private boolean validInput(PendingOrderModel model) {
        // check if VATNumber is filled and a valid number
        boolean resposta= isFilled(model, model.getprodcode(), "prodcode must be filled")
                && isInt(model, model.getprodcode(), "prodcode with invalid characters");
        return resposta;
    }

    private PendingOrderModel createModel(HttpServletRequest request) {
        // Create the object model
        PendingOrderModel model = new PendingOrderModel();
        model.setGetOrdersHandler(getOrdersHandler);

        // fill it with data from the request
        model.setprodcode(request.getParameter("prodcode"));
        return model;
    }
}
