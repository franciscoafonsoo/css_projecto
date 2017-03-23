package facade.dto;

import java.io.Serializable;
import java.util.Date;


public class OrdersDTO implements Serializable {

    private static final long serialVersionUID = -4087131153704256744L;

    public final int id;
    public final int supplierId;
    public final int prodcode;
    public final Date orderDate;
    public final Date deliveryDate;
    public final double qty;
    public final int oldOlder;


    public OrdersDTO(int id, int supplierId, int prodCode, Date orderDate, Date deliveryDate, double qty, int oldOlder) {
        this.id = id;
        this.supplierId = supplierId;
        this.prodcode = prodCode;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.qty = qty;
        this.oldOlder = oldOlder;
    }
}
