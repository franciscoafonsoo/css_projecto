package business;

import facade.dto.OrdersDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IReceiveOrderHandlerRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


@Stateless
@WebService
public class ReceiveOrderHandler implements IReceiveOrderHandlerRemote {

    @EJB
    private OrderCatalog orderCatalog;

    @EJB
    private SupplierCatalog supplierCatalog;

    public List<OrdersDTO> getOrdersBySupplier (int vat)
            throws ApplicationException {
        try {
            int i;
            Supplier s = supplierCatalog.getSupplier(vat);
            List<Orders> orderss = orderCatalog.getOrdersBySupplier(s);

            List<OrdersDTO> listo = new ArrayList<>();

            for(Orders os: orderss) {
                if (os.getOldOrder() == null) i = 0;
                else i = os.getOldOrder().getId();
                listo.add(new OrdersDTO(os.getId(), os.getSupplier().getId(), os.getProduct().getProdCod(), os.getOrderDate(), os.getDeliveryDate(),
                        os.getQty(), i));
            }

            return listo;
        } catch (Exception e) {
            throw new ApplicationException("Error adding order " + e);
        }
    }

    public void receiveOrder(int id, double qty) throws ApplicationException {
        try {
            orderCatalog.receiveOrder(id, qty);
        } catch (Exception e) {
            throw new ApplicationException("Error receiving order " + e);
        }
    }
}