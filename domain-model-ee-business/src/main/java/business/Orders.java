package business;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.EnumType.STRING;

/**
 * Mudança da query no segundo caso de uso, passando a encontrar as encomendas pendentes por fornecedor em vez de todas
 * as encomendas de um fornecedor. Embora seja assim impossivel consultar encomendas recebidas ou parciais, fica agora
 * como o prof. pede no enunciado.
 *
 */

@Entity
@NamedQueries({
        @NamedQuery(name=Orders.FIND_BY_SUPPLIER, query="SELECT o FROM Orders o WHERE o.supplier = :" +
                Orders.SUPPLIER),
        @NamedQuery(name=Orders.FIND_BY_PRODUCT, query="SELECT o FROM Orders o WHERE o.product = :" +
                Orders.PRODUCT),
        @NamedQuery(name=Orders.FIND_ALL_PENDING_ORDERS_BY_PROD, query="SELECT o FROM Orders o WHERE o.product = :" +
                Orders.PRODUCT + " AND o.status = :" + Orders.STATUS),
        @NamedQuery(name=Orders.FIND_ALL_PENDING_ORDERS_BY_SUPPLIER, query="SELECT o FROM Orders o WHERE o.supplier = :" +
                Orders.SUPPLIER + " AND o.status = :" + Orders.STATUS),
})
public class Orders {

    // Named query name constants
    public static final String FIND_BY_SUPPLIER = "Orders.findBySupplier";
    public static final String FIND_ALL_PENDING_ORDERS_BY_PROD = "Orders.findPendingOrdersByProd";
    public static final String FIND_ALL_PENDING_ORDERS_BY_SUPPLIER = "Orders.findPendingOrdersBySupplier";
    public static final String FIND_BY_PRODUCT = "Orders.findByProduct";
    public static final String PRODUCT = "product";
    public static final String SUPPLIER = "supplier";
    public static final String FIND_ALL_ORDERS = "Orders.findAllOrders";
    public static final String STATUS = "status";

    // 1. attributes

    @Id @GeneratedValue private int id;

    @ManyToOne private Supplier supplier;

    @OneToOne private Product product;

    private double qty;

    @Temporal(TemporalType.DATE) private Date orderDate;

    @Temporal(TemporalType.DATE) private Date deliveryDate;

    @Enumerated(STRING) private OrderStatus status;

    @OneToOne private Orders oldOrder;

    // 2. constructor

    protected Orders() {}

    public Orders(Supplier supplier, Product product, Date deliveryDate, double qty) {
        this.supplier = supplier;
        this.product = product;
        this.deliveryDate = deliveryDate;
        this.qty = qty;
        this.orderDate = new Date();
        this.status = OrderStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public double getQty() {
        return qty;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Orders getOldOrder() {
        return oldOrder;
    }

    public void setOldOrder(Orders oldOrder) {
        this.oldOrder = oldOrder;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
