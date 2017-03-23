package facade.handlers;


import facade.dto.OrdersDTO;
import facade.exceptions.ApplicationException;

import javax.ejb.Remote;

@Remote
public interface IReceiveOrderHandlerRemote {

    public Iterable<OrdersDTO> getOrdersBySupplier(int vat) throws ApplicationException;

    public void receiveOrder(int id, double qty) throws ApplicationException;

}