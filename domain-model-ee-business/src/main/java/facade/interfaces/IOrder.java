package facade.interfaces;


import java.io.Serializable;
import java.util.Date;

public interface IOrder extends Serializable{

    int getSupplierCode();

    int getProductCode();

    double getQty();

    Date getDeliveryDate();

    Date getOrderDate();

    int getId();

    int getoldOlder();
}
