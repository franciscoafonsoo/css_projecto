package business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TransactionCatalog {
	
	@PersistenceContext private EntityManager em;

	
	public Transaction getTransaction(int id) throws ApplicationException {
		try{
			TypedQuery<Transaction> q = em.createNamedQuery("Transaction.findById", Transaction.class);
			q.setParameter("id" , id);
			return q.getSingleResult();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting Transaction", e);
		}
	}
	
	

	public void createTransaction(TransactionType type, double value, int id, int customerVat) throws ApplicationException {
		// Lol i have been
		try{
			Transaction t = new Transaction(type, value, id, customerVat);
			em.persist(t);
		}
		catch (Exception e){
			throw new ApplicationException("Something Shady happened: Error creating Transaction", e);
		}
		
	}
	
	public List<Transaction> getTransactionsByVAT(int vat) throws ApplicationException {
		
		try{
			TypedQuery<Transaction> q = em.createNamedQuery("Transaction.findAllByVAT", Transaction.class);
			q.setParameter("vat", vat);
			return q.getResultList();
		}
		catch(Exception e){
			throw new ApplicationException("Something Shady happened: Error getting all the customer's Transactions", e);
		}
	}
	
}
