package business;

import facade.exceptions.ApplicationException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;


@Stateless
public class SupplierCatalog {

    @PersistenceContext
    private EntityManager em;

    public Supplier getSupplier (int vat) throws ApplicationException {
        TypedQuery<Supplier> query = em.createNamedQuery(Supplier.FIND_BY_VAT, Supplier.class);
        query.setParameter(Supplier.NUMBER_VAT, vat);
        try {
            return query.getSingleResult();
        } catch (PersistenceException e) {
            throw new ApplicationException ("Order not found.");
        }
    }
}
