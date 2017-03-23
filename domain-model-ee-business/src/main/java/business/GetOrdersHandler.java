package business;

import facade.dto.OrdersDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IGetOrdersHandlerRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;


@Stateless
@WebService
public class GetOrdersHandler implements IGetOrdersHandlerRemote {

    @EJB
    private OrderCatalog orderCatalog;

    public List<OrdersDTO> getOrdersByProduct(int prodCode) throws ApplicationException {
        try {
            int oldOrder;
            Product product = orderCatalog.getProductByProdCode(prodCode);
            List<Orders> orders = orderCatalog.getOrdersByProduct(product);

            List<OrdersDTO> listo = new ArrayList<>();

            for(Orders os: orders) {

                if (os.getOldOrder() == null) {
                    oldOrder = 0;
                } else {
                    oldOrder = os.getOldOrder().getId();
                }

                listo.add(new OrdersDTO(os.getId(), os.getSupplier().getId(), os.getProduct().getProdCod(), os.getOrderDate(), os.getDeliveryDate(),
                        os.getQty(), oldOrder));
            }
            return listo;
        } catch (Exception e) {
            throw new ApplicationException("Error getting orders " + e);
        }
    }
}
