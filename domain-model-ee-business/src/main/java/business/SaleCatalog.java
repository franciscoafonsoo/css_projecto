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
import java.util.stream.Collectors;


@Stateless
public class SaleCatalog {

    /**
     * Entity manager for accessing the persistence service
     */
    @PersistenceContext
    private EntityManager em;


    public Sale getSaleByCustomer (int vat) throws ApplicationException {
        TypedQuery<Sale> query = em.createNamedQuery(Sale.FIND_BY_CUSTOMER, Sale.class);
        query.setParameter(Supplier.NUMBER_VAT, vat);
        try {
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new ApplicationException ("Sale not found.");
        }
    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Sale addSale (Date date, Customer customer)
            throws ApplicationException {
        Sale sale = new Sale(date, customer);
        em.persist(sale);
        return sale;
    }


    public Sale getSaleById(int id) throws ApplicationException {
        Sale s = em.find(Sale.class, id);
        if (s == null)
            throw new ApplicationException("Sale with id " + id + " not found");
        else
            return s;
    }


    public Iterable<Sale> getSales() {
        TypedQuery<Sale> query = em.createNamedQuery(Sale.FIND_ALL_SALES, Sale.class);
        return new LinkedList<>(query.getResultList());
    }

    public Iterable<Product> getProducts(int id) throws ApplicationException {
        Sale s = getSaleById(id);
        List<SaleProduct> listsp = s.getSaleProducts();
        return listsp.stream().map(SaleProduct::getProduct).collect(Collectors.toList());
    }


    public Sale addProductToSale (Sale sale, Product product, double qty) throws ApplicationException {
        sale.addProductToSale(product, qty);
        sale = em.merge(sale);
        product = em.merge(product);
        return sale;
    }

    public void annulSale(int id) throws ApplicationException {
        Sale s = getSaleById(id);
        if(!s.getAnnulled()) {
            s.setAnnulled(true);
            List<SaleProduct> saleProducts = s.getSaleProducts();
            for(SaleProduct sp : saleProducts) {
                Product p = sp.getProduct();
                p.setQty(p.getQty() + sp.getQty());
                saleProducts.remove(p);
                em.merge(p);
            }
            s.removeSaleProducts();
            em.merge(s);
        }
    }


    public void deleteSale(int id) throws ApplicationException {
        Sale s = em.find(Sale.class, id);
        if (s == null)
            throw new ApplicationException("Sale with id " + id + " not found");
        em.remove(s);
    }
}