package presentation.web.model;

import facade.dto.OrdersDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IGetOrdersHandlerRemote;
import facade.handlers.IReceiveOrderHandlerRemote;
import facade.interfaces.IOrder;

import java.util.LinkedList;


public class PendingOrderModel extends Model {

    private String prodcode;
    private IGetOrdersHandlerRemote getOrdersHandler;

    public void setGetOrdersHandler(IGetOrdersHandlerRemote getOrdersHandler) {
        this.getOrdersHandler = getOrdersHandler;
    }


    public String getprodcode () {
        return prodcode;
    }

    public void setprodcode(String prodcode) {
        this.prodcode = prodcode;
    }

    public void clearFields() {
        prodcode = "";
    }

    public Iterable<? extends IOrder> pendingOrder() {
        try {
            Iterable<OrdersDTO> orders = getOrdersHandler.getOrdersByProduct(Integer.parseInt(prodcode));
            LinkedList<IOrder> orderss = new LinkedList <>();
            for (OrdersDTO o: orders)
                orderss.add((IOrder)o);

            return orderss;

        } catch (ApplicationException e) {
            return new LinkedList <IOrder>();
        }
    }
}
