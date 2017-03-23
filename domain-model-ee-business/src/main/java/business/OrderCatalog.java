package business;

import facade.exceptions.ApplicationException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Stateless
public class OrderCatalog {

    /**
     * Entity manager for accessing the persistence service
     */
    @PersistenceContext
    private EntityManager em;


    /**
     * Finds an order given its product.
     *
     * @param product The Product object
     * @return A list of Orders objects corresponding to the orders with the product.
     * @throws ApplicationException When the Orders with the product is not found.
     */
    public List<Orders> getOrdersByProduct (Product product) throws ApplicationException {
        TypedQuery<Orders> query = em.createNamedQuery(Orders.FIND_ALL_PENDING_ORDERS_BY_PROD, Orders.class);
        query.setParameter(Orders.PRODUCT, product);
        query.setParameter(Orders.STATUS, OrderStatus.PENDING);
        try {
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new ApplicationException ("Order not found.");
        }
    }

    public Product getProductByProdCode (int prodcode) throws ApplicationException {
        TypedQuery<Product> query = em.createNamedQuery(Product.FIND_BY_PRODUCT_CODE, Product.class);
        query.setParameter(Product.PRODUCT_CODE, prodcode);
        try {
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new ApplicationException ("Prod not found.");
        }
    }


    /**
     * Finds all pending orders given its supplier.
     *
     * @param supplier Supplier Object
     * @return A List of Orders objects corresponding to the orders with the supplier.
     * @throws ApplicationException When the Orders with the supplier is not found.
     */
    public List<Orders> getOrdersBySupplier (Supplier supplier) throws ApplicationException {
        TypedQuery<Orders> query = em.createNamedQuery(Orders.FIND_ALL_PENDING_ORDERS_BY_SUPPLIER, Orders.class);
        query.setParameter(Orders.SUPPLIER, supplier);
        query.setParameter(Orders.STATUS, OrderStatus.PENDING);
        try {
            return query.getResultList();
        } catch (PersistenceException e) {
            throw new ApplicationException ("Order not found.");
        }
    }

    /**
     * Adds a new order
     *
     * @param vat The supplier vat
     * @param prodCode The product code
     * @param deliveryDate The delivery date
     * @param qty The order qty
     * @throws ApplicationException When the order is already in the repository
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Orders addOrder (int vat, int prodCode, Date deliveryDate, double qty) throws ApplicationException {
        Supplier supplier = prepareOrder(vat);
        Product product = productDetails(prodCode);
        Orders order = new Orders(supplier, product, deliveryDate, qty);
        product.setPendingQty(qty);
        em.persist(order);
        return order;
    }


    public Orders getOrderById(int id) throws ApplicationException {
        Orders o = em.find(Orders.class, id);
        if (o == null)
            throw new ApplicationException("Order with id " + id + " not found");
        else
            return o;
    }


    public Iterable<Orders> getOrders() {
        TypedQuery<Orders> query = em.createNamedQuery(Orders.FIND_ALL_ORDERS, Orders.class);
        return new LinkedList<>(query.getResultList());
    }


    public void deleteOrder(int id) throws ApplicationException {
        Orders o = em.find(Orders.class, id);
        if (o == null)
            throw new ApplicationException("Order with id " + id + " not found");
        em.remove(o);
    }


    public Supplier prepareOrder(int vat) throws ApplicationException {
        // gets the supplier number by having its vat number
        TypedQuery<Supplier> query = em.createNamedQuery(Supplier.FIND_BY_VAT, Supplier.class);
        query.setParameter(Supplier.NUMBER_VAT, vat);
        try {
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new ApplicationException ("Supplier not found.");
        }
    }


    public Product productDetails(int prodCode) throws ApplicationException {
        //gets the product by having its prod code
        TypedQuery<Product> query = em.createNamedQuery(Product.FIND_BY_PRODUCT_CODE, Product.class);
        query.setParameter(Product.PRODUCT_CODE, prodCode);
        try {
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new ApplicationException ("Product not found.");
        }
    }


    public void receiveOrder(int id, double qty) throws ApplicationException {
        Orders order = getOrderById(id);
        Product product = order.getProduct();
        double pendingQty = product.getPendingQty();

        if(qty <= pendingQty) {
            double newQty = pendingQty - qty;

            product.setPendingQty(newQty);
            product.setQty(product.getQty() + qty);
            em.merge(product);
            Date date = new Date();

            if(qty < pendingQty) {
                Orders newOrder = addOrder(order.getSupplier().getVat(), product.getProdCod(), order.getDeliveryDate(), qty);
                newOrder.setOrderDate(order.getOrderDate());
                newOrder.setOldOrder(order);
                em.persist(newOrder);
                order.setDeliveryDate(date);
                order.setStatus(OrderStatus.PENDING_RECIEVED);
                em.merge(order);
            } else {
                order.setDeliveryDate(date);
                order.setStatus(OrderStatus.RECIEVED);
                em.merge(order);
            }
        } else throw new ApplicationException("qty needs to be less than pending");
    }


    public void updateOrder(int id) throws ApplicationException {
        Orders o = getOrderById(id);
    }


    public void deleteProducts(int id) throws ApplicationException {
        Orders o = getOrderById(id);
    }
}
