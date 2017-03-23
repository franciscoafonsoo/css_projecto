package controller.web.inputController.actions;

import facade.exceptions.ApplicationException;
import facade.handlers.IAddOrderHandlerRemote;
import presentation.web.model.NewOrderModel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles the criar cliente event.
 * If the request is valid, it dispatches it to the domain model (the application's business logic)
 * Notice as well the use of an helper class to assist in the jsp response.
 *
 * @author fmartins
 *
 */
@Stateless
public class CreateOrderAction extends Action {

    @EJB private IAddOrderHandlerRemote addOrderHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NewOrderModel model = createModel(request);
        request.setAttribute("model", model);

        if (validInput(model)) {
            try {
                addOrderHandler.addOrder(intValue(model.getvat()), intValue(model.getproductcode()), dateValue(model.getdeliveryDate()), Double.parseDouble(model.getqty()));
                model.clearFields();
                model.addMessage("Order Added");
            } catch (ApplicationException e) {
                model.addMessage("Error adding order: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            model.addMessage("Error validating order data");

        request.getRequestDispatcher("/addOrder/newOrder.jsp").forward(request, response);
    }


    private boolean validInput(NewOrderModel model) {

        // check if VATNumber is filled and a valid number
        boolean result = isFilled(model, model.getvat(), "vat number must be filled")
                && isInt(model, model.getvat(), "vat number with invalid characters");

        // check if VATNumber is filled and a valid number
        result &= isFilled(model, model.getproductcode(), "productcode number must be filled")
                && isInt(model, model.getproductcode(), "productcode number with invalid characters");

        // check if VATNumber is filled and a valid number
        result &= isFilled(model, model.getdeliveryDate(), "date number must be filled");

        // check if VATNumber is filled and a valid number
        result &= isFilled(model, model.getqty(), "qty number must be filled");

        return result;
    }


    private NewOrderModel createModel(HttpServletRequest request) {
        // Create the object model
        NewOrderModel model = new NewOrderModel();
        model.setAddOrderHandler(addOrderHandler);

        // fill it with data from the request
        model.setvat(request.getParameter("vat"));
        model.setproductcode(request.getParameter("productcode"));
        model.setdeliveryDate(request.getParameter("deliveryDate"));
        model.setqty(request.getParameter("qty"));

        return model;
    }
}
