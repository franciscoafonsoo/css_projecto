package controller.web.inputController.actions;

import facade.dto.SupplierDTO;
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
public class SupplierOrderAction extends Action {

    @EJB private IAddOrderHandlerRemote addOrderHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NewOrderModel model = createModel(request);
        request.setAttribute("model", model);

        if (validInput(model)) {
            try {
                SupplierDTO s = addOrderHandler.prepareOrder(intValue(model.getvat()));
                model.clearFields();
                model.addMessage("Supplier");
                model.addMessage(supplierToString(s));
            } catch (ApplicationException e) {
                model.addMessage("Error getting supplier: " + e.getMessage());
            }
        } else
            model.addMessage("Error validating supplier data");

        request.getRequestDispatcher("/addOrder/newOrder.jsp").forward(request, response);
    }

    private String supplierToString(SupplierDTO s){
        return "Supplier name: " + s.name + "<br>Id: " + s.id + "<br>VAT: " + s.vat + "<br>";
    }

    private boolean validInput(NewOrderModel model) {

        // check if VATNumber is filled and a valid number
        boolean result = isFilled(model, model.getvat(), "VAT number must be filled")
                && isInt(model, model.getvat(), "VAT number with invalid characters");

        return result;
    }


    private NewOrderModel createModel(HttpServletRequest request) {
        // Create the object model
        NewOrderModel model = new NewOrderModel();
        model.setAddOrderHandler(addOrderHandler);

        // fill it with data from the request
        model.setvat(request.getParameter("vat"));

        return model;
    }
}
