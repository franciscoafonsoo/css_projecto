package presentation.web.model;

import facade.dto.OrdersDTO;
import facade.dto.ProductDTO;
import facade.dto.SupplierDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IAddCustomerHandlerRemote;
import facade.handlers.IAddOrderHandlerRemote;
import facade.interfaces.IDiscount;

import java.util.Date;
import java.util.LinkedList;

/**
 * Helper class to assist in the response of novo cliente.
 * This class is the response information expert.
 *
 * @author fmartins
 *
 */
public class NewOrderModel extends Model {

    private String id;
    private String supplierId;
    private String productcode;
    private String qty;
    private String deliveryDate;
    private String vat;

    private IAddOrderHandlerRemote addOrderHandler;

    public void setAddOrderHandler(IAddOrderHandlerRemote addOrderHandler) {
        this.addOrderHandler = addOrderHandler;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getsupplierId() {
        return supplierId;
    }

    public void setsupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getproductcode() {
        return productcode;
    }

    public void setproductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getqty() {
        return qty;
    }

    public void setqty(String qty) {
        this.qty = qty;
    }

    public String getdeliveryDate() {
        return deliveryDate;
    }

    public void setdeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getvat() {
        return vat;
    }

    public void setvat(String vat) {
        this.vat = vat;
    }


    public void clearFields() {
        id = supplierId = productcode = qty = deliveryDate = vat = "";
    }


    public SupplierDTO prepareOrder () throws ApplicationException{
        try{
            return addOrderHandler.prepareOrder(Integer.parseInt(vat));
        }catch (ApplicationException e){
            throw new ApplicationException("error getting supplier details", e);
        }
    }

    public ProductDTO productDetails() throws ApplicationException{
        try{
            return addOrderHandler.productDetails(Integer.parseInt(productcode));
        }catch (ApplicationException e){
            throw new ApplicationException("error getting product details", e);
        }

    }
}
