package facade.handlers;


import facade.dto.OrdersDTO;
import facade.dto.ProductDTO;
import facade.dto.SupplierDTO;
import facade.exceptions.ApplicationException;

import javax.ejb.Remote;
import java.util.Date;

@Remote
public interface IAddOrderHandlerRemote {

    public OrdersDTO addOrder (int vat, int prodCode, Date deliveryDate, double qty)
            throws ApplicationException;

    public SupplierDTO prepareOrder (int vat) throws ApplicationException;

    public ProductDTO productDetails(int prodCode) throws ApplicationException;

}