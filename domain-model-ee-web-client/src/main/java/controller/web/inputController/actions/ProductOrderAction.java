package controller.web.inputController.actions;

import facade.dto.ProductDTO;
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
public class ProductOrderAction extends Action {

    @EJB private IAddOrderHandlerRemote addOrderHandler;

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NewOrderModel model = createModel(request);
        request.setAttribute("model", model);

        if (validInput(model)) {
            try {
                ProductDTO p = addOrderHandler.productDetails(intValue(model.getproductcode()));
                model.clearFields();
                model.addMessage("product");
                model.addMessage(productToString(p));
            } catch (ApplicationException e) {
                model.addMessage("Error getting product: " + e.getMessage());
            }
        } else
            model.addMessage("Error validating product data");

        request.getRequestDispatcher("/addOrder/newOrder.jsp").forward(request, response);
    }

    private String productToString(ProductDTO p){
        return "Product name: " + p.description + "<br>Code: " + p.prodCod + "<br>Face value: " + p.faceValue + "<br>Quantity: " + p.qty + "<br>";
    }

    private boolean validInput(NewOrderModel model) {

        // check if VATNumber is filled and a valid number
        boolean result = isFilled(model, model.getproductcode(), "productcode number must be filled")
                && isInt(model, model.getproductcode(), "productcode number with invalid characters");

        return result;
    }


    private NewOrderModel createModel(HttpServletRequest request) {
        // Create the object model
        NewOrderModel model = new NewOrderModel();
        model.setAddOrderHandler(addOrderHandler);

        // fill it with data from the request
        model.setproductcode(request.getParameter("productcode"));

        return model;
    }
}
