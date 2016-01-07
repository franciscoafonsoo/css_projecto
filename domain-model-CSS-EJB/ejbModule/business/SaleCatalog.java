package business;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * A catalog for sales
 * 
 * @author fmartins
 * @version 1.1 (17/04/2015)
 *
 */

@Stateless
public class SaleCatalog {

	/**
	 * Entity manager factory for accessing the persistence service 
	 */
	@PersistenceContext
	private EntityManager em;
	
	

	/**
	 * Creates a new sale and adds it to the repository
	 * 
	 * @param customer The customer the sales belongs to
	 * @return The newly created sale
	 */
	public Sale newSale (Customer cliente) throws ApplicationException {
		try {
			Sale sale = new Sale(new Date(), cliente);
			em.persist(sale);
			return sale;
 		} catch (Exception e) {
			throw new ApplicationException("Error adding sale", e);
		}
	}

	// @pre venda.isEmAberto()
	// @pre produto.qty() >= qty
	/**
	 * @param sale
	 * @param product
	 * @param qty
	 * @throws ApplicationException
	 */
	public void addProductToSale (Sale sale, Product product, double qty) 
				throws ApplicationException {
		try {
			em.merge(product);
			em.merge(sale);
			sale.addProductToSale(product, qty);
 		} catch (Exception e) {
			throw new ApplicationException("Error adding product to sale", e);
		}
	}
	
	public Sale getSale(int saleId) throws ApplicationException{
		try {
			TypedQuery<Sale> query = em.createNamedQuery(Sale.FIND_BY_SALE_ID, Sale.class);
			query.setParameter(Sale.Sale_ID,  saleId);
			return query.getSingleResult();
		}
		catch (Exception e) {
			throw new ApplicationException("Sale with code " + saleId + " does not exist");
		}
	}

}
