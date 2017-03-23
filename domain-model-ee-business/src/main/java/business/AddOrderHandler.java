package business;

import facade.dto.OrdersDTO;
import facade.dto.ProductDTO;
import facade.dto.SupplierDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IAddOrderHandlerRemote;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.Date;


@Stateless
@WebService
public class AddOrderHandler implements IAddOrderHandlerRemote {

    @EJB
    private OrderCatalog orderCatalog;

    public OrdersDTO addOrder (int vat, int prodCode, Date deliveryDate, double qty)
            throws ApplicationException {
        try {
            int oldOrder;
            Orders o = orderCatalog.addOrder(vat, prodCode, deliveryDate, qty);
            if (o.getOldOrder() == null) {
                oldOrder = 0;
            } else
                oldOrder = o.getOldOrder().getId();
            return new OrdersDTO(o.getId(), o.getSupplier().getId(), o.getProduct().getProdCod(), o.getOrderDate(), o.getDeliveryDate(),
                    o.getQty(), oldOrder);
        } catch (Exception e) {
            throw new ApplicationException("Error adding order " + e);
        }
    }

    public SupplierDTO prepareOrder (int vat) throws ApplicationException {
        try {
            Supplier s = orderCatalog.prepareOrder(vat);
            return new SupplierDTO(s.getName(), s.getVat(), s.getId());
        } catch (Exception e) {
            throw new ApplicationException("Error adding order " + e);
        }
    }

    public ProductDTO productDetails(int prodCode) throws ApplicationException {
        try {
            Product p = orderCatalog.productDetails(prodCode);
            return new ProductDTO(p.getProdCod(), p.getDescription(), p.getFaceValue(), p.getQty());
        } catch (Exception e) {
            throw new ApplicationException("Error getting product " + e);
        }
    }
}
