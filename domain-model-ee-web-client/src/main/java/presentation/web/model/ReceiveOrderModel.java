package presentation.web.model;

import facade.dto.OrdersDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IReceiveOrderHandlerRemote;
import facade.interfaces.IOrder;

import java.util.LinkedList;

public class ReceiveOrderModel extends Model {

    private String id;
    private String supplierId;
    private String vat;
    private String prodcode;
    private String orderDate;
    private String deliveryDate;
    private String qty;
    private String oldOlder;

    private IReceiveOrderHandlerRemote receiveOrderHandler;

    public void setReceiveOrderHandler(IReceiveOrderHandlerRemote receiveOrderHandler) {
        this.receiveOrderHandler = receiveOrderHandler;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getvat() {
        return vat;
    }

    public void setvat(String vat) {
        this.vat = vat;
    }

    public String getsupplierId() {
        return supplierId;
    }

    public void setsupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getprodcode () {
        return prodcode;
    }

    public void setprodcode(String prodcode) {
        this.prodcode = prodcode;
    }

    public String getorderDate () {
        return orderDate;
    }

    public void setorderDate (String orderDate) {
        this.orderDate = orderDate;
    }

    public String getdeliveryDate () {
        return deliveryDate;
    }

    public void setdeliveryDate () {
        this.deliveryDate = deliveryDate;
    }

    public String getqty () {
        return qty;
    }

    public void setqty (String qty) {
        this.qty = qty;
    }

    public String getoldOlder () {
        return oldOlder;
    }

    public void setoldOlder (String oldOlder) {
        this.oldOlder = oldOlder;
    }

    public void clearFields() {
        id = supplierId = prodcode = orderDate = deliveryDate = qty = oldOlder = "";
    }

    public Iterable<? extends IOrder> getOrdersBySupplier() {
        try {
            Iterable<OrdersDTO> orders = receiveOrderHandler.getOrdersBySupplier(Integer.parseInt(vat));
            LinkedList<IOrder> orderss = new LinkedList <>();
            for (OrdersDTO o: orders)
                orderss.add((IOrder)o);

            return orderss;

        } catch (ApplicationException e) {
            return new LinkedList <IOrder>();
        }
    }

    public String receiveOrder() throws ApplicationException {
        try {
            receiveOrderHandler.receiveOrder(Integer.parseInt(id), Double.parseDouble(qty));
            return "Order " + id + " received";
        } catch (ApplicationException e) {
            return "error receiving order";
        }
    }
}
