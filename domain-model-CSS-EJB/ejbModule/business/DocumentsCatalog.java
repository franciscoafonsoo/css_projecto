package business;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DocumentsCatalog {

	@PersistenceContext private EntityManager em;
	
	
	public Documents getDocument(int id) throws ApplicationException{
		try{
			TypedQuery<Documents> q = em.createNamedQuery("Documents.findById", Documents.class);
			q.setParameter("id" , id);
			return q.getSingleResult();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting Document", e);
			}
	}
	
	public Iterable<Documents> getDocuments() throws ApplicationException {
		try{
			TypedQuery<Documents> q = em.createNamedQuery("Documents.findAll", Documents.class);
			return q.getResultList();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting all Documents", e);
		}
	}
	
	public List<Documents> getDocumentByVat(int vat) throws ApplicationException{
		try{
			TypedQuery<Documents> q = em.createNamedQuery("Documents.findByVAT", Documents.class);
			q.setParameter("vat" , vat);
			return q.getResultList();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting Document by VAT", e);
			}
		}
	
	public Invoice newInvoice (Sale sale) throws ApplicationException {
		try {
			Invoice invoice = new Invoice(sale);
			em.persist(invoice);
			return invoice;
		} catch (Exception e) {
			throw new ApplicationException("Error adding invoice", e);
		}
	}
	
	public void newReceipt (double value, Invoice invoice, int tranche) throws ApplicationException {
		try {
			Receipt receipt = new Receipt(value, invoice.getId(), tranche, invoice.getSale());
			em.persist(receipt);
		} catch (Exception e) {
			throw new ApplicationException("Error adding receipt", e);
		}
	}
	
	}
	

