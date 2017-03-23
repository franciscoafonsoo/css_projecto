package facade.handlers;


import facade.dto.OrdersDTO;
import facade.exceptions.ApplicationException;

import javax.ejb.Remote;

@Remote
public interface IGetOrdersHandlerRemote {

    public Iterable<OrdersDTO> getOrdersByProduct(int prodCode) throws ApplicationException;

}